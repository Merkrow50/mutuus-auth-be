package com.mutuus.dto;

import com.mutuus.model.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TravelDTO {

  private Integer id;

  private Location origin;

  private Location destiny;

  private CarDTO car;



}
