/**
 * 
 */
package com.example.springbootmongodb.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	@GetMapping(value = {"/sort/", "/sort"})
	public List<ToDo> getAllToDoSort() {
		Sort sort = Sort.by(Sort.DEFAULT_DIRECTION, "name");
		return toDoSerivce.getAllToDoSort(sort);
	}
	
	@GetMapping(value = {"/pagebale/", "/pagebale"})
	public List<ToDo> getAllToDoPagebale() {
		final Pageable pageableRequest = PageRequest.of(0, 2);
		return toDoSerivce.getAllToDoPagebale(pageableRequest).getContent();
	}

	@PostMapping(value= {"isExist/", "isExist"})
	public Boolean isTodoExist(@RequestBody ToDo toDo) {
		
		ExampleMatcher NAME_MATCHER = ExampleMatcher.matching()
	            .withMatcher("name", GenericPropertyMatchers.ignoreCase());
		
		Example<ToDo> example = Example.<ToDo>of(toDo, NAME_MATCHER);

		return toDoSerivce.isTodoExist(example);
	}
	
	@PostMapping(value= {"/", ""})
	public ToDo addTodo(@RequestBody ToDo toDo) {
		return toDoSerivce.addTodo(toDo);
	}
	
	@DeleteMapping(value= "/{id}")
	public void removeTodoById(@PathVariable @Validated String id) {
		toDoSerivce.removeTodoById(id);
	}
	
	@GetMapping(value = "/count")
	public long count() {
		return toDoSerivce.count();
	}
}
