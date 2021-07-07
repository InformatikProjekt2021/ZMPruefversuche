package com.zmp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ExperimentController {

    @GetMapping("/experiment")
    @ModelAttribute("experiment")
    public String management() {
        return "experiment";
    }
}
