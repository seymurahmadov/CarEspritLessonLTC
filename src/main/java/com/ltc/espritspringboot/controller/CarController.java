package com.ltc.espritspringboot.controller;

import com.ltc.espritspringboot.dto.CarRequestDto;
import com.ltc.espritspringboot.dto.CarResponseDto;
import com.ltc.espritspringboot.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {


    // 1. Field Injection
    // 2. Constructor Injection
    // 3. Setter Injection


    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/getAll")
    public List<CarResponseDto> getAll() {
        return carService.getAll();
    }


    @GetMapping("find-by-{id}")
    public CarResponseDto findById(@PathVariable Long id) {
        CarResponseDto byId = carService.findById(id);
        return byId;

    }

    @PostMapping("/create")
    public String create(@RequestBody CarRequestDto carDto) {
        carService.create(carDto);
        return "Success";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        carService.delete(id);
        return "Success";

    }


    @PutMapping("/update{id}")
    public String update(@PathVariable Long id, @RequestBody CarRequestDto carDto) {
        carService.update(id, carDto);
        return "Success";

    }


}
