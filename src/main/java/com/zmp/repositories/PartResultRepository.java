package com.zmp.repositories;

import com.zmp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartResultRepository extends JpaRepository<User,Long> {
}