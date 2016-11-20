package com.muzir.kek.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.muzir.kek.enums.Constants;

/**
 * @author erhun.baycelik
 *
 */
@Component
public class SessionInterceptor extends HandlerInterceptorAdapter {

	private static final String EXCLUDE_URLS = "/login,/register,/error";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute(Constants.KEKUSER.name()) != null) {
			return true;
		}
		String servletPath = request.getServletPath();
		if (StringUtils.contains(EXCLUDE_URLS, servletPath)) {
			return super.preHandle(request, response, handler);
		}
		response.sendRedirect(request.getContextPath() + "/login");
		return false;
	}
}
