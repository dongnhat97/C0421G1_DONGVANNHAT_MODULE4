package com.model.service;

import com.model.repository.ICalculateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateService implements ICalculateService {
    @Autowired
    ICalculateRepository iCalculateRepository;
    @Override
    public String calculate(double numberFirst, double numberSecond, String operator) {
        return iCalculateRepository.calculate(numberFirst,numberSecond,operator);
    }
}
