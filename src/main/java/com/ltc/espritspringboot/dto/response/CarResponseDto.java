package com.ltc.espritspringboot.dto.response;

import com.ltc.espritspringboot.entity.OwnerEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResponseDto {
    private Long id;
    private String carName;
    private Integer carYear;
    private OwnerEntity ownerEntity;

}
