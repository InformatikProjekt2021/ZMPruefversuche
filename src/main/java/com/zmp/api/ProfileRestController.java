package com.zmp.api;

import com.zmp.model.User;
import com.zmp.repositories.UserRepository;
import com.zmp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * API for Users Profile
 * this class can be used to communicate with the database
 */

@RestController
@RequestMapping("/api/profile")
public class ProfileRestController {

    UserRepository userRepository;
    UserService userService;

    /**
     * Constructor is called on application start
     */
    public ProfileRestController(UserRepository userRepository, UserService userService){
        this.userRepository = userRepository;
        this.userService = userService;
    }

    /**
     * Function to get a User by GET request
     * @return returns A HTTP responsentity with the user
     */
    @GetMapping("/get")
    public ResponseEntity<User> getUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return new ResponseEntity<>(userRepository.findByEmail(email), HttpStatus.OK);
    }

    /**
     * Function to edit users password by POST request
     * @return returns A HTTP responsentity with the newly edited user
     */
    @PostMapping("/editpw")
    public User editPassword(@RequestBody User user){
        return userService.editPassword(user);
    }

}
