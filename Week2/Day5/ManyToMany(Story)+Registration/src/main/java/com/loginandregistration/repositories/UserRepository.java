package com.loginandregistration.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loginandregistration.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
//get all users
	List<User> findAll();

// find User by email
Optional<User> findByEmail(String email);

}
