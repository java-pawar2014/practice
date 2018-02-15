package com.flightapi.bind.bean.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.flightapi.bind.bean.Appendices;
import com.flightapi.bind.bean.FlightTracksResponse;
import com.flightapi.bind.bean.RequestFlightTrack;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author bpawar
 *
 */
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response", propOrder = { "appendix", "flightTracks", "request" })
@NoArgsConstructor
@ToString
@Getter
@Setter
public class FlightTracksByDayResponse {

	private Appendices appendix;
	private FlightTracksResponse.FlightTracks flightTracks;
	private RequestFlightTrack request;

}
