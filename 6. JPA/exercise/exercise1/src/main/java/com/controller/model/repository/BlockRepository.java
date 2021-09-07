package com.controller.model.repository;

import com.controller.model.bean.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Blog,Long> {

}
