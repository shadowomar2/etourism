package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.events.Events;
import com.example.demo.entity.tours.Tours;

public interface EventRepository extends JpaRepository<Events, Long> {

}
