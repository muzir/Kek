package com.muzir.kek.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.muzir.kek.domain.User;
import com.muzir.kek.enums.Constants;
import com.muzir.kek.service.SessionService;

@Service
public class SessionServiceImpl implements SessionService {

	@Override
	public User getUser(HttpSession session) {
		if (session != null && session.getAttribute(Constants.KEKUSER.name()) != null) {
			return (User) session.getAttribute(Constants.KEKUSER.name());
		}
		return null;
	}

	@Override
	public void setUser(HttpSession session, User user) {
		session.setAttribute(Constants.KEKUSER.name(), user);
	}

}
