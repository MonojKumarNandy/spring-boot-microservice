package com.demo.authentication.service;

import com.demo.authentication.entitity.User;
import com.demo.authentication.exception.UserAlreadyExistsException;

public interface UserService {
	public void signUp(User user) throws UserAlreadyExistsException;

	public boolean userExistingStatus(String username);

	public User getUser(String username);
}
