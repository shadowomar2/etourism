package com.example.demo.entity.events;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EventsComments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Lob
	@Column(length = 512)
	private String comment;

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

	@Override
	public String toString() {
		return "EventsComments [id=" + id + ", description=" + comment + ", user_id=" + user_id + ", user=" + user
				+ ", event_id=" + event_id + ", events=" + events + "]";
	}

	public EventsComments(Long id, String description, long user_id, User user, long event_id, Events events) {
		 
		this.id = id;
		this.comment = description;
		this.user_id = user_id;
		this.user = user;
		this.event_id = event_id;
		this.events = events;
	}

	public EventsComments(String description, long user_id, User user, long event_id, Events events) {
	 
		this.comment = description;
		this.user_id = user_id;
		this.user = user;
		this.event_id = event_id;
		this.events = events;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getcomment() {
		return comment;
	}

	public void setcomment(String comment) {
		this.comment = comment;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getEvent_id() {
		return event_id;
	}

	public void setEvent_id(long event_id) {
		this.event_id = event_id;
	}

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	public EventsComments() {
		 
	}

}
