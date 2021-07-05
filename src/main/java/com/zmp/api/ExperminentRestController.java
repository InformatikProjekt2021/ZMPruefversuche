package com.zmp.api;

import com.zmp.model.Experiment;
import com.zmp.repositories.ExperimentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExperminentRestController {
    ExperimentRepository experimentRepository;

    public ExperminentRestController(ExperimentRepository experimentRepository){
        this.experimentRepository= experimentRepository;
    }

    @GetMapping("/api/experiment")
    public List<Experiment> test() {
        return experimentRepository.findAll();
    }

    @PostMapping("/api/experiment/new")
    public String newExperiment(@ModelAttribute Experiment experiment){
        experimentRepository.save(experiment);
        return "redirect:/experiment?success";
    }
}
