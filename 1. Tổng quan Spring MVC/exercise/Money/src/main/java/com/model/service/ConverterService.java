package com.model.service;

import com.model.repository.IConvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverterService implements IConverterService {
    @Autowired
    private IConvertRepository iConvertRepository;
    @Override
    public double convert(double amount, double rate) {
        return iConvertRepository.convert(amount,rate);
    }
}
