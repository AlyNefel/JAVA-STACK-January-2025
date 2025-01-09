## Spring boot 
- JAVA framework comes with a lot of pre-made settings, so you don't have to spend time setting everything up yourself. This means you can start writing your code right away. It also includes built-in servers and automatic configurations, which make the development process faster and easier.

## Maven
- Handles the dependencies, builds, and configurations for a Spring Boot project

## @RestController
- Create and manage endpoints that handle HTTP requests and responses in a Spring Boot application

## @RequestMapping
- An annotation used in Spring Boot to map HTTP requests to specific handler methods in a controller

## @RequestParam 
- Declaration eg :
- @RequestMapping("/home/user")
public String userName(@RequestParam(value="firstName") String firstName,@RequestParam(value="lastName",required=false) String lastName) {
	System.out.print("helloo"+firstName);
	
	return "Hey "+firstName+" "+lastName+ " !";

	//http://localhost:8080/home/user?firstName=ali&lastName=essoudani

}

## @PathVariable
-Declaration eg: 
-@RequestMapping("/home/user/{firstName}/{lastName}")

public String userPage1(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName) {
// we don't type the value keyword 
	
System.out.print("helloo"+firstName);
	

}
