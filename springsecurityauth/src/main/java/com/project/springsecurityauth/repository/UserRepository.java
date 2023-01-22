package com.project.springsecurityauth.repository;

import com.project.springsecurityauth.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    //query method where we are going to find users by username
    //boolean for user exist

    //specific way that jpa allows you to create query methods
    //and pull specific info without having to create SQL?? statements
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
