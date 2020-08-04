package com.demo.authentication.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.authentication.entitity.User;
import com.demo.authentication.exception.UserAlreadyExistsException;
import com.demo.authentication.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	public static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@PostMapping
	public void signUp(@RequestBody @Valid User user) throws UserAlreadyExistsException {
		LOGGER.debug("SignUp");
		userService.signUp(user);
	}

	@GetMapping("/getuser/{username}")
	public User getUser(@PathVariable String username) {
		LOGGER.debug("get user by username");
		return userService.getUser(username);
	}

}
