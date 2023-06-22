package com.mutuus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_car")
public class Car {

    @Id
    @GeneratedValue
    public Integer id;

    private String model;

    private String plate;

    @OneToOne
    private User pilot;

    @OneToMany
    private List<User> passengers;

    private Long passengersLimit;

}
