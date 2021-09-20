package com.controller.model.service;

import com.controller.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    Page<Employee> findAll(Pageable pageable);
    Employee findById(Integer integer);
    void save(Employee employee);
    void delete(Integer integer);
}
