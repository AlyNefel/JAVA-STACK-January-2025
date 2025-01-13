package com.formdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formdemo.models.User;



@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	//this is to return all the instances in user table
List<User> findAll();
// get the user with username and password 
List <User> findByUserNameAndPassword(String userName,String password);



}
