package com.model.repository;

import com.model.bean.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> finAll();
    void Save(Product product);
    void delete(int id);
    Product findByID(int id);
    void update(Product product);
    List<Product> search(String name);
}
