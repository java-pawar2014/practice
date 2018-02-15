package org.restful.jsonbinder.bind;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author bpawar
 *
 */
public class JsonDataMarshaller {

	private ObjectMapper objectMapper;

	public JsonDataMarshaller() {
		objectMapper = new ObjectMapper();
	}

	/**
	 * Converts the json data from the given JSON string to respective class.
	 * 
	 * @param jsonData
	 * @param clazz
	 * @return a Java object with converted data into
	 * @throws Throwable
	 */
	public Object marshalData(String jsonData, Class<?> clazz) throws Throwable {
		Object object = null;

		object = objectMapper.readValue(jsonData, clazz);
		if (object == null)
			throw new Throwable("Failed to parse the json data.");

		return object;
	}
}
