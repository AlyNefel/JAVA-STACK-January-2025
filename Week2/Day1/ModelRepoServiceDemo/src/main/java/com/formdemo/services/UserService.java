package com.formdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formdemo.models.User;
import com.formdemo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;

// how to connect the repo to the service : second choice 
 //private final UserRepository userRepo;
 //public UserService(UserRepository userRepo) {
	// this.userRepo=userRepo;
// }
 
	// method from service to get all users 
	public List<User> getAllUsers(){
	System.out.println("We are in find all");
		return userRepo.findAll();
		
	}
	//Method get user with password and username
	public List<User> getUserWithNameAndPass(String userName,String password){
		return userRepo.findByUserNameAndPassword(userName, password);
	}
	
	//Create User
	public User createUser(User user) {
		return userRepo.save(user);
		// override save method 
		//userRepo.createUser()
	}
 
}
