package edu.neu.booking.ticketbooking.controller;

import java.util.List;


import edu.neu.booking.ticketbooking.controller.model.UserModel;
import edu.neu.booking.ticketbooking.entity.User;
import edu.neu.booking.ticketbooking.entity.vo.LoginUser;
import edu.neu.booking.ticketbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		
		//List<User> users = userService.getAllUsersByRole(null);
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/profile")
	public 	ResponseEntity<LoginUser> getUserByUserName(@RequestParam String username) {
		return new ResponseEntity<>(userService.getUserById(username), HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<User> createUser(@RequestBody UserModel userModel) {
		User users = userService.createUser(userModel);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@DeleteMapping("{username}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable String username){
		boolean isDeleted = userService.deleteUser(username);
		return new ResponseEntity<>(isDeleted, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody UserModel userModel){
		User user = userService.updateUser(userModel);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	


}

