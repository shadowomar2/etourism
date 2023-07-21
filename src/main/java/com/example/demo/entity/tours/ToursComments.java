package com.example.demo.entity.tours;

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
public class ToursComments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	@Column(length = 512)
	private String comment;
	
    @Column(insertable=false, updatable=false)	 
	private long user_id;
	
    @Column(insertable=false, updatable=false)	 
	private long tour_id;
	 
	@ManyToOne
	@JoinColumn(name = "tour_id")
	@JsonIgnore 
    private Tours tour;
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore 
    private User user;
 

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getId_tour() {
		return tour_id;
	}

	public void setId_tour(long tour_id) {
		this.tour_id = tour_id;
	}

	public Tours getTour() {
		return tour;
	}

	public void setTour(Tours tour) {
		this.tour = tour;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
 


	public ToursComments(String comment, long user_id, long tour_id, Tours tour, User user) {
	 
		this.comment = comment;
		this.user_id = user_id;
		this.tour_id = tour_id;
		this.tour = tour;
		this.user = user;
	}

	public ToursComments(Long id, String comment, long user_id, long tour_id, Tours tour, User user) {
		super();
		this.id = id;
		this.comment = comment;
		this.user_id = user_id;
		this.tour_id = tour_id;
		this.tour = tour;
		this.user = user;
	}

	public ToursComments() {
	 
	}

	@Override
	public String toString() {
		return "ToursComments [id=" + id + ", description=" + comment + ", user_id=" + user_id + ", id_tour="
				+ tour_id + ", tour=" + tour + "]";
	}
	
}
