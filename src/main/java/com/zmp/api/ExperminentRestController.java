package com.zmp.api;

import com.zmp.model.Experiment;
import com.zmp.model.User;
import com.zmp.repositories.UserRepository;
import com.zmp.services.ExperimentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/experiment")
public class ExperminentRestController {

    ExperimentService experimentService;
    UserRepository userRepository;

    public ExperminentRestController(ExperimentService experimentService,UserRepository userRepository){
        this.experimentService = experimentService;
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Experiment>> getAllExperiments() {
        List<Experiment> all = experimentService.getAllExperiment();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping("/new")
    public  ResponseEntity<Experiment> newExperiment(@RequestBody Experiment experiment){
        Date date  = new Date();
        experiment.setDate(date.toString());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        User user = userRepository.findByEmail(currentPrincipalName);
        experiment.setUserId(user);

        Experiment tmp = experimentService.addExperiment(experiment);
        return new ResponseEntity<>(tmp,HttpStatus.CREATED);
    }
}
