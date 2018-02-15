package com.springcore.propeditor;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.propeditor.bean.Payslip;

public class PropertyEditorApplication {

	public static void main(String[] args) {

		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));

		Payslip payslip = container.getBean(Payslip.class);
		System.err.println(payslip);
	}
}
