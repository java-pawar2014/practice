package com.flightapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightapi.bind.bean.request.FlightTrackRequest;
import com.flightapi.bind.bean.response.FlightTrackByIdResponse;
import com.flightapi.bind.bean.response.FlightTracksByDayResponse;

/**
 * @author bpawar
 *
 */
@Service
public interface FlightTrackService {

	/**
	 * <p>
	 * Returns the positional track for a specific flight, specified by flight ID.
	 * Flight plan may be optionally included. To narrow down to only the freshest
	 * data, you may optionally limit the age (in minutes) and/or number of
	 * positions returned.
	 * </p>
	 * 
	 * @param flightId
	 *            an arbitrary number that FlightStats uses to uniquely identify the
	 *            flight
	 * @param params
	 *            an instance of {@link FlightTrackRequest}
	 * 
	 * @param url
	 *            a HTTP URL for tracking the flight positions for flight ID
	 * 
	 * @return positional track for a specific flight, specified by flight ID.
	 */
	ResponseEntity<FlightTrackByIdResponse> trackFlightById(String flightId, FlightTrackRequest params, String url);

	/**
	 * <p>
	 * Returns the positional tracks of flights, with a given carrier and flight
	 * number, <b>arriving or having arrived</b> on the given date. If 'hourOfDay'
	 * is specified, results will be limited to the given hour, unless 'numHours' is
	 * also specified. Arrival airport may optionally be specified. Flight plans may
	 * be optionally included.<br>
	 * OR<br>
	 * Returns the positional tracks of flights, with a given carrier and flight
	 * number, <b>departing or having departed</b> on the given date. If 'hourOfDay'
	 * is specified, results will be limited to the given hour, unless 'numHours' is
	 * also specified. Departure airport may optionally be specified. Flight plans
	 * may be optionally included. <br>
	 * To narrow down to only the freshest data, you may optionally limit the age
	 * (in minutes) or number of positions per track.
	 * </p>
	 * 
	 * @param params
	 *            an instance of {@link FlightTrackRequest}
	 * @param url
	 *            a HTTP URL for tracking the flight positions for a day
	 * @return positional tracks of flight
	 */
	ResponseEntity<FlightTracksByDayResponse> flightTracksByDayResponse(FlightTrackRequest params, String url);
}
