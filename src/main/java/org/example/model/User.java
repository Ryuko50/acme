package org.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 40)
    private String name;
    @Column(name = "password", nullable = false, length = 40)
    private String password;
}
