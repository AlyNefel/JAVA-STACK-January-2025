package com.formdemo.models;

public class User {
private String userName;
private String password;

//Constructor
public User(String userName, String password) {
	
	this.userName = userName;
	this.password = password;
}

//Getters and setter 
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


}
