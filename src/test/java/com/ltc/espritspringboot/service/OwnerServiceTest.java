package com.ltc.espritspringboot.service;

import com.ltc.espritspringboot.dto.response.OwnerResponseDto;
import com.ltc.espritspringboot.entity.OwnerEntity;
import com.ltc.espritspringboot.repository.OwnerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerServiceTest {

    @InjectMocks
    OwnerService ownerService;

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    ModelMapper modelMapper;

    OwnerEntity ownerEntity;


    @BeforeEach
    public void setUp() {
        ownerEntity  =new OwnerEntity(1L, "Saquba", "Osmanova", 20, null);
    }


    @Test
    public void checkNameTest() {
        String actual = ownerService.checkName("Aslan", "Quliyev");


        Assertions.assertEquals("Aslan Quliyev", actual);
    }


    @Test
    public void getAllTest() {
        OwnerEntity ownerEntity1 = new OwnerEntity(1L, "Saquba", "Osmanova", 20, null);
        OwnerEntity ownerEntity2 = new OwnerEntity(2L, "Huseyn", "Ibrahimov", 29, null);
        OwnerEntity ownerEntity3 = new OwnerEntity(3L, "Semsi", "Abbasov", 30, null);

        List<OwnerEntity> all = Arrays.asList(ownerEntity1, ownerEntity2, ownerEntity3);

        when(ownerRepository.findAll()).thenReturn(all);

        List<OwnerResponseDto> actual = all.stream()
                .map(item -> modelMapper.map(item, OwnerResponseDto.class))
                .toList();

        List<OwnerResponseDto> expected = ownerService.getAll();

        Assertions.assertEquals(actual, expected);

    }


    @Test
    public void getOwnerByIdTest() {
        OwnerEntity ownerEntity1 = new OwnerEntity(1L, "Saquba", "Osmanova", 20, null);


        when(ownerRepository.findById(1L)).thenReturn(Optional.of(ownerEntity1));

        OwnerResponseDto actual = modelMapper.map(ownerEntity1, OwnerResponseDto.class);


        OwnerResponseDto expected = ownerService.findById(1L);

        Assertions.assertEquals(actual, expected);
    }



    @Test
    public void deleteTest(){
        OwnerEntity ownerEntity1 = new OwnerEntity(1L, "Saquba", "Osmanova", 20, null);

        when(ownerRepository.findById(1L)).thenReturn(Optional.of(ownerEntity1));


        String actual = ownerService.delete(1L);

        Assertions.assertEquals("Car deleted successfully", actual);

    }


}
