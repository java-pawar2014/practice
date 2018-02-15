package org.restful.converter.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.restful.converter.bean.FlightBean;

@Path(value = "/flight")
public class FlightStatus {

	public FlightStatus() {
	}

	@POST
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/status")
	private FlightBean getStatusByFlightCode(@Context FlightBean flightBean) {
		if (flightBean != null) {
			flightBean.setStatus("Flight has been take off and will land on time");
		}
		return flightBean;
	}
}
