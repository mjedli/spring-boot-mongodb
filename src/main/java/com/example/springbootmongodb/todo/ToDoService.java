/**
 * 
 */
package com.example.springbootmongodb.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mjedli
 *
 */
@Service
@Transactional
public class ToDoService {

	@Autowired
	ToDoRepositoryInt repository;
	
	public Optional<ToDo> findById(String id) {
		return repository.findById(id);
	}
	
	public List<ToDo> findByName(String name) {
		return repository.findByName(name);
	}
	
	public Optional<ToDo> getToDoById(String id) {
		return repository.findById(id);
	}

	public ToDo addTodo(ToDo toDo) {
		return repository.insert(toDo);
	}

	public List<ToDo> getAllToDo() {
		return repository.findAll();
	}
	
	public List<ToDo> getAllToDoSort(Sort sort) {
		return repository.findAll(sort);
	}

	public Page<ToDo> getAllToDoPagebale(Pageable pageableRequest) {
		return repository.findAll(pageableRequest);
	}

	
	public void removeTodoById(String id) {
		repository.deleteById(id);
	}
	
	public long count() {
		return repository.count();
	}
}