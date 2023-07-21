package com.example.demo.model;

import java.util.Objects;

public class SignUpDto {
    private String name;
    private String username;
    private String email;
    private String password;
    private String Address;
    private Long phoneNumper;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, name, password, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SignUpDto other = (SignUpDto) obj;
		return Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	 
	public SignUpDto(String name, String username, String email, String password, String address, Long phoneNumper) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		Address = address;
		this.phoneNumper = phoneNumper;
	}
	@Override
	public String toString() {
		return "SignUpDto [name=" + name + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", Address=" + Address + ", phoneNumper=" + phoneNumper + "]";
	}
	 
    
}