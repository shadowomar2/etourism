package com.example.demo.model;

public class Editdetails {

	private String address;
	private long phonenumber;
    private String gender;
    private String City;
    private String profile_pictureURL;
    
 
	@Override
	public String toString() {
		return "Editdetails [address=" + address + ", phonenumber=" + phonenumber + ", gender=" + gender + ", City="
				+ City + ", profile_pictureURL=" + profile_pictureURL + "]";
	}
	public Editdetails(String address, long phonenumber, String gender, String city, String profile_pictureURL) {
		super();
		this.address = address;
		this.phonenumber = phonenumber;
		this.gender = gender;
		City = city;
		this.profile_pictureURL = profile_pictureURL;
	}
	public String getProfile_pictureURL() {
		return profile_pictureURL;
	}
	public void setProfile_pictureURL(String profile_pictureURL) {
		this.profile_pictureURL = profile_pictureURL;
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
    
}
