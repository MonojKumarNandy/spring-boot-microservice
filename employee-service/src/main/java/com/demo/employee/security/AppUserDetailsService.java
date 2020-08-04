package com.demo.employee.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.employee.entities.User;
import com.demo.employee.repository.RoleRepository;
import com.demo.employee.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsService.class);

	@Autowired
	private UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	User user;
	AppUser appUser;

	public AppUserDetailsService() {
		super();
	}

	public AppUserDetailsService(UserRepository userRepository, RoleRepository roleRepository) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOGGER.info("LoadUserByName Start");
		LOGGER.debug("UserRepository:{}", userRepository);
		user = userRepository.findByUsername(username);
		LOGGER.debug("User :{}", user);
		if (user == null)
			throw new UsernameNotFoundException("UserName not found");
		else
			appUser = new AppUser(user);
		LOGGER.info("LoadUserByName End");
		return appUser;
	}

	/*
	 * public void signUp(User newUser) throws UserAlreadyExistsException {
	 * LOGGER.info("AppUserDetailsService signUp Start"); User user = new User();
	 * user = userRepository.findByUsername(newUser.getUsername()); if (user ==
	 * null) {
	 * 
	 * Role role = roleRepository.findByRoleId(2); Set<Role> roleList = new
	 * HashSet<Role>(); roleList.add(role); newUser.setRoleList(roleList); String
	 * password = newUser.getPassword();
	 * newUser.setPassword(passwordEncoder().encode(password));
	 * userRepository.save(newUser); } else throw new UserAlreadyExistsException();
	 * 
	 * LOGGER.info("AppUserDetailsService signUp end"); }
	 */
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("password encoder");
		return new BCryptPasswordEncoder();
	}
}
