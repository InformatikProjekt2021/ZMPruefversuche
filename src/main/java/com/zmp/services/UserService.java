package com.zmp.services;


import com.zmp.model.dto.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService{
    User save(User user);
}