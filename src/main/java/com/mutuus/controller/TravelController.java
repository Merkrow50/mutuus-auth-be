package com.mutuus.controller;

import com.mutuus.model.Travel;
import com.mutuus.repository.TravelRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/travel")
@AllArgsConstructor
public class TravelController {

  private TravelRepository travelRepository;

  @GetMapping
  public ResponseEntity<List<Travel>> getAll() {
    return ResponseEntity.ok(travelRepository.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Travel> getById(@PathVariable Integer id) {
    return ResponseEntity.ok(travelRepository.findById(id).get());
  }

}
