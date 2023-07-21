package com.example.demo.entity.hotel;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "hotels")
public class Hotels {
	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 60)
	private String name;
	private String place;
	@Column(precision = 12)
	private Double longitude;
	@Column(precision = 12)
	private Double latitude;
	private long phonenumber;
	private long phonenumber2;
	@OneToMany(mappedBy = "hotels", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<HotelImages> images = new HashSet<>();

	public Set<HotelImages> getImages() {
		return images;
	}

	public void setImages(Set<HotelImages> images) {
		this.images = images;
	}

	@Lob
	@Column(length = 512)
	private String description;

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

	@Override
	public String toString() {
		return "Hotels [id=" + id + ", name=" + name + ", place=" + place + ", longitude=" + longitude + ", latitude="
				+ latitude + ", phonenumber=" + phonenumber + ", phonenumber2=" + phonenumber2 + ", images=" + images
				+ ", description=" + description + "]";
	}

	public Hotels(String name, String place, Double longitude, Double latitude, long phonenumber, long phonenumber2,
			Set<HotelImages> images, String description) {
		super();
		this.name = name;
		this.place = place;
		this.longitude = longitude;
		this.latitude = latitude;
		this.phonenumber = phonenumber;
		this.phonenumber2 = phonenumber2;
		this.images = images;
		this.description = description;
	}

	public Hotels(long id, String name, String place, Double longitude, Double latitude, long phonenumber,
			long phonenumber2, Set<HotelImages> images, String description) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
		this.longitude = longitude;
		this.latitude = latitude;
		this.phonenumber = phonenumber;
		this.phonenumber2 = phonenumber2;
		this.images = images;
		this.description = description;
	}

	public Hotels() {
		super();
	}

}
