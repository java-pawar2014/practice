package com.agsft.testapp;

import java.util.logging.Level;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.java.Log;

@SpringBootApplication
@Log
public class TestappApplication {

	public static void main(String[] args) {
		log.log(Level.INFO,"Starting main...");
		SpringApplication.run(TestappApplication.class, args);
	}
}
