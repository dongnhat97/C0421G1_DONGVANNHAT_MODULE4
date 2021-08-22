package com.model.repository;

import org.springframework.stereotype.Repository;


public interface IConvertRepository {
    double convert(double amount, double rate);

}
