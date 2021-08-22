package com.model.service;

import com.model.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceService implements IDictionaryService{
    @Autowired
    IDictionaryRepository iDictionaryRepository;
    @Override
    public String translate(String key) {
        return iDictionaryRepository.translate(key);
    }
}
