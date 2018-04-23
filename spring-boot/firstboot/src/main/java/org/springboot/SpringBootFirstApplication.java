package org.springboot;

import org.springboot.configuration.WebMvcConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

//@ComponentScan
//@EnableAutoConfiguration
//@Import({WebMvcConfiguration.class})
@SpringBootApplication
@ImportResource("application-context.xml")
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class SpringBootFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstApplication.class, args);
	}

}
