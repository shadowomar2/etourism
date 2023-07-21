package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.entity.tours.Locations;
import com.example.demo.entity.tours.TourImages;

 
public class Tourmodel {
 
	private String name;
	private String place; 
	private Set<Locations> locations = new HashSet<>();
	private String starttime;
	private String endtime;
	private String tripdistance;
	private String lastdatetobook;
	private double price;
	private int maximumbooking;
	private long phonenumber;
	private long phonenumber2;
    private Set<TourImages> images = new HashSet<>();
	private String description;
	private String ownername;
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
	public Set<Locations> getLocations() {
		return locations;
	}
	public void setLocations(Set<Locations> locations) {
		this.locations = locations;
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
	public String getTripdistance() {
		return tripdistance;
	}
	public void setTripdistance(String tripdistance) {
		this.tripdistance = tripdistance;
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
	public Set<TourImages> getImages() {
		return images;
	}
	public void setImages(Set<TourImages> images) {
		this.images = images;
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
	public Tourmodel(String name, String place, Set<Locations> locations, String starttime, String endtime,
			String tripdistance, String lastdatetobook, double price, int maximumbooking, long phonenumber,
			long phonenumber2, Set<TourImages> images, String description, String ownername) {
		super();
		this.name = name;
		this.place = place;
		this.locations = locations;
		this.starttime = starttime;
		this.endtime = endtime;
		this.tripdistance = tripdistance;
		this.lastdatetobook = lastdatetobook;
		this.price = price;
		this.maximumbooking = maximumbooking;
		this.phonenumber = phonenumber;
		this.phonenumber2 = phonenumber2;
		this.images = images;
		this.description = description;
		this.ownername = ownername;
	}
	@Override
	public String toString() {
		return "Tourmodel [name=" + name + ", place=" + place + ", locations=" + locations + ", starttime=" + starttime
				+ ", endtime=" + endtime + ", tripdistance=" + tripdistance + ", lastdatetobook=" + lastdatetobook
				+ ", price=" + price + ", maximumbooking=" + maximumbooking + ", phonenumber=" + phonenumber
				+ ", phonenumber2=" + phonenumber2 + ", images=" + images + ", description=" + description
				+ ", ownername=" + ownername + "]";
	}
	 

}
