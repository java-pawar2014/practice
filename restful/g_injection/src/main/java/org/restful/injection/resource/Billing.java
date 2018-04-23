package org.restful.injection.resource;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * The resources handles the query params. The query params are optional and
 * order is not preserved.
 * 
 * @author bpawar
 *
 */
@Path(value = "/billing")
public class Billing {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/individual")
	public Response getBill(@QueryParam("billNo") int billNo, @QueryParam("customerId") String customerId) {
		Response response = null;

		response = Response.ok("[ Customer : " + customerId + " Bill No : " + billNo + " ]", MediaType.TEXT_PLAIN_TYPE)
				.build();
		return response;
	}
}
