package com.example.demo.repository;

import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.tours.Locations;
 
 
 

public interface LocationRepository extends JpaRepository<Locations, Long> {

 List<Locations> findByTour_id(long tour_id);
}
