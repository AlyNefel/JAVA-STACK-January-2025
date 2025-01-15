package com.todolist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todolist.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	
	//get all user 
	List<User> findAll();

}
