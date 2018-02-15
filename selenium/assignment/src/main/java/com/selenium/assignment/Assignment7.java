package com.selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author bpawar
 *
 */
public class Assignment7 {

	public static void run() {
		System.out.println("Executing Assignment 7");
		WebDriver webDriver = null;

		try {
			webDriver = new ChromeDriver();
			webDriver.get("http://toolsqa.wpengine.com/automation-practice-form/");
			webDriver.manage().window().fullscreen();
			Thread.sleep(2000);
			Select continents = new Select(webDriver.findElement(By.id("continents")));
			Thread.sleep(2000);
			continents.selectByVisibleText("Australia");
			Thread.sleep(2000);
			for (WebElement continent : continents.getOptions()) {
				System.out.println(continent.getText());
			}
			Thread.sleep(2000);
			continents.selectByVisibleText("North America");
			Thread.sleep(2000);
		} catch (Throwable cause) {
			cause.printStackTrace();
		} finally {
			webDriver.close();
		}
	}
}
