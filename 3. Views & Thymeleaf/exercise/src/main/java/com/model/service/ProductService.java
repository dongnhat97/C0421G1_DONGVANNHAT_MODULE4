package com.model.service;

import com.model.bean.Product;
import com.model.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository iProductRepository;
    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
       iProductRepository.save(product);
    }

    @Override
    public void delete(int id) {
       iProductRepository.delete(id);
    }

    @Override
    public void update(Product product) {
      iProductRepository.update(product);
    }

    @Override
    public Product finById(int id) {
        return iProductRepository.finById(id);
    }

    @Override
    public List<Product> finByName(String name) {
        return iProductRepository.finByName(name);
    }
}
