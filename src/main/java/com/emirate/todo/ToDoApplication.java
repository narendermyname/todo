package com.emirate.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.emirate.todo.model.ToDo;
import com.emirate.todo.repository.ToDoJpaRepository;

@SpringBootApplication
public class ToDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoApplication.class, args);
	}
}

class BootStrap implements CommandLineRunner {

	@Autowired
	private ToDoJpaRepository todoRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... arg0) throws Exception {
		String msg = "Hello";
		ToDo todo = new ToDo(msg, "Pending");
		todoRepo.save(todo);

		for (ToDo t : todoRepo.findAll()) {
			System.out.println(t);
		}
	}

}
