package com.example.demo.model;

import java.sql.Date;

 

public class UserResponse {

	private Long id;
	private String name;
	private String username;
	private String email;
	private String address;
	private long phonenumber;
    private String gender;
    private String City;
    private Date dateOfBirth ;

    private String profile_pictureURL;

	public UserResponse() {
		super();
	}

	public UserResponse(Long id, String name, String username, String email, String address, long phonenumber,
			String gender, String city, Date dateOfBirth, String profile_pictureURL) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.address = address;
		this.phonenumber = phonenumber;
		this.gender = gender;
		City = city;
		this.dateOfBirth = dateOfBirth;
		this.profile_pictureURL = profile_pictureURL;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getProfile_pictureURL() {
		return profile_pictureURL;
	}

	public void setProfile_pictureURL(String profile_pictureURL) {
		this.profile_pictureURL = profile_pictureURL;
	}
    
    
    
}
