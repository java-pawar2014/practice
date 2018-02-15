package com.aop.programmatic;

import java.io.File;
import java.io.IOException;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;

import com.aop.programmatic.throwing.advice.ExceptionHandlerAdvice;
import com.aop.programmatic.throwing.service.FileService;

/**
 * @author bpawar
 *
 */
public class ThrowsAdvice {

	public void run(ApplicationContext context) {

		ProxyFactory proxyFactory = null;
		FileService fileService = null;
		ExceptionHandlerAdvice exceptionHandlerAdvice = null;

		fileService = context.getBean(FileService.class);
		exceptionHandlerAdvice = context.getBean(ExceptionHandlerAdvice.class);
		proxyFactory = context.getBean(ProxyFactory.class);
		proxyFactory.setTarget(fileService);
		proxyFactory.addAdvice(exceptionHandlerAdvice);

		fileService = (FileService) proxyFactory.getProxy();

		try {
			File file = fileService.load("/home/bpawa/Downloads/root1.txt");
			System.out.println("File created: " + file.getAbsolutePath());
		} catch (IOException e) {
		}
		proxyFactory.removeAdvice(exceptionHandlerAdvice);
	}
}
