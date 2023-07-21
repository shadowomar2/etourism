package com.example.demo.entity.hotel;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class HotelImages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String imageURL;

	@ManyToOne(fetch = FetchType.LAZY)
	private Hotels hotels;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Hotels getHotels() {
		return hotels;
	}

	public void setHotels(Hotels hotels) {
		this.hotels = hotels;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public HotelImages(String imageURL, Hotels hotels) {
		 
		this.imageURL = imageURL;
		this.hotels = hotels;
	}
 
	public HotelImages(  ) {
      
    }
	public HotelImages(Long id, String imageURL, Hotels hotels) {
	 
		this.id = id;
		this.imageURL = imageURL;
		this.hotels = hotels;
	}

	@Override
	public String toString() {
		return "HotelImages [id=" + id + ", imageURL=" + imageURL + ", hotels=" + hotels + "]";
	}

}
