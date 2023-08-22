package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "CUSTOMER")
@Getter
@Setter
public class Customer extends User{

    @Column(name = "score")
    private Double score;
}
