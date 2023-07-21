package com.example.demo.model;

import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SignupRequestDTO {
    @NotBlank
    @Size(max = 100)
    @Email
    private String email;
 
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(min = 8, max = 40)
    private String password;
 
    @NotBlank
    @Size(max = 50)
    private String name;
    
    @NotNull
    private long phonenumber;
    @NotBlank
    private String gender;
    @NotNull
    private Date dateOfBirth ;
    @NotNull
    private String city ;
    @NotNull
    private String Address ;
 
    private String profile_pictureurl;


    
    public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

  
 
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProfile_pictureURL() {
		return profile_pictureurl;
	}

	public void setProfile_pictureURL(String profile_pictureURL) {
		this.profile_pictureurl = profile_pictureURL;
	}

	public SignupRequestDTO(@NotBlank @Size(max = 100) @Email String email,
			@NotBlank @Size(min = 3, max = 20) String username, @NotBlank @Size(min = 8, max = 40) String password,
			@NotBlank @Size(max = 50) String name, @NotNull long phonenumber, @NotBlank String gender,
			@NotNull Date dateOfBirth, @NotNull String city, @NotNull String address, String profile_pictureurl) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.name = name;
		this.phonenumber = phonenumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		Address = address;
		this.profile_pictureurl = profile_pictureurl;
	}
	

 
 
	 
    
    
}
