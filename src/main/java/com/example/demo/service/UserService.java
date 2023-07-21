package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.entity.Users_details;
import com.example.demo.entity.events.Booking_event;
import com.example.demo.entity.tours.Booking_tour;
import com.example.demo.entity.tours.Locations;
import com.example.demo.model.BookingResponse;
import com.example.demo.model.Editdetails;
import com.example.demo.model.EditpasswordDTO;
import com.example.demo.repository.Booking_eventRepository;
import com.example.demo.repository.Booking_tourRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.User_detailsRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private User_detailsRepository detailsRepository;
	 
	 
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	public Users_details getdetails(String username) {

		Optional<User> u = userRepository.findByUsernameOrEmail(username,username);
		if (u.isEmpty()) {
			return null;
		}
		User user = u.get();
		return  user.getUsers_details() ;
		
	}
	public String getname(String username) {

		Optional<User> u = userRepository.findByUsernameOrEmail(username,username);
		if (u.isEmpty()) {
			return null;
		}
		User user = u.get();
		return  user.getName() ;
		
	}
	public Users_details editdetails(Editdetails editdetails, String username) {
	    Optional<User> optionalUser = userRepository.findByUsernameOrEmail(username, username);
	    if (optionalUser.isEmpty()) {
	        return null;
	    }
	    User user = optionalUser.get();
	    Users_details userDetails = user.getUsers_details();
	    
	    // Update the userDetails object only if the corresponding editdetails field is not null
	    if (editdetails.getAddress() != null) {
	        userDetails.setAddress(editdetails.getAddress());
	    }
	    if (	editdetails.getPhonenumber() != 0) {
	        userDetails.setPhonenumber(editdetails.getPhonenumber());
	    }
	    if (editdetails.getGender() != null) {
	        userDetails.setGender(editdetails.getGender());
	    }
	    if (editdetails.getCity() != null) {
	        userDetails.setCity(editdetails.getCity());
	    }
	    if (editdetails.getProfile_pictureURL() != null) {
	        userDetails.setProfile_pictureURL(editdetails.getProfile_pictureURL());
	    }
	    
	    detailsRepository.save(userDetails);
	    return userDetails;
	}
	
	
	public BookingResponse showbooking(String username) {

		Optional<User> u = userRepository.findByUsernameOrEmail(username,username);
		if (u.isEmpty()) {
			return null;
		}
		User user = u.get();		  
		 return new BookingResponse( user.getBookings_tour(), user.getBookings_event()) ;
		
	}
	 
	public void editpassword(EditpasswordDTO editpasswordDTO,String username) throws Exception {

		Optional<User> u = userRepository.findByUsernameOrEmail(username,username);
		if (u.isEmpty()) {
			 
		}
		else {
			try {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, editpasswordDTO.getPasswordold()));
			} catch (DisabledException e) {
				throw new Exception("USER_DISABLED", e);
			} catch (BadCredentialsException e) {
				throw new Exception("INVALID_CREDENTIALS", e);
			}
			
		User user = u.get();
		user.setPassword(passwordEncoder.encode(editpasswordDTO.getPasswordnew()));
		userRepository.save(user);
		}
		 
	}
	
	
//	public BookingResponse removebookingevent(String username,long id) {
//
//		Optional<User> u = userRepository.findByUsernameOrEmail(username,username);
//		if (u.isEmpty()) {
//			return null;
//		}
//		User user = u.get();		  
//		
//		 for (Booking_event bk : user.getBookings_event()) {
//			if(bk.getId()==id) {
//				user.removeBookingevent(bk);
//				booking_eventRepository.delete(bk);
//			}
//		}
//		 return new BookingResponse( user.getBookings_tour(), user.getBookings_event()) ;
//	}
//	public BookingResponse removebookingtour(String username,long id) {
//
//		Optional<User> u = userRepository.findByUsernameOrEmail(username,username);
//		if (u.isEmpty()) {
//			return null;
//		}
//		User user = u.get();		  
//		
//		 for (Booking_tour bk : user.getBookings_tour()) {
//			if(bk.getId()==id) {
//				user.removeBookingTour(bk);
//				booking_tourRepository.delete(bk);
//			}
//		}
//		 return new BookingResponse( user.getBookings_tour(), user.getBookings_event()) ;
//	}







	

}
