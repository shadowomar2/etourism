package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.events.EventImages;
import com.example.demo.entity.hotel.HotelImages;
import com.example.demo.entity.restaurant.RestaurantImages;
 

public class Response_restaurant {

	private long id;
	private String name;
	private String place;
	private Double longitude;
	private Double latitude;
	private long phonenumber;
	private long phonenumber2;
	private String description;
	private List<Images_response> images = new ArrayList<>();
	
 
	public void setImages(List<RestaurantImages> images) {
		List<Images_response> arr=new ArrayList<>();
		for (RestaurantImages img : images) {
			arr.add(new Images_response(img.getId(),img.getRestaurant().getId(),img.getImageURL() ));
		}
		this.images = arr;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public long getPhonenumber2() {
		return phonenumber2;
	}
	public void setPhonenumber2(long phonenumber2) {
		this.phonenumber2 = phonenumber2;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Images_response> getImages() {
		return images;
	}
	
	public Response_restaurant(long id, String name, String place, Double longitude, Double latitude, long phonenumber,
			long phonenumber2, String description, List<Images_response> images) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
		this.longitude = longitude;
		this.latitude = latitude;
		this.phonenumber = phonenumber;
		this.phonenumber2 = phonenumber2;
		this.description = description;
		this.images = images;
	}
	@Override
	public String toString() {
		return "Response_hotels [id=" + id + ", name=" + name + ", place=" + place + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", phonenumber=" + phonenumber + ", phonenumber2=" + phonenumber2
				+ ", description=" + description + ", images=" + images + "]";
	}
	

}
