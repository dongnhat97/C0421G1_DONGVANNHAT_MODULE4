package com.controller.model.service;

import com.controller.model.bean.Block;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlockService {
    List<Block> finAll();
    Page<Block> finAll(Pageable pageable);
    void save(Block block);
    Block findById(Long id);
    void delete(Long id);
    Page<Block> findByBlockName (Pageable page, String name);

}
