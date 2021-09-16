package com.controller.model.service;



import com.controller.model.bean.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
//    void save(User user);
//    void update(User user);
    User findById(int id);
}
