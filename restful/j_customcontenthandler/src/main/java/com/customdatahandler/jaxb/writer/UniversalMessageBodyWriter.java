package com.customdatahandler.jaxb.writer;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.customdatahandler.annotation.KeyValuePair;

@Provider
@Produces(value = { MediaType.TEXT_PLAIN, MediaType.APPLICATION_OCTET_STREAM })
public class UniversalMessageBodyWriter implements MessageBodyWriter<Object> {

	@Override
	public long getSize(Object object, Class<?> clazz, Type classType, Annotation[] annotations, MediaType mediaType) {
		return 0;
	}

	@Override
	public boolean isWriteable(Class<?> clazz, Type classType, Annotation[] annotations, MediaType mediaType) {
		if (clazz.isAnnotationPresent(KeyValuePair.class)) {
			return true;
		}
		return false;
	}

	@Override
	public void writeTo(Object object, Class<?> clazz, Type classType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> responseHeaders, OutputStream outputStream)
			throws IOException, WebApplicationException {
		String rawResponse = null;
		System.out.println("UniversalMessageBodyWriter.writeTo");
		rawResponse = generateRawData(object, clazz);
		outputStream.write(rawResponse.getBytes());
		outputStream.close();
	}

	private String generateRawData(Object object, Class<?> clazz) {
		Field[] attributes = null;
		StringBuffer buffer = null;
		String attributeName = null;

		boolean flag = true;

		try {
			buffer = new StringBuffer();
			attributes = clazz.getDeclaredFields();
			for (Field attribute : attributes) {
				attributeName = attribute.getName();
				Method method = getMethod(attributeName, clazz);

				String value = method.invoke(object).toString();
				if (flag == true) {
					buffer.append(attributeName).append("=").append(value);
					flag = false;
				} else {
					buffer.append(";").append(attributeName).append("=").append(value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	private Method getMethod(String name, Class<?> clazz) {
		Method[] methods = null;
		Method methodReturn = null;
		methods = clazz.getDeclaredMethods();

		char firstChar = name.charAt(0);
		String firstString = new String(new char[] { firstChar }).toUpperCase();
		firstChar = firstString.charAt(0);
		name = name.replace(name.charAt(0), firstChar);
		String methodName = new StringBuilder("get").append(name).toString();
		for (Method method : methods) {
			if (method.getName().startsWith(methodName)) {
				methodReturn = method;
				break;
			}
		}
		return methodReturn;
	}
}
