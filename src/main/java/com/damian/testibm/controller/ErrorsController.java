package com.damian.testibm.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ErrorsController {
	
	public static final String ISE_VIEW = "error/500";
	
	//@ExceptionHandler(Exception.class)
	public String showInternalServerError() {
		return ISE_VIEW;
	}

}
