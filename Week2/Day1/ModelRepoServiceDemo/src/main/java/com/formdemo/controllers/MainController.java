package com.formdemo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.formdemo.models.User;
import com.formdemo.services.UserService;

import jakarta.servlet.http.HttpSession;

//controller annotation
@Controller
public class MainController {
@Autowired 
UserService userServ;
	//@RequestMapping("/")
	
	// getMapping to render page 
	@GetMapping("/login")
	public String index(HttpSession session) {
		System.out.print(userServ.getAllUsers().get(0).getUserName());   
		session.setAttribute("users", userServ.getAllUsers());
		return "index.jsp";
	}
	
	// if we want to use @RequestMapping :
	//@RequestMapping(value="/login",method=RequestMethod.POST)
	//Post mapping to collect data
	@PostMapping("/login")
	public String handleLogin(@RequestParam(value="userName") String userName,@RequestParam(value="password") String password,HttpSession session,
			RedirectAttributes redirectAttribuites){
		String msg=String.format("UserName : %s\nPassword : %s", userName,password);
		System.out.print(userServ.getUserWithNameAndPass(userName,password));
		if(userServ.getUserWithNameAndPass(userName,password).size()==0) {
			//adding flash attribute
			redirectAttribuites.addFlashAttribute("errorMessage","Wrong Credentials!!");
			return "redirect:/login";
		}
		else {
			session.setAttribute("userName", userName);
			session.setAttribute("password", password);
			
			//using redirect to prevent re-submit form
			return "redirect:/home";
		}
		
	}
	
@GetMapping("/home")
public String renderHome() {
	
	return "home.jsp";
}
	
}
