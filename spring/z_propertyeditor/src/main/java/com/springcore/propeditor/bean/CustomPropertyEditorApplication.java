package com.springcore.propeditor.bean;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.propeditor.custom.bean.ComplexNumber;
import com.springcore.propeditor.custom.bean.MathCalculator;

public class CustomPropertyEditorApplication {
	public static void main(String[] args) {
/*
		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));

		MathCalculator mathCalculator = container.getBean(MathCalculator.class);
		mathCalculator.calculate();
*/
		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
		((ConfigurableListableBeanFactory) container).addPropertyEditorRegistrar(new PropertyEditorRegistrar() {

			public void registerCustomEditors(PropertyEditorRegistry registry) {
				registry.registerCustomEditor(ComplexNumber.class, new ComplexNumberEditorSupport());
			}
		});

		MathCalculator mathCalculator = container.getBean(MathCalculator.class);
		mathCalculator.calculate();
	}
}
