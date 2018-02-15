package com.springcore.postprocessor;

import java.util.Date;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.springcore.postprocessor.bean.BaseVO;

public class BaseVOPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof BaseVO) {
			((BaseVO) bean).setLastModifiedDate(new Date());
		}
		return bean;
	}
}
