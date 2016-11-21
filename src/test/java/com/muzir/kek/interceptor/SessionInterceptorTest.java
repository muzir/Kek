package com.muzir.kek.interceptor;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.muzir.kek.domain.User;
import com.muzir.kek.enums.Constants;

/**
 * @author erhun.baycelik
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class SessionInterceptorTest {

	@Mock
	HttpServletRequest request;
	@Mock
	HttpServletResponse response;
	@Mock
	HttpSession session;
	@Mock
	User user;
	@Mock
	Object handler;

	private final String LOGIN_URL = "/login";
	private final String UNKNOWN_URL = "/unknown";
	private final String CONTEXT_URL = "/kek/";

	@InjectMocks
	SessionInterceptor sessionInterceptor;

	@Test
	public void shouldLoggedUser() throws Exception {
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute(Constants.KEKUSER.name())).thenReturn(user);
		Assert.assertTrue(sessionInterceptor.preHandle(request, response, handler));
	}

	@Test
	public void shouldExcludeUrl() throws Exception {
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute(Constants.KEKUSER.name())).thenReturn(null);
		when(request.getServletPath()).thenReturn(LOGIN_URL);
		Assert.assertTrue(sessionInterceptor.preHandle(request, response, handler));
	}

	@Test
	public void shouldUNKNOWN_URLRedirectToLogin() throws Exception {
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute(Constants.KEKUSER.name())).thenReturn(null);
		when(request.getServletPath()).thenReturn(UNKNOWN_URL);
		when(request.getContextPath()).thenReturn(CONTEXT_URL);
		Assert.assertFalse(sessionInterceptor.preHandle(request, response, handler));
		verify(response).sendRedirect(CONTEXT_URL + LOGIN_URL);
	}

}
