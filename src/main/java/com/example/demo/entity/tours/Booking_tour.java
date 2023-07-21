package com.example.demo.entity.tours;

import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking_tour")
public class Booking_tour {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(insertable = false, updatable = false)
	private long user_id;

	@Column(insertable = false, updatable = false)
	private long tour_id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id")
	@JsonIgnore
	private Tours tours;
	
	private String state;
	private boolean paid;
	private boolean review;

	
	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getTour_id() {
		return tour_id;
	}

	public void setTour_id(long tour_id) {
		this.tour_id = tour_id;
	}

	public boolean isReview() {
		return review;
	}

	public void setReview(boolean review) {
		this.review = review;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Tours getTours() {
		return tours;
	}

	public void setTours(Tours tours) {
		this.tours = tours;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
 

	public Booking_tour() {
	 
	}

	public Booking_tour(long user_id, long tour_id, User user, Tours tours, String state, boolean paid,
			boolean review) {
 
		this.user_id = user_id;
		this.tour_id = tour_id;
		this.user = user;
		this.tours = tours;
		this.state = state;
		this.paid = paid;
		this.review = review;
	}

	public Booking_tour(Long id, long user_id, long tour_id, User user, Tours tours, String state, boolean paid,
			boolean review) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.tour_id = tour_id;
		this.user = user;
		this.tours = tours;
		this.state = state;
		this.paid = paid;
		this.review = review;
	}

	@Override
	public String toString() {
		return "Booking_tour [id=" + id + ", user_id=" + user_id + ", tour_id=" + tour_id + ", tours=" + tours
				+ ", state=" + state + ", paid=" + paid + ", review=" + review + "]";
	}

	 
 
}
