package com.selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author bpawar
 *
 */
public class Assignment5 {

	public static void run() {
		System.out.println("Executing Assignment 5");
		WebDriver webDriver = null;

		webDriver = new ChromeDriver();
		try {

			webDriver.get("http://toolsqa.wpengine.com/automation-practice-form/");
			Thread.sleep(2000);
			webDriver.manage().window().fullscreen();
			Thread.sleep(2000);
			WebElement anchorLink = webDriver.findElement(By.partialLinkText("Partial Link Test"));
			anchorLink.click();
			Thread.sleep(5000);
			WebElement submit = webDriver.findElement(By.tagName("button"));
			System.out.println(submit.getText());
			Thread.sleep(5000);
			WebElement anchor = webDriver.findElement(By.linkText("Link Test"));
			anchor.click();
			Thread.sleep(5000);
		} catch (Throwable cause) {
			cause.printStackTrace();
		} finally {
			webDriver.close();
		}

	}
}
