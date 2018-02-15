package com.springcore.instancefm;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.instancefm.bean.GoogleMapRenderer;

/**
 * @author bpawar
 *
 */
@SuppressWarnings("deprecation")
public class InstanceFactoryMethodApplication {

	public static void main(String[] args) {

		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));

		GoogleMapRenderer googleMapRenderer = container.getBean(GoogleMapRenderer.class);

		googleMapRenderer.render("hadapsar", "swargate");
	}
}