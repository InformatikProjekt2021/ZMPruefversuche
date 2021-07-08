package com.zmp.services;

import com.zmp.model.PartResult;
import com.zmp.repositories.PartResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PartResultService {

        private final PartResultRepository resultRepository;

        @Autowired
        public PartResultService(PartResultRepository PartResultRepository) {
            this.resultRepository = PartResultRepository;
        }

        public PartResult save(PartResult partResult){
            return resultRepository.save(partResult);
        }

        public List<PartResult> getPartResult(){
            return resultRepository.findAll();
        }

        public void deleteExperiment(PartResult partResult){
            resultRepository.delete(partResult);
        }
        //find one?
}

