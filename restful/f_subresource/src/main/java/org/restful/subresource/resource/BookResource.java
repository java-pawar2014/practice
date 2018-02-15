package org.restful.subresource.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path(value = "/book")
public class BookResource {

	@GET
	@Path(value = "/name/{isbn}")
	public String getBookName(@PathParam("isbn") String bookIsbn) {
		return new StringBuilder().append("book ").append(bookIsbn).append(" name rest reference").toString()
				.toUpperCase();
	}

	@Path(value = "/novel")
	public NovelBookResource getNovelBook() {

		return new NovelBookResource();
	}

}
