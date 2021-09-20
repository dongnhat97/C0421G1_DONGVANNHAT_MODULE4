package com.controller.model.service.impl;

import com.controller.model.authentic.User;
import com.controller.model.repository.UserRepository;
import com.controller.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }
}
