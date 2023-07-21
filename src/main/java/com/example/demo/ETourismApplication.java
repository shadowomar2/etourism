package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.SignUpDto;
import com.example.demo.model.SignupRequestDTO;
import com.example.demo.repository.RoleRepository;

@SpringBootApplication

public class ETourismApplication {
 
	
	public static void main(String[] args) {
		 
		SpringApplication.run(ETourismApplication.class, args);
         
	}

}
