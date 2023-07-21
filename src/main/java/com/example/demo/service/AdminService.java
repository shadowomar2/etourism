package com.example.demo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.entity.Users_details;
import com.example.demo.entity.events.Booking_event;
import com.example.demo.entity.hotel.Hotels;
import com.example.demo.entity.tours.Booking_tour;
import com.example.demo.model.BookingResponse;
import com.example.demo.model.Response_hotels;
import com.example.demo.model.StatisticsResponse;
import com.example.demo.model.UserResponse;
import com.example.demo.repository.Booking_eventRepository;
import com.example.demo.repository.Booking_tourRepository;
import com.example.demo.repository.EventImagesRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.repository.TourRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.User_detailsRepository;

@Service
public class AdminService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	User_detailsRepository user_detailsRepository;

	@Autowired
	private Booking_tourRepository booking_tourRepository;

	@Autowired
	EventRepository eventRepository;

	@Autowired
	TourRepository tourRepository;


	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	private Booking_eventRepository booking_eventRepository;
	
	public List<UserResponse> getallusers() {
		List<User> users = userRepository.findAll();
		List<UserResponse> response_users = new ArrayList<>();
		for (User user : users) {

			UserResponse response = new UserResponse(user.getId(), user.getName(), user.getUsername(), user.getEmail(),
					null, 0, null, null, null, null);

			Users_details users_details = user.getUsers_details();
			if (users_details.getAddress() != null) {
				response.setAddress(users_details.getAddress());
			}
			if (users_details.getPhonenumber() != 0) {
				response.setPhonenumber(users_details.getPhonenumber());
			}
			if (users_details.getProfile_pictureURL() != null) {
				response.setProfile_pictureURL(users_details.getProfile_pictureURL());
			}
			if (users_details.getDateOfBirth() != null) {
				response.setDateOfBirth(users_details.getDateOfBirth());
			}
			if (users_details.getGender() != null) {
				response.setGender(users_details.getGender());
			}
			if (users_details.getCity() != null) {
				response.setCity(users_details.getCity());
			}

			response_users.add(response);
		}

		return response_users;
	}

	@Transactional
	public void deleteUser(Long id) {
		Optional<User> u = userRepository.findById(id);
		if (u.isEmpty()) {
			return;
		}	
		User user = u.get();
		Long iddetails=user.getUsers_details().getId();
		System.out.println(iddetails);
		userRepository.deleteRolesByUserId(id);
		userRepository.deleteById(id);
		userRepository.deleteUserDetailsByUserId(iddetails);
 
	}

	public BookingResponse getbooking(Long id) {
		Optional<User> u = userRepository.findById(id);
		if (u.isEmpty()) {
			return null;
		}
		User user = u.get();
		return new BookingResponse(user.getBookings_tour(), user.getBookings_event());

	}

	public void bookaccepttour(Long id) {
		Optional<Booking_tour> BT = booking_tourRepository.findById(id);
		if (BT.isEmpty()) {
			return;
		}
		Booking_tour booking_tour = BT.get();
		booking_tour.setState("accept");
		booking_tourRepository.save(booking_tour);
	}

	public void bookacceptevent(Long id) {
		Optional<Booking_event> BE = booking_eventRepository.findById(id);
		if (BE.isEmpty()) {
			return;
		}
		Booking_event booking_event = BE.get();
		booking_event.setState("Accept");
		booking_eventRepository.save(booking_event);
	}

	public UserResponse getuser(Long id) {
		Optional<User> u = userRepository.findById(id);
		if (u.isEmpty()) {
			return null;
		}	
		User user = u.get();
		
		UserResponse response = new UserResponse(user.getId(), user.getName(), user.getUsername(), user.getEmail(),
				null, 0, null, null, null, null);

		Users_details users_details = user.getUsers_details();
		if (users_details.getAddress() != null) {
			response.setAddress(users_details.getAddress());
		}
		if (users_details.getPhonenumber() != 0) {
			response.setPhonenumber(users_details.getPhonenumber());
		}
		if (users_details.getProfile_pictureURL() != null) {
			response.setProfile_pictureURL(users_details.getProfile_pictureURL());
		}
		if (users_details.getDateOfBirth() != null) {
			response.setDateOfBirth(users_details.getDateOfBirth());
		}
		if (users_details.getGender() != null) {
			response.setGender(users_details.getGender());
		}
		if (users_details.getCity() != null) {
			response.setCity(users_details.getCity());
		}
		return response;
	}

	public StatisticsResponse getstatistics() {
		 long numberOfUsers = userRepository.count();
		 long number_of_events = eventRepository.count();
		 long number_of_tours = tourRepository.count();
		 long number_of_hotels = hotelRepository.count();
		 long number_of_restaurants = restaurantRepository.count();
		 long number_of_bookings_tour = booking_tourRepository.count();
		 long number_of_bookings_event = booking_eventRepository.count();
		return new StatisticsResponse(numberOfUsers, number_of_events, number_of_tours, number_of_hotels, number_of_restaurants, number_of_bookings_tour, number_of_bookings_event);
	}
}
