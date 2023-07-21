package com.example.demo.entity.events;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.example.demo.entity.User;
import com.example.demo.entity.tours.Booking_tour;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Booking_event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(insertable = false, updatable = false)
	private long user_id;

	@Column(insertable = false, updatable = false)
	private long event_id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;

	@ManyToOne
	@JoinColumn(name = "event_id")
	@JsonIgnore
	private Events events;
	
	
	private String state;
	
	private boolean paid;
	private boolean review;
	
	public boolean isReview() {
		return review;
	}
	public void setReview(boolean review) {
		this.review = review;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public long getEvent_id() {
		return event_id;
	}
	public void setEvent_id(long event_id) {
		this.event_id = event_id;
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
	public Events getEvents() {
		return events;
	}
	public void setEvents(Events events) {
		this.events = events;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
 
	public Booking_event() {
	 
	}
	public Booking_event(Long id, long user_id, long event_id, User user, Events events, String state, boolean paid,
			boolean review) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.event_id = event_id;
		this.user = user;
		this.events = events;
		this.state = state;
		this.paid = paid;
		this.review = review;
	}
	public Booking_event(long user_id, long event_id, User user, Events events, String state, boolean paid,
			boolean review) {
		super();
		this.user_id = user_id;
		this.event_id = event_id;
		this.user = user;
		this.events = events;
		this.state = state;
		this.paid = paid;
		this.review = review;
	}
	@Override
	public String toString() {
		return "Booking_event [id=" + id + ", user_id=" + user_id + ", event_id=" + event_id + ", user=" + user
				+ ", events=" + events + ", state=" + state + ", paid=" + paid + ", review=" + review + "]";
	}

	
}
