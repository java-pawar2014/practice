package com.agsft.ccsms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = { "com.agsft.ccsms.feign" })
public class CcsmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcsmsApplication.class, args);
	}
}
