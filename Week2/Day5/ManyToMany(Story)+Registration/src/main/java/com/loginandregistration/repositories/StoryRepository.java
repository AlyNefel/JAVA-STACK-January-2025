package com.loginandregistration.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loginandregistration.models.Story;

@Repository
public interface StoryRepository extends CrudRepository<Story,Long> {
	
	//Get All stories
	List<Story> findAll();

}
