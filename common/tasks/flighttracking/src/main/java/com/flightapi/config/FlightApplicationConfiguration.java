package com.flightapi.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.NoArgsConstructor;

/**
 * @author bpawar
 *
 */
@SpringBootConfiguration
@NoArgsConstructor
public class FlightApplicationConfiguration {

	@Bean
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}
}
