package com.muzir.kek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.muzir.kek.interceptor.SessionInterceptor;

/**
 * @author erhun.baycelik
 *
 */
@Component
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
	@Autowired
	private SessionInterceptor sessionInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sessionInterceptor);
	}
}
