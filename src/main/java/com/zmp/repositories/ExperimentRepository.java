package com.zmp.repositories;

import com.zmp.model.Experiment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperimentRepository extends JpaRepository<Experiment,Long> {
}