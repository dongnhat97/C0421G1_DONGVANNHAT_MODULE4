package com.controller.model.service.impl;

import com.controller.model.entity.Education;
import com.controller.model.repository.EducationRepository;
import com.controller.model.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationImpl implements IEducationService {
    @Autowired
    private EducationRepository educationRepository;
    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }
}
