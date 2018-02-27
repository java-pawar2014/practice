package com.customdatahandler.jaxb.reader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import com.customdatahandler.annotation.KeyValuePair;

@Provider
@Consumes(MediaType.TEXT_PLAIN)
public class UniversalMessageBodyReader implements MessageBodyReader<Object> {

	private SimpleDateFormat dateFormat;

	public UniversalMessageBodyReader() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	}

	@Override
	public boolean isReadable(Class<?> clazz, Type classType, Annotation[] annotations, MediaType mediaType) {
		if (clazz.isAnnotationPresent(KeyValuePair.class)) {
			return true;
		}
		return false;
	}

	@Override
	public Object readFrom(Class<Object> clazz, Type classType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> requestHeaders, InputStream inputStream)
			throws IOException, WebApplicationException {
		System.out.println("Entered into UniversalMessageBodyReader.readFrom");

		Object object = null;
		String rawData = null;
		Map<String, String> attributesAndValues = null;

		rawData = extractData(inputStream);

		System.out.println(rawData);
		attributesAndValues = getKeyValues(rawData);
		try {
			object = bindMapToObject(clazz, attributesAndValues);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Exiting from UniversalMessageBodyReader.readFrom");
		return object;
	}

	private String extractData(InputStream inputStream) {
		StringBuffer buffer = null;
		int c = 0;
		try {
			buffer = new StringBuffer();
			while ((c = inputStream.read()) != -1) {
				buffer.append((char) c);
			}
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
		return buffer.toString();
	}

	private Map<String, String> getKeyValues(String rawData) {

		Map<String, String> keyValuedMap = null;

		keyValuedMap = new ConcurrentHashMap<String, String>();
		String[] keyValueTokens = rawData.split(";");
		for (String keyValue : keyValueTokens) {
			String[] keysAndValuePair = keyValue.split("=");
			if (keysAndValuePair.length == 2)
				keyValuedMap.put(keysAndValuePair[0], keysAndValuePair[1]);
		}
		return keyValuedMap;
	}

	private Object bindMapToObject(Class<?> clazz, Map<String, String> attributesAndValues) {

		Object object = null;
		Set<String> attributes = null;

		try {
			object = clazz.newInstance();
			attributes = attributesAndValues.keySet();
			for (String attribute : attributes) {
				String value = attributesAndValues.get(attribute);
				Method method = getMethod(attribute, clazz);
				if (method != null) {
					Class<?>[] argumentTypes = method.getParameterTypes();
					if (argumentTypes[0].isAssignableFrom(Date.class)) {
						method.invoke(object, dateFormat.parse(value));
					} else {
						method.invoke(object, value);
					}
				}
			}
		} catch (

		Exception e) {
			throw new WebApplicationException(e);
		}
		return object;
	}

	private Method getMethod(String name, Class<?> clazz) {
		Method[] methods = null;
		Method methodReturn = null;
		methods = clazz.getDeclaredMethods();

		char firstChar = name.charAt(0);
		String firstString = new String(new char[] { firstChar }).toUpperCase();
		firstChar = firstString.charAt(0);
		name = name.replace(name.charAt(0), firstChar);
		String methodName = new StringBuilder("set").append(name).toString();
		for (Method method : methods) {
			if (method.getName().startsWith(methodName)) {
				methodReturn = method;
				break;
			}
		}
		return methodReturn;
	}
}
