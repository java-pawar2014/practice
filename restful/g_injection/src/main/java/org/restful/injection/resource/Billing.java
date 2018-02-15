package org.restful.injection.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
	public String getBill(@QueryParam("billNo") int billNo, @QueryParam("customerId") String customerId) {
		return "[ Customer : " + customerId + " Bill No : " + billNo + " ]";
	}
}
