package com.controller.model.service;

import com.controller.model.entity.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
