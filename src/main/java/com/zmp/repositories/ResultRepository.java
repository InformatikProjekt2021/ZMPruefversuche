package com.zmp.repositories;

import com.zmp.model.dto.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result,Long> {
}