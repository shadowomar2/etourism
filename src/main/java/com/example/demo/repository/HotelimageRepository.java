package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.hotel.HotelImages;
import com.example.demo.entity.hotel.Hotels;

public interface HotelimageRepository extends JpaRepository<HotelImages, Long>{
 List<HotelImages> findByHotels(Hotels hotels);
}
