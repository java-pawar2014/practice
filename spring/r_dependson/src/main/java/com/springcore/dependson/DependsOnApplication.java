package com.springcore.dependson;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.dependson.bean.LoanCalculator;

/**
 * @author bpawar
 *
 */
@SuppressWarnings("deprecation")
public class DependsOnApplication {

	public static void main(String[] args) {
		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
		LoanCalculator loanCalculator = container.getBean(LoanCalculator.class);
		double grandTotal = loanCalculator.calculateInterest(25000, 12, "hyderabad1");
		System.out.println("Total Amount : " + grandTotal);
	}
}
