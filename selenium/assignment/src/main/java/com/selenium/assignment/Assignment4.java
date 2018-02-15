package com.selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author bpawar
 *
 */
public class Assignment4 {

	public static void run() {
		System.out.println("Executing Assignment 4");
		WebDriver webDriver = null;

		webDriver = new ChromeDriver();
		try {

			webDriver.get("http://toolsqa.wpengine.com/automation-practice-form/");
			webDriver.manage().window().fullscreen();
			Thread.sleep(5000);
			WebElement firstName = webDriver.findElement(By.name("firstname"));
			firstName.sendKeys("root");
			Thread.sleep(2000);
			WebElement lastName = webDriver.findElement(By.name("lastname"));
			lastName.sendKeys("root");
			Thread.sleep(2000);
			WebElement gender = webDriver.findElement(By.id("sex-0"));
			gender.click();
			Thread.sleep(2000);
			WebElement experience = webDriver.findElement(By.id("exp-1"));
			experience.click();
			Thread.sleep(2000);
			WebElement profession= webDriver.findElement(By.xpath("id(\"profession-0\")"));
			profession.click();
			
			Thread.sleep(5000);
			WebElement submit = webDriver.findElement(By.id("submit"));
			submit.submit();
			Thread.sleep(5000);
		} catch (Throwable cause) {
			cause.printStackTrace();
		} finally {
			webDriver.close();
		}
	}
}
