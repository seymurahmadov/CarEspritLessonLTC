package com.ltc.espritspringboot.controller;

import com.ltc.espritspringboot.dto.CarDto;
import com.ltc.espritspringboot.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {


    // 1. Field Injection
    // 2. Constructor Injection
    // 3. Setter Injection


    private final  CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/getAll")
    public List<CarDto> getAll() {
        return carService.getAll();
    }

    @PostMapping("/create")
    public String create(@RequestBody CarDto carDto) {
        carService.create(carDto);
        return "Success";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        carService.delete(id);
        return "Success";

    }


    @PutMapping("/update{id}")
    public String update(@PathVariable Long id, @RequestBody CarDto carDto) {
        carService.update(id, carDto);
        return "Success";

    }


}
