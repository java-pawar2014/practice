package org.restful.converter.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.restful.converter.bean.FlightBean;

@Path(value = "/flight")
public class FlightStatus {

	public FlightStatus() {
	}

	@GET
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/status")
	public FlightBean getStatusByFlightCode(@QueryParam("flightBean") FlightBean flightBean) {

		if (flightBean != null) {
			flightBean.setStatus("Flight has been take off and will land on time");
		} else {
			flightBean = new FlightBean();
			flightBean.setStatus("No flight found.");
		}
		return flightBean;
	}

	@GET
	@Path("/name/{flightId}")
	public String getFlightName(@PathParam("flightId") String flightId) {
		return new StringBuilder().append("Flight NAME").append(flightId.toUpperCase()).toString();
	}
}
