package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "USER")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 40)
    private String name;
    @Column(name = "middlename", length = 40)
    private String middlename;
    @Column(name = "surname", nullable = false, length = 40)
    private String surname;
    @Column(name = "photo", length = 200)
    private String photo;
    @Column(name = "email", nullable = false, length = 40)
    private String email;
    @Column(name = "address", nullable = false, length = 200)
    private String address;
    @Column(name = "banned")
    private boolean banned;
    @OneToOne
    private UserAccount userAccount;
}
