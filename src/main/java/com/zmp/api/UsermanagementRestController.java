package com.zmp.api;

import com.zmp.model.User;
import com.zmp.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsermanagementRestController {

    UserRepository userRepository;

    public UsermanagementRestController(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @GetMapping("/api/userlist")
    public List<User> test() {
        return userRepository.findAll();
    }

    // function to edit a User
    // function to delete a User
    // function to show user info
}
