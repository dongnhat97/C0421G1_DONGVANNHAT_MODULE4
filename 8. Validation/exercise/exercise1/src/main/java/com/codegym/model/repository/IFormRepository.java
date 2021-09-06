package com.codegym.model.repository;

import com.codegym.model.bean.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFormRepository extends JpaRepository<Form,Long> {
}
