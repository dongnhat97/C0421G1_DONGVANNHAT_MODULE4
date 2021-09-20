package com.controller.model.repository;

import com.controller.model.entity.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentTypeRepository extends JpaRepository<RentType,Integer> {
}
