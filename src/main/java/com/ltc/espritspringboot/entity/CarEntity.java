package com.ltc.espritspringboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "car")
@Getter
@Setter
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String carName;

    @Column(name = "car_year")
    private Integer carYear;


    @OneToOne
    private EngineEntity engineEntity;

    @ManyToOne
    private OwnerEntity ownerEntity;

    @ManyToMany
    private List<WheelEntity> wheelEntityList;

}
