package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "ADMIN")
@Getter
@Setter
public class Admin extends User{
}
