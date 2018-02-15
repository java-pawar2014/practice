package com.flightapi.bind.bean.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.flightapi.bind.bean.Appendices;
import com.flightapi.bind.bean.FlightStatusesResponse;
import com.flightapi.bind.bean.RequestFlightStatus;
import com.flightapi.bind.bean.FlightStatusesResponse.FlightStatuses;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response", propOrder = { "request", "appendix", "flightStatuses" })
public class FlightStatusesByDayResponse {

	private RequestFlightStatus request;
	private Appendices appendix;
	private FlightStatusesResponse.FlightStatuses flightStatuses;

	public FlightStatusesByDayResponse() {
	}

	public FlightStatusesByDayResponse(RequestFlightStatus request, Appendices appendix, FlightStatuses flightStatuses) {
		super();
		this.request = request;
		this.appendix = appendix;
		this.flightStatuses = flightStatuses;
	}

	public RequestFlightStatus getRequest() {
		return request;
	}

	public void setRequest(RequestFlightStatus request) {
		this.request = request;
	}

	public Appendices getAppendix() {
		return appendix;
	}

	public void setAppendix(Appendices appendix) {
		this.appendix = appendix;
	}

	public FlightStatusesResponse.FlightStatuses getFlightStatuses() {
		return flightStatuses;
	}

	public void setFlightStatuses(FlightStatusesResponse.FlightStatuses flightStatuses) {
		this.flightStatuses = flightStatuses;
	}

	@Override
	public String toString() {
		return "FlightStatusesByDayResponse [request=" + request + ", appendix=" + appendix + ", flightStatuses="
				+ flightStatuses + "]";
	}
}
