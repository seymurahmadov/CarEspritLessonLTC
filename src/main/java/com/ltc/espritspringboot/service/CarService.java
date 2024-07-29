package com.ltc.espritspringboot.service;

import com.ltc.espritspringboot.dto.request.CarRequestDto;
import com.ltc.espritspringboot.dto.response.CarResponseDto;
import com.ltc.espritspringboot.entity.CarEntity;
import com.ltc.espritspringboot.entity.OwnerEntity;
import com.ltc.espritspringboot.repository.CarRepository;
import com.ltc.espritspringboot.repository.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Timer;

@Service
@Slf4j
public class CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final OwnerRepository ownerRepository;

    public CarService(CarRepository carRepository, ModelMapper modelMapper, OwnerRepository ownerRepository) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.ownerRepository = ownerRepository;
    }

    public String hello(String name,String surname) {
        return "Hello " + name + " " + surname;

    }

    public List<CarResponseDto> getAll() {
        log.info("Carin get All metodu cagirdim");
        List<CarEntity> all = carRepository.findAll();


        List<CarResponseDto> list = all.stream()
                .map(item -> modelMapper.map(item, CarResponseDto.class))
                .toList();

        log.info("Carin get All metodu cagrildi. her sey yaxsidi");

        return list;



    }



    public CarResponseDto findById(Long id) {
        CarEntity carEntity = carRepository.findById(id).orElseThrow();
        CarResponseDto sevinc =  modelMapper.map(carEntity, CarResponseDto.class);
        return sevinc;
    }








    public String create( CarRequestDto carDto) {


        CarEntity car = modelMapper.map(carDto, CarEntity.class);

        OwnerEntity ownerEntity = ownerRepository.findById(carDto.getOwnerId()).orElseThrow();

        car.setOwnerEntity(ownerEntity);

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



    public List<CarResponseDto> getAllByName(String carName){
        List<CarEntity> allByCarName = carRepository.findAllByCarName(carName);

        List<CarResponseDto> list = allByCarName.stream()
                .map(item -> modelMapper.map(item, CarResponseDto.class))
                .toList();


        return list;
    }




    @Scheduled(cron = "0 33 13 * * ?")
    public void sayCarName() throws InterruptedException {
        System.out.println("Mercedes " + LocalTime.now());
    }
}
