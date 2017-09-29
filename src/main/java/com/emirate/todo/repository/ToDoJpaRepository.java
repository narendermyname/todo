/**
 * 
 */
package com.emirate.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emirate.todo.model.ToDo;

/**
 * @author ntanwa
 *
 */
public interface ToDoJpaRepository extends JpaRepository<ToDo, Long> {

	List<ToDo> findByMsg(String msg);
}
