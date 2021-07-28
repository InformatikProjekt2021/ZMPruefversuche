package com.zmp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller to login view
 */
@Controller
public class LoginController {

   @GetMapping("/login")
   public String login() {
       return "login";
   }
}
