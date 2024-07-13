package com.ltc.espritspringboot.controller;

import com.ltc.espritspringboot.dto.request.CarRequestDto;
import com.ltc.espritspringboot.dto.request.OwnerRequestDto;
import com.ltc.espritspringboot.dto.response.OwnerResponseDto;
import com.ltc.espritspringboot.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/getAll")
    public List<OwnerResponseDto> getAll() {
        return ownerService.getAll();
    }



    @PostMapping("/create")
    public String create(@RequestBody OwnerRequestDto requestDto) {
        ownerService.create(requestDto);
        return "Success";
    }

}
