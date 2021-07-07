package com.zmp.controller;

import com.zmp.model.User;
import com.zmp.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class userProfileController {

    private final UserRepository repository;

    public userProfileController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("/userprofile")
    public String user(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        User user = repository.findByEmail(currentPrincipalName);
        model.addAttribute("user", user);
        return "userProfile";
    }
}
