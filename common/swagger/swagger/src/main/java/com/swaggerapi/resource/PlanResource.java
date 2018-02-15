package com.swaggerapi.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Path(value = "/plan")
@Api
public class PlanResource {

	@Path(value = "/information/{planNumber}")
	@GET
	@Produces(value = MediaType.TEXT_PLAIN)
	@ApiOperation(value = "/information", notes = "Information of plan for given plan number", response = String.class)
	public Response getPlanInfo(@ApiParam(required = true) @PathParam(value = "planNumber") String planNumber) {

		Response response = null;

		try {
			response = Response
					.ok(Integer.parseInt(planNumber) + "\tPersonal Accident Insurance Policy" + "\t5000" + "\t12")
					.build();
		} catch (WebApplicationException cause) {
			response = Response.status(Status.BAD_REQUEST).build();
		}
		return response;
	}
}
