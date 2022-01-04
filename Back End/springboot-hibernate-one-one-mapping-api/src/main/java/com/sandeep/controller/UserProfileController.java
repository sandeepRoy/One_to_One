package com.sandeep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.repository.UserProfileRepository;
import com.sandeep.entity.UserProfile;

@RestController
@RequestMapping("/api/v1/")
public class UserProfileController {
	@Autowired
	private UserProfileRepository userprofileRepository;
	
	@GetMapping("/user_profiles")
	public List<UserProfile> getAllUserProfiles() {
		return userprofileRepository.findAll();
	}
	
	@PostMapping("/user_profiles")
	public UserProfile createUserProfile(@RequestBody UserProfile userProfile) {
		return userprofileRepository.save(userProfile);
	}
}
