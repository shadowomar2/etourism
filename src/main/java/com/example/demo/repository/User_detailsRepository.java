package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;
import com.example.demo.entity.Users_details;
import com.example.demo.entity.hotel.HotelImages;
import com.example.demo.entity.hotel.Hotels;

public interface User_detailsRepository extends JpaRepository<Users_details, Long>  {
	Optional<Users_details>  findByUser(User User);
	
}
