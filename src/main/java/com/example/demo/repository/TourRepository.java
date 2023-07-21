package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.tours.Locations;
import com.example.demo.entity.tours.Tours;

public interface TourRepository extends JpaRepository<Tours, Long> {
 
     
}