package com.todolist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.models.Todo;
import com.todolist.repositories.TodoRepository;

@Service
public class TodoService {

	@Autowired
	TodoRepository todoRepo;
	
	//Get all todos Method
	public List<Todo> getAllTodos(){
		return todoRepo.findAll();
	}
	
	//search method 
	public List<Todo> searchByTitle(String str){
		return todoRepo.findByTitleContains(str);
	}
	// Create Todo 
	public Todo createTask(Todo todo) {
		return todoRepo.save(todo);
	}
	
	// get todo byId
	public Todo getTodoById(Long id) {
		Optional<Todo> todo = todoRepo.findById(id);
		if(todo.isEmpty()) {
			return null;
		} else {
			return todo.get();
		}
		
	}
	
	//Delete Method by id 
	public void deleteTodoById(Long id) {
		todoRepo.deleteById(id);
	}
	
	//update todo by id  method 
	
	public Todo updateTodo(Long id,Todo newTodo) {
		newTodo.setId(id);
		return todoRepo.save(newTodo);
		
	}
}
