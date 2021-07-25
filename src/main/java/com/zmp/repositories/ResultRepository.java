package com.zmp.repositories;

import com.zmp.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for Result entity
 * this class directly fetches data from the database
 */
public interface ResultRepository extends JpaRepository<Result,Long> {
}