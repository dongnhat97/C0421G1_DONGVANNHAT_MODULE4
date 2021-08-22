package com.model.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ConvertRepository implements IConvertRepository {
    @Override
    public double convert(double amount, double rate) {
        return amount*rate;
    }
}
