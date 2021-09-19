package com.controller.model.service.impl;

import com.controller.model.authentic.MyUserDetail;
import com.controller.model.authentic.User;
import com.controller.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    IUserService iUserService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserService.findByUsername(username);
        if (user==null) {
            throw new UsernameNotFoundException("User name: "+ username + " not found.");
        }
        return new MyUserDetail(user);
    }
}
