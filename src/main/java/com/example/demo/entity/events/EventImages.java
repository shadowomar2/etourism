package com.example.demo.entity.events;

 

import javax.persistence.Column;
import javax.persistence.Entity;
 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class EventImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Lob 
    @Column(length=512)
    private String imageURL;
    
    @Column(insertable=false, updatable=false)	 
	private long event_id;
    
    @ManyToOne 
    @JoinColumn(name = "event_id")
    @JsonIgnore 
    private Events events;

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
 

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}
 
	@Override
	public String toString() {
		return "EventImages [id=" + id + ", imageURL=" + imageURL + ", event_id=" + event_id + ", events=" + events
				+ "]";
	}

	public EventImages(String imageURL, long event_id, Events events) {
		super();
		this.imageURL = imageURL;
		this.event_id = event_id;
		this.events = events;
	}

	public EventImages(Long id, String imageURL, long event_id, Events events) {
		super();
		this.id = id;
		this.imageURL = imageURL;
		this.event_id = event_id;
		this.events = events;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public EventImages() {
	 
	}
    
}
