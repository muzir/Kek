package com.muzir.kek.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.muzir.kek.dao.UserRepository;
import com.muzir.kek.domain.User;
import com.muzir.kek.service.impl.LoginServiceImpl;
import com.muzir.kek.util.Hashy;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {

	@Mock
	UserRepository userRepository;
	@Mock
	Hashy hashy;

	@InjectMocks
	LoginServiceImpl loginServiceImpl;

	private String userName = "userName";
	private String password = "password";
	private String hashedPassword = "p3sswoORd";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldGetUser() {
		loginServiceImpl.getUser(userName, password);
		verify(hashy).calculateHash(password);
	}

	@Test
	public void shouldCreateUserPasswordHashed() {
		when(hashy.calculateHash(password)).thenReturn(hashedPassword);
		User user = new User();
		user.setName(userName);
		user.setPasswordSha256(password);
		loginServiceImpl.createUser(user);
		verify(hashy).calculateHash(password);
		User hashedUser = new User();
		hashedUser.setName(userName);
		hashedUser.setPasswordSha256(hashedPassword);
		verify(userRepository).save(hashedUser);
	}

}
