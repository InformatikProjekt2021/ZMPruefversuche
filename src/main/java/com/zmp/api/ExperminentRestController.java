package com.zmp.api;

import com.zmp.model.Experiment;
import com.zmp.model.User;
import com.zmp.repositories.ExperimentRepository;
import com.zmp.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
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
}
