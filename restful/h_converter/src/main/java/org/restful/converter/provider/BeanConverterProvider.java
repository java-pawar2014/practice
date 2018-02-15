package org.restful.converter.provider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import org.restful.converter.bean.FlightBean;
import org.restful.converter.convert.FlightBeanConverter;

@Provider
public class BeanConverterProvider implements ParamConverterProvider {

	public BeanConverterProvider() {

	}

	@Override
	public ParamConverter getConverter(Class rawType, Type genericType, Annotation[] annotations) {
		ParamConverter paramConverter = null;

		if (rawType.isAssignableFrom(FlightBean.class)) {

			paramConverter = new FlightBeanConverter();
		}

		return paramConverter;
	}

}
