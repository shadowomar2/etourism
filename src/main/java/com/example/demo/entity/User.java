package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.entity.events.Booking_event;
import com.example.demo.entity.tours.Booking_tour;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }) })
public class User {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false)
    @Size(max = 100)
    private String password;
    
    @Column(nullable = false)
	private String name;
    @Column(nullable = false)
	private String username;
    
    @Column(nullable = false)
	private String email;
    
    
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
               inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @JsonIgnore 
    private Set<Role> roles;

 
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)	
	private Users_details users_details;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore 
	private Set<Booking_tour> bookings_tour = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore 
	private Set<Booking_event> bookings_event = new HashSet<>();
	
	public void addBookingTour(Booking_tour bookingTour) {
	    if (bookings_tour == null) {
	        bookings_tour = new HashSet<>();
	    }
	    bookings_tour.add(bookingTour);
	  
	}
	public void addBookingevent(Booking_event bookingevent) {
	    if (bookings_event == null) {
	    	bookings_event = new HashSet<>();
	    }
		bookings_event.add(bookingevent);
	 
	}
	public void removeBookingevent(Booking_event bookingevent) {
	    if (bookings_event != null) {
	    	bookings_event.remove(bookingevent);
	    }
	}
	public void removeBookingTour(Booking_tour bookingTour) {
	    if (bookings_tour != null) {
	        bookings_tour.remove(bookingTour);
	    }
	}
	public Set<Booking_tour> getBookings_tour() {
		return bookings_tour;
	}

	public void setBookings_tour(Set<Booking_tour> bookings_tour) {
		this.bookings_tour = bookings_tour;
	}

	public Set<Booking_event> getBookings_event() {
		return bookings_event;
	}

	public void setBookings_event(Set<Booking_event> bookings_event) {
		this.bookings_event = bookings_event;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Users_details getUsers_details() {
		return users_details;
	}

	public void setUsers_details(Users_details users_details) {
		this.users_details = users_details;
	}

 

	 
	public User() {
		super();
	}

	public User(Long id, @Size(max = 100) String password, String name, String username, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.username = username;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", username=" + username + ", email="
				+ email + "]";
	}

 

 
 

}