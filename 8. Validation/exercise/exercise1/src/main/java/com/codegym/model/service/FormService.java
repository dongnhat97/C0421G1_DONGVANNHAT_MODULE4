package com.codegym.model.service;

import com.codegym.model.bean.Form;
import com.codegym.model.repository.IFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService implements IFormService {
    @Autowired
    IFormRepository iFormRepository;
    @Override
    public void save(Form form) {
        iFormRepository.save(form);
    }
}
