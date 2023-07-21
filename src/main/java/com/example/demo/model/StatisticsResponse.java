package com.example.demo.model;

public class StatisticsResponse {
	private long number_of_users;
private long number_of_events;
private long number_of_tours;
private long number_of_hotels;
private long number_of_restaurants;
private long number_of_bookings_tour;
private long number_of_bookings_event;
public long getNumber_of_users() {
	return number_of_users;
}
public void setNumber_of_users(long number_of_users) {
	this.number_of_users = number_of_users;
}
public long getNumber_of_events() {
	return number_of_events;
}
public void setNumber_of_events(long number_of_events) {
	this.number_of_events = number_of_events;
}
public long getNumber_of_tours() {
	return number_of_tours;
}
public void setNumber_of_tours(long number_of_tours) {
	this.number_of_tours = number_of_tours;
}
public long getNumber_of_hotels() {
	return number_of_hotels;
}
public void setNumber_of_hotels(long number_of_hotels) {
	this.number_of_hotels = number_of_hotels;
}
public long getNumber_of_restaurants() {
	return number_of_restaurants;
}
public void setNumber_of_restaurants(long number_of_restaurants) {
	this.number_of_restaurants = number_of_restaurants;
}
public long getNumber_of_bookings_tour() {
	return number_of_bookings_tour;
}
public void setNumber_of_bookings_tour(long number_of_bookings_tour) {
	this.number_of_bookings_tour = number_of_bookings_tour;
}
public long getNumber_of_bookings_event() {
	return number_of_bookings_event;
}
public void setNumber_of_bookings_event(long number_of_bookings_event) {
	this.number_of_bookings_event = number_of_bookings_event;
}
public StatisticsResponse(long number_of_users, long number_of_events, long number_of_tours, long number_of_hotels,
		long number_of_restaurants, long number_of_bookings_tour, long number_of_bookings_event) {
	super();
	this.number_of_users = number_of_users;
	this.number_of_events = number_of_events;
	this.number_of_tours = number_of_tours;
	this.number_of_hotels = number_of_hotels;
	this.number_of_restaurants = number_of_restaurants;
	this.number_of_bookings_tour = number_of_bookings_tour;
	this.number_of_bookings_event = number_of_bookings_event;
}
@Override
public String toString() {
	return "StatisticsResponse [number_of_users=" + number_of_users + ", number_of_events=" + number_of_events
			+ ", number_of_tours=" + number_of_tours + ", number_of_hotels=" + number_of_hotels
			+ ", number_of_restaurants=" + number_of_restaurants + ", number_of_bookings_tour="
			+ number_of_bookings_tour + ", number_of_bookings_event=" + number_of_bookings_event + "]";
}
 
}
