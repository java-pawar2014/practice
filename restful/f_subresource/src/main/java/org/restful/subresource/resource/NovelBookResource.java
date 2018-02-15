package org.restful.subresource.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public class NovelBookResource {

	@GET
	@Path(value = "/name/{isbn}")
	public String getBookName(@PathParam("isbn") String bookIsbn) {
		return new StringBuilder().append("book ").append(bookIsbn).append(" name novel").toString().toUpperCase();
	}
}
