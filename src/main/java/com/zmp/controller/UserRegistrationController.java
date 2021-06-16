package com.zmp.controller;

import com.zmp.model.Role;
import com.zmp.model.User;
import com.zmp.repositories.RoleRepository;
import com.zmp.repositories.UserRepository;
import com.zmp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private final UserService userService;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public UserRegistrationController(UserService userService, RoleRepository roleRepository,  UserRepository userRepository) {
        super();
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
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
        Role role;
        if(userRepository.count()==0) {
            role = roleRepository.getOne(1L);
        }else{
            role = roleRepository.getOne(2L);
        }
        user.setRole(role.getName());
        userService.save(user);

        return "redirect:/registration?success";
    }
}
