package com.zmp.services;

import com.zmp.model.Result;
import com.zmp.repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ResultService {

    private final ResultRepository resultRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public Result save(Result result){
        return resultRepository.save(result);
    }

    public List<Result> getPartResult(){
        return resultRepository.findAll();
    }

    public void deleteExperiment(Result result){
        resultRepository.delete(result);
    }
    //find one?
}
