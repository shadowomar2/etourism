package com.example.demo.entity.tours;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tours")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Tours {

	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 60)
	private String name;
	private String place;

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore 
	private List<Locations> locations=new ArrayList<>();

	private String starttime;
	private String endtime;

	private String tripdistance;
	private String lastdatetobook;
	private double price;
	 
	private int maximumbooking;
	private long phonenumber;
	private long phonenumber2;

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "tour", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<TourImages> images = new HashSet<>();

	@Lob
	@Column(length = 512)
	private String description;
	private String ownername;

	@OneToMany(mappedBy = "tours", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Booking_tour> bookings = new HashSet<>();
	
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "tour")
	@JsonIgnore 
	private List<ToursComments> comments=new ArrayList<>();

	public List<ToursComments> getComments() {
		return comments;
	}

	public void setComments(List<ToursComments> comments) {
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

	public Set<TourImages> getImages() {
		return images;
	}

	public void setImages(Set<TourImages> images) {
		this.images = images;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public List<Locations> getLocations() {
		return locations;
	}

	public void setLocations(List<Locations> locations) {
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

	public Set<Booking_tour> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking_tour> bookings) {
		this.bookings = bookings;
	}

	public Tours() {

	}

	public Tours(long id, String name, String place, List<Locations> locations, String starttime, String endtime,
			String tripdistance, String lastdatetobook, double price, int maximumbooking, long phonenumber,
			long phonenumber2, Set<TourImages> images, String description, String ownername,
			Set<Booking_tour> bookings) {
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
		this.images = images;
		this.description = description;
		this.ownername = ownername;
		this.bookings = bookings;
	}

	public Tours(String name, String place, List<Locations> locations, String starttime, String endtime,
			String tripdistance, String lastdatetobook, double price, int maximumbooking, long phonenumber,
			long phonenumber2, Set<TourImages> images, String description, String ownername,
			Set<Booking_tour> bookings) {
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
		this.bookings = bookings;
	}

	public void addlocation(Locations l) {
		if (locations == null)
			locations = new ArrayList<>();
		locations.add(l);
		l.setTours(this);
	}


	@Override
	public String toString() {
		return "Tours [id=" + id + ", name=" + name + ", place=" + place + ", locations=" + locations + ", starttime="
				+ starttime + ", endtime=" + endtime + ", tripdistance=" + tripdistance + ", lastdatetobook="
				+ lastdatetobook + ", price=" + price + ", maximumbooking=" + maximumbooking + ", phonenumber="
				+ phonenumber + ", phonenumber2=" + phonenumber2 + ", images=" + images + ", description=" + description
				+ ", ownername=" + ownername + ", bookings=" + bookings + ", comments=" + comments + "]";
	}

	public Tours(String name, String place, String starttime, String endtime, String tripdistance,
			String lastdatetobook, double price, int maximumbooking, long phonenumber, long phonenumber2,
			String description, String ownername) {
		super();
		this.name = name;
		this.place = place;
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
	}

	public Tours(long id, String name, String place, String starttime, String endtime, String tripdistance,
			String lastdatetobook, double price, int maximumbooking, long phonenumber, long phonenumber2,
			String description, String ownername) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
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
	}

}
