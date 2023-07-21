package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.events.EventImages;
import com.example.demo.entity.events.Events;
import com.example.demo.entity.hotel.HotelImages;
import com.example.demo.entity.hotel.Hotels;
import com.example.demo.entity.tours.Locations;
import com.example.demo.entity.tours.TourImages;
import com.example.demo.entity.tours.Tours;
import com.example.demo.model.Images_response;
import com.example.demo.model.Response_hotels;
import com.example.demo.model.Response_tours;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.HotelimageRepository;

@Service
public class HotelService {

	@Autowired
	HotelRepository hotelRepository;

	@Autowired
	HotelimageRepository hotelimageRepository;

	public List<Response_hotels> getAllHotels() {
		List<Hotels> hotels= hotelRepository.findAll();
		List<Response_hotels> response_hotels = new ArrayList<>();
		for (Hotels hotel : hotels) {
			Response_hotels response = new Response_hotels(hotel.getId(), hotel.getName(), hotel.getPlace(),  
					hotel.getLongitude(), hotel.getLatitude(),    hotel.getPhonenumber(), hotel.getPhonenumber2(),
					hotel.getDescription(),null );
			 
			response.setImages(hotelimageRepository.findByHotels(hotel));
		 
			response_hotels.add(response);
		}
	 
		return response_hotels;
	}

	public Hotels getHotelById(Long id) {

		Optional<Hotels> optional = hotelRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		Hotels hotel = optional.get();
		return hotel;

	}

	public Hotels createHotel(Hotels hotel) {

    Hotels h = hotelRepository.save(new Hotels(hotel.getName(), hotel.getPlace(), hotel.getLongitude()
        , hotel.getLatitude(), hotel.getPhonenumber(),
          hotel.getPhonenumber2(), null, hotel.getDescription()));

    Set<HotelImages> images = hotel.getImages();
    if (images != null) {
      for (HotelImages img : hotel.getImages()) {
        hotelimageRepository.save(new HotelImages(img.getImageURL(), h));
      }

    }
    return h;
  }
	public Hotels updateHotel(Long id, Hotels hotelDetails) {
		Hotels hotel = getHotelById(id);
		if (hotel == null) {
			return null;
		}
		hotel.setName(hotelDetails.getName());
		hotel.setPlace(hotelDetails.getPlace());
		hotel.setLongitude(hotelDetails.getLongitude());
		hotel.setLatitude(hotelDetails.getLatitude());
		hotel.setPhonenumber(hotelDetails.getPhonenumber());
		hotel.setPhonenumber2(hotelDetails.getPhonenumber2());
		hotel.setDescription(hotelDetails.getDescription());
 
		return hotelRepository.save(hotel);
	}

	public void deleteHotel(Long id) {
		hotelRepository.delete(getHotelById(id));
	}

	public List<Images_response> getimages(Long id) {
		Optional<Hotels> optional = hotelRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		Hotels hotel = optional.get();
		List<HotelImages> images = hotelimageRepository.findByHotels(hotel);
		List<Images_response> response = new ArrayList<>();
		for (HotelImages eventimage : images) {
			response.add(new Images_response(eventimage.getId(), eventimage.getHotels().getId(), eventimage.getImageURL()));
		}
		return response;
	}
	public void deleteimage(Long id) {
		Optional<HotelImages> images = hotelimageRepository.findById(id);
		if (!images.isEmpty()) {
			hotelimageRepository.deleteById(id);
		}

		
	}

	public void addimage(String imageURL, Long id) {
		Optional<Hotels> eventsoptional = hotelRepository.findById(id);
		if (!eventsoptional.isEmpty()) {
			Hotels event = eventsoptional.get();
			hotelimageRepository.save(new HotelImages(imageURL, event));
		}
		
	}
 
}