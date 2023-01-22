package com.project.springsecurityauth.repository;

import com.project.springsecurityauth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    //query method within our role repository
    Optional<Role> findByName(String name);
}
