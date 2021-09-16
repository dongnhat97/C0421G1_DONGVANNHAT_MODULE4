package com.controller.model.service;

import com.controller.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> finAll();
    Page<Category> finAll(Pageable pageable);
    void save(Category category);
    void delete(long id);
    Category finById(long id);

}
