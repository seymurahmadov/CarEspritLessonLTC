package com.ltc.espritspringboot.repository;

import com.ltc.espritspringboot.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository <OwnerEntity, Long> {
}
