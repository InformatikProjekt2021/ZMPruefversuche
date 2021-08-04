package com.zmp.controller;

import com.zmp.communication.Connection;
import com.zmp.communication.ConnectionHandler;
import com.zmp.model.Experiment;
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

/**
 * Controller to manage a new Experiment
 */
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
        Double[] data = new Double[4];
        data[0] = experiment.getHeight();
        data[1] = experiment.getTestSpeed();
        data[2] = experiment.getyAxisForce();
        data[3] = experiment.getWidth();
        int counter =1;
        //empty field handling
        if(experiment.getName().equals("")){
            return "redirect:/experiment?errorInputEmpty";
        }
        for(int i = 0; i<data.length;i++){
            if(data[i] == null){
                return "redirect:/experiment?errorInputEmpty";
            }
            if(data[i] == 0.0){
                counter++;
            }
        }
        //all values are 0 if counter == 5
        if(counter == 5 ){
            return "redirect:/experiment?errorInputEmpty";
        }
        // save input data
        try {
            Date date = new Date();
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = auth.getName();
            User user = userRepository.findByEmail(currentPrincipalName);
            experiment.setDate(date.toString());
            experiment.setUserId(user);
            experimentService.addExperiment(experiment);
        }catch (Exception e){
            return "redirect:/experiment?errorUnknown";
        }

        if(ConnectionHandler.getClientSocket() != null){
            try {
                ConnectionHandler.setExperiment(experiment);
                Connection tcp = new Connection(ConnectionHandler.getClientSocket());
                ConnectionHandler.setConnection(tcp);

                //send data
                tcp.writeStream(data);
                //read data
                tcp.readStream(this.partResultService);
                experimentService.updateExperiment(experiment.getId());
                System.out.println(experimentService.findById(experiment.getId()).getPartResult().size()+" Datasets received for Experiment "+ experiment.getId());

            }catch (Exception e){
                return "redirect:/experiment?errorTcp";
            }
        }else{
            ConnectionHandler.setClientSocket(null);
            return "redirect:/experiment?error";
        }
        ConnectionHandler.setClientSocket(null);
        return "redirect:/experiment?success";
    }

}
