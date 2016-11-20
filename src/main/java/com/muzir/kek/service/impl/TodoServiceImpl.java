package com.muzir.kek.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muzir.kek.dao.TodoRepository;
import com.muzir.kek.domain.Todo;
import com.muzir.kek.domain.User;
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
	public List<Todo> getUserTodos(User user) {
		return todoRepository.findByUser(user);
	}

	@Override
	public Todo saveTodo(Todo todo) {
		return todoRepository.save(todo);
	}

}
