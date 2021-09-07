package com.controller.model.service;

import com.controller.model.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlockService {
    List<Blog> finAll();
    Page<Blog> finAll(Pageable pageable);
    void save(Blog block);
    Blog findById(Long id);
    void delete(Long id);

}
