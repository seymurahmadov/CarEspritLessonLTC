package com.ltc.espritspringboot.service;

import com.ltc.espritspringboot.dto.request.OwnerRequestDto;
import com.ltc.espritspringboot.dto.response.CarResponseDto;
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
}
