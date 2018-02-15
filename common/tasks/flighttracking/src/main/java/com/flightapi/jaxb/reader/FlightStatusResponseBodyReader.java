package com.flightapi.jaxb.reader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;

import com.flightapi.bind.bean.ResponseImpl;
import com.flightapi.bind.bean.response.FlightStatusByIdResponse;

@Provider
@Consumes(MediaType.APPLICATION_XML)
public class FlightStatusResponseBodyReader implements MessageBodyReader<FlightStatusByIdResponse> {

	private Logger logger = Logger.getLogger(FlightStatusResponseBodyReader.class);

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {

		/*
		logger.debug("Checking readability of type : " + type.getDeclaringClass().getName());
		 if (type.isAnnotationPresent(XmlAccessorType.class)) {
			logger.debug("Target binding class is annotated with : " + EnableStatusBinding.class.getName());
			return true;
		}*/
		return true;
	}

	@Override
	public FlightStatusByIdResponse readFrom(Class<FlightStatusByIdResponse> type, Type genericType, Annotation[] annotations,
			MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		logger.debug("Unmarshalling the received data...");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ResponseImpl.class);
			FlightStatusByIdResponse response = (FlightStatusByIdResponse) jaxbContext.createUnmarshaller().unmarshal(entityStream);
			logger.debug("Unmarshalling of response is completed..!!");
			return response;
		} catch (JAXBException e) {
			logger.debug("Error in deserializing", e);
			throw new ProcessingException(e);
		}

	}
}
