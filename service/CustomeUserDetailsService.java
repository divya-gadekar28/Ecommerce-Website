package com.inn.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inn.ecommerce.model.CustomUserDetail;
import com.inn.ecommerce.model.User;
import com.inn.ecommerce.repo.UserRepo;

@Service
public class CustomeUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		Optional<User> user = userRepo.findUserByEmail(email);
		user.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return user.map(CustomUserDetail::new).get();
		
	}
}
