package com.controller.model.service.impl;

import com.controller.model.entity.Customer;
import com.controller.model.repository.CustomerRepository;
import com.controller.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {
       customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable) {
        return customerRepository.findAllByCustomerNameContaining(name,pageable);
    }



}
