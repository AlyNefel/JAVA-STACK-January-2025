package com.jspdemo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	
	//Mapping web requests means associating incoming HTTP requests (like GET, POST, PUT, DELETE) to specific methods in your controller classes.
	@RequestMapping("/")
	
	//A Model is an object that you can use to pass attributes from the Controller to the View. To make the Model object available
	//when we just declare it it called depencecie injection
	public String index(Model model,HttpSession session) {
		model.addAttribute("name","Test Model");
		ArrayList<String> listOfLanguages=new ArrayList<>();
		listOfLanguages.add("VueJs");
		listOfLanguages.add("Java");
		listOfLanguages.add("C#");
		model.addAttribute("list",listOfLanguages);
		session.setAttribute("age", 22);
		model.addAttribute("age",33);
		System.out.print(session.getAttribute("age"));
		return "index.jsp";
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session) {
		System.out.print(session.getAttribute("age"));
		return "home.jsp";
	}
}
