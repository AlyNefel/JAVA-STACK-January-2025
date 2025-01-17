package com.loginandregistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginandregistration.models.LoginUser;
import com.loginandregistration.models.Story;
import com.loginandregistration.models.User;
import com.loginandregistration.services.StoryService;
import com.loginandregistration.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	@Autowired 
	StoryService storyService;
	// get the index page 
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index";
	}
	
	//Register
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser")User newUser,
			BindingResult result,
			HttpSession session,
			Model model) {
		// we will call the register method from the service 
		User user =userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index";
		}
		
		// we will set the userId in the session if true
		session.setAttribute("userId", user.getId());
		// we will redirect to a home page 
		return "redirect:/home";
	}
	
	//Login process
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin")LoginUser newLogin,
			BindingResult result,
			HttpSession session,Model model) {
		User user = userService.login(newLogin,result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index";
		}
		session.setAttribute("userId", user.getId());
		// we will redirect to a home page 
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String homePage(HttpSession session,Model model) {
		if(session.getAttribute("userId")!=null) {
			model.addAttribute("user",userService.getUserById((Long) session.getAttribute("userId")));
			model.addAttribute("stories",storyService.getAllStories());
			return "home";
		}
		return "redirect:/";
	}
	
	// get new story page 
	@GetMapping("/story/new")
	public String createStory(@ModelAttribute("story") Story story) {
		return "createtory";
	}
	
	//create story process
	@PostMapping("/createstory")
	public String createStory(@Valid @ModelAttribute("story")Story story,
			      BindingResult result,
			      HttpSession session) {
		if(result.hasErrors()) {
			return "createtory";
		}
		User user = userService.getUserById((Long) session.getAttribute("userId"));
		story.setCreator(user);
		storyService.createStory(story);
		return "redirect:/home";
		
	}
	// like route
	@GetMapping("/like/{storyId}")
	public String likeStory(@PathVariable("storyId")Long storyId,
			HttpSession session) {
		storyService.likeStory((Long) session.getAttribute("userId"), storyId);
		return "redirect:/home";
	}
	
	// dislike route
		@GetMapping("/dislike/{storyId}")
		public String dislikeStory(@PathVariable("storyId")Long storyId,
				HttpSession session) {
			storyService.dislikeStory((Long) session.getAttribute("userId"), storyId);
			return "redirect:/home";
		}
	
	//get display story page
		@GetMapping("/stories/{storyId}")
		public String getDisplayPage(@PathVariable("storyId")Long storyId,
				Model model) {
			model.addAttribute("story",storyService.getStoryById(storyId));
			return "displayStory";
		}
		
	//Logout 
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//clear session
		session.invalidate();
		//redirect
		return "redirect:/";
	}
	
}
