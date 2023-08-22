package org.example.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "HANDY_WORKER")
@Getter
@Setter
public class HandyWorker extends User{
    @Column(name = "score")
    private Double score;
    @Column(name = "brand", nullable = false, length = 40)
    private String brand;
    @OneToOne
    private Resume resume;
}
