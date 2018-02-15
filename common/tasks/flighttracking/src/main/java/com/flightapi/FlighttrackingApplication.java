package com.flightapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * The API provides the best available position for active flights, either
 * ASDI from the FAA or ADS-B from transceivers located around the globe. In
 * cases where the flight is out of range of either of these systems -- such as
 * ocean crossings -- FlightStats derives the position based on the last known
 * location and its destination. With a sourceType of 'derived', the API
 * automatically returns the best available position. Users also have the option
 * of requesting the 'raw' data (either ASDI or ADS-B) or 'all' which will
 * return both derived and raw in the same payload.
 * </p>
 * 
 * @author bpawar
 *
 */
@SpringBootApplication
public class FlighttrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlighttrackingApplication.class, args);
	}
}
