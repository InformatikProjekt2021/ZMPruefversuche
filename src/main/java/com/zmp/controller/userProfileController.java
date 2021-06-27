package com.zmp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class userProfileController {

    @GetMapping("/user")
    public String user() {
        return "userProfile";
    }
}
