package com.flightapi.bind.bean.request;

import java.io.Serializable;

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

@XmlRootElement(name = "flightTrackRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flightTrackRequest", propOrder = {})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightTrackRequest implements Serializable {

	private static final long serialVersionUID = 1451803153352656366L;

	// Carrier (airline) code
	private String carrier;
	// Flight number
	private int flight;
	// Four-digit year
	private int year;
	// Month (1 to 12)
	private int month;
	// Day of month
	private int day;
	// Arrival hour of day (0-23)
	private int hourOfDay;
	// Time given as UTC instead of local (default is false)
	private boolean utc;
	// Number of hours' worth of arrivals to include (up to 24)
	private int numHours;
	// Include flight plan (default false)
	private boolean includeFlightPlan;
	// Arrival airport code
	private String airport;
	// Maximum number of positions in track
	private int maxPositions;
	// Maximum age for positions in track (minutes)
	private long maxPositionAgeMinutes;
	// Positional Source Type
	private String sourceType;
	// Type of any given codes: 'IATA', 'ICAO', or 'FS'. If not specified, all
	// domains will be searched in the order stated.
	private String codeType;
	// Extended options for modifying standard API behavior to fit special use
	// cases. Options: 'useInlinedReferences', 'useHttpErrors'.
	private String extendedOptions;

}
