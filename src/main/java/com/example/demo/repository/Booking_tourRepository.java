package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.tours.Booking_tour;

public interface Booking_tourRepository extends JpaRepository<Booking_tour, Long>{
	List<Booking_tour> findByUser_id(long user_id);
}
