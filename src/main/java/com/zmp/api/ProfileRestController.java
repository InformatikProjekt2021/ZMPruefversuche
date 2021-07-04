package com.zmp.api;

import com.zmp.model.User;
import com.zmp.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProfileRestController {

    UserRepository userRepository;
    private User user;

    public ProfileRestController(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @GetMapping("/api/profile")
    public User test() {
        return userRepository.getOne(user.getId());
    }

    //function to get User Info
    // function to edit password
}
