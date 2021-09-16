package com.controller.model.repository;

import com.controller.model.bean.Block;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block,Long> {
   Page<Block> findByBlockName (Pageable page, String name);
}
