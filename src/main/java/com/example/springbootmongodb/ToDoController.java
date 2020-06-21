/**
 * 
 */
package com.example.springbootmongodb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mjedli
 *
 */
@RestController
public class ToDoController {

	static List<ToDo> data;
	
	static {
	ToDo todo1 = new ToDo();
	
	todo1.setId(1);
	todo1.setName("name1");
	todo1.setDescription("Desciption of todo");
	
	
	ToDo todo2 = new ToDo();
	
	todo2.setId(2);
	todo2.setName("name2");
	todo2.setDescription("Desciption of todo");
	
	 data = new ArrayList<>(java.util.Arrays.asList(todo1,todo2));
	
	}
	
	@GetMapping(value = "/{id}")
	public ToDo getToDo(@PathVariable int id) {
		
		ToDo todo = new ToDo();
		
		todo.setId(id);
		todo.setName("name");
		todo.setDescription("Desciption of todo");
		
		return todo ;
	}
	
	@GetMapping(value = {"/", ""})
	public List<ToDo> getAll() {
		return data;
	}
	
	
	@PostMapping(value= {"/", ""})
	public ToDo addTodo(@RequestBody ToDo toDo) {
		data.add(toDo);
		return toDo;
	}
	
}
