package com.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todolist.models.Todo;
import com.todolist.services.TodoService;

import jakarta.validation.Valid;

@Controller
public class TodoController {
@Autowired
TodoService todoService;

// get the main page 
@GetMapping("/todos")
public String index(Model model) {
	model.addAttribute("todos",todoService.getAllTodos());
	return "todoList";
}

// search with query 
@GetMapping("/todos/search")
public String search(@RequestParam("query")String str,Model model) {
	model.addAttribute("todos",todoService.searchByTitle(str));
	return "todoList";
}

// get create new todo page 
@GetMapping("/todo/new")
public String newTodoPage(@ModelAttribute("todo")Todo todo) {
	return "createTodo";
}

// Create todo process
@PostMapping("/todos")
public String createTodo(@Valid @ModelAttribute("todo")Todo todo,BindingResult result) {
	// if there is validation errors related to the model
	if(result.hasErrors()) {
		return "createTodo";
	}
	// if there is no error we will persist the data in the db and redirect to /todos
	todoService.createTask(todo);
	System.out.println("this is the model attribute "+todo.getTitle());
	return "redirect:/todos";
}

// delete todo process

@GetMapping("/todo/delete/{id}")
public String deleteTodo(@PathVariable("id")Long id) {
	todoService.deleteTodoById(id);
	return "redirect:/todos";
}

//get edit page 
@GetMapping("/todo/edit/{id}")
public String renderEditPage(@ModelAttribute("todo")Todo todo,Model model,@PathVariable("id")Long id) {
	//1-get our todo using the id 
	Todo todoToEdit=todoService.getTodoById(id);
	model.addAttribute("todo",todoToEdit);
	return "editTodo";
}

// perform edit
@PutMapping("/edit/todo/{id}") 
public String updateTodo(@PathVariable Long id, @Valid @ModelAttribute("todo") Todo todo, BindingResult result)
{ if (result.hasErrors()) { return "editTodo"; 

 } 
todoService.updateTodo(id, todo); 

return "redirect:/todos"; }


}
