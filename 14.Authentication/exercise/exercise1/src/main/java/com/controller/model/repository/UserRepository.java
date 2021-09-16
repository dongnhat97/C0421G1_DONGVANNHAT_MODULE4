package com.controller.model.repository;

import com.controller.model.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
