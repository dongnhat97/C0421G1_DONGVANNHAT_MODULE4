package com.model.service;

import com.model.bean.Product;
import com.model.repository.BaseRepository;
import com.model.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;
@Service

public class ProductService implements IProductService {
    @Autowired
    IProductRepository iProductRepository;
    @Override
    public List<Product> finAll() {
        return iProductRepository.finAll();
    }

    @Override
    public void Save(Product product) {
       iProductRepository.Save(product);
    }

    @Override
    public void delete(int id) {
     iProductRepository.delete(id);
    }

    @Override
    public Product findByID(int id) {
        return iProductRepository.findByID(id);
    }

    @Override
    public void update(Product product) {
        iProductRepository.update(product);
    }

    @Override
    public List<Product> search(String name) {
        return iProductRepository.search(name);
    }
}
