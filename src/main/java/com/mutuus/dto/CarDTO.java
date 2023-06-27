package com.mutuus.dto;

import com.mutuus.model.User;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {


  private Integer id;

  private String model;

  private String plate;

  private User pilot;

  private List<User> passengers;

  private Long passengersLimit;

}
