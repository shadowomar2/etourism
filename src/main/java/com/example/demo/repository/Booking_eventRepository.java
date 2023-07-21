package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.events.Booking_event;

public interface Booking_eventRepository extends JpaRepository<Booking_event, Long> {
	List<Booking_event> findByUser_id(long user_id);
}
