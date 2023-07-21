package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.tours.TourImages;

public interface TourImagesRepository extends JpaRepository<TourImages,Long>{
	 List<TourImages> findByTour_id(long tour_id);
}
