package com.agsft.orgchart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class OrganizationChartApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationChartApplication.class, args);
	}
}
