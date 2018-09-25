package org.spring.bootconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConfigurationApplication {
	public static void main(String[] args) {
		System.setProperty("spring.config.location", "classpath:/spring-boot.properties");
		SpringApplication.run(SpringBootConfigurationApplication.class, args);
	}
}
