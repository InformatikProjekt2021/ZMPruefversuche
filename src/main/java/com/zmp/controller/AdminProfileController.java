package com.zmp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminProfileController {
//test

    @GetMapping("/admin")
    public String admin() {
        return "adminProfile";
    }
}