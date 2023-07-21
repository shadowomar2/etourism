package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.entity.events.Booking_event;
import com.example.demo.entity.events.EventImages;
import com.example.demo.entity.events.Events;
import com.example.demo.entity.events.EventsComments;
import com.example.demo.entity.tours.Booking_tour;
import com.example.demo.entity.tours.Locations;
import com.example.demo.entity.tours.TourImages;
import com.example.demo.entity.tours.Tours;
import com.example.demo.entity.tours.ToursComments;
import com.example.demo.model.Comment_Response;
import com.example.demo.model.Commentmodel;
import com.example.demo.model.Eventmodel;
import com.example.demo.model.Images_response;
import com.example.demo.model.Response_Events;
import com.example.demo.model.Response_tours;
import com.example.demo.model.Tourmodel;
import com.example.demo.repository.Booking_eventRepository;
import com.example.demo.repository.EventImagesRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.EventsCommentsRepository;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.TourImagesRepository;
import com.example.demo.repository.TourRepository;
import com.example.demo.repository.ToursCommentsRepository;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Service
public class EventsService {
	@Autowired
	EventRepository eventRepository;
	@Autowired
	private Booking_eventRepository booking_eventRepository;
	@Autowired
	EventImagesRepository eventimagerepository;
	@Autowired
	EventsCommentsRepository commentsRepository;
	@Autowired
	UserRepository userRepository;

	public List<Comment_Response> getCommentsofEvents(Long id) {

		List<EventsComments> res = commentsRepository.findByEvents_id(id);
		if (res.isEmpty()) {
			return null;
		}
		List<Comment_Response> response = new ArrayList<>();
		for (EventsComments r : res) {
			User user =userRepository.getById(r.getUser_id());
			if (user != null) {
				response.add(new Comment_Response(r.getId(),user.getName(), r.getEvent_id(), r.getcomment()));

			}
		}
		return response;

	}

	public EventsComments addCommentsofEvents(Commentmodel commentmodel, String username) {
		Optional<User> u = userRepository.findByUsernameOrEmail(username, username);
		if (u.isEmpty()) {
			return null;
		}
		User user = u.get();
		Optional<Events> optionalTour = eventRepository.findById(commentmodel.getID());
		if (optionalTour.isEmpty()) {
			return null;
		}
		Events event = optionalTour.get();

		return commentsRepository
				.save(new EventsComments(commentmodel.getComment(), user.getId(), user, commentmodel.getID(), event));

	}

	public List<Images_response> getImagesofEvent(Long id) {
		List<EventImages> images = eventimagerepository.findByEvents_Id(id);
		List<Images_response> response = new ArrayList<>();
		for (EventImages eventimage : images) {
			response.add(new Images_response(eventimage.getId(), eventimage.getEvent_id(), eventimage.getImageURL()));
		}
		return response;
	 

	}

	public  Events  getEventbyid(long id) {
		 
		 Optional<Events> optionalEvents = eventRepository.findById(id);
			if (optionalEvents.isEmpty()) {
				return null;
			}
			else {
				return optionalEvents.get();			}
		 
	}

	public List<Response_Events> getAllEvents() {
		List<Events> events = eventRepository.findAll();
		List<Response_Events> response_Events = new ArrayList<>();
		for (Events event : events) {
			Response_Events response_Event = new Response_Events(event.getId(), event.getName(), event.getPlace(),
					event.getLongitude(), event.getLatitude(), event.getStarttime(), event.getEndtime(),
					event.getLastdatetobook(), event.getPrice(), event.getMaximumbooking(), event.getPhonenumber(),
					event.getPhonenumber2(), event.getDescription(), event.getOwnername(), null);
			response_Event.setImages(eventimagerepository.findByEvents_Id(event.getId()));
			response_Events.add(response_Event);
		}
		System.out.println(response_Events);
		return response_Events;
	}

	public Long addevent(Eventmodel event) {

		Events savedtour = eventRepository.save(new Events(event.getName(), event.getPlace(), event.getLongitude(),
				event.getLatitude(), event.getStarttime(), event.getEndtime(), event.getLastdatetobook(),
				event.getPrice(), event.getMaximumbooking(), event.getPhonenumber(), event.getPhonenumber2(),

				event.getDescription(), event.getOwnername()));
		Set<EventImages> images = event.getImages();
		if (images != null) {
			for (EventImages img : event.getImages()) {
				eventimagerepository.save(new EventImages(img.getImageURL(), savedtour.getId(), savedtour));
			}

		}

		return savedtour.getId();
	}

