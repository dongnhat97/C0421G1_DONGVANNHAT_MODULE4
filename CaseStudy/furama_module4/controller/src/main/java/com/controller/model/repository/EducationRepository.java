package com.controller.model.repository;

import com.controller.model.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education,Integer> {
}
