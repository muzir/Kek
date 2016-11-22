package com.muzir.kek.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muzir.kek.dao.UserRepository;
import com.muzir.kek.domain.User;
import com.muzir.kek.service.LoginService;
import com.muzir.kek.util.Hashy;

/**
 * @author erhun.baycelik
 *
 */
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	Hashy hashy;

	public User createUser(User user) {
		String hashedPassword = hashy.calculateHash(user.getPasswordSha256());
		user.setPasswordSha256(hashedPassword);
		return userRepository.save(user);
	}

	public Optional<User> getUser(String userName, String password) {
		String hashedPassword = hashy.calculateHash(password);
		Optional<User> userOptional = userRepository.findByNameAndPasswordSha256(userName, hashedPassword);
		return userOptional;
	}

	public boolean isUserExist(String userName) {
		Optional<User> optionalUser=userRepository.findByName(userName);
		return optionalUser.isPresent();
	}
}
