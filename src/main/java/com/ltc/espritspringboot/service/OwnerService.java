package com.ltc.espritspringboot.service;

import com.ltc.espritspringboot.dto.request.OwnerRequestDto;
import com.ltc.espritspringboot.dto.response.OwnerResponseDto;
import com.ltc.espritspringboot.entity.OwnerEntity;
import com.ltc.espritspringboot.repository.OwnerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final ModelMapper modelMapper;

    public OwnerService(OwnerRepository ownerRepository, ModelMapper modelMapper) {
        this.ownerRepository = ownerRepository;
        this.modelMapper = modelMapper;
    }






    public String checkName(String name, String surname){
        return name +  " " + surname;
    }


    public List<OwnerResponseDto> getAll(){
        List<OwnerEntity> all = ownerRepository.findAll();
        List<OwnerResponseDto> list = all.stream()
                .map(item -> modelMapper.map(item, OwnerResponseDto.class))
                .toList();

        return list;
    }

    public String create(OwnerRequestDto ownerRequestDto){
        OwnerEntity ownerEntity = modelMapper.map(ownerRequestDto, OwnerEntity.class);
        ownerRepository.save(ownerEntity);
        return "Succes";
    }

    public OwnerResponseDto findById(Long id) {
        OwnerEntity ownerEntity = ownerRepository.findById(id).orElseThrow();
        OwnerResponseDto mapper =  modelMapper.map(ownerEntity, OwnerResponseDto.class);
        return mapper;
    }


    public String delete( Long id) {
        OwnerEntity ownerEntity = ownerRepository.findById(id).orElseThrow();
        ownerRepository.delete(ownerEntity);
        return "Car deleted successfully";
    }

    public String update( Long id, OwnerRequestDto ownerRequestDto) {

        OwnerEntity ownerEntity = ownerRepository.findById(id).orElseThrow();

        modelMapper.map(ownerRequestDto, ownerEntity);

        ownerRepository.save(ownerEntity);

        return "Car updated successfully";

    }

}
