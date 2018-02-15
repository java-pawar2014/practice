package org.restful.bootstrap.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path(value = "/book")
public class BookResource {

	@Path("/info")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String getBookName(@QueryParam("bookId") long bookId) {

		return "INFOPUBL" + bookId;
	}
}
