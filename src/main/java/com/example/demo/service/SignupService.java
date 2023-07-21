package com.example.demo.service;

import java.sql.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.Users_details;
import com.example.demo.model.SignupRequestDTO;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Service
public class SignupService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public boolean isEmailUnique(String email) {
		Optional<User> user = userRepository.findByEmail(email);
		return !user.isPresent();
	}

	public User createUser(SignupRequestDTO userDto) {
		User user = new User();
		user.setName(userDto.getName());
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());

		user.setPassword(passwordEncoder.encode(userDto.getPassword()));

		Optional<Role> roleOptional = roleRepository.findByName("USER");

		Role role;
		if (roleOptional.isPresent()) {
			role = roleOptional.get();

		} else {
			role = new Role();
			role.setName("USER");
			roleRepository.save(role);

		}
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(role);

		user.setRoles(userRoles);

		Users_details users_details = new Users_details();
		users_details.setAddress(userDto.getAddress());
		users_details.setCity(userDto.getCity());
		users_details.setPhonenumber(userDto.getPhonenumber());
		users_details.setDateOfBirth(userDto.getDateOfBirth());
		users_details.setGender(userDto.getGender());
		users_details.setProfile_pictureURL(userDto.getProfile_pictureURL());
		user.setUsers_details(users_details);

		return userRepository.save(user);
	}

	public void createAdminUser(String Username, String password) {
		User user = new User();
		user.setName(Username);
		user.setUsername(Username);
		user.setEmail(Username);
    
		user.setPassword(passwordEncoder.encode(password));

		Optional<Role> roleOptional = roleRepository.findByName("ADMIN");

		Role role;
		if (roleOptional.isPresent()) {
			role = roleOptional.get();

		} else {
			role = new Role();
			role.setName("ADMIN");
			roleRepository.save(role);

		}
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(role);

		user.setRoles(userRoles);

		Users_details users_details = new Users_details();

		users_details.setAddress("");
		users_details.setCity("");
		users_details.setPhonenumber(0);
		users_details.setDateOfBirth(new Date(0));
		users_details.setGender("");
		users_details.setProfile_pictureURL("");
		user.setUsers_details(users_details);
		System.out.println(user);
		userRepository.save(user);
	}
}
