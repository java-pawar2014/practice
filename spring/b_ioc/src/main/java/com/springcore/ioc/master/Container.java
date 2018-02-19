package com.springcore.ioc.master;

import java.lang.reflect.Field;
import java.security.KeyStore.Entry.Attribute;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.springcore.ioc.bean.factory.ObjectFactory;
import com.springcore.ioc.source.loader.MetadataLoader;

public class Container {

	private static Container container;
	private static Map<String, Object> objectMetadata;

	public Container() {
		objectMetadata = new ConcurrentHashMap<String, Object>();
	}

	public static Container loadContainer(String metadataFile) {
		System.out.println("Starting container...");
		if (container == null) {
			synchronized (Container.class) {
				if (container == null) {
					container = new Container();
				}
			}
		}
		System.out.println("Container initialized.");
		instantiate(metadataFile);
		return container;
	}

	public Map<String, Object> getObjectMetadata() {
		return objectMetadata;
	}

	@SuppressWarnings("unchecked")
	private static void instantiate(String metadataFile) {
		MetadataLoader metadataLoader = null;

		System.out.println("Loading class files metadata...");
		metadataLoader = MetadataLoader.getMetadataLoader();
		metadataLoader.load(metadataFile);

		Enumeration<String> classKeys = (Enumeration<String>) metadataLoader.getClassMetadata().propertyNames();
		System.out.println("Creating and instantiating class objects from metadata...");
		while (classKeys.hasMoreElements()) {
			String classKey = classKeys.nextElement();
			String className = metadataLoader.getClassMetadata().getProperty(classKey);
			Object targetObject = ObjectFactory.createObject(className);
			objectMetadata.put(classKey, targetObject);
		}
		/*
		 * System.out.println("Setting up dependents..."); Collection<Object>
		 * objects = objectMetadata.values(); for (Object object : objects) {
		 * Class<?> objectClass = object.getClass(); Field[]
		 * attributesOfObjectClass = objectClass.getDeclaredFields(); for (Field
		 * attributeOfObjectClass : attributesOfObjectClass) { Class<?>
		 * attributeOfClass = attributeOfObjectClass.getClass(); for (Object
		 * object1 : objects) { if
		 * (attributeOfClass.isAssignableFrom(object1.getClass())) { try {
		 * attributeOfObjectClass.set(object, object1); } catch
		 * (IllegalArgumentException e) { e.printStackTrace(); } catch
		 * (IllegalAccessException e) { e.printStackTrace(); } } } } }
		 */
	}
}
