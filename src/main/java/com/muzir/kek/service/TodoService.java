package com.muzir.kek.service;

import java.util.List;

import com.muzir.kek.domain.Todo;
import com.muzir.kek.domain.User;

/**
 * @author erhun.baycelik
 *
 */
public interface TodoService {
	List<Todo> getUserTodos(User user);
	Todo saveTodo(Todo todo); 
}
