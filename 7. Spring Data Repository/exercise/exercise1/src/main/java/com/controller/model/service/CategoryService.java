package com.controller.model.service;

import com.controller.model.bean.Category;
import com.controller.model.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> finAll() {
        return categoryRepository.findAll();
    }
}
