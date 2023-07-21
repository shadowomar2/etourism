package com.example.demo.repository;

 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.events.EventImages;
import com.example.demo.entity.tours.TourImages;
 

public interface EventImagesRepository extends JpaRepository<EventImages, Long> {
 
	 List<EventImages> findByEvents_Id(long event_id);     
	 void deleteByEvents_Id(long event_id);
}
