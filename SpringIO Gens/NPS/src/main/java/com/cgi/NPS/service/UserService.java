package com.cgi.NPS.service;

import java.util.List;

import com.cgi.NPS.model.User;

public interface UserService {

	User addNewUser(User user);

	List<User> getAllUsers();
	
	User getByUsername(String username);
	
	

}
