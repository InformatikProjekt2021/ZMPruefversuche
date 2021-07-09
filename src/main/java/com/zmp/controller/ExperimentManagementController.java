package com.zmp.controller;

import com.zmp.repositories.ExperimentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/experimentmanagement")
public class ExperimentManagementController {

    private ExperimentRepository experimentRepository;

    public ExperimentManagementController(ExperimentRepository experimentRepository) {
        this.experimentRepository = experimentRepository;
    }

    @GetMapping
    public String getView(){
        return "/experimentManagement";
    }

}
