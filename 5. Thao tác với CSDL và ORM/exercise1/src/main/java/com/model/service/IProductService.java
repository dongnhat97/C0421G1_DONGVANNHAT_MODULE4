package com.model.service;

import com.model.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    void delete(int id);
    void update(Product product);
    Product finById(int id);
    List<Product> finByName (String name);
}
