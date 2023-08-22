package org.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "USER_ACCOUNT")
@Getter
@Setter
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false, length = 40)
    private String username;
    @Column(name = "password", nullable = false, length = 40)
    private String password;
}
