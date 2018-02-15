package org.restful.httpmethods.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/product")
public class ProductResource {

	@GET
	@Consumes(value = { MediaType.TEXT_PLAIN })
	@Produces(value = { MediaType.TEXT_PLAIN })
	public String getProduct(@QueryParam("productId") String productId) {
		System.out.println("GET invoked...");
		return "PRODUCT" + productId;
	}

	@POST
	@Consumes(value = { MediaType.TEXT_PLAIN })
	@Produces(value = { MediaType.TEXT_PLAIN })
	public String saveProduct(@QueryParam("productName") String productName, @QueryParam("qauntity") int quantity) {
		System.out.println("POST invoked...");
		return "PRODUCT 1524 " + productName + " - " + quantity + " Nos saved.";
	}

	@PUT
	@Consumes(value = { MediaType.TEXT_PLAIN })
	@Produces(value = { MediaType.TEXT_PLAIN })
	public String updateProduct(@QueryParam("productName") String productName, @QueryParam("qauntity") int quantity) {
		System.out.println("PUT invoked...");
		return "PRODUCT 1524 " + productName + " - " + quantity + " Nos updated.";
	}

	@DELETE
	@Consumes(value = { MediaType.TEXT_PLAIN })
	@Produces(value = { MediaType.TEXT_PLAIN })
	public String deleteProduct(@QueryParam("productId") String productId) {
		System.out.println("DELETE invoked...");
		return "PRODUCT 1524 " + productId + " deleted.";
	}

}
