package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "SPONSOR")
@Getter
@Setter
public class Sponsor extends User {
}
