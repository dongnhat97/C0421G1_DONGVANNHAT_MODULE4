package com.controller.model.service;

import com.controller.model.bean.Category;
import com.controller.model.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Category> finAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category finById(long id) {
        return categoryRepository.findById(id).get();
    }
}
