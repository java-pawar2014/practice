package com.flightapi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightapi.bind.bean.request.FlightByDayRequest;
import com.flightapi.bind.bean.response.FlightStatusByIdResponse;
import com.flightapi.bind.bean.response.FlightStatusesByDayResponse;
import com.flightapi.service.FlightStatusService;

import lombok.NoArgsConstructor;

/**
 * <p>
 * The controller give you access to <b>current flight information</b>,
 * including scheduled, estimated and actual departure/arrival times, equipment
 * type, delay calculations, terminal, gate and baggage carousel.<br>
 * Current flight information is made available for flights for roughly three
 * days in advance of departure until roughly seven days after arrival.
 * </p>
 * 
 * @author bpawar
 *
 */
@RestController
@NoArgsConstructor
public class FlightStatusController {

	/**
	 * All URLs for finding flight status, make it configurable if required.
	 */
	private final String URL_APPLICATION = "https://api.flightstats.com/flex/flightstatus/rest/v2";
	private final String URL_FLIGHT_STATUS_BY_ID_XML = "/xml/flight/status/{flightId}?appId={appId}&appKey={appKey}&extendedOptions={extendedOptions}";
	private final String URL_FLIGHT_STATUS_ARR_BY_DAY_XML = "/xml/flight/status/{carrier}/{flight}/arr/{year}/{month}/{day}?appId={appId}&appKey={appKey}&utc={utc}&airport={airport}&codeType={codeType}&extendedOptions={extendedOptions}";
	private final String URL_FLIGHT_STATUS_DEP_BY_DAY_XML = "/xml/flight/status/{carrier}/{flight}/dep/{year}/{month}/{day}?appId={appId}&appKey={appKey}&utc={utc}&airport={airport}&codeType={codeType}&extendedOptions={extendedOptions}";

	@Autowired
	private FlightStatusService flightStatusService;

