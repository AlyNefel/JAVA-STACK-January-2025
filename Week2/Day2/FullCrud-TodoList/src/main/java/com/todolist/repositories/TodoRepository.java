package com.todolist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todolist.models.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo,Long> {

	// find all todos
	List<Todo> findAll();
	// get todo with title contains
	List<Todo> findByTitleContains(String title);
}
