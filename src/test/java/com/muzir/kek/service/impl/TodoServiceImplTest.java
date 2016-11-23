package com.muzir.kek.service.impl;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

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

	@Test
	public void shouldVerifyRepositoryDeleteCall() {
		String deleteDoneId = "1";
		todoServiceImpl.deleteMarkedAsDone(deleteDoneId, user);
		verify(todoRepository).deleteByIdAndUser(Long.valueOf(deleteDoneId), user);
	}

	@Test
	public void shouldUpdateTodosAsDoneUserNull() {
		String[] markedTodoIds = { "1", "2", "3", "4" };
		todoServiceImpl.updateTodosAsDone(markedTodoIds, null);
	}

	@Test
	public void shouldUpdateTodosAsDoneTodoIdsNull() {
		todoServiceImpl.updateTodosAsDone(null, user);
	}

	@Test
	public void shouldUpdateTodosAsDoneTodoIdsLenghtZero() {
		String[] markedTodoIds = {};
		todoServiceImpl.updateTodosAsDone(markedTodoIds, user);
	}

	@Test
	public void shouldUpdateTodosAsDone() {
		String[] markedTodoIds = { "1", "2", "3", "4" };
		Optional<Todo> optionalTodo = Optional.of(new Todo());
		when(todoRepository.findByUserAndId(anyObject(), anyLong())).thenReturn(optionalTodo);
		todoServiceImpl.updateTodosAsDone(markedTodoIds, user);
		verify(todoRepository, times(4)).save(optionalTodo.get());
	}

}
