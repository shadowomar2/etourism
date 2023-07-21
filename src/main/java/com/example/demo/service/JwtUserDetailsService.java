package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    User user = userRepository.findByUsernameOrEmail(username,username)
	            .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

	    List<GrantedAuthority> authorities = new ArrayList<>();
	    for (Role role : user.getRoles()) {
	        authorities.add(new SimpleGrantedAuthority(role.getName()));
	    }

	    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
	            authorities);
	}

}