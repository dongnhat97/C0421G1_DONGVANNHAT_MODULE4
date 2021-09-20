package com.controller.model.service.impl;

import com.controller.model.entity.Position;
import com.controller.model.repository.PositionRepository;
import com.controller.model.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionImpl implements IPositionService {
    @Autowired
    PositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
