package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookingResponse;
import com.example.demo.model.Response_hotels;
import com.example.demo.model.StatisticsResponse;
import com.example.demo.model.UserResponse;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AdminService;

@RestController
@RequestMapping("/admin/settings")
@CrossOrigin(  allowedHeaders = {"Authorization", "Content-Type"})
public class AdminController {

	@Autowired
	AdminService adminService;
	
	
	@GetMapping("/allusers")
	public List<UserResponse> getallusers() {
		return adminService.getallusers();
	}
	@GetMapping("/user/{id}")
	public UserResponse getuser(@PathVariable Long id) {
		  return adminService.getuser(id);
	}
	
	@GetMapping("/booking/{id}")
	public BookingResponse getbooking(@PathVariable Long id) {
		return adminService.getbooking(id);
	}

	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Long id) {
		  adminService.deleteUser(id);
	}
	
	@PutMapping("/accepttour/{id}")
	public void accepttour(@PathVariable Long id) {
		  adminService.bookaccepttour(id);
	}
	
	@PutMapping("/acceptevent/{id}")
	public void acceptevent(@PathVariable Long id) {
		  adminService.bookacceptevent(id);
	}
	
	@GetMapping("/statistics")
	public StatisticsResponse getstatistics() {
		  return adminService.getstatistics();
	}
}
