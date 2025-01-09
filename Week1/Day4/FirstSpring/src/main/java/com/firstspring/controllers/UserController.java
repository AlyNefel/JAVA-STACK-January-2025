package com.firstspring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
@RequestMapping("/userController")
public String index() {
	return "Hello from User Controller";
}
}
