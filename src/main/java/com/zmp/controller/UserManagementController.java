package com.zmp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserManagementController {

    @GetMapping("/management")
    @ModelAttribute("user")
    public String management() {
        return "management";
    }
}
