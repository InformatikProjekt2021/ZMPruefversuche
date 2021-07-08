package com.zmp.controller;

import com.zmp.model.Experiment;
import com.zmp.model.User;
import com.zmp.repositories.UserRepository;
import com.zmp.services.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/experiment")
public class ExperimentController {

    ExperimentService experimentService;
    UserRepository userRepository;

    @Autowired
    public ExperimentController(ExperimentService experimentService,UserRepository userRepository){
        super();
        this.experimentService = experimentService;
        this.userRepository = userRepository;
    }

    @ModelAttribute("experiment")
    public Experiment experiment(){
        return new Experiment();
    }

    @GetMapping()
    public String management() {
        return "experiment";
    }

    @PostMapping
    public String newExperiment(@ModelAttribute("experiment") Experiment experiment){
        Date date  = new Date();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        User user = userRepository.findByEmail(currentPrincipalName);
        experiment.setDate(date.toString());
        experiment.setUserId(user);
        experimentService.addExperiment(experiment);
        return "redirect:/experiment?success";
    }

}
