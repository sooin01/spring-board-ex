package com.my.app.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public String exception(Exception e) {
		return "common/error/exception";
	}

	@ExceptionHandler(UnauthorizedException.class)
	public String exception(UnauthorizedException e) {
		return "common/error/401";
	}

}
