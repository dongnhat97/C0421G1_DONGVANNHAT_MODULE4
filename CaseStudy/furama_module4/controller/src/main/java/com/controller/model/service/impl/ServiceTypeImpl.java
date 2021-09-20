package com.controller.model.service.impl;

import com.controller.model.entity.ServiceType;
import com.controller.model.repository.ServiceTypeRepository;
import com.controller.model.service.IServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTypeImpl implements IServiceType {
    @Autowired
    ServiceTypeRepository serviceTypeRepository;
    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
