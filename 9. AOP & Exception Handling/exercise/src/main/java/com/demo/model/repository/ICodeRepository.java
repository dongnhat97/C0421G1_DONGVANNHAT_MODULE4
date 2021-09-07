package com.demo.model.repository;

import com.demo.model.bean.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICodeRepository extends JpaRepository<Code,Integer> {
}
