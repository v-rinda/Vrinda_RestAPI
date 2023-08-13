package com.GreenStitch.service;

import com.GreenStitch.model.UserData;
import com.GreenStitch.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserData signInUser() {
		return userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
	}
	@Override
	public UserData CreateUser(UserData userData) {
		return userRepository.save(userData);
	}
}
