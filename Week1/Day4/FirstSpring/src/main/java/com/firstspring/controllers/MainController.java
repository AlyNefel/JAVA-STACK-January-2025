package com.firstspring.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class MainController {
	//to create a route we need a particular annotation called request mapping
	//RequestMapping annotation : this is to tell the compiler what path is related to the HTTP request
		@RequestMapping("/")
		
		//building up the method that will be executed with when this route is triggered through the browser
		public String index() {
			return "<h1>Hello !! from Rest Controller </h1>";
		}
		
	  //Query params :
		@RequestMapping("/home")
		
		//Start with @RequestParam(value="test" Type nameOfVariable)
		
		public String home(@RequestParam(value="firstName",required=false) String firstName,@RequestParam(value="lastName",required=false) String lastName) {
			String msg = String.format("Hello %s %s", firstName,lastName);
			
			//go to the browser and test it/we need//to begin with a question mark there that's that's how the URL knows that the query are going to start being built up
			//http://localhost:8080/home/user?firstName=ali&lastName=essoudani
			return msg;
		}
		
		//Path Variable: Ps : it's a part of the path 
		//path variables  in python "/home/user/<int:id1>  "
		
		
		@RequestMapping("/home/profile/{id}")
		public String profile(@PathVariable("id") int id) {
			return "test"+id;
		}
}
