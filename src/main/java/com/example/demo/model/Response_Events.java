package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import com.example.demo.entity.events.EventImages;
import com.example.demo.entity.tours.TourImages;

public class Response_Events {
	 private long id;
		private String name;
		private String place;
		 
	    private Double longitude ;
	 
	    private Double latitude  ;
		private String starttime;
		private String endtime;
 
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
		public void setImages(List<EventImages> images) {
			List<Images_response> arr=new ArrayList<>();
			for (EventImages img : images) {
				arr.add(new Images_response(img.getId(),img.getEvent_id(),img.getImageURL() ));
			}
			this.images = arr;
		}
		 
		
		@Override
		public String toString() {
			return "Response_Events [id=" + id + ", name=" + name + ", place=" + place + ", longitude=" + longitude
					+ ", latitude=" + latitude + ", starttime=" + starttime + ", endtime=" + endtime
					+ ", lastdatetobook=" + lastdatetobook + ", price=" + price + ", maximumbooking=" + maximumbooking
					+ ", phonenumber=" + phonenumber + ", phonenumber2=" + phonenumber2 + ", description=" + description
					+ ", ownername=" + ownername + ", images=" + images + "]";
		}
		public Response_Events(long id, String name, String place, Double longitude, Double latitude, String starttime,
				String endtime, String lastdatetobook, double price, int maximumbooking, long phonenumber,
				long phonenumber2, String description, String ownername, List<Images_response> images) {
			super();
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
			this.images = images;
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
		
		
		
}