	/**
	 * <p>
	 * <b>Returns the Flight Status associated with provided Flight ID. The Flight
	 * ID is an arbitrary number that FlightStats uses to uniquely identify
	 * flights.</b><br>
	 * Searches for the flight. Takes flight number as template parameter and
	 * application number, application key as query parameters for searching the
	 * current status of flight.<br>
	 * <b>NOTE: <i>flightId</i> is template parameter (mandatory).</b><br>
	 * Returns the status details of the flight if found, else returns null.
	 * </p>
	 * <b>URL Info:</b><br>
	 * <ol>
	 * <li>Template Parameter: flightId</li>
	 * <li>Query Parameter: extendedOptions</li>
	 * </ol>
	 * 
	 * @param flightId
	 *            flight number given by Flight Stats API
	 * @param applicationId
	 *            approved application number
	 * @param accessKey
	 *            key for accessing the resource
	 * @return current status of flight for flight number if found else null
	 */
	@GetMapping(path = "/flight/status/{flightId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE,
			MediaType.APPLICATION_PDF_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_XHTML_XML_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	public ResponseEntity<FlightStatusByIdResponse> getFlightStatusById(@PathVariable("flightId") String flightId,
			@RequestParam(name = "extendedOptions", required = false) String extendedOptions) {

		return flightStatusService.getFlightStatusById(flightId, extendedOptions,
				URL_APPLICATION.concat(URL_FLIGHT_STATUS_BY_ID_XML));
	}

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
	 * </p>
	 * <b>URL Info:</b><br>
	 * <ol>
	 * <li>Template Parameters: carrier, flightNumber, year, month, day</li>
	 * <li>Query Parameters: utc, airport, codeType, extendedOptions</li>
	 * </ol>
	 * 
	 * @param carrier
	 *            mandatory - Airline company code like American Airline-AA, Air
	 *            India-AI
	 * @param flightNumber
	 *            mandatory - Flight number given by airline
	 * @param year
	 *            mandatory - Year of the day (YYYY)
	 * @param month
	 *            mandatory - Month of the day (MM)
	 * @param day
	 *            mandatory - Arrival day (DD)
	 * @param utc
	 *            optional - boolean for utc, if true the above day will be treated
	 *            as per UTC time zone
	 * @param airport
	 *            optional - Airport code for which flight is arriving.
	 * @param codeType
	 *            optional - Code of organization under which flight is registered
	 *            like 'IATA', 'ICAO', or 'FS'.
	 * @param extendedOptions
	 *            optional - Extended options for modifying standard API behavior to
	 *            fit special use cases.Options: 'useInlinedReferences',
	 *            'useHttpErrors', 'includeDeltas'.
	 * @return Statuses of the flight for requested day
	 */
	@GetMapping(path = { "/flight/status/arr/day/{carrier}/{flightNumber}/{year}/{month}/{day}",
			"/flight/status/dep/day/{carrier}/{flightNumber}/{year}/{month}/{day}" }, produces = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE,
					MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_PDF_VALUE,
					MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_XHTML_XML_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE })
	public ResponseEntity<FlightStatusesByDayResponse> getFlightStatusesByDay(
			@PathVariable(name = "carrier") String carrier, @PathVariable(name = "flightNumber") String flightNumber,
			@PathVariable(name = "year") int year, @PathVariable(name = "month") int month,
			@PathVariable(name = "day") int day, @RequestParam(name = "utc", defaultValue = "false") boolean utc,
			@RequestParam(name = "airport", required = false) String airport,
			@RequestParam(name = "codeType", required = false) String codeType,
			@RequestParam(name = "extendedOptions", required = false) String extendedOptions,
			HttpServletRequest request) {

		FlightByDayRequest params = null;

		params = new FlightByDayRequest(carrier, flightNumber, year, month, day, utc, airport, codeType,
				extendedOptions);

		if (request.getRequestURI().contains("arr"))
			return flightStatusService.getFlightStatuseByDay(params,
					URL_APPLICATION.concat(URL_FLIGHT_STATUS_ARR_BY_DAY_XML));
		else if (request.getRequestURI().contains("dep"))
			return flightStatusService.getFlightStatuseByDay(params,
					URL_APPLICATION.concat(URL_FLIGHT_STATUS_DEP_BY_DAY_XML));
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * <p>
	 * Searches for the flight(s) <b>arriving or departing</b> on given date. The
	 * parameter <i>params</i> is of {@link FlightByDayRequest} binded by the
	 * request body mapper by taking parameters from request body. The parameters
	 * can be defined in either JSON or XML format.<br>
	 * Parameters have to send in request body must have names as:<br>
	 * <ul>
	 * <li>carrier</li>
	 * <li>flightNumber</li>
	 * <li>year</li>
	 * <li>month</li>
	 * <li>day</li>
	 * <li>utc</li>
	 * <li>airport</li>
	 * <li>codeType</li>
	 * <li>extendedOptions
	 * </ul>
	 * </p>
	 * 
	 * @see FlightByDayRequest
	 * @see #getFlightStatusesByDay(String, String, int, int, int, boolean, String,
	 *      String, String)
	 * @param params
	 *            instance of {@link FlightByDayRequest} by binding request
	 *            parameters
	 * @param request
	 *            a {@link HttpServletRequest} instance
	 * 
	 * @return Statuses of the flight for requested day
	 */
	@PostMapping(path = { "/flight/status/arr/day", "/flight/status/dep/day" }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE,
					MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_PDF_VALUE,
					MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_XHTML_XML_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE })
	public ResponseEntity<FlightStatusesByDayResponse> getFlightStatusesByDay(@RequestBody FlightByDayRequest params,
			HttpServletRequest request) {

		if (request.getRequestURI().contains("arr"))
			return flightStatusService.getFlightStatuseByDay(params,
					URL_APPLICATION.concat(URL_FLIGHT_STATUS_ARR_BY_DAY_XML));
		else if (request.getRequestURI().contains("dep"))
			return flightStatusService.getFlightStatuseByDay(params,
					URL_APPLICATION.concat(URL_FLIGHT_STATUS_DEP_BY_DAY_XML));
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}