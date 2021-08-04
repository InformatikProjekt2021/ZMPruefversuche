package com.zmp.services;

import com.zmp.communication.ConnectionHandler;
import com.zmp.model.Experiment;
import com.zmp.repositories.ExperimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * service to access the Experiment repository
 */
@Service
@Transactional
public class ExperimentService {

    private ExperimentRepository experimentRepository;

    @Autowired
    public ExperimentService(ExperimentRepository experimentRepository) {
        this.experimentRepository = experimentRepository;
    }

    public Experiment addExperiment(Experiment experiment){
        return experimentRepository.save(experiment);
    }

    public List<Experiment> getAllExperiment(){
        return experimentRepository.findAll();
    }

    public void deleteExperiment(Experiment experiment){
       experimentRepository.delete(experiment);
    }
    //find one?

    public Experiment findById (Long id){
        return experimentRepository.getOne(id);
    }
    public void updateExperiment (long id){
        Experiment tmp = experimentRepository.getOne(id);
        if(ConnectionHandler.getResults() != null && ConnectionHandler.getResults().size() >0) {
            tmp.setPartResult(ConnectionHandler.getResults());
        }
    }
}
