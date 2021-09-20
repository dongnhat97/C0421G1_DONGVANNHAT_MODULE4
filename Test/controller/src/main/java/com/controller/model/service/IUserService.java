package com.controller.model.service;

import com.controller.model.authentic.User;

public interface IUserService {
    User findByUsername(String name);
}
