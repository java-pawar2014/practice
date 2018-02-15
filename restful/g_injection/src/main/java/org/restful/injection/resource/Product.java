package org.restful.injection.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * The resource talks about the form params and header params, the form
 * paramaters and header parameters are optional.
 * 
 * @author bpawar
 *
 */
@Path("/product")
public class Product {

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/add")
	public String newProduct(@FormParam("name") String name, @FormParam("weight") int weight,
			@FormParam("price") float price) {
		return "Product Name: " + name + "\nWeight: " + weight + "\nPrice: " + price;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/find")
	public String findProduct(@HeaderParam("name") String name, @HeaderParam("price") float price) {
		return "Product name: " + name + " Price: " + price;
	}
}