package com.zmp.api;

import com.zmp.model.Experiment;
import com.zmp.model.User;
import com.zmp.model.dto.ExperimentDto;
import com.zmp.repositories.UserRepository;
import com.zmp.services.ExperimentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * API for Experiments
 * this class can be used to communicate with the database (Rest endpoint)
 */

@RestController
@RequestMapping("/api/experiment")
public class ExperminentRestController {

    ExperimentService experimentService;
    UserRepository userRepository;

    /**
     * Constructor is called on application start
     */
    public ExperminentRestController(ExperimentService experimentService,UserRepository userRepository){
        this.experimentService = experimentService;
        this.userRepository = userRepository;
    }

    /**
     * Function to get all Experiments by GET request
     * uses a DTO to transfer relevant Data from the real db entity
     * @return returns A HTTP responsentity with a List of all Experiments in its body
     */
    @GetMapping("/all")
    public ResponseEntity<List<ExperimentDto>> getAllExperiments() {
        List<Experiment> all = experimentService.getAllExperiment();
        List<ExperimentDto> result = new ArrayList<>();

        for(Experiment experiment: all){
            ExperimentDto dto = new ExperimentDto();
            dto.setDate(experiment.getDate());
            dto.setName(experiment.getName());
            dto.setId(experiment.getId());
            dto.setTestSpeed(experiment.getTestSpeed());
            dto.setHeight(experiment.getHeight());
            dto.setWidth(experiment.getWidth());
            dto.setyAxisForce(experiment.getyAxisForce());
            result.add(dto);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Function to create new experiments by POST request
     * currently not in use, experiment is built over ExperimentController in Package controller
     * @return returns A HTTP response entity with the new experiment and a "CREATED" code in its body
     */
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
