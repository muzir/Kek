package com.muzir.kek.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.muzir.kek.domain.Todo;
import com.muzir.kek.domain.User;

/**
 * @author erhun.baycelik
 *
 */
public interface TodoRepository extends CrudRepository<Todo, Long> {
	List<Todo> findByUserAndIsDone(User user, String isDone);

	Optional<Todo> findByUserAndId(User user, Long todoId);

	@Transactional
	void deleteByIdAndUser(Long todoId, User user);
}
