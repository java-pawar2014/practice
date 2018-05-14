package org.springboot.json.util;

import java.awt.Color;
import java.io.IOException;

import org.springboot.json.web.bean.UserDTO;
import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent
public class UserDTOJsonSerializer extends JsonSerializer<UserDTO> {

	private PrettyPrinter prettyPrinter;

	public UserDTOJsonSerializer() {
		this.prettyPrinter = new MinimalPrettyPrinter(" = ");
	}

	@Override
	public void serialize(UserDTO user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {
//		jsonGenerator.setPrettyPrinter(prettyPrinter);
		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("userId", getValue(Color.BLACK));
		jsonGenerator.writeStringField("firstName", getValue(Color.BLUE));
		jsonGenerator.writeStringField("lastName", getValue(Color.DARK_GRAY));
		jsonGenerator.writeStringField("contact", getValue(Color.YELLOW));
		jsonGenerator.writeStringField("email", getValue(Color.BLUE));
		jsonGenerator.writeEndObject();
		jsonGenerator.setRootValueSeparator(new SerializedString(" = "));
	}

	private static String getValue(Color color) {
		int r = (int) Math.round(color.getRed() * 255.0);
		int g = (int) Math.round(color.getGreen() * 255.0);
		int b = (int) Math.round(color.getBlue() * 255.0);
		return String.format("#%02x%02x%02x", r, g, b);
	}
}
