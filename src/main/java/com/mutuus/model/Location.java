package com.mutuus.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_location")
public class Location {

    @Id
    @GeneratedValue
    public Integer id;

    Long accuracy;

    Long altitude;

    Long altitudeAccuracy;

    Long heading;

    Double latitude;

    Double longitude;

    Long speed;

}
