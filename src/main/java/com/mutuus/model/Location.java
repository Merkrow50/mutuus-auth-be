package com.mutuus.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_location")
public class Location {

    @Id
    @GeneratedValue
    public Integer id;

    @OneToOne
    private Travel originTravel;

    @OneToOne
    private Travel destinyTravel;

    Long accuracy;

    Long altitude;

    Long altitudeAccuracy;

    Long heading;

    Double latitude;

    Double longitude;

    Long speed;

}
