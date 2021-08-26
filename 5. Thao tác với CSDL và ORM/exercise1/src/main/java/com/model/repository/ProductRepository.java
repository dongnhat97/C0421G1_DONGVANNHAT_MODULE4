package com.model.repository;

import com.model.bean.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepository implements IProductRepository{
    public static Map<Integer,Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1,new Product(1,"Iphone",10.5,"new","apple"));
        productMap.put(2,new Product(2,"IPad",9.2,"new","apple"));
        productMap.put(3,new Product(3,"Galaxy",7.6,"old","Samsung"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public void delete(int id) {
         productMap.remove(id);
    }

    @Override
    public void update(Product product) {
     productMap.put(product.getId(),product);
    }

    @Override
    public Product finById(int id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> finByName(String name) {
     List<Product> productList = new ArrayList<>(productMap.values());
     List<Product> products = new ArrayList<>();
     for (Product product : productList) {
         if (name.toLowerCase().contains(product.getName().toLowerCase())) {
             products.add(product);
         }
     }
     return products;
    }
}
