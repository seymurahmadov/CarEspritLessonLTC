package com.ltc.espritspringboot.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Entity
@Table(name = "owner")
@Getter
@Setter
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private Integer age;


    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<CarEntity> carEntity;

}
