package com.zmp.controller;

import com.zmp.model.User;
import com.zmp.repositories.UserRepository;
import com.zmp.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userprofile")
public class userProfileController {

    private final UserRepository repository;
    private final UserService userService;
    private User user;

    public userProfileController(UserRepository repository, UserService userService){
        this.userService = userService;
        this.repository = repository;
    }

    @GetMapping
    public String user(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        User user = repository.findByEmail(currentPrincipalName);
        this.user = user;
        model.addAttribute("user", user);
        return "userProfile";
    }

    @PostMapping
    public User editPassword(@RequestBody User user){
        String password = user.getPassword();
        user = this.user;
        user.setPassword(password);
        return userService.editPassword(user);
    }
}
