package com.model.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements  IDictionaryRepository{
    @Override
    public String translate(String key) {
        Map<String,String> map = new HashMap<>();
        map.put("people","nguoi");
        map.put("love","tình yeu");
        map.put("dog","con cho");
        map.put("cat","meo");
        String keyLower = key.toLowerCase();
        if (map.containsKey(keyLower)) {
            return map.get(keyLower);
        }
        return "khong ton tai tu khoa nay";
    }
}
