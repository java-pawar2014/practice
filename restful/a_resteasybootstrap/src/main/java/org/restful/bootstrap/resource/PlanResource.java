package org.restful.bootstrap.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path(value = "/plan")
public class PlanResource {

	@Path("/info")
	@GET
	@Produces(value = { MediaType.TEXT_PLAIN })
	@Consumes(value = { MediaType.TEXT_PLAIN })
	public String getPlanInfo(@QueryParam("PlanId") long planId) {

		return "Plan " + planId;
	}
}