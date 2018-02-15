package org.restful.contenthandler.resolver;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.restful.contenthandler.bean.CustomerAddressBean;
import org.restful.contenthandler.bean.CustomerBean;
/*
@Provider
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class CustomerResolver implements ContextResolver<JAXBContext> {

	private JAXBContext context;

	public CustomerResolver() throws JAXBException {

		this.context = JAXBContext.newInstance(CustomerBean.class, CustomerAddressBean.class);
	}

	public JAXBContext getContext(Class<?> type) {
		if (type.equals(CustomerBean.class)) {
			return context;
		} else {
			return null;
		}
	}
}
*/