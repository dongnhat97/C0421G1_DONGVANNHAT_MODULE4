package com.demo.model.service;

import com.demo.model.bean.Code;
import com.demo.model.repository.ICodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CodeService implements ICodeService{
    @Autowired
    ICodeRepository iCodeRepository;
    @Override
    public List<Code> findAll() {
        return iCodeRepository.findAll();
    }

    @Override
    public void save(Code code) {
        iCodeRepository.save(code);
    }

    @Override
    public void delete(int id) {
        iCodeRepository.deleteById(id);
    }
}
