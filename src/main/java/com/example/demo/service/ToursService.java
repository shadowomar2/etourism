package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.entity.events.EventsComments;
import com.example.demo.entity.tours.Booking_tour;
import com.example.demo.entity.tours.Locations;
import com.example.demo.entity.tours.TourImages;
import com.example.demo.entity.tours.Tours;
import com.example.demo.entity.tours.ToursComments;
import com.example.demo.model.Comment_Response;
import com.example.demo.model.Commentmodel;
import com.example.demo.model.Images_response;
import com.example.demo.model.Response_tours;
import com.example.demo.model.Tourmodel;
import com.example.demo.repository.Booking_tourRepository;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.TourImagesRepository;
import com.example.demo.repository.TourRepository;
import com.example.demo.repository.ToursCommentsRepository;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Service
public class ToursService {
	@Autowired
	TourRepository tourRepository;
	@Autowired
	private Booking_tourRepository booking_tourRepository;
	@Autowired
	LocationRepository locationRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	TourImagesRepository tourimagesRepository;
	@Autowired
	ToursCommentsRepository commentsRepository;

	public List<Locations> getlocationofTour(Long id) {

		return locationRepository.findByTour_id(id);

	}

	public List<Comment_Response> getCommentsofTours(Long id) {
		List<ToursComments> res = commentsRepository.findByTour_id(id);
		if (res.isEmpty()) {
			return null;
		}
		List<Comment_Response> response = new ArrayList<>();
		for (ToursComments r : res) {
			User user = userRepository.getById(r.getUser_id());
			if (user != null) {
				response.add(new Comment_Response(r.getId(), user.getName(), r.getId_tour(), r.getComment()));
			}
		}
		return response;

	}

	public ToursComments addCommentsofTours(Commentmodel commentmodel, String username) {
		Optional<User> u = userRepository.findByUsernameOrEmail(username, username);
		if (u.isEmpty()) {
			return null;
		}
		User user = u.get();

		Optional<Tours> optionalTour = tourRepository.findById(commentmodel.getID());
		if (optionalTour.isEmpty()) {
			return null;
		}
		Tours existingTour = optionalTour.get();
		return commentsRepository.save(
				new ToursComments(commentmodel.getComment(), user.getId(), commentmodel.getID(), existingTour, user));

	}

	public List<Images_response> getImagesofTour(Long id) {
		List<TourImages> images = tourimagesRepository.findByTour_id(id);
		List<Images_response> response = new ArrayList<>();
		for (TourImages tourImages : images) {
			response.add(new Images_response(tourImages.getId(), tourImages.getTour_id(), tourImages.getImageURL()));
		}
		return response;

	}

	public Optional<Tours> gettourbyid(long id) {
		return tourRepository.findById(id);
	}

	public List<Response_tours> getAllTours() {
		List<Tours> tours = tourRepository.findAll();
		List<Response_tours> response_tours = new ArrayList<>();
		for (Tours tour : tours) {
			Response_tours response_tour = new Response_tours(tour.getId(), tour.getName(), tour.getPlace(), null,
					tour.getStarttime(), tour.getEndtime(), tour.getTripdistance(), tour.getLastdatetobook(),
					tour.getPrice(), tour.getMaximumbooking(), tour.getPhonenumber(), tour.getPhonenumber2(),
					tour.getDescription(), tour.getOwnername(), null);

			response_tour.setImages(tourimagesRepository.findByTour_id(tour.getId()));
			response_tour.setLocations(locationRepository.findByTour_id(tour.getId()));
			response_tours.add(response_tour);
		}
		System.out.println(response_tours);
		return response_tours;
	}

	public Long addtour(Tourmodel tour) {

		Tours savedtour = tourRepository.save(new Tours(tour.getName(), tour.getPlace(),

				tour.getStarttime(), tour.getEndtime(), tour.getTripdistance(), tour.getLastdatetobook(),
				tour.getPrice(), tour.getMaximumbooking(), tour.getPhonenumber(), tour.getPhonenumber2(),

				tour.getDescription(), tour.getOwnername()));
		System.out.println(tour.getLocations());
		for (Locations l : tour.getLocations()) {
			locationRepository.save(new Locations(l.getLongitude(), l.getLatitude(), l.getName(), savedtour));
		}
		for (TourImages img : tour.getImages()) {
			tourimagesRepository.save(new TourImages(img.getImageURL(), savedtour.getId(), savedtour));
		}
		return savedtour.getId();
	}

