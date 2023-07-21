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

import com.example.demo.entity.restaurant.Restaurant;
import com.example.demo.model.Images_response;
import com.example.demo.model.Response_restaurant;
import com.example.demo.service.RestaurantService;

@RestController
@RequestMapping("/test/restaurant")
@CrossOrigin(  allowedHeaders = {"Authorization", "Content-Type"})
public class RestaurantController {

	@Autowired
    RestaurantService restaurantService;

     

    @GetMapping
    public List<Response_restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }

    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(id, restaurant);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
    }
    
    
	@GetMapping("/images/{id}")
	public List<Images_response> getimagesHotel(@PathVariable Long id) {
		return restaurantService.getimages(id);
	}
	@DeleteMapping("/images/{id}")
	public void deleteimage(@PathVariable Long id) {
		restaurantService.deleteimage(id) ;
	}
	
	@PostMapping("/addimage/{id}")
	public void addimage(@PathVariable Long id,@RequestBody Images_response ImageURL ) {
		restaurantService.addimage(ImageURL.getImageURL(),id) ;
	}
}