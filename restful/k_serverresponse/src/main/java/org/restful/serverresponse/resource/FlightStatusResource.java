package org.restful.serverresponse.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.restful.serverresponse.bean.FlightStatusBean;

@Path(value = "/flight/status")
public class FlightStatusResource {

	public FlightStatusResource() {

	}

	@GET
	@Path(value = "/{flightId}")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getFlightStatusById(@PathParam("flightId") long flightId) {
		Response response = null;
		FlightStatusBean statusBean = null;

		if (flightId <= 0) {
			response = Response.status(Status.BAD_REQUEST.getStatusCode(),
					"Flight ID " + flightId + " must be greater than 0 (zero).").build();
		} else {
			statusBean = createFlightStatus(flightId);
			if (statusBean != null) {
				response = Response.ok(statusBean).build();
			} else {
				response = Response
						.status(Status.NOT_FOUND.getStatusCode(), "Flight for ID " + flightId + " is not found.")
						.build();
			}

		}

		return response;
	}

	private FlightStatusBean createFlightStatus(long flightId) {
		FlightStatusBean statusBean = null;

		statusBean = new FlightStatusBean();
		statusBean.setFlightId(flightId);
		statusBean.setFlyingId(flightId + flightId + "");
		statusBean.setFlightName("AI" + flightId);
		statusBean.setSource("SOURCE" + flightId);
		statusBean.setDestination("DESTN" + flightId);
		return statusBean;
	}

}
