package com.springcore.nestedbeanfact;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.nestedbeanfact.bean.CustomerLoanApprover;

/**
 * @author bpawar
 *
 */
public class NestedBeanFactoryApplication {

	public static void main(String[] args) {
		BeanFactory container1 = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
		BeanFactory container2 = new XmlBeanFactory(new ClassPathResource("dispatcher-servlet.xml"), container1);
		
		CustomerLoanApprover loanApprover = container2.getBean(CustomerLoanApprover.class);
		loanApprover.approve(36000, 560000, 18);
	}
}
