package com.controller.model.service.impl;

import com.controller.model.entity.Contract;
import com.controller.model.repository.ContractRepository;
import com.controller.model.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
       contractRepository.save(contract);
    }
}
