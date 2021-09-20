package com.controller.model.service;

import com.controller.model.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);
    void save(Contract contract);
}
