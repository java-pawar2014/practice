package org.restful.injection.util;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

public class URIExtractor {
	
	public String extractMap(MultivaluedMap<String, String> map) {
		
		StringBuffer buffer = new StringBuffer();
		for (String paramName : map.keySet()) {
			buffer.append(paramName).append(" = ");
			List<String> values = map.get(paramName);
			for (String value : values) {
				buffer.append(value).append(", ");
			}
		}
		return buffer.toString();
	}

}
