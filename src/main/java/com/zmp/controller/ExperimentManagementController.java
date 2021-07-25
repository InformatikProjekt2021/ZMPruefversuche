package com.zmp.controller;

import com.zmp.model.Experiment;
import com.zmp.repositories.ExperimentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/experimentmanagement")
public class ExperimentManagementController {

    private ExperimentRepository experimentRepository;

    public ExperimentManagementController(ExperimentRepository experimentRepository) {
        this.experimentRepository = experimentRepository;
    }

    @GetMapping
    public String getView(){
        return "experimentmanagement";
    }
    @GetMapping("/delete/{id}")
    public String deleteIncome(@PathVariable(value = "id") Long id, Model model) {
        Optional<Experiment> experiment = experimentRepository.findById(id);
        experimentRepository.delete(experiment.get());
        model.addAttribute("experiments",experimentRepository.findAll());
        return "redirect:/experimentmanagement";
    }

}
