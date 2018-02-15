package com.aop.programmatic.throwing.config;

import org.springframework.context.annotation.Bean;

import com.aop.programmatic.throwing.advice.ExceptionHandlerAdvice;
import com.aop.programmatic.throwing.service.FileService;

public class ThrowingAdviceConfig {

	@Bean
	public FileService fileService() {
		return new FileService();
	}

	@Bean
	public ExceptionHandlerAdvice exceptionHandlerAdvice() {
		return new ExceptionHandlerAdvice();
	}
}
