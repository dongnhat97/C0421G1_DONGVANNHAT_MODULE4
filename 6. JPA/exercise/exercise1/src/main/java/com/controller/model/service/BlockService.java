package com.controller.model.service;

import com.controller.model.bean.Blog;
import com.controller.model.repository.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlockService implements IBlockService {
    @Autowired
    private BlockRepository blockRepository;
    @Override
    public List<Blog> finAll() {
        return blockRepository.findAll();
    }

    @Override
    public Page<Blog> finAll(Pageable pageable) {
        return blockRepository.findAll(pageable);
    }


    @Override
    public void save(Blog block) {
         blockRepository.save(block);
    }

    @Override
    public Blog findById(Long id) {
        return blockRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
       blockRepository.deleteById(id);
    }
}
