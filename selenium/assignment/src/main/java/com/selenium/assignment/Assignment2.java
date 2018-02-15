package com.selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author bpawar
 *
 */
public class Assignment2 {

	public static void run() {
		System.out.println("Executing Assignment 2");
		WebDriver webDriver = null;

		webDriver = new ChromeDriver();
		try {

			webDriver.get("http://demoqa.com/frames-and-windows/");
			webDriver.manage().window().fullscreen();
			Thread.sleep(3000);
			webDriver.findElement(By.xpath("id(\"menu-item-158\")/a[1]")).click();
			Thread.sleep(4000);

		} catch (Throwable cause) {
			cause.printStackTrace();
		} finally {
			// webDriver.close();
			webDriver.quit();
		}
	}
}
