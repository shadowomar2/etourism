package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.entity.events.EventImages;
import com.example.demo.entity.events.Events;
import com.example.demo.entity.events.EventsComments;
import com.example.demo.entity.tours.ToursComments;
import com.example.demo.model.Comment_Response;
import com.example.demo.model.Commentmodel;
import com.example.demo.model.Eventmodel;
import com.example.demo.model.Images_response;
import com.example.demo.model.Response_Events;
 
import com.example.demo.service.EventsService;

@RestController
@RequestMapping("/user")
@CrossOrigin(  allowedHeaders = {"Authorization", "Content-Type"})
public class EventsController {
	@Autowired
	private EventsService eventsserver;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@GetMapping("/allevents")
	public List<Response_Events> getmsg( ) {
		 System.out.println("sdsdsd");
		return   eventsserver.getAllEvents() ;

	}
	@GetMapping("/imagessofevent/{id}")
	public List<Images_response> getimages(@PathVariable Long id) {
		List<Images_response> all= eventsserver.getImagesofEvent(id) ;
	 
		return all;
	}
	
	@DeleteMapping("/deleteimagesofevent/{id}")
	public void deleteimage(@PathVariable Long id) {
		eventsserver.deleteimage(id) ;
	}
	
	@PostMapping("/addimagesofevent/{id}")
	public void addimage(@PathVariable Long id,@RequestBody Images_response ImageURL ) {
		eventsserver.addimage(ImageURL.getImageURL(),id) ;
	}
	
	@GetMapping("/events/{id}")
	public  Events  getevents(@PathVariable Long id) {
		return eventsserver.getEventbyid(id);
	}
 
	@PostMapping("/addevents")
	public Long addevents(@RequestBody Eventmodel eventmodel) {
		return eventsserver.addevent(eventmodel);
	}

	@PutMapping("/editevent/{id}")
	public Long editevent( @RequestBody Eventmodel eventmodel,@PathVariable Long id) {
		return eventsserver.editevent(eventmodel,id );
	}

	@DeleteMapping("/deleltevent/{id}")
	public Long deleltevent(@PathVariable Long id) {
		return eventsserver.deleteevent(id);	 
	}
	
	
	@GetMapping("/geteventsComment/{eventID}")
	public  List<Comment_Response> getcomment(  @PathVariable Long eventID) {

		return eventsserver.getCommentsofEvents(eventID);

	}
	
	@PostMapping("/addeventsComment")
	public EventsComments addcomment(@RequestHeader("Authorization") String authorizationHeader,@RequestBody Commentmodel commentmodel) {
		String token = authorizationHeader.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		return eventsserver.addCommentsofEvents(commentmodel,username);

	}
	@PostMapping("/bookevent/{id}")
	public String booktour(@RequestHeader("Authorization") String authorizationHeader,@PathVariable Long id) {
		String token = authorizationHeader.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		return eventsserver.addBookingEvent(username,id);

	}
	@DeleteMapping("/bookevent/{id}")
	public void Deletbooktour(@RequestHeader("Authorization") String authorizationHeader,@PathVariable Long id) {
		String token = authorizationHeader.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		eventsserver.removeBookingEvent(username,id);

	}
	
}
