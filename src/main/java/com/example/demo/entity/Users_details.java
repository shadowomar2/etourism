package com.example.demo.entity;
 
  
import java.sql.Date;
 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
import javax.persistence.OneToOne;
 
@Entity
public class Users_details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String address;
	private long phonenumber;

    private String gender;
    private String City;
    private Date dateOfBirth ;
	@OneToOne(fetch = FetchType.LAZY)	
	private User user;
 
    private String profile_pictureURL;

 

	public String getProfile_pictureURL() {
		return profile_pictureURL;
	}

	public void setProfile_pictureURL(String profile_pictureURL) {
		this.profile_pictureURL = profile_pictureURL;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Users_details() {
		 
	}

 

	public Users_details(long id, String address, long phonenumber, String gender, String city, Date dateOfBirth,
			User user, String profile_pictureURL) {
		super();
		this.id = id;
		this.address = address;
		this.phonenumber = phonenumber;
		this.gender = gender;
		City = city;
		this.dateOfBirth = dateOfBirth;
		this.user = user;
		this.profile_pictureURL = profile_pictureURL;
	}

	@Override
	public String toString() {
		return "Users_details [id=" + id + ", address=" + address + ", phonenumber=" + phonenumber + ", gender="
				+ gender + ", City=" + City + ", dateOfBirth=" + dateOfBirth + ", user=" + user + "]";
	}

	 

 
 
}
