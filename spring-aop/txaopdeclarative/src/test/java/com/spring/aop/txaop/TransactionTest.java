package com.spring.aop.txaop;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.tx.bean.Product;
import com.spring.aop.tx.service.ProductService;

import junit.framework.TestCase;

public class TransactionTest extends TestCase {

	private static Logger logger = Logger.getLogger(TransactionTest.class);

	public static void main(String[] args) {
		ApplicationContext context = null;
		ProductService productService = null;

		context = new ClassPathXmlApplicationContext("bean-configuration.xml");

		productService = context.getBean(ProductService.class);
		try {
			// Rollback transaction if duplicate entry
			productService.add(new Product(100, "SAMSUNG"));
			productService.add(new Product(200, "APPLE"));
			productService.add(new Product(300, "HTC"));
			productService.add(new Product(400, "SONY"));
		} catch (Throwable cause) {
			logger.info("Transaction failed while insert 1, rollbacking...");
		}

		logger.info("----------------------All products----------------------");
		logger.info(productService.getAllProducts());
		logger.info("--------------------------------------------------------");

		try {
			// Rollback transaction for duplicate entry
			productService.addAll(
					Arrays.asList(new Product(500, "MOTO"), new Product(200, "APPLE"), new Product(600, "OPPO")));
		} catch (Throwable cause) {
			logger.info("Transaction failed while insert 2, rollbacking...");
		}

		logger.info("----------------------All products----------------------");
		logger.info(productService.getAllProducts());
		logger.info("--------------------------------------------------------");

		((ConfigurableApplicationContext) context).close();
	}
}
