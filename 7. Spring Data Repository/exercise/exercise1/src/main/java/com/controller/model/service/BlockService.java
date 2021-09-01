package com.controller.model.service;

import com.controller.model.bean.Block;
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
    public List<Block> finAll() {
        return blockRepository.findAll();
    }

    @Override
    public Page<Block> finAll(Pageable pageable) {
        return blockRepository.findAll(pageable);
    }


    @Override
    public void save(Block block) {
         blockRepository.save(block);
    }

    @Override
    public Block findById(Long id) {
        return blockRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
       blockRepository.deleteById(id);
    }

    @Override
    public Page<Block> findByBlockName(Pageable page,String name) {
        return blockRepository.findByBlockName(page,name);
    }

}
