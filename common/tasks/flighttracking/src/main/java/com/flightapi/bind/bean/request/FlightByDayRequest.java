package com.flightapi.bind.bean.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement(name = "flightbyday")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flightbyday", propOrder = { "carrier", "flightNumber", "year", "month", "day", "utc", "airport",
		"codeType", "extendedOptions" })
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightByDayRequest implements Serializable {

	private static final long serialVersionUID = 5079697460269817115L;

	@NotNull
	private String carrier;
	@NotNull
	private String flightNumber;
	@NotNull
	private int year;
	@NotNull
	private int month;
	@NotNull
	private int day;
	private boolean utc;
	private String airport;
	private String codeType;
	private String extendedOptions;
}
