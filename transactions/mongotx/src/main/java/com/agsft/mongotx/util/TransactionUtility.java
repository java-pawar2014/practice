package com.agsft.mongotx.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.agsft.mongotx.web.exception.ConversionException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TransactionUtility {

	private ObjectMapper mapper;
	
	public TransactionUtility() {
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
}
