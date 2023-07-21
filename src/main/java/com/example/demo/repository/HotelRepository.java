package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.hotel.Hotels;
 

public interface HotelRepository extends JpaRepository<Hotels, Long> {

}
