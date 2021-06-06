package com.zmp.services;


import com.zmp.model.dto.User;
import com.zmp.model.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
}