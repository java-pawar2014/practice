package org.restful.contenthandler.writer;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;

@Provider
@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_OCTET_STREAM })
public class JAXBUniversalMarshaller implements MessageBodyWriter<Class<?>> {

	@Context
	private JAXBContext context;

	public JAXBUniversalMarshaller() {
	}

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		System.out.println("JAXBUniversalMarshaller.isWriteable");
		return type.isAnnotationPresent(XmlRootElement.class);
	}

	@Override
	public long getSize(Class<?> t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		System.out.println("JAXBUniversalMarshaller.getSize");
		return 0;
	}

	@Override
	public void writeTo(Class<?> target, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		// JAXBContext context = null;
		Marshaller marshaller = null;
		System.out.println("JAXBUniversalMarshaller.writeTo");

		try {
			// context = JAXBContext.newInstance(type);

			marshaller = context.createMarshaller();
			marshaller.marshal(target, entityStream);

			entityStream.flush();

		} catch (JAXBException cause) {
			throw new WebApplicationException(cause);
		}
	}
}
