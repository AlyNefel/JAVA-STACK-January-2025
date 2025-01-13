package com.formdemo.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

// this is to declare it's a class 
@Entity
// the name of DB table connected with this class 
@Table(name="users")
public class User {
	// the JPA will handel the creation of the id 	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
//@NotNull(message="don't lkeave ur username empty !!")	

@NotEmpty
private String userName;
@Size(min=3,max=8,message="password should be between 3 and 8 ! ")
private String password;
@Column(updatable=false)
private Date createdAt;
private Date updatedAt;

@PrePersist
public void onCreate() {
	this.createdAt=new Date();
	this.updatedAt=new Date();
}

@PreUpdate()
public void onUpdate() {
	this.updatedAt=new Date();
}
//Constructor with fields 

// empty constructor 
public User() {}

public User(@NotEmpty String userName,
		@Size(min = 3, max = 8, message = "password should be between 3 and 8 ! ") String password, Date createdAt,
		Date updatedAt) {
	super();
	this.userName = userName;
	this.password = password;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
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
