package com.zmp.api;

import com.zmp.model.Experiment;
import com.zmp.services.ExperimentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiment")
public class ExperminentRestController {

    ExperimentService experimentService;

    public ExperminentRestController(ExperimentService experimentService){
        this.experimentService = experimentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Experiment>> getAllExperiments() {
        List<Experiment> all = experimentService.getAllExperiment();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping("/new")
    public  ResponseEntity<Experiment> newExperiment(@RequestBody Experiment experiment){
        Experiment tmp = experimentService.addExperiment(experiment);
        return new ResponseEntity<>(tmp,HttpStatus.CREATED);
    }
}
