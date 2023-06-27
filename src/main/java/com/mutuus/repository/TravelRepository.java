package com.mutuus.repository;

import com.mutuus.dto.TravelDTO;
import com.mutuus.model.Travel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Integer> {

}
