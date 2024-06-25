package com.ltc.espritspringboot.service;

import com.ltc.espritspringboot.dto.CarDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CarService {



    List<CarDto> carDtos = new ArrayList<>();


    public List<CarDto> getAll() {
        return carDtos;
    }

    public String create(@RequestBody CarDto carDto) {
        carDtos.add(carDto);
        return "Car added successfully";
    }

    public String delete(@RequestParam Long id) {
        carDtos.removeIf(item -> Objects.equals(item.getId(), id));
        return "Car deleted successfully";
    }


    public String update(@PathVariable Long id, @RequestBody CarDto carDto) {
        for (CarDto item : carDtos) {
            if (item.getId().equals(id)) {

//
//                item.builder()
//                        .id(carDto.getId())
//                        .carName(carDto.getCarName())
//                        .carYear(carDto.getCarYear())
//                        .build();


                item.setId(carDto.getId());
                item.setCarName(carDto.getCarName());
                item.setCarYear(carDto.getCarYear());
            }
        }
        return "Car updated successfully";

    }


}
