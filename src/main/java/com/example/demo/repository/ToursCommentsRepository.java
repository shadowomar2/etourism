package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

 
import com.example.demo.entity.tours.ToursComments;

public interface ToursCommentsRepository extends JpaRepository<ToursComments, Long>{
	List<ToursComments> findByTour_id(long tour_id);
}
