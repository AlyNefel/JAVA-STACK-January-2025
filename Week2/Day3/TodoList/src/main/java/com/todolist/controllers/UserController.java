package com.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.todolist.models.User;
import com.todolist.services.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {
@Autowired
UserService userService;
	
	//get the create user page 
	@GetMapping("/user/new")
	public String createUser(@ModelAttribute("user")User user) {
		return "createUser";
	}
	
	// user creation process
	@PostMapping("/user/new")
	public String saveUser(@Valid @ModelAttribute("user")User user,
			BindingResult result) {
		// if result has errors 
		if(result.hasErrors()) {
			return "createUser";
		}
		userService.createUser(user);
		return "redirect:/todos";
	}
	
	//Delete route 
	@DeleteMapping("/user/delete/{userId}")
	public String deleteUser(@PathVariable("userId")Long userId) {
		userService.deleteUser(userId);
		return "redirect:/todos";
	}
}
