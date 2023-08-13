package com.GreenStitch.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.GreenStitch.model.UserData;
import com.GreenStitch.repository.UserRepository;


@Service
public class SecurityUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		UserData user  = userRepository.findByEmail(userName);

		if(user == null)
		{
			throw new UsernameNotFoundException("User not present with username as : " + userName);
		}

		return new SecurityUserDetails(user);
	}

}
