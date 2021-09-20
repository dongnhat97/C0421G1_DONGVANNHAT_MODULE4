package com.controller.model.service;


import com.controller.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService {
    List<Service> findAll();
    Page<Service> findAll(Pageable pageable);
    Service findById(Integer id);
    void save(Service service);
    void delete(Integer id);

}
