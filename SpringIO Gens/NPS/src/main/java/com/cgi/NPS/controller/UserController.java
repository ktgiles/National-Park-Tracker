package com.cgi.NPS.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.NPS.model.User;
import com.cgi.NPS.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/new")
	public ResponseEntity<?> createUserHandler(@RequestBody User user){
		ResponseEntity<?> response;		
		try {
			User newUser = userService.addNewUser(user);
			response = new ResponseEntity<User>(newUser, HttpStatus.CREATED);
		} catch(Exception e){
			//make this a custom exception - duplicate user warning
			response = new ResponseEntity<String>("it's broke", HttpStatus.CONFLICT);
		}
		return response;
	}
	
	//FOR SETUP AND TESTING ONLY - REMOVE PRIOR TO PROD
	@GetMapping(value = "/allusers")
	public ResponseEntity<List<User>> getAllUsersHandler(){
		ResponseEntity<List<User>> response;
		List<User> users = userService.getAllUsers();
		response = new ResponseEntity<List<User>>(users, HttpStatus.OK);
		return response;
	
	}
	
	//FOR SETUP AND TESTING ONLY - REMOVE PRIOR TO PROD
	@GetMapping(value = "/{username}")
	public ResponseEntity<?> getByUsernameHandler(@PathVariable("username") String username){
		ResponseEntity <?> response;
		User exists = userService.getByUsername(username);
		if (exists != null) {
			response = new ResponseEntity<User>(exists, HttpStatus.OK);
		} else {
			response = null;
		}
		return response;
	}
	
	@GetMapping(value ="/exists/{username}")
	public boolean usernameExists(@PathVariable("username") String username) {
		User exists = userService.getByUsername(username);
		if (exists != null) {
			return true;
		} else {
			return false;
		}
	}

	
}