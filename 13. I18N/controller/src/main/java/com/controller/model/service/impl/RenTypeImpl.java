package com.controller.model.service.impl;

import com.controller.model.entity.RentType;
import com.controller.model.repository.RentTypeRepository;
import com.controller.model.service.IRenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RenTypeImpl implements IRenType {
    @Autowired
    RentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
//    public RentType findById(Integer integer){
//        return rentTypeRepository.findById(integer).get();
//    }
}
