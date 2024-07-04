package com.ltc.espritspringboot.service;

import com.ltc.espritspringboot.dto.CarRequestDto;
import com.ltc.espritspringboot.dto.CarResponseDto;
import com.ltc.espritspringboot.entity.CarEntity;
import com.ltc.espritspringboot.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public CarService(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }


    public List<CarResponseDto> getAll() {
        List<CarEntity> all = carRepository.findAll();


        List<CarResponseDto> list = all.stream()
                .map(item -> modelMapper.map(item, CarResponseDto.class))
                .toList();


        return list;

    }



    public CarResponseDto findById(Long id) {
        CarEntity carEntity = carRepository.findById(id).orElseThrow();
        CarResponseDto sevinc =  modelMapper.map(carEntity, CarResponseDto.class);
        return sevinc;
    }













    public String create( CarRequestDto carDto) {
        CarEntity car = modelMapper.map(carDto, CarEntity.class);
        carRepository.save(car);
        return "Car added successfully";
    }


    public String delete( Long id) {
        CarEntity carEntity = carRepository.findById(id).orElseThrow();
        carRepository.delete(carEntity);
        return "Car deleted successfully";
    }






    public String update( Long id, CarRequestDto carDto) {

        CarEntity humbet = carRepository.findById(id).orElseThrow();

        modelMapper.map(carDto, humbet);

        carRepository.save(humbet);

        return "Car updated successfully";

    }


}
