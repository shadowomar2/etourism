package com.example.demo.model;

import java.util.Set;

import com.example.demo.entity.events.Booking_event;
import com.example.demo.entity.tours.Booking_tour;

public class BookingResponse {
	private Set<Booking_tour> bookings_tour;
	private Set<Booking_event> bookings_event;
	
 
	@Override
	public String toString() {
		return "bookingResponse [bookings_tour=" + bookings_tour + ", bookings_event=" + bookings_event + "]";
	}
	public Set<Booking_tour> getBookings_tour() {
		return bookings_tour;
	}
	public void setBookings_tour(Set<Booking_tour> bookings_tour) {
		this.bookings_tour = bookings_tour;
	}
	public Set<Booking_event> getBookings_event() {
		return bookings_event;
	}
	public void setBookings_event(Set<Booking_event> bookings_event) {
		this.bookings_event = bookings_event;
	}
	public BookingResponse(Set<Booking_tour> bookings_tour, Set<Booking_event> bookings_event) {
		super();
		this.bookings_tour = bookings_tour;
		this.bookings_event = bookings_event;
	}
	
}
