package com.muzir.kek.service;

import javax.servlet.http.HttpSession;

import com.muzir.kek.domain.User;

public interface SessionService {
	User getUser(HttpSession session);

	void setUser(HttpSession session, User user);
}
