package com.zmp.repositories;

import com.zmp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for Role entity
 * this class directly fetches data from the database
 */
public interface RoleRepository extends JpaRepository<Role,Long> {

}
