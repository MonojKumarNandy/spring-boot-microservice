package com.demo.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.authentication.entitity.User;
import com.demo.authentication.exception.UserAlreadyExistsException;
import com.demo.authentication.repository.UserRepository;
import com.demo.authentication.security.AppUserDetailsService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Override
	public void signUp(User user) throws UserAlreadyExistsException {
		appUserDetailsService.signUp(user);
	}

	@Override
	public boolean userExistingStatus(String username) {
		return userRepository.findByUsername(username) == null ? true : false;
	}

	@Override
	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}

}
