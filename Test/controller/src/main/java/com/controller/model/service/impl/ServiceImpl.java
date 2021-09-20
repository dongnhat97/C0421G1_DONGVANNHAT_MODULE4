package com.controller.model.service.impl;


import com.controller.model.entity.Service;
import com.controller.model.repository.ServiceRepository;
import com.controller.model.service.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@org.springframework.stereotype.Service
public class ServiceImpl implements IService {
@Autowired
    ServiceRepository serviceRepository;

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Service findById(Integer id) {
        return serviceRepository.findById(id).get();
    }

    @Override
    public void save(Service service) {
          serviceRepository.save(service);
    }

    @Override
    public void delete(Integer id) {
           serviceRepository.deleteById(id);
    }
}
