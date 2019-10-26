package com.my.app.common.interceptor;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.my.app.common.annotation.Authorization;
import com.my.app.common.annotation.Authorization.Role;

public class AuthInterceptor implements HandlerInterceptor {

	private static final Logger LOG = LoggerFactory.getLogger(AuthInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod method = (HandlerMethod) handler;
		Authorization authorization = method.getMethodAnnotation(Authorization.class);

		if (authorization != null) {
			List<Role> roleList = Arrays.asList(authorization.name());

			if (roleList.contains(Role.ADMIN) && roleList.contains(Role.USER)) {
				LOG.info("관리자/사용자 접근 가능!");
				// throw new UnauthorizedException();
			} else if (roleList.contains(Role.ADMIN)) {
				LOG.info("관리자 접근 가능!");
			} else if (roleList.contains(Role.USER)) {
				LOG.info("사용자 접근 가능!");
			}
		} else {
			LOG.info("누구나 접근 가능!");
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
