package edu.neu.booking.ticketbooking.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import edu.neu.booking.ticketbooking.controller.model.UserModel;
import edu.neu.booking.ticketbooking.entity.User;
import edu.neu.booking.ticketbooking.entity.vo.LoginUser;
import edu.neu.booking.ticketbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findById(username)
				.orElseThrow(() -> new RuntimeException("User not found: " + username));

		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
		System.out.println("Role is being set");
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				Arrays.asList(authority));
	}
	
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	
	public LoginUser getUserById(String username) {
		User user = userRepository.findById(username).get();
		LoginUser loginUser = new LoginUser(user.getUsername(),user.getName(),user.getEmail(),user.getPhone(),null);
		return  loginUser;
	}
	
	public String createUser(UserModel userModel) {
		String message = "Sign Up Successfully";

		Optional<User> isExist =  userRepository.findById(userModel.getUsername());

		if(isExist.isPresent()) {
			message = "Duplicate Username";
			return message;
		}

		userRepository.save(new User(userModel.getName(),userModel.getEmail(), userModel.getPhone(),userModel.getUsername(), new BCryptPasswordEncoder().encode(userModel.getPassword())));
		return message;
	}
	
	public boolean deleteUser(String username) {
		Optional<User> user = userRepository.findById(username);
		if(user.isPresent()) {
			userRepository.delete(user.get());
			return true;
		}else {
			return false;
		}
	}
	
	public User updateUser(UserModel userModel) {
		Optional<User> user = userRepository.findById(userModel.getUsername());
		System.out.println(user);
		if(user.isPresent()) {
			User _user = user.get();
			System.out.println(_user);
			_user.setEmail(userModel.getEmail());
			_user = userRepository.save(_user);
			return _user;
		}
		System.out.println("Item is null");
		return null;
		
	}



	

}
