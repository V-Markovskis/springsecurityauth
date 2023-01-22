package com.project.springsecurityauth.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
//jpa stuff at the bottom
@Entity
@Table(name = "roles")

// we have admin and users, so need to create roles class
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


}
