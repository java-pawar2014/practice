package com.springcore.replacement;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.replacement.bean.PlanFinder;

/**
 * @author bpawar
 *
 */
@SuppressWarnings("deprecation")
public class MethodReplacementApplication {

	public static void main(String[] args) {
		
		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
		PlanFinder planFinder = container.getBean(PlanFinder.class);
		
		System.out.println(planFinder.findPlans(20, 412307, 0, 0));
	}
}
