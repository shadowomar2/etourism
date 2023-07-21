package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.JwtTokenUtil;
import com.example.demo.entity.tours.Booking_tour;
import com.example.demo.entity.tours.Locations;
 
import com.example.demo.entity.tours.Tours;
import com.example.demo.entity.tours.ToursComments;
import com.example.demo.model.Comment_Response;
import com.example.demo.model.Commentmodel;
import com.example.demo.model.Images_response;
import com.example.demo.model.Response_tours;
import com.example.demo.model.Tourmodel;
import com.example.demo.service.SignupService;
import com.example.demo.service.ToursService;

@RestController
@RequestMapping("/user")
@CrossOrigin(  allowedHeaders = {"Authorization", "Content-Type"})
public class ToursController {
	
	@Autowired
	private ToursService toursserver;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@GetMapping("/alltours")
	public List<Response_tours> getmsg( ) {
		 
		return   toursserver.getAllTours() ;

	}
	
	
	
	@GetMapping("/locationsoftour/{id}")
	public List<Locations> getlocation(@PathVariable Long id) {
		List<Locations> all= toursserver.getlocationofTour(id) ;
	 
		return all;

	}
	@GetMapping("/imagessoftour/{id}")
	public List<Images_response> getimages(@PathVariable Long id) {
		List<Images_response> all= toursserver.getImagesofTour(id) ;
	 
		return all;

	}

	@DeleteMapping("/deleteimagesoftour/{id}")
	public void deleteimage(@PathVariable Long id) {
	  toursserver.deleteimage(id) ;
	}
	
	@PostMapping("/addimagesoftour/{id}")
	public void addimage(@PathVariable Long id,@RequestBody Images_response ImageURL ) {
	  toursserver.addimage(ImageURL.getImageURL(),id) ;
	}
	@GetMapping("/tours/{id}")
	public Optional<Tours> gettours(@PathVariable Long id) {

		return toursserver.gettourbyid(id);

	}
	
	
	@GetMapping("/gettoursComment/{tourID}")
	public  List<Comment_Response> getcomment(  @PathVariable Long tourID) {

		return toursserver.getCommentsofTours(tourID);

	}
	
	@PostMapping("/addtoursComment")
	public ToursComments addcomment(@RequestHeader("Authorization") String authorizationHeader,@RequestBody Commentmodel commentmodel) {
		String token = authorizationHeader.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		return toursserver.addCommentsofTours(commentmodel,username);

	}
	
	
	@PostMapping("/addtours")
	public Long addtour(@RequestBody Tourmodel tourmodel) {

		return toursserver.addtour(tourmodel);

	}

	@PutMapping("/edittour/{id}")
	public Long edittour( @RequestBody Tourmodel tourmodel,@PathVariable Long id) {
		return toursserver.edittour(tourmodel,id );
	}

	@DeleteMapping("/delelttour/{id}")
	public Long delelttour(@PathVariable Long id) {
		return toursserver.deletetour(id);
	 
	}
	@DeleteMapping("/deleltlocationsoftour/{id}")
	public void deleltlocationsoftour(@PathVariable Long id) {
		  toursserver.deletelocationsoftour(id);
	 
	}
	@PostMapping("/addlocationsoftour/{id}")
	public String addlocationsoftour(@RequestBody  Locations  locations,@PathVariable Long id) {
		  return toursserver.addlocationsoftour(locations,id);
	 
	}
	
	
	@PostMapping("/booktour/{id}")
	public String booktour(@RequestHeader("Authorization") String authorizationHeader,@PathVariable Long id) {
		String token = authorizationHeader.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		return toursserver.addBookingTour(username,id);

	}
	@DeleteMapping("/booktour/{id}")
	public void Deletbooktour(@RequestHeader("Authorization") String authorizationHeader,@PathVariable Long id) {
		String token = authorizationHeader.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		  toursserver.removeBookingTour(username,id);

	}
	
}
