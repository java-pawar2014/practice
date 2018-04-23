package org.restful.serverresponse.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.restful.serverresponse.bean.FlightStatusBean;

@Path(value = "/flight/status")
public class FlightStatusResource {

	public FlightStatusResource() {

	}

	@GET
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(value = "/head")
	public Response getFirstTenAccounts() {
		Response response = null;
		List<FlightStatusBean> headFlights;
		Response.ResponseBuilder responseBuilder = null;
		
		
		responseBuilder = Response.ok();
		responseBuilder.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML);
		
		headFlights = new ArrayList<FlightStatusBean>();
		for (int x = 0; x < 10; x++) {
			FlightStatusBean statusBean = new FlightStatusBean();
			statusBean.setFlightId(2251 + x + 1);
			statusBean.setFlightName("AI" + (2251 + x + 1));
			statusBean.setFlyingId("AI" + (2251 + x + 1));
			statusBean.setDestination("DESTN" + (x + 1));
			statusBean.setSource("SRC" + (x + 1));
			headFlights.add(statusBean);
		}
		if (headFlights.isEmpty()) {
			response = Response.status(Status.NO_CONTENT).build();
		} else {
			// response = Response.status(Status.OK).entity(headFlights).build();
			// response = Response.ok(headFlights).build();
			
			responseBuilder.entity(headFlights);
			response = responseBuilder.build();
		}
		return response;
	}

	@GET
	@Path(value = "/{flightId}")
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getFlightStatusById(@PathParam("flightId") long flightId) {
		Response response = null;
		FlightStatusBean statusBean = null;

		if (flightId <= 0) {
			response = Response.status(Status.BAD_REQUEST.getStatusCode(),
					"Flight ID " + flightId + " must be greater than 0 (zero).").build();
		} else {
			statusBean = createFlightStatus(flightId);
			if (statusBean != null) {
				response = Response.accepted(statusBean).build();
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
