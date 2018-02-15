package com.selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author bpawar
 *
 */
public class Assignment3 {

	public static void run() {
		System.out.println("Executing Assignment 3");

		WebDriver driver = new ChromeDriver();

		driver.get("http://demoqa.com/");
		driver.manage().window().fullscreen();
		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath("id(\"menu-item-374\")/a[1]")).click();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().forward();
			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(5000);

		} catch (Throwable cause) {
			cause.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}
