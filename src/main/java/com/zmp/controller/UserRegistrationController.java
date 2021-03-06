package com.zmp.controller;

import com.zmp.model.User;
import com.zmp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Controller to manage user registration view
 */
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private final UserService userService;

    @Autowired
    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") User user) {
        user.setUsername(user.getFirstName()+user.getLastName());
        List<User> users  = userService.getAllUsers();
        for(User tmp : users){
            if(tmp.getEmail().equals(user.getEmail())){
                return "redirect:/registration?error";
            }
        }
        userService.save(user);
        return "redirect:/registration?success";
    }
}
