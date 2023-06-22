package com.mutuus.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_travel")
public class Travel {

    @Id
    @GeneratedValue
    public Integer id;

    @OneToOne
    private Location origin;

    @OneToOne
    private Location destiny;

    @OneToOne
    private Car car;


}
