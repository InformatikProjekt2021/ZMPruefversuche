package com.zmp.controller;

import com.zmp.model.User;
import com.zmp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AdminProfileController {

    @Autowired
    private UserRepository repository;

    public AdminProfileController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("/adminprofile")
    @ModelAttribute("user")
    public String user(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        User user = repository.findByEmail(currentPrincipalName);
        model.addAttribute("user", user);
        return "adminProfile";
    }
}
