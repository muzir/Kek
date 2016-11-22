package com.muzir.kek.service.impl;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.muzir.kek.dao.TodoRepository;
import com.muzir.kek.domain.Todo;
import com.muzir.kek.domain.User;
import com.muzir.kek.enums.DoneStatus;

/**
 * @author erhun.baycelik
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TodoServiceImplTest {

	@Mock
	TodoRepository todoRepository;

	@Mock
	Todo todo;
	@Mock
	User user;

	@InjectMocks
	TodoServiceImpl todoServiceImpl;

	@Test
	public void shouldVerifyRepositorySaveCall() {
		todoServiceImpl.saveTodo(todo);
		verify(todoRepository).save(todo);
	}

	@Test
	public void shouldVerifyRepositoryGetUserCall() {
		todoServiceImpl.getUserTodosByIsDone(user, DoneStatus.DONE.getValue());
		verify(todoRepository).findByUserAndIsDone(user, DoneStatus.DONE.getValue());
	}

}
