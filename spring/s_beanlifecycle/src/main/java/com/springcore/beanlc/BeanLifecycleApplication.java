package com.springcore.beanlc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.beanlc.bean.prog.Robot;

/**
 * @author bpawar
 *
 */
public class BeanLifecycleApplication {

	public static void main(String[] args) {
		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));

		// Robot robot = container.getBean(Robot.class);

		Robot robot = container.getBean(Robot.class);
		((ConfigurableListableBeanFactory) container).destroySingletons();

	}
}
