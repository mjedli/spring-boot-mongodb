/**
 * 
 */
package com.example.springbootmongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping(value = "/{id}")
	public ToDo getToDoById(@PathVariable int id) {
		return toDoSerivce.getToDoById(id);
	}
	
	@GetMapping(value = {"/", ""})
	public List<ToDo> getAllToDo() {
		return toDoSerivce.getAllToDo();
	}
	
	
	@PostMapping(value= {"/", ""})
	public ToDo addTodo(@RequestBody ToDo toDo) {
		return toDoSerivce.addTodo(toDo);
	}
	
	@DeleteMapping(value= {"/", ""})
	public void removeTodoById(@RequestBody ToDo toDo) {
		toDoSerivce.removeTodoById(toDo.getId());
	}
}
