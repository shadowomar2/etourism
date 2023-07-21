package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.restaurant.Restaurant;
import com.example.demo.entity.restaurant.RestaurantImages;

public interface RestaurantimageRepository extends JpaRepository<RestaurantImages, Long> {
 List<RestaurantImages> findByRestaurant(Restaurant restaurant);
}
