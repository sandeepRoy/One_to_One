package com.sandeep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.repository.UserRepository;
import com.sandeep.entity.User;
import com.sandeep.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	//get all data
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	//get data by id
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No User with id: " + id));
		return ResponseEntity.ok(user);
	}
	
	// post data
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
}