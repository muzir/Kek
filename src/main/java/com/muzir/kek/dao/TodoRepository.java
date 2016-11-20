package com.muzir.kek.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.muzir.kek.domain.Todo;
import com.muzir.kek.domain.User;

/**
 * @author erhun.baycelik
 *
 */
public interface TodoRepository extends CrudRepository<Todo, Long> {
	List<Todo> findByUser(User user);
}
