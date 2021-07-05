package com.zmp.api;

import com.zmp.model.User;
import com.zmp.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProfileRestController {

    UserRepository userRepository;

    public ProfileRestController(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @GetMapping("/api/profile")
    public User test() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email);
    }

    //function to get User Info
    // function to edit password
}
