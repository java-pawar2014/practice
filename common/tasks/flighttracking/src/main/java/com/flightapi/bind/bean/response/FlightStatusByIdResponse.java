package com.flightapi.bind.bean.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.web.bind.annotation.ResponseBody;

import com.flightapi.bind.bean.Appendices;
import com.flightapi.bind.bean.FlightStatusV2;
import com.flightapi.bind.bean.RequestFlightStatusById;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response", propOrder = { "appendix", "flightStatus", "request" })
@Setter
@Getter
@ToString
@ResponseBody
@NoArgsConstructor
@AllArgsConstructor
public class FlightStatusByIdResponse {

	private Appendices appendix;
	private FlightStatusV2 flightStatus;
	private RequestFlightStatusById request;

}
