package com.zmp.api;

import com.zmp.model.User;
import com.zmp.repositories.UserRepository;
import com.zmp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/profile")
public class ProfileRestController {

    UserRepository userRepository;
    UserService userService;

    public ProfileRestController(UserRepository userRepository, UserService userService){
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity<User> getUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return new ResponseEntity<>(userRepository.findByEmail(email), HttpStatus.OK);
    }
    @PostMapping("/editpw")
    public User editPassword(@RequestBody User user){
        return userService.editPassword(user);
    }

}
