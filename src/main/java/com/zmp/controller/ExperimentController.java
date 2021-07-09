package com.zmp.controller;

import com.zmp.communication.Connection;
import com.zmp.communication.ConnectionHandler;
import com.zmp.model.Experiment;
import com.zmp.model.PartResult;
import com.zmp.model.User;
import com.zmp.repositories.UserRepository;
import com.zmp.services.ExperimentService;
import com.zmp.services.PartResultService;
import com.zmp.services.ResultService;
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
    PartResultService partResultService;
    ResultService resultService;

    @Autowired
    public ExperimentController(ExperimentService experimentService,UserRepository userRepository,
                                PartResultService partResultService,ResultService resultService){
        super();
        this.partResultService = partResultService;
        this.resultService = resultService;
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
        ConnectionHandler.setExperiment(experiment);
        Connection tcp = new Connection(ConnectionHandler.getClientSocket());
        ConnectionHandler.setConnection(tcp);

        Double[] data = new Double[4];
        data[0] = experiment.getHeight();
        data[1] = experiment.getTestSpeed();
        data[2] = experiment.getyAxisForce();
        data[3] = experiment.getWidth();

        tcp.writeStream(data);
        PartResult partResult = tcp.readStream();
        if(partResult != null) {
            partResultService.save(partResult);
        }else {
            System.out.println("no data received from client");
        }
        Date date  = new Date();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        User user = userRepository.findByEmail(currentPrincipalName);
        experiment.setDate(date.toString());
        experiment.setUserId(user);
        experimentService.addExperiment(experiment);
        return "redirect:/experiment";
    }

}
