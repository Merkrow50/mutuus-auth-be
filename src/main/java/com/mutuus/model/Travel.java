package com.mutuus.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_travel")
public class Travel implements Serializable {

    @Id
    @GeneratedValue
    public Integer id;

    private LocalDateTime dateTime;

    @OneToOne
    private Location origin;

    @OneToOne
    private Location destiny;

    @OneToOne
    private Car car;


}
