package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

 
import com.example.demo.entity.events.EventImages;
 

public class Eventmodel {
	
	private String name;
	private String place; 
    private Double longitude ;
    private Double latitude  ;   
	private String starttime;
	private String endtime;
 
	private String lastdatetobook;
	private double price;
	private int maximumbooking;
	private long phonenumber;
	private long phonenumber2;
	private String description;
	private String ownername;
	
    private Set<EventImages> images = new HashSet<>();
    
    
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
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
 
	public String getLastdatetobook() {
		return lastdatetobook;
	}
	public void setLastdatetobook(String lastdatetobook) {
		this.lastdatetobook = lastdatetobook;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getMaximumbooking() {
		return maximumbooking;
	}
	public void setMaximumbooking(int maximumbooking) {
		this.maximumbooking = maximumbooking;
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
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public Set<EventImages> getImages() {
		return images;
	}
	public void setImages(Set<EventImages> images) {
		this.images = images;
	}
 
	public Eventmodel(String name, String place, Double longitude, Double latitude, String starttime, String endtime,
			String lastdatetobook, double price, int maximumbooking, long phonenumber, long phonenumber2,
			String description, String ownername, Set<EventImages> images) {
		super();
		this.name = name;
		this.place = place;
		this.longitude = longitude;
		this.latitude = latitude;
		this.starttime = starttime;
		this.endtime = endtime;
		this.lastdatetobook = lastdatetobook;
		this.price = price;
		this.maximumbooking = maximumbooking;
		this.phonenumber = phonenumber;
		this.phonenumber2 = phonenumber2;
		this.description = description;
		this.ownername = ownername;
		this.images = images;
	}
	@Override
	public String toString() {
		return "Eventmodel [name=" + name + ", place=" + place + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", starttime=" + starttime + ", endtime=" + endtime + ", lastdatetobook=" + lastdatetobook
				+ ", price=" + price + ", maximumbooking=" + maximumbooking + ", phonenumber=" + phonenumber
				+ ", phonenumber2=" + phonenumber2 + ", description=" + description + ", ownername=" + ownername
				+ ", images=" + images + "]";
	}
 
    
    
    
}
