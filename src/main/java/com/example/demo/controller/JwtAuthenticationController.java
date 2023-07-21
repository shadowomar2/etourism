package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.config.JwtTokenUtil;
import com.example.demo.entity.User;
import com.example.demo.model.JwtRequest;
import com.example.demo.model.JwtResponse;
import com.example.demo.model.Response_tours;
import com.example.demo.model.SignupRequestDTO;
import com.example.demo.service.JwtUserDetailsService;
import com.example.demo.service.SignupService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private SignupService signupService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	
	@GetMapping(value = "/check" )
	  public ResponseEntity<?> check( ) {
	         Map<String, String> response = new HashMap<>();
	          response.put("server", "tour_server");
	          response.put("version", "1.0.0");
	          return ResponseEntity.ok(response);

	  }
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsernameoremail(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsernameoremail());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	@GetMapping("/getusername")
	public ResponseEntity<?> getUsername(@RequestHeader("Authorization") String authorizationHeader) {
		String jwtToken = authorizationHeader.substring(7); // remove "Bearer " prefix
		String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		return ResponseEntity.ok(userDetails.getUsername());
	}

	@PostMapping("/makeadmin")
	public ResponseEntity<?> addAdmin() {
		signupService.createAdminUser("admin", "admin");
		return ResponseEntity.ok("ok");
	}

	@GetMapping("/getrole")
	public ResponseEntity<?> getrole(@RequestHeader("Authorization") String authorizationHeader) {
		String token = authorizationHeader.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		List<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());

		return ResponseEntity.ok(roles);
	}

	@GetMapping("/check-auth")
	public ResponseEntity<String> checkAuth(@RequestHeader("Authorization") String authorizationHeader) {
	    String jwtToken = authorizationHeader.substring(7); // remove "Bearer " prefix
	    String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
	    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	    
	    if (Objects.nonNull(userDetails)) {
	        return ResponseEntity.ok("User is authenticated");
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	    }
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody @Valid SignupRequestDTO userDto) {
		System.out.println(userDto);

		User user = signupService.createUser(userDto);
		return ResponseEntity.ok("");
	}

	@GetMapping("/check-email/{email}")
	public ResponseEntity<Boolean> checkEmail(@PathVariable("email") String email) {
		boolean isUnique = signupService.isEmailUnique(email);
		return ResponseEntity.ok(isUnique);
	}

	private void authenticate(String username, String password) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}