	public Long edittour(Tourmodel tour, long id) {

		Optional<Tours> optionalTour = tourRepository.findById(id);
		if (optionalTour.isEmpty()) {
			return null;
		}
		Tours existingTour = optionalTour.get();
		existingTour.setName(tour.getName() != null ? tour.getName() : existingTour.getName());
		existingTour.setPlace(tour.getPlace() != null ? tour.getPlace() : existingTour.getPlace());
		existingTour.setStarttime(tour.getStarttime() != null ? tour.getStarttime() : existingTour.getStarttime());
		existingTour.setEndtime(tour.getEndtime() != null ? tour.getEndtime() : existingTour.getEndtime());
		existingTour.setTripdistance(
				tour.getTripdistance() != null ? tour.getTripdistance() : existingTour.getTripdistance());
		existingTour.setLastdatetobook(
				tour.getLastdatetobook() != null ? tour.getLastdatetobook() : existingTour.getLastdatetobook());
		existingTour.setPrice(tour.getPrice() != 0 ? tour.getPrice() : existingTour.getPrice());
		existingTour.setMaximumbooking(
				tour.getMaximumbooking() != 0 ? tour.getMaximumbooking() : existingTour.getMaximumbooking());
		existingTour.setPhonenumber(tour.getPhonenumber() != 0 ? tour.getPhonenumber() : existingTour.getPhonenumber());
		existingTour
				.setPhonenumber2(tour.getPhonenumber2() != 0 ? tour.getPhonenumber2() : existingTour.getPhonenumber2());
		existingTour
				.setDescription(tour.getDescription() != null ? tour.getDescription() : existingTour.getDescription());
		existingTour.setOwnername(tour.getOwnername() != null ? tour.getOwnername() : existingTour.getOwnername());

		List<Locations> optionalLocation = locationRepository.findByTour_id(id);

		for (Locations locations : optionalLocation) {

			locationRepository.deleteById(locations.getId());

		}
		System.out.println(tour.getLocations());
		List<Locations> loc = new ArrayList<Locations>();
		Set<Locations> locations = tour.getLocations();
		if (locations != null) {
			for (Locations l : locations) {
				locationRepository.save(new Locations(l.getLongitude(), l.getLatitude(), l.getName(), existingTour));
				loc.add(l);
			}
		}
		tourRepository.save(existingTour);
		existingTour.setLocations(loc);
		return existingTour.getId();
	}

	public Long deletetour(Long id) {

		Optional<Tours> tour = tourRepository.findById(id);
		if (!tour.isEmpty()) {
			tourRepository.deleteById(id);
			return id;
		} else {
			return null;
		}

	}

	public void deletelocationsoftour(Long id) {

		Optional<Locations> optionalLocation = locationRepository.findById(id);

		if (!optionalLocation.isEmpty()) {
			Locations locations = optionalLocation.get();
			locationRepository.deleteById(locations.getId());

		}

	}

	public String addlocationsoftour(Locations loc, Long id) {

		Optional<Tours> tour = tourRepository.findById(id);
		if (!tour.isEmpty()) {
			Tours t=tour.get();
			loc.setTour_id(id);

			locationRepository.save(new Locations(loc.getLongitude(), loc.getLatitude(), loc.getName(), t));
			return "ok";
		}

		return "tour not exist";
	}

	public void deleteimage(Long id) {

		Optional<TourImages> images = tourimagesRepository.findById(id);
		if (!images.isEmpty()) {
			tourimagesRepository.deleteById(id);
		}

	}

	public void addimage(String imageURL, Long id) {

		Optional<Tours> toursoptional = tourRepository.findById(id);
		if (!toursoptional.isEmpty()) {
			Tours tour = toursoptional.get();
			tourimagesRepository.save(new TourImages(imageURL, tour.getId(), tour));
		}

	}

	public String addBookingTour(String username, long Tourid) {
		Optional<User> u = userRepository.findByUsernameOrEmail(username, username);
		if (u.isEmpty()) {
			return null;
		}
		User user = u.get();
		Optional<Tours> toursoptional = tourRepository.findById(Tourid);
		if (toursoptional.isEmpty()) {
			return null;
		}

		Tours tour = toursoptional.get();
		List<Booking_tour> bookingTours = booking_tourRepository.findByUser_id(user.getId());
		for (Booking_tour booking_tour : bookingTours) {
			if (Tourid == booking_tour.getTour_id()) {
				return null;
			}
		}
		booking_tourRepository.save(new Booking_tour(user.getId(), tour.getId(), user, tour, "waiting", false, false));
		return "ok";

	}

	public void removeBookingTour(String username, long bookingTourId) {
		Optional<User> u = userRepository.findByUsernameOrEmail(username, username);
		if (u.isEmpty()) {
			return;
		}
		User user = u.get();
		List<Booking_tour> bookingTours = booking_tourRepository.findByUser_id(user.getId());
		for (Booking_tour booking_tour : bookingTours) {
			if (bookingTourId == booking_tour.getTour_id()) {
				booking_tourRepository.deleteById(booking_tour.getId());
			}
		}

	}
}
