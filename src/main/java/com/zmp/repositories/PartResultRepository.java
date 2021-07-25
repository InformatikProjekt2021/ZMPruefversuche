package com.zmp.repositories;

import com.zmp.model.PartResult;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for PartResult entity
 * this class directly fetches data from the database
 */
public interface PartResultRepository extends JpaRepository<PartResult,Long> {
}