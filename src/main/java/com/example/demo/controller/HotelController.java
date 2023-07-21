package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.hotel.Hotels;
import com.example.demo.model.Images_response;
import com.example.demo.model.Response_hotels;
import com.example.demo.service.HotelService;

@RestController
@RequestMapping("/test/hotels")
@CrossOrigin(allowedHeaders = { "Authorization", "Content-Type" })
public class HotelController {
	
	
	@Autowired
	HotelService hotelService;

	@GetMapping
	public List<Response_hotels> getAllHotels() {
		return hotelService.getAllHotels();
	}

	@GetMapping("/{id}")
	public Hotels getHotelById(@PathVariable Long id) {
		return hotelService.getHotelById(id);
	}

	@PostMapping
	public Hotels createHotel(@RequestBody Hotels hotel) {
		return hotelService.createHotel(hotel);
	}

	@PutMapping("/{id}")
	public Hotels updateHotel(@PathVariable Long id, @RequestBody Hotels hotel) {
		return hotelService.updateHotel(id, hotel);
	}

	@DeleteMapping("/{id}")
	public void deleteHotel(@PathVariable Long id) {
		hotelService.deleteHotel(id);
	}
	
	
	@GetMapping("/images/{id}")
	public List<Images_response> getimagesHotel(@PathVariable Long id) {
		return hotelService.getimages(id);
	}
	@DeleteMapping("/images/{id}")
	public void deleteimage(@PathVariable Long id) {
		hotelService.deleteimage(id) ;
	}
	
	@PostMapping("/addimage/{id}")
	public void addimage(@PathVariable Long id,@RequestBody Images_response ImageURL ) {
		hotelService.addimage(ImageURL.getImageURL(),id) ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}