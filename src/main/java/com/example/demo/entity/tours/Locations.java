package com.example.demo.entity.tours;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Locations {
	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(precision = 12)
	private Double longitude;
	@Column(precision = 12)
	private Double latitude;

	private String name;
	@Column(insertable=false, updatable=false)
	 
	private long tour_id;
	 
	
 

	public long getTour_id() {
		return tour_id;
	}

	public void setTour_id(long tour_id) {
		this.tour_id = tour_id;
	}

	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "tour_id")
	@JsonIgnore 
	private Tours tour;

	public Locations(Double longitude, Double latitude, String name, Tours tours) {

		this.longitude = longitude;
		this.latitude = latitude;
		this.name = name;
		this.tour = tours;
	}

	@Override
	public String toString() {
		return "Locations [id=" + id + ", longitude=" + longitude + ", latitude=" + latitude + ", name=" + name + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tours getTours() {
		return tour;
	}

	public void setTours(Tours tours) {
		this.tour = tours;
	}

	public Locations() {

	}

}
