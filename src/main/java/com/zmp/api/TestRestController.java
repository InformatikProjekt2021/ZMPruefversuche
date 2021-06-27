package com.zmp.api;

import com.zmp.model.User;
import com.zmp.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestRestController {

    UserRepository userRepository;

    public TestRestController(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @GetMapping("/testR")
    public List<User> login() {
        return userRepository.findAll();
    }
}