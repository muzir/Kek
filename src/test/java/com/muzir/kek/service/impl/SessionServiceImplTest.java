package com.muzir.kek.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.muzir.kek.domain.User;
import com.muzir.kek.enums.Constants;

/**
 * @author erhun.baycelik
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class SessionServiceImplTest {

	SessionServiceImpl sessionServiceImpl;

	@Mock
	HttpSession session;

	@Mock
	User user;

	@Before
	public void setUp() throws Exception {
		sessionServiceImpl = new SessionServiceImpl();

	}

	@Test
	public void shouldGetUserSucced() {
		sessionServiceImpl.getUser(session);
		verify(session).getAttribute(Constants.KEKUSER.name());
	}

	@Test
	public void shouldGetUserReturnUser() {
		when(session.getAttribute(Constants.KEKUSER.name())).thenReturn(user);
		Assert.assertEquals(user, sessionServiceImpl.getUser(session));

	}

	@Test
	public void shouldGetUserNullWhenAttributeNull() {
		when(session.getAttribute(Constants.KEKUSER.name())).thenReturn(null);
		Assert.assertNull(sessionServiceImpl.getUser(session));

	}

	@Test
	public void shouldGetUserNull() {
		Assert.assertNull(sessionServiceImpl.getUser(null));
	}

	@Test
	public void shouldSetUserSucced() {
		sessionServiceImpl.setUser(session, user);
		verify(session).setAttribute(Constants.KEKUSER.name(), user);
	}

}
