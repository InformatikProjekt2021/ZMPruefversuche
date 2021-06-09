package com.zmp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserManagementController {

    @GetMapping("/management")
    public String management() {
        return "management";
    }
}
