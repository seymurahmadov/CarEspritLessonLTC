package com.ltc.espritspringboot.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerResponseDto {
    private Long id;
    private String name;
    private String surname;
    private Integer age;

}
