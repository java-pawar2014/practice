package com.flightapi.service.handler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flightapi.app.ApiCredentials;
import com.flightapi.bind.bean.request.FlightByDayRequest;
import com.flightapi.bind.bean.response.FlightStatusByIdResponse;
import com.flightapi.bind.bean.response.FlightStatusesByDayResponse;
import com.flightapi.service.FlightStatusService;

/**
 * @author bpawar
 *
 */
@Service
public class FlightStatusServiceHandler implements FlightStatusService {

	private Logger logger = Logger.getLogger(FlightStatusServiceHandler.class);

	@Autowired
	private RestTemplate restTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.flightapi.service.FlightStatusService#getFlightStatuseByDay(com.
	 * flight.tracking.bind.bean.request.FlightByDayRequest, java.lang.String)
	 */
	public ResponseEntity<FlightStatusesByDayResponse> getFlightStatuseByDay(FlightByDayRequest params, String url) {
		FlightStatusesByDayResponse flightStatusesByDayResponse = null;
		ResponseEntity<FlightStatusesByDayResponse> response = null;
		HttpEntity<?> requestEntity = null;
		HttpHeaders requestHeaders = null;

		requestHeaders = new HttpHeaders();
		requestHeaders.set("accept", MediaType.APPLICATION_XML_VALUE);
		requestEntity = new HttpEntity<>(requestHeaders);
		response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, FlightStatusesByDayResponse.class,
				params.getCarrier(), params.getFlightNumber(), params.getYear(), params.getMonth(), params.getDay(),
				ApiCredentials.getAppId(), ApiCredentials.getAppKey(), params.isUtc(), params.getAirport(),
				params.getCodeType(), params.getExtendedOptions());
		flightStatusesByDayResponse = response.getBody();

		logger.info(flightStatusesByDayResponse);

		return ResponseEntity.ok(flightStatusesByDayResponse);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.flightapi.service.FlightStatusService#getFlightStatusById(java.lang
	 * .String, java.lang.String, java.lang.String)
	 */
	@Override
	public ResponseEntity<FlightStatusByIdResponse> getFlightStatusById(String flightId, String extendedOptions,
			String url) {
		ResponseEntity<FlightStatusByIdResponse> response = null;
		FlightStatusByIdResponse flightStatusByIdResponse = null;
		HttpEntity<?> requestEntity = null;
		HttpHeaders requestHeaders = null;

		requestHeaders = new HttpHeaders();
		requestHeaders.set("accept", MediaType.APPLICATION_XML_VALUE);
		requestEntity = new HttpEntity<>(requestHeaders);

		response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, FlightStatusByIdResponse.class, flightId,
				ApiCredentials.getAppId(), ApiCredentials.getAppKey(), extendedOptions);
		if (response != null) {
			flightStatusByIdResponse = response.getBody();
			logger.info(flightStatusByIdResponse);
		}

		return ResponseEntity.ok(flightStatusByIdResponse);
	}
}
