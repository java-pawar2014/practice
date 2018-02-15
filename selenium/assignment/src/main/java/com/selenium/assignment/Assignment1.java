package com.selenium.assignment;

import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * @author bpawar
 *
 */
public class Assignment1 {

	public static void run() {
		System.out.println("Executing Assignment 1");
		WebDriver webDriver = null;
		
		FirefoxOptions opts = new FirefoxOptions().setLogLevel(Level.ALL);
		webDriver = new ChromeDriver();
		// webDriver = new FirefoxDriver(opts);
		webDriver.get("http://store.demoqa.com/");
		webDriver.manage().window().fullscreen();
		System.out.println("Page Title : " + webDriver.getTitle());
		System.out.println("Title length : " + webDriver.getTitle().length());
		System.out.println("Page URL : " + webDriver.getCurrentUrl());
		// System.out.println("Page Source: \n" + webDriver.getPageSource());
		System.out.println("Page source length : " + webDriver.getPageSource().length());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.close();
	}
}
