package com.springannotation.stereotype.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.springannotation.stereotype.bean.Engine;

/**
 * @author bpawar
 *
 */
@Component
public class EngineBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		if (bean instanceof Engine) {
			Engine engine = (Engine) bean;

			engine.setEngineSerial("ENG558455");
			engine.setEngineType("PETROL");
			return engine;
		}
		return bean;
	}
}