	public Long editevent(Eventmodel event, long id) {

		Optional<Events> optionalEvents = eventRepository.findById(id);
		if (optionalEvents.isEmpty()) {
			return null;
		}
		 
		Events existingEvent = optionalEvents.get();
		existingEvent.setName(event.getName() != null ? event.getName() : existingEvent.getName());
		existingEvent.setPlace(event.getPlace() != null ? event.getPlace() : existingEvent.getPlace());
		existingEvent.setStarttime(event.getStarttime() != null ? event.getStarttime() : existingEvent.getStarttime());
		existingEvent.setEndtime(event.getEndtime() != null ? event.getEndtime() : existingEvent.getEndtime());

		existingEvent.setLastdatetobook(
				event.getLastdatetobook() != null ? event.getLastdatetobook() : existingEvent.getLastdatetobook());
		existingEvent.setPrice(event.getPrice() != 0 ? event.getPrice() : existingEvent.getPrice());
		existingEvent.setMaximumbooking(
				event.getMaximumbooking() != 0 ? event.getMaximumbooking() : existingEvent.getMaximumbooking());
		existingEvent
				.setPhonenumber(event.getPhonenumber() != 0 ? event.getPhonenumber() : existingEvent.getPhonenumber());
		existingEvent.setPhonenumber2(
				event.getPhonenumber2() != 0 ? event.getPhonenumber2() : existingEvent.getPhonenumber2());
		existingEvent.setDescription(
				event.getDescription() != null ? event.getDescription() : existingEvent.getDescription());
		existingEvent.setOwnername(event.getOwnername() != null ? event.getOwnername() : existingEvent.getOwnername());
		existingEvent.setLongitude(event.getLongitude() != null ? event.getLongitude() : existingEvent.getLongitude());
		existingEvent.setLatitude(event.getLatitude() != null ? event.getLatitude() : existingEvent.getLatitude());
		 
	 
		eventRepository.save(existingEvent);
		return existingEvent.getId();
	}

	public Long deleteevent(Long id) {
		Optional<Events> events = eventRepository.findById(id);

		if (!events.isEmpty()) {
			eventRepository.deleteById(id);
			return id;
		} else {
			return null;
		}

	}

	public String addBookingEvent(String username, long eventid) {
		Optional<User> u = userRepository.findByUsernameOrEmail(username, username);
		if (u.isEmpty()) {
			return null;
		}
		User user = u.get();
		Optional<Events> events = eventRepository.findById(eventid);

		if (events.isEmpty()) {
			return null;
		}

		Events event = events.get();
		List<Booking_event> bookingTours = booking_eventRepository.findByUser_id(user.getId());
		for (Booking_event booking_tour : bookingTours) {
			if (eventid == booking_tour.getEvent_id()) {
				return null;
			}
		}
		booking_eventRepository
				.save(new Booking_event(user.getId(), event.getId(), user, event, "waiting", false, false));
		return "ok";

	}

	public void removeBookingEvent(String username, long bookingEventId) {
		Optional<User> u = userRepository.findByUsernameOrEmail(username, username);
		if (u.isEmpty()) {
			return;
		}
		User user = u.get();
		List<Booking_event> bookingEvents = booking_eventRepository.findByUser_id(user.getId());
		for (Booking_event booking_event : bookingEvents) {
			if (bookingEventId == booking_event.getEvent_id()) {
				booking_eventRepository.deleteById(booking_event.getId());
			}
		}
	}

	public void deleteimage(Long id) {
		Optional<EventImages> images = eventimagerepository.findById(id);
		if (!images.isEmpty()) {
			eventimagerepository.deleteById(id);
		}

		
	}

	public void addimage(String imageURL, Long id) {
		Optional<Events> eventsoptional = eventRepository.findById(id);
		if (!eventsoptional.isEmpty()) {
			Events event = eventsoptional.get();
			eventimagerepository.save(new EventImages(imageURL, event.getId(), event));
		}
		
	}
}
