package com.controller.model.service;

import com.controller.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Integer id);
    void save(Customer customer);
    void delete(Integer id);
    Page<Customer> findAllByCustomerNameContaining(String name,Pageable pageable);
}
