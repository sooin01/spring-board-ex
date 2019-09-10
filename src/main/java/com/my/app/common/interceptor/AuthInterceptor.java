package com.my.app.common.interceptor;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.my.app.common.annotation.Authorization;
import com.my.app.common.annotation.Authorization.Role;

public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("권한 체크!");

		HandlerMethod method = (HandlerMethod) handler;
		Authorization authorization = method.getMethodAnnotation(Authorization.class);

		if (authorization != null) {
			List<Role> roleList = Arrays.asList(authorization.name());

			if (roleList.contains(Role.ADMIN) && roleList.contains(Role.USER)) {
				System.out.println("관리자와 사용자 접근 가능!");
				// throw new UnauthorizedException();
			} else if (roleList.contains(Role.ADMIN)) {
				System.out.println("관리자 접근 가능!");
			} else if (roleList.contains(Role.USER)) {
				System.out.println("사용자 접근 가능!");
			}
		} else {
			System.out.println("누구나 접근 가능!");
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
