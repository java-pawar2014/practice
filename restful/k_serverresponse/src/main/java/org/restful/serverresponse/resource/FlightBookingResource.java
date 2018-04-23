package org.restful.serverresponse.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.restful.serverresponse.bean.FlightBookBean;

@Path(value = "/flight/book")
public class FlightBookingResource {

	public FlightBookingResource() {
	}

	@POST
	@Consumes(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path(value = "/domestic")
	public Response bookFlight(FlightBookBean bookingBean) {
		Response response = null;

		if (bookingBean != null) {
			double amount = 1254 * bookingBean.getPassengerCount();
			bookingBean.setFareAmount(amount <= 0 ? 1254 : amount);
			bookingBean.setBooked(true);

			response = Response.ok(bookingBean).build();
		} else {
			response = Response.accepted(bookingBean).build();
		}
		return response;
	}
}
