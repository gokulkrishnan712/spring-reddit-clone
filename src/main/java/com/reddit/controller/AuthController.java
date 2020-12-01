package com.reddit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reddit.model.RegisterRequest;
import com.reddit.service.AuthService;

@RestController
@RequestMapping("/api/reddit")
public class AuthController {
	
	@Autowired
	private AuthService auth;
	@GetMapping("/home")
	public String homePage() {
		return "hello world";
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> registerRequest(@RequestBody RegisterRequest register) {
		auth.signUp(register);
		return new ResponseEntity<>("User Registration Siccessful.\n You can start access your Account",
									HttpStatus.OK);
	}

}
