package com.zmp.controller;

import com.zmp.model.User;
import com.zmp.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * Controller to manage user management view
 */
@Controller
public class UserManagementController {

    UserRepository userRepository;

    public UserManagementController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/management")
    public String management() {
        return "management";
    }

    @GetMapping("/management/delete/{id}")
    public String deleteIncome(@PathVariable(value = "id") Long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        userRepository.delete(user.get());
        model.addAttribute("users",userRepository.findAll());
        return "redirect:/management";
    }

}
