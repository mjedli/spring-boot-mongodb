/**
 * 
 */
package com.example.springbootmongodb.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mjedli
 *
 */
@RestController
public class ToDoController {
	
	@Autowired
	ToDoService toDoSerivce;
	
	@GetMapping(value = "/id/{id}")
	public Optional<ToDo> getToDoById(@PathVariable String id) {
		return toDoSerivce.getToDoById(id);
	}
	
	@GetMapping(value = "/name/{name}")
	public List<ToDo> getToDoByName(@PathVariable String name) {
		return toDoSerivce.findByName(name);
	}
	
	@GetMapping(value = {"/", ""})
	public List<ToDo> getAllToDo() {
		return toDoSerivce.getAllToDo();
	}
	
	@PostMapping(value= {"/", ""})
	public ToDo addTodo(@RequestBody ToDo toDo) {
		return toDoSerivce.addTodo(toDo);
	}
	
	@DeleteMapping(value= "/{id}")
	public void removeTodoById(@PathVariable @Validated String id) {
		toDoSerivce.removeTodoById(id);
	}
}
