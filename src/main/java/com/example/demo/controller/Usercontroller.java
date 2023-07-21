package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.JwtTokenUtil;
import com.example.demo.entity.User;
import com.example.demo.entity.Users_details;
import com.example.demo.entity.restaurant.Restaurant;
import com.example.demo.model.Editdetails;
import com.example.demo.model.EditpasswordDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.User_detailsRepository;
import com.example.demo.service.JwtUserDetailsService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(allowedHeaders = { "Authorization", "Content-Type" })
public class Usercontroller {
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	@Autowired
	private UserService userService;

	@GetMapping("/getdetails")
	public ResponseEntity<?> details(@RequestHeader("Authorization") String authorizationHeader) {
		String token = authorizationHeader.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(token);

		return ResponseEntity.ok(userService.getdetails(username));
	}
	@GetMapping("/getname")
	public ResponseEntity<?> getname(@RequestHeader("Authorization") String authorizationHeader) {
		String token = authorizationHeader.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(token);

		return ResponseEntity.ok(userService.getname(username));
	}
	@GetMapping("/showbooking")
	public ResponseEntity<?> showbooking(@RequestHeader("Authorization") String authorizationHeader) {
		String token = authorizationHeader.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(token);

		return ResponseEntity.ok(userService.showbooking(username));
	}
	@PutMapping("/changedetails")
	public ResponseEntity<?> changedetails(@RequestHeader("Authorization") String authorizationHeader,@RequestBody Editdetails users_details) throws Exception {
		String token = authorizationHeader.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		userService.editdetails(users_details, username);
		return ResponseEntity.ok("ok");
	}
	@PostMapping("/changepassword")
	public ResponseEntity<?> changepassword(@RequestHeader("Authorization") String authorizationHeader,@RequestBody EditpasswordDTO dto) throws Exception {
		String token = authorizationHeader.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		userService.editpassword(dto, username);
		return ResponseEntity.ok("ok");
	}
}
