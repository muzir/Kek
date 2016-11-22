package com.muzir.kek.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.muzir.kek.domain.User;

/**
 * @author erhun.baycelik
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByNameAndPasswordSha256(String name,String passwordSha256);

	Optional<User> findByName(String userName);
}
