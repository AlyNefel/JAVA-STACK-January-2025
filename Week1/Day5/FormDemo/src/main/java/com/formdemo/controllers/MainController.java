package com.formdemo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.formdemo.models.User;

import jakarta.servlet.http.HttpSession;

//controller annotation
@Controller
public class MainController {

	//@RequestMapping("/")
	
	// getMapping to render page 
	@GetMapping("/login")
	public String index() {
		return "index.jsp";
	}
	
	// if we want to use @RequestMapping :
	//@RequestMapping(value="/login",method=RequestMethod.POST)
	//Post mapping to collect data
	@PostMapping("/login")
	public String handleLogin(@RequestParam(value="userName") String userName,@RequestParam(value="password") String password,HttpSession session,
			RedirectAttributes redirectAttribuites){
		String msg=String.format("UserName : %s\nPassword : %s", userName,password);
		
		 //just for us to see them that they actually travel from the jsp towards this controller route
		System.out.println(msg);
		
		//simulation of database
		User user=new User("Jabrane","123");
		User user1=new User("test","123");
		
		// we will add those uesers to an arrayList
		ArrayList<User> listUsers = new ArrayList<>();
		listUsers.add(user1);
		listUsers.add(user);
		//we will loop throught this array list and compare it with request params 
		for(User item:listUsers) {
			if(item.getUserName().equals(userName) && item.getPassword().equals(password)) {
				session.setAttribute("userName", userName);
				session.setAttribute("password", password);
				
				//using redirect to prevent re-submit form
				return "redirect:/home";
			}
				
			
		}
		//adding flash attribute
		redirectAttribuites.addFlashAttribute("errorMessage","Wrong Credentials!!");
		return "redirect:/login";
	}
	
@GetMapping("/home")
public String renderHome() {
	return "home.jsp";
}
	
}
