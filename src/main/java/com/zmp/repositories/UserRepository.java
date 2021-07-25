package com.zmp.repositories;

import com.zmp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for user entity
 * this class directly fetches data from the database
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String username);
}
