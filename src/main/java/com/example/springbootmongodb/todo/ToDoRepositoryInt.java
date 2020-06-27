/**
 * 
 */
package com.example.springbootmongodb.todo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mjedli
 *
 */
@Repository
public interface ToDoRepositoryInt extends MongoRepository<ToDo, String> {

	List<ToDo> findByName(String name);
	
}
