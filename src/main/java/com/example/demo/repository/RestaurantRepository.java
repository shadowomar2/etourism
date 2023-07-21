package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.restaurant.Restaurant;
import com.example.demo.entity.tours.Tours;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

}
