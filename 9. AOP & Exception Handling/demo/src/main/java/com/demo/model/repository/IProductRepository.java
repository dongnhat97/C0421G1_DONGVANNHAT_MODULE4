package com.demo.model.repository;

import com.demo.model.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
