package com.example.demo.entity.restaurant;
 

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RestaurantImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	private String imageURL;
	@ManyToOne(fetch = FetchType.LAZY)
	
    private Restaurant restaurant;
	
	
    public RestaurantImages(String imageURL, Restaurant restaurant) {
		 
		this.imageURL = imageURL;
		this.restaurant = restaurant;
	}



	@Override
	public String toString() {
		return "RestaurantImages [id=" + id + ", imageURL=" + imageURL + ", restaurant=" + restaurant + "]";
	}



	public RestaurantImages(Long id, String imageURL, Restaurant restaurant) {
		super();
		this.id = id;
		this.imageURL = imageURL;
		this.restaurant = restaurant;
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

 

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

 

	public String getImageURL() {
		return imageURL;
	}



	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}



	public RestaurantImages() {
	 
	}
    
    
}
