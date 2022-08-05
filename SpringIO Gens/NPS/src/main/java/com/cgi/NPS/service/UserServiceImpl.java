package com.cgi.NPS.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.NPS.model.User;
import com.cgi.NPS.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	public User addNewUser(User user) {
		Optional<User> optional = userRepo.getByUsername(user.getUsername());
		if (optional.isEmpty()) {
			 userRepo.save(user);
			 return user;
		} else {
			//throw custom exception because user w/username already exists? 
			return null;
		}
	}
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
		
	}
	
	public User getByUsername(String username) {
		Optional<User> optional = userRepo.getByUsername(username);
		if (optional.isPresent()) {
			return userRepo.getUserByUsername(username);
		} else {
			//throw custom exception?
			return null;
		}
	}
 



	
}
