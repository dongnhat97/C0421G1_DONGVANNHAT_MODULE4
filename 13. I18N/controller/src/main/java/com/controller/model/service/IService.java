package com.controller.model.service;


import com.controller.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService {
    Page<Service> findAll(Pageable pageable);
    Service findById(Integer id);
    void save(Service service);
    void delete(Integer id);

}
