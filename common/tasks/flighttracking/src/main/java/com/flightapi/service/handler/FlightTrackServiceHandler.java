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
import com.flightapi.bind.bean.request.FlightTrackRequest;
import com.flightapi.bind.bean.response.FlightTrackByIdResponse;
import com.flightapi.bind.bean.response.FlightTracksByDayResponse;
import com.flightapi.service.FlightTrackService;

/**
 * @author bpawar
 *
 */
@Service
public class FlightTrackServiceHandler implements FlightTrackService {

	private Logger logger = Logger.getLogger(FlightTrackServiceHandler.class);

	@Autowired
	private RestTemplate restTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see FlightTrackService#trackFlightById(String, FlightTrackRequest, String)
	 */
	@Override
	public ResponseEntity<FlightTrackByIdResponse> trackFlightById(String flightId, FlightTrackRequest params,
			String url) {
		ResponseEntity<FlightTrackByIdResponse> responseEntity = null;
		FlightTrackByIdResponse flightTrackByIdResponse = null;
		HttpEntity<?> requestEntity = null;
		HttpHeaders requestHeaders = null;
		StringBuilder urlBuilder = null;

		urlBuilder = new StringBuilder(url);
		if (params != null)
			urlBuilder.append(this.bindUrlForTrackFlight(params));

		logger.info(urlBuilder.toString());
		requestHeaders = new HttpHeaders();
		requestHeaders.set("accept", MediaType.APPLICATION_XML_VALUE);

		requestEntity = new HttpEntity<>(requestHeaders);
		responseEntity = restTemplate.exchange(urlBuilder.toString(), HttpMethod.GET, requestEntity,
				FlightTrackByIdResponse.class, flightId, ApiCredentials.getAppId(), ApiCredentials.getAppKey());

		if (responseEntity != null) {
			flightTrackByIdResponse = responseEntity.getBody();
			logger.info(flightTrackByIdResponse);
		}
		return ResponseEntity.ok(flightTrackByIdResponse);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see FlightTrackService#flightTracksByDayResponse(FlightTrackRequest, String)
	 */
	@Override
	public ResponseEntity<FlightTracksByDayResponse> flightTracksByDayResponse(FlightTrackRequest params, String url) {
		ResponseEntity<FlightTracksByDayResponse> responseEntity = null;
		FlightTracksByDayResponse flightTracksByDayResponse = null;
		HttpEntity<?> requestEntity = null;
		HttpHeaders requestHeaders = null;
		StringBuilder urlBuilder = null;

		urlBuilder = new StringBuilder(url);
		if (params != null)
			urlBuilder.append(this.bindUrlForTrackFlight(params));

		logger.info(urlBuilder.toString());
		requestHeaders = new HttpHeaders();
		requestHeaders.set("accept", MediaType.APPLICATION_XML_VALUE);

		requestEntity = new HttpEntity<>(requestHeaders);
		responseEntity = restTemplate.exchange(urlBuilder.toString(), HttpMethod.GET, requestEntity,
				FlightTracksByDayResponse.class, params.getCarrier(), params.getFlight(), params.getYear(),
				params.getMonth(), params.getDay(), ApiCredentials.getAppId(), ApiCredentials.getAppKey());

		if (responseEntity != null) {
			flightTracksByDayResponse = responseEntity.getBody();
			logger.info(flightTracksByDayResponse);
		}
		return ResponseEntity.ok(flightTracksByDayResponse);
	}

	/**
	 * <p>
	 * <b>URL Builder for query parameters</b><br>
	 * Builds the {@link String} equivalent of applicable query parameters in the
	 * form key and value as '{key}={value}' separating by '&'.<br>
	 * </p>
	 * 
	 * @param params
	 *            a non-null instance of {@link FlightTrackRequest}
	 * @return a String equivalent of applicable query parameters
	 */
	private String bindUrlForTrackFlight(FlightTrackRequest params) {

		StringBuilder builder = new StringBuilder();
		if (params.getAirport() != null)
			builder.append("&airport=").append(params.getAirport());
		if (params.getCodeType() != null)
			builder.append("&codeType=").append(params.getCodeType());
		if (params.getExtendedOptions() != null)
			builder.append("&extendedOptions=").append(params.getExtendedOptions());
		if (params.getHourOfDay() != 0)
			builder.append("&hourOfDay=").append(params.getHourOfDay());
		if (params.getMaxPositionAgeMinutes() != 0)
			builder.append("&maxPositionAgeMinutes=").append(params.getMaxPositionAgeMinutes());
		if (params.getMaxPositions() != 0)
			builder.append("&maxPositions=").append(params.getMaxPositions());
		if (params.getNumHours() != 0)
			builder.append("&numHours=").append(params.getNumHours());
		if (params.getSourceType() != null)
			builder.append("&sourceType=").append(params.getSourceType());

		builder.append("&includeFlightPlan=").append(params.isIncludeFlightPlan());
		builder.append("&utc=").append(params.isUtc());
		return builder.toString();
	}
}
