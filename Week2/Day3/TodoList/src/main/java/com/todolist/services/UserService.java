package com.todolist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.models.User;
import com.todolist.repositories.UserRepository;

@Service
public class UserService {
	//link the repository
	@Autowired
	UserRepository userRepo;
	
	
	//get all the users 
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	// create user method
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	//get userById method 
	public User getUserById(Long id) {
		Optional<User> u=userRepo.findById(id);
		if(u.isEmpty()) {
			return null;
		}
		return u.get();
	}
// delete user 
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}
}
