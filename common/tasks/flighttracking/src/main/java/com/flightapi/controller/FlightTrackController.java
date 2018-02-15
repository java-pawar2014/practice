package com.flightapi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightapi.bind.bean.request.FlightByDayRequest;
import com.flightapi.bind.bean.request.FlightTrackRequest;
import com.flightapi.bind.bean.response.FlightTrackByIdResponse;
import com.flightapi.bind.bean.response.FlightTracksByDayResponse;
import com.flightapi.service.FlightTrackService;

import lombok.NoArgsConstructor;

/**
 * <p>
 * The controller give you access to information on an <b>active</b> flight,
 * including position (lat/long), altitude, bearing, speed and route.<br>
 * Initial flight plans and aircraft positions are made available when they are
 * received (often roughly 24 hours in advance for flight plans) until roughly
 * seven days after arrival.
 * </p>
 * 
 * @author bpawar
 */
@RestController
@NoArgsConstructor
public class FlightTrackController {

	private final String URL_APPLICATION = "https://api.flightstats.com/flex/flightstatus/rest/v2";
	private final String URL_TRACK_BY_ID_XML = "/xml/flight/track/{flightId}?appId={appId}&appKey={appKey}";
	private final String URL_ARR_TRACKS_BY_DAY_XML = "/xml/flight/tracks/{carrier}/{flight}/arr/{year}/{month}/{day}?appId={appId}&appKey={appKey}";
	private final String URL_DEP_TRACKS_BY_DAY_XML = "/xml/flight/tracks/{carrier}/{flight}/dep/{year}/{month}/{day}?appId={appId}&appKey={appKey}";

	// https://api.flightstats.com/flex/flightstatus/rest/v2/xml/flight/tracks/AA/100/arr/2017/12/29?appId=e73aba2a&appKey=2555787bb0117d52ae25521900f9b8ad&utc=false&includeFlightPlan=false&maxPositions=2

	@Autowired
	private FlightTrackService flightTrackService;

	/**
	 * <p>
	 * Returns the positional track for a specific flight, specified by flight ID.
	 * Flight plan may be optionally included. To narrow down to only the freshest
	 * data, you may optionally limit the age (in minutes) and/or number of
	 * positions returned.
	 * </p>
	 * <b>URL Information:</b><br>
	 * <ol>
	 * <li><b>Template Parameter:</b> flightId</li>
	 * <li><b>Query Parameters:</b> appId, appKey, includeFlightPlan, maxPositions,
	 * maxPositionAgeMinutes, sourceType, extendedOptions</li>
	 * </ol>
	 * 
	 * @param flightId
	 *            an arbitrary number that FlightStats uses to uniquely identify the
	 *            flight
	 * @param params
	 *            instance of {@link FlightByDayRequest} by binding request
	 *            parameters
	 * 
	 * @return positional track for a specific flight, specified by flight ID
	 */
	@PostMapping(path = { "/flight/track/{flightId}" }, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_PDF_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<FlightTrackByIdResponse> trackFlightById(@PathVariable("flightId") String flightId,
			@RequestBody(required = false) FlightTrackRequest params) {

		return flightTrackService.trackFlightById(flightId, params, URL_APPLICATION.concat(URL_TRACK_BY_ID_XML));
	}

	/**
	 * @param params
	 * @param request
	 * @return
	 */
	@PostMapping(path = { "/flight/track/arr/day", "/flight/track/dep/day" }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_PDF_VALUE,
					MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<FlightTracksByDayResponse> flightTracksByDayResponse(@RequestBody FlightTrackRequest params,
			HttpServletRequest request) {

		if (request.getRequestURI().contains("arr"))
			return flightTrackService.flightTracksByDayResponse(params,
					URL_APPLICATION.concat(URL_ARR_TRACKS_BY_DAY_XML));
		else if (request.getRequestURI().contains("dep"))
			return flightTrackService.flightTracksByDayResponse(params,
					URL_APPLICATION.concat(URL_DEP_TRACKS_BY_DAY_XML));
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}