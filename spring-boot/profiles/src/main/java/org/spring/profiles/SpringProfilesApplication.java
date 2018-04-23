package org.spring.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringProfilesApplication {

	@Autowired
	private Environment environment;
	
	public static void main(String[] args) {
		SpringApplication starter = new SpringApplication(SpringProfilesApplication.class);
		starter.setAdditionalProfiles("production");
		starter.run(args);
	}
}
