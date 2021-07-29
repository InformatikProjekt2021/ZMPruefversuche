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
 * controller to add new Users if youre admin
 */
@Controller
@RequestMapping("/addUser")
public class AddUserController {


    private final UserService userService;

    @Autowired
    public AddUserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping
    public String testing() {
        return "addUser";
    }


    @ModelAttribute("user")
    public User user() {
        return new User();
    }


    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") User user) {
        user.setUsername(user.getFirstName()+user.getLastName());
        List<User> users  = userService.getAllUsers();
        for(User tmp : users){
            if(tmp.getEmail().equals(user.getEmail())){
                return "redirect:/addUser?error";
            }
        }
        userService.save(user);
        return "redirect:/management";
    }
}
