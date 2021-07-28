package com.zmp.services;


import com.zmp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * spring security pattern for user management
 */
public interface UserService extends UserDetailsService{
    User save(User user);

    User updateUser(User user);

    void deleteUser(long id);

    User editPassword(User user);
}