package com.muzir.kek.service;

import java.util.List;

import com.muzir.kek.domain.Todo;
import com.muzir.kek.domain.User;

/**
 * @author erhun.baycelik
 *
 */
public interface TodoService {
	List<Todo> getUserTodosByIsDone(User user,String isDone);
	Todo saveTodo(Todo todo);
	void updateTodosAsDone(String []markedTodoIds, User user);
	void deleteMarkedAsDone(String deleteDoneId, User user); 
}
