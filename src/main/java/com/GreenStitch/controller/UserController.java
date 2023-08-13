package com.GreenStitch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.GreenStitch.exceptions.UserException;
import com.GreenStitch.model.UserData;
import com.GreenStitch.repository.UserRepository;
import com.GreenStitch.service.UserService;

@RestController
public class UserController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;

	@GetMapping("/hello")
	public ResponseEntity<String> HelloFromGreenStitch() throws UserException
	{
			UserData userData = userService.signInUser();

			if(userData == null)
			{
				return new ResponseEntity<>("Invalid JWT Token", HttpStatus.UNAUTHORIZED);
			}

			String message = "HelloFromGreenStitch";

			return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping("/loginUser")
	public ResponseEntity<UserData> loginUser(Authentication authentication) throws BadCredentialsException {

		UserData userData = userRepository.findByEmail(authentication.getName());

		if(userData == null)
		{
			throw new BadCredentialsException("Invalid Credentials. Please enter correct Username or Password");
		}

		return new ResponseEntity<>(userData, HttpStatus.ACCEPTED);
	}

	@PostMapping("/signup")
	public ResponseEntity<UserData> registerNewUser(@Validated @RequestBody UserData userData) throws UserException
	{
		String hashedPassword = passwordEncoder.encode(userData.getPassword());

		userData.setPassword(hashedPassword);

		UserData newUser = userService.CreateUser(userData);

		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
}
