package com.demo.model.service;

import com.demo.model.bean.Code;

import java.util.List;

public interface ICodeService {
    List<Code> findAll();
    void save(Code code);
    void delete(int id);
}
