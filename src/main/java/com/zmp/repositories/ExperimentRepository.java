package com.zmp.repositories;

import com.zmp.model.Experiment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for Experiment entity
 * this class directly fetches data from the database
 */
public interface ExperimentRepository extends JpaRepository<Experiment,Long> {
}