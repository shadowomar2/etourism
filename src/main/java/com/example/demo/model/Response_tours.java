package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.demo.entity.tours.Booking_tour;
import com.example.demo.entity.tours.Locations;
import com.example.demo.entity.tours.TourImages;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

 
public class Response_tours {
    private long id;
	private String name;
	private String place;
	private List<Loc> locations=new ArrayList<>();
	private String starttime;
	private String endtime;
	private String tripdistance;
	private String lastdatetobook;
	private double price;
	private int maximumbooking;
	private long phonenumber;
	private long phonenumber2;
	private String description;
	private String ownername;
	private List<Images_response> images=new ArrayList<>();
	
	
	public List<Images_response> getImages() {
		return images;
	}
	public void setImages(List<TourImages> images) {
		List<Images_response> arr=new ArrayList<>();
		for (TourImages img : images) {
			arr.add(new Images_response(img.getId(),img.getTour_id(),img.getImageURL() ));
		}
		this.images = arr;
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
	public List<Loc> getLocations() {
		return locations;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setLocations(List<Locations> locations) {
		List<Loc> larr=new ArrayList<>();
		for (Locations locations2 : locations) {
			larr.add(new Loc(locations2.getLongitude(), locations2.getLatitude(), locations2.getName(), locations2.getTour_id()));
		}
		this.locations = larr;
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
 
	public Response_tours(long id, String name, String place, List<Loc> locations, String starttime, String endtime,
			String tripdistance, String lastdatetobook, double price, int maximumbooking, long phonenumber,
			long phonenumber2, String description, String ownername, List<Images_response> images) {
		super();
		this.id = id;
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
		this.description = description;
		this.ownername = ownername;
		this.images = images;
	}
	@Override
	public String toString() {
		return "Response_tours [id=" + id + ", name=" + name + ", place=" + place + ", locations=" + locations
				+ ", starttime=" + starttime + ", endtime=" + endtime + ", tripdistance=" + tripdistance
				+ ", lastdatetobook=" + lastdatetobook + ", price=" + price + ", maximumbooking=" + maximumbooking
				+ ", phonenumber=" + phonenumber + ", phonenumber2=" + phonenumber2 + ", description=" + description
				+ ", ownername=" + ownername + ", images=" + images + "]";
	}
 
 
 

}
class Loc{
 
	private Double longitude;
	private Double latitude;
	private String name;
	private long tour_id;
 
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getTour_id() {
		return tour_id;
	}
	public void setTour_id(long tour_id) {
		this.tour_id = tour_id;
	}
	public Loc(  Double longitude, Double latitude, String name, long tour_id) {
	 
		this.longitude = longitude;
		this.latitude = latitude;
		this.name = name;
		this.tour_id = tour_id;
	}
	
	 
}