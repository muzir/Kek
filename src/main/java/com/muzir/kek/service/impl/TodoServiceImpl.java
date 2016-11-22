package com.muzir.kek.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muzir.kek.dao.TodoRepository;
import com.muzir.kek.domain.Todo;
import com.muzir.kek.domain.User;
import com.muzir.kek.enums.DoneStatus;
import com.muzir.kek.service.TodoService;

/**
 * @author erhun.baycelik
 *
 */
@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoRepository todoRepository;

	@Override
	public List<Todo> getUserTodosByIsDone(User user, String isDone) {
		return todoRepository.findByUserAndIsDone(user, isDone);
	}

	@Override
	public Todo saveTodo(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public void updateTodosAsDone(String[] markedTodoIds, User user) {
		if (user == null) {
			return;
		}
		if (markedTodoIds == null || markedTodoIds.length == 0) {
			return;
		}
		for (String markedTodoId : markedTodoIds) {
			Optional<Todo> optionalTodo = todoRepository.findByUserAndId(user, Long.valueOf(markedTodoId));
			if (optionalTodo.isPresent()) {
				Todo todo = optionalTodo.get();
				todo.setIsDone(DoneStatus.DONE.getValue());
				todoRepository.save(todo);
			}
		}
	}

	@Override
	public void deleteMarkedAsDone(String deleteDoneId, User user) {
		todoRepository.deleteByIdAndUser(Long.valueOf(deleteDoneId), user);
	}
}
