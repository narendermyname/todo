package com.emirate.todo;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.emirate.todo.model.ToDo;
import com.emirate.todo.repository.ToDoJpaRepository;

public class ToDoApplicationTests {

	@InjectMocks
	private ToDoJpaRepository todoRepo;
	
	//@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	//@Test
	public void contextLoads() {
		String msg = "Hello";
		ToDo todo =  new ToDo(msg,"Pending");
		//todoRepo.save();
		when(todoRepo.findByMsg(msg)).thenReturn(Arrays.asList(todo));
		verify(todoRepo).findByMsg(msg);
	}

}
