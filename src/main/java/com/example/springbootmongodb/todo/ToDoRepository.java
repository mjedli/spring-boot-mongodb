/**
 * 
 */
package com.example.springbootmongodb.todo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mjedli
 *
 */
@Repository
public interface ToDoRepository extends MongoRepository<ToDo, String> {
	
}
