package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.hotel.HotelImages;
import com.example.demo.entity.hotel.Hotels;
import com.example.demo.entity.restaurant.Restaurant;
import com.example.demo.entity.restaurant.RestaurantImages;
import com.example.demo.model.Images_response;
import com.example.demo.model.Response_hotels;
import com.example.demo.model.Response_restaurant;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.repository.RestaurantimageRepository;

@Service
public class RestaurantService {
	@Autowired
	RestaurantRepository restaurantRepository;
	@Autowired
	RestaurantimageRepository restaurantimageRepository;
	
	
	public List<Response_restaurant> getAllRestaurants() {
		List<Restaurant> restaurants= restaurantRepository.findAll();
		List<Response_restaurant> response_restaurants = new ArrayList<>();
		for (Restaurant restaurant : restaurants) {
			Response_restaurant response = new Response_restaurant(restaurant.getId(), restaurant.getName(), restaurant.getPlace(),  
					restaurant.getLongitude(), restaurant.getLatitude(),    restaurant.getPhonenumber(), restaurant.getPhonenumber2(),
					restaurant.getDescription(),null );
			 
			response.setImages(restaurantimageRepository.findByRestaurant(restaurant));
		 
			response_restaurants.add(response);
		}
	 
		return response_restaurants;
	}

	public Restaurant getRestaurantById(Long id) {

		Optional<Restaurant> optional = restaurantRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		Restaurant restaurant = optional.get();
		return restaurant;
		
	}

	public Restaurant createRestaurant(Restaurant restaurant) {
		Restaurant r = restaurantRepository.save(new Restaurant(restaurant.getName(), restaurant.getPlace(),
                restaurant.getLongitude(), restaurant.getLatitude(), restaurant.getPhonenumber(),
                restaurant.getPhonenumber2(), restaurant.getDescription(), null));
        
        Set<RestaurantImages> images = restaurant.getImages();
        if (images != null) {
            for (RestaurantImages img : restaurant.getImages()) {
                restaurantimageRepository.save(new RestaurantImages(img.getImageURL(), r));
            }

        }
        return r;
	}

	public Restaurant updateRestaurant(Long id, Restaurant restaurantDetails) {
		Restaurant restaurant = getRestaurantById(id);
		restaurant.setName(restaurantDetails.getName());
		restaurant.setPlace(restaurantDetails.getPlace());
		restaurant.setLongitude(restaurantDetails.getLongitude());
		restaurant.setLatitude(restaurantDetails.getLatitude());
		restaurant.setPhonenumber(restaurantDetails.getPhonenumber());
		restaurant.setPhonenumber2(restaurantDetails.getPhonenumber2());
		restaurant.setDescription(restaurantDetails.getDescription());
 
		return restaurantRepository.save(restaurant);
	}

	public void deleteRestaurant(Long id) {
		restaurantRepository.delete(getRestaurantById(id));
	}

	public List<Images_response> getimages(Long id) {
		Optional<Restaurant> optional = restaurantRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		Restaurant restaurant = optional.get();
		List<RestaurantImages> images = restaurantimageRepository.findByRestaurant(restaurant);
		List<Images_response> response = new ArrayList<>();
		for (RestaurantImages eventimage : images) {
			response.add(new Images_response(eventimage.getId(), eventimage.getRestaurant().getId(), eventimage.getImageURL()));
		}
		return response;
	}
	public void deleteimage(Long id) {
		Optional<RestaurantImages> images = restaurantimageRepository.findById(id);
		if (!images.isEmpty()) {
			restaurantimageRepository.deleteById(id);
		}

		
	}

	public void addimage(String imageURL, Long id) {
		Optional<Restaurant> eventsoptional = restaurantRepository.findById(id);
		if (!eventsoptional.isEmpty()) {
			Restaurant event = eventsoptional.get();
			restaurantimageRepository.save(new RestaurantImages(imageURL, event));
		}
		
	}
}