package com.controller.model.service.impl;

import com.controller.model.entity.CustomerType;
import com.controller.model.repository.ICustomerTypeRepository;
import com.controller.model.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository iCustomerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }
}
