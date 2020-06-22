/**
 * 
 */
package com.example.springbootmongodb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mjedli
 *
 */
@Service
public class ToDoService {

	@Autowired
	ToDoRepository repository;
	
	public Optional<ToDo> getToDoById(String id) {
		return repository.findById(id);
	}

	public ToDo addTodo(ToDo toDo) {
		return repository.insert(toDo);
	}

	public List<ToDo> getAllToDo() {
		return repository.findAll();
	}

	public void removeTodoById(String id) {
		repository.deleteById(id);
	}
}