package com.example.demo.entity.tours;

import java.util.Arrays;

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

@Entity
public class TourImages {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String imageURL;
    
    @Column(insertable=false, updatable=false)	 
	private long tour_id;
	 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tour_id")
    private Tours tour;

 

	@Override
	public String toString() {
		return "TourImages [id=" + id + ", imageURL=" + imageURL + ", tour_id=" + tour_id    + "]";
	}

	public TourImages(String imageURL, long tour_id, Tours tour) {
	 
		this.imageURL = imageURL;
		this.tour_id = tour_id;
		this.tour = tour;
	}

	public TourImages(Long id, String imageURL, long tour_id, Tours tour) {
		super();
		this.id = id;
		this.imageURL = imageURL;
		this.tour_id = tour_id;
		this.tour = tour;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public long getTour_id() {
		return tour_id;
	}

	public void setTour_id(long tour_id) {
		this.tour_id = tour_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

 

	public Tours getTour() {
		return tour;
	}

	public void setTour(Tours tour) {
		this.tour = tour;
	}

 

	public TourImages() {
		 
	}
 
   
}