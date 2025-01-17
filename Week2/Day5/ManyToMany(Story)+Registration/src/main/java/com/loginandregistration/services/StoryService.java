package com.loginandregistration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginandregistration.models.Story;
import com.loginandregistration.models.User;
import com.loginandregistration.repositories.StoryRepository;

@Service
public class StoryService {
@Autowired
StoryRepository storyRepo;
@Autowired
UserService userService;
	
	//get all stories
public List<Story> getAllStories(){
	return storyRepo.findAll()
;}

//create story 
public Story createStory(Story story) {
	return storyRepo.save(story);
}

//getStoryById
public Story getStoryById(Long id) {
	Optional<Story> s=storyRepo.findById(id);
	if(s.isEmpty()) {
		return null;
	}
	return s.get();
}

//like process
public void likeStory(Long userId,Long storyId) {
	// get user by id 
	User user =userService.getUserById(userId);
	//get story by id 
	Story story =getStoryById(storyId);
	// check if they are not null
	if(user !=null && story!=null) {
		// we will add the user to the likers list
		story.getLikers().add(user);
		//we will persisit the changes
		storyRepo.save(story);
	}
}
	//dislike process
	public void dislikeStory(Long userId,Long storyId) {
		// get user by id 
		User user =userService.getUserById(userId);
		//get story by id 
		Story story =getStoryById(storyId);
		// check if they are not null
		if(user !=null && story!=null) {
			// we will add the user to the likers list
			story.getLikers().remove(user);
			story.setId(storyId);
			//we will persisit the changes
			storyRepo.save(story);
		}	
	
	 
}
}
