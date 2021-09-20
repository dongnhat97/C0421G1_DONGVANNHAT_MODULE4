package com.controller.model.repository;

import com.controller.model.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}
