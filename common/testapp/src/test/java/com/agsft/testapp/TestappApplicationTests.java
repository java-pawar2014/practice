package com.agsft.testapp;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestappApplicationTests {

	@Test
	public void contextLoads() {
	}

	public static void main(String[] args) {
		LocalDate date1 = LocalDate.of(2018, Month.JULY, 1);
		LocalDate date2 = LocalDate.now();
		System.err.println(date1);
		System.err.println(date2);
		System.out.println(ChronoUnit.DAYS.between(date1, date2));
		
	}
}
