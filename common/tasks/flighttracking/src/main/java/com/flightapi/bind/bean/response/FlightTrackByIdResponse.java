package com.flightapi.bind.bean.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.web.bind.annotation.ResponseBody;

import com.flightapi.bind.bean.Appendices;
import com.flightapi.bind.bean.FlightTrackV2;
import com.flightapi.bind.bean.RequestFlightTrackById;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="response",propOrder = { "request", "appendix", "flightTrack" })
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ResponseBody
public class FlightTrackByIdResponse {

	private RequestFlightTrackById request;
	private Appendices appendix;
	private FlightTrackV2 flightTrack;

}
