package com.muzir.kek.service;

import java.util.Optional;

import com.muzir.kek.domain.User;

public interface LoginService {
	Optional<User> getUser(String userName, String password);

	User createUser(User user);

}
