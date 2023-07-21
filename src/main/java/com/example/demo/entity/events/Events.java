package com.example.demo.entity.events;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.demo.entity.tours.ToursComments;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Events {

	
	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 60)
	private String name;
	private String place; 
	
	@Column(  precision = 12 )
    private Double longitude ;
    @Column(  precision = 12 )
    private Double latitude  ;
    
	private String starttime;
	private String endtime;
 
  
	private String lastdatetobook;
	private double price;
	private int maximumbooking;
	private long phonenumber;
	private long phonenumber2;
	@Lob 
	@Column( length=512)
	private String description;
	private String ownername;
    @OneToMany(mappedBy = "events", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore 
    private Set<Booking_event> bookings = new HashSet<>();
    
    
    @OneToMany(mappedBy = "events", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EventImages> images = new HashSet<>();
    
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "events")
	@JsonIgnore 
	private List<EventsComments> comments=new ArrayList<>();
    
	public Set<EventImages> getImages() {
		return images;
	}
	public void setImages(Set<EventImages> images) {
		this.images = images;
	}
	public List<EventsComments> getComments() {
		return comments;
	}
	public void setComments(List<EventsComments> comments) {
		this.comments = comments;
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
	public Set<Booking_event> getBookings() {
		return bookings;
	}
	public void setBookings(Set<Booking_event> bookings) {
		this.bookings = bookings;
	}
	 
	 
 
	public Events(String name, String place, Double longitude, Double latitude, String starttime, String endtime,
			String lastdatetobook, double price, int maximumbooking, long phonenumber, long phonenumber2,
			String description, String ownername ) {
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
	 
	}
	
	public Events() {
	 
	}
	public Events(String name, String place, Double longitude, Double latitude, String starttime, String endtime,
			String lastdatetobook, double price, int maximumbooking, long phonenumber, long phonenumber2,
			String description, String ownername, Set<Booking_event> bookings, Set<EventImages> images) {
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
		this.bookings = bookings;
		this.images = images;
	}
	public Events(long id, String name, String place, Double longitude, Double latitude, String starttime,
			String endtime, String lastdatetobook, double price, int maximumbooking, long phonenumber,
			long phonenumber2, String description, String ownername, Set<Booking_event> bookings,
			Set<EventImages> images) {
 
		this.id = id;
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
		this.bookings = bookings;
		this.images = images;
	}
	@Override
	public String toString() {
		return "Events [id=" + id + ", name=" + name + ", place=" + place + ", longitude=" + longitude + ", latitude="
				+ latitude + ", starttime=" + starttime + ", endtime=" + endtime + ", lastdatetobook=" + lastdatetobook
				+ ", price=" + price + ", maximumbooking=" + maximumbooking + ", phonenumber=" + phonenumber
				+ ", phonenumber2=" + phonenumber2 + ", description=" + description + ", ownername=" + ownername
				+ ", bookings=" + bookings + ", images=" + images + "]";
	}
 
	
 

}
