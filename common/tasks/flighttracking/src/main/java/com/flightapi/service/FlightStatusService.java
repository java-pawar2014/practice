package com.flightapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightapi.bind.bean.request.FlightByDayRequest;
import com.flightapi.bind.bean.response.FlightStatusByIdResponse;
import com.flightapi.bind.bean.response.FlightStatusesByDayResponse;

/**
 * @author bpawar
 *
 */
@Service
public interface FlightStatusService {

	/**
	 * <p>
	 * <b>Returns the Flight Status associated with provided Flight ID. The Flight
	 * ID is an arbitrary number that FlightStats uses to uniquely identify
	 * flights.</b><br>
	 * Searches for the flight. Takes flight number as template parameter and
	 * application number, application key as query parameters for searching the
	 * current status of flight.<br>
	 * </p>
	 * 
	 * @param flightId
	 *            an arbitrary number that FlightStats uses to uniquely identify the
	 *            flight
	 * @param extendedOptions
	 * 
	 * @param url
	 *            a HTTP URL for querying the flight status for flight Id
	 * 
	 * @return a {@link ResponseEntity} instance which holds
	 *         {@link FlightStatusByIdResponse} as body
	 */
	ResponseEntity<FlightStatusByIdResponse> getFlightStatusById(String flightId, String extendedOptions, String url);

	/**
	 * <p>
	 * <b>Returns the Flight Statuses for the given Carrier and Flight Number that
	 * departed on the given date. Optionally, the arrival airport may be specified.
	 * <br>
	 * OR<br>
	 * Returns the Flight Statuses for the given Carrier and Flight Number that
	 * departed on the given date. Optionally, the departure airport may be
	 * specified. </b><br>
	 * Searches for the flight(s) <b>arriving or departing</b> on given date. Takes
	 * parameters carrier (Airline company code like American Airline-AA, Air
	 * India-AI), flightNumber, year, month, day as mandatory parameters and other
	 * parameters like utc, airport, codeType, extendedOptions as optional
	 * parameters.<br>
	 * It looks for the flight(s) by querying it based on given day and flight.<br>
	 * 
	 * @param params
	 *            an instance of {@link FlightByDayRequest}
	 * @param url
	 *            a HTTP URL for querying the flight status for the day
	 * 
	 * @return a {@link ResponseEntity} instance which holds
	 *         {@link FlightStatusesByDayResponse} as body
	 */
	ResponseEntity<FlightStatusesByDayResponse> getFlightStatuseByDay(FlightByDayRequest params, String url);
}
