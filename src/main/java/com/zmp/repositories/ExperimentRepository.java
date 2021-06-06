package com.zmp.repositories;

import com.zmp.model.dto.Experiment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperimentRepository extends JpaRepository<Experiment,Long> {
}