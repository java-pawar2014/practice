package com.springcore.postprocessor;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.postprocessor.delegate.EmployeeDelegate;

@SuppressWarnings("deprecation")
public class PostProcessorApplication {

	public static void main(String[] args) {

		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));

		BaseVOPostProcessor postProcessor = container.getBean(BaseVOPostProcessor.class);

		((ConfigurableListableBeanFactory) container).addBeanPostProcessor(postProcessor);
		EmployeeDelegate employeeDelegate = container.getBean(EmployeeDelegate.class);
		employeeDelegate.save();
	}
}
