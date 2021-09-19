package com.controller.model.service;

import com.controller.model.entity.RentType;
import com.controller.model.entity.ServiceType;

import java.util.List;

public interface IServiceType {
    List<ServiceType> findAll();
}
