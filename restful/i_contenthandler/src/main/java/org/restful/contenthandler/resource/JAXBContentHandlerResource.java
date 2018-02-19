package org.restful.contenthandler.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.restful.contenthandler.bean.CustomerAddressBean;
import org.restful.contenthandler.bean.CustomerBean;

/**
 * JAXB is an older Java specification and is not defined by JAX-RS. JAXB is an
 * annotation framework that maps Java classes to XML and XML schema. It is
 * extremely useful because instead of interacting with an abstract
 * representation of an XML document, you can work with real Java objects that
 * are closer to the domain you are modeling.<br>
 * JAX-RS has built-in support for JAXB.<br>
 * The built-in JAXB handlers will handle any JAXB-annotated class for the
 * application/xml, text/xml, or application/*+xml media types.<br>
 * By default, they will also manage the creation and initialization of
 * JAXBContext instances. Because the creation of JAXBContext instances can be
 * expensive, JAX-RS implementations usually cache them after they are first
 * initialized.
 * 
 * @author bpawar
 *
 */
@Path("/jaxb")
public class JAXBContentHandlerResource {

	@GET
	@Produces(value = { MediaType.APPLICATION_XML, "application/octet-stream" })
	@Path("/customer/find/{id}")
	public CustomerBean getCustomer(@PathParam("id") int id) {
		System.out.println("JAXBContentHandlerResource.getCustomer");
		CustomerBean customer = findCustomer(id);
		return customer;
	}

	private CustomerBean findCustomer(int id) {
		CustomerBean customer = null;
		CustomerAddressBean address = null;
		List<String> goods = null;

		address = new CustomerAddressBean();
		address.setStreet("B201 West");
		address.setCity("Pune");
		address.setState("MH");
		address.setZip("414402");

		goods = new ArrayList<String>();
		goods.add("AE2342");
		goods.add("AE2343");
		goods.add("AE2344");
		goods.add("AE2345");
		goods.add("AE2346");

		customer = new CustomerBean();
		customer.setId(id);
		customer.setFullName("John");
		customer.setAddress(address);
		customer.setGoods(goods);

		return customer;
	}

	@POST
	@Consumes(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("/customer/save")
	public CustomerBean createCustomer(CustomerBean customer) {

		System.out.println("Customer saved...");
		System.out.println(customer);

		return customer;
	}
}
