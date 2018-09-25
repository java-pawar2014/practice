package com.agsft.springaudit.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.agsft.springaudit.data.entity.UserEntity;
import com.agsft.springaudit.exception.ConversionException;
import com.agsft.springaudit.web.model.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PojoObjectMapper {

	private ObjectMapper mapper;

	public PojoObjectMapper() {
		this.mapper = new ObjectMapper();
	}

	public <T, E> List<T> convertValues(Iterable<E> convertibles, Class<T> type) throws ConversionException {
		List<T> convertedValues = new ArrayList<T>();
		for (E convertible : convertibles) {
			try {
				convertedValues.add(mapper.convertValue(convertible, type));
			} catch (Exception cause) {
				cause.printStackTrace();
				throw new ConversionException("Failed to convert " + convertible.getClass().getName() + " to " + type);
			}
		}
		return convertedValues;
	}

	public <T, E> T convertValue(E convertible, Class<T> type) throws ConversionException {
		try {
			return mapper.convertValue(convertible, type);
		} catch (Exception cause) {
			throw new ConversionException("Failed to convert " + convertible.getClass().getName() + " to " + type);
		}
	}

	public <T, E> T updateValue(E fromObject, Class<T> toClass) throws ConversionException {
		try {

			return null;
		} catch (Exception cause) {
			throw new ConversionException("Failed to convert " + fromObject.getClass().getName() + " to " + toClass);
		}
	}

	public static void main(String[] args) {
		UserEntity masterClassObject = new UserEntity();
		masterClassObject.setFirstName("Chetan");
		masterClassObject.setLastName("Kale");
		UserDTO slaveClassObject = new UserDTO();

		Class<?> masterClass = masterClassObject.getClass();
		Class<?> slaveClass = slaveClassObject.getClass();

		for (Field masterField : slaveClass.getDeclaredFields()) {
			masterField.setAccessible(true);
			Object value = null;
			String fieldName = masterField.getName();
			try {
				Field getValueField = masterClass.getDeclaredField(fieldName);
				getValueField.setAccessible(true);
				value = getValueField.get(masterClassObject);
				try {
					Field setValuefield = slaveClass.getDeclaredField(fieldName);
					setValuefield.setAccessible(true);
					Class<?> getValueFieldType = getValueField.getType();
					if (getValueFieldType.isPrimitive()) {
						
					} else {
						if (Class.forName(getValueField.getType().getName())
								.isAssignableFrom(Class.forName(setValuefield.getType().getName()))) {
							System.out.println(getValueField.getType().getName() + " is assignable to "
									+ setValuefield.getType().getName());
							setValuefield.set(slaveClassObject, value);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
			}
		}
		System.out.println(slaveClassObject);
	}
}
