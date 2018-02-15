package com.selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author bpawar
 *
 */
public class Assignment6 {

	public static void run() {
		System.out.println("Executing Assignment 6");
		WebDriver webDriver = new ChromeDriver();
		try {
			webDriver.get("http://toolsqa.wpengine.com/automation-practice-form/");
			Thread.sleep(2000);
			webDriver.manage().window().fullscreen();
			Thread.sleep(5000);
			WebElement gender = webDriver.findElement(By.id("sex-1"));
			if (!gender.isSelected()) {
				gender.click();
			}
			Thread.sleep(3000);
			WebElement experience = webDriver.findElement(By.id("exp-2"));
			if (!experience.isSelected()) {
				experience.click();
			}
			Thread.sleep(3000);
			WebElement profession = webDriver.findElement(By.id("profession-1"));
			if (!profession.isSelected()) {
				profession.click();
			}
			if (profession.getAttribute("value").contentEquals("Automation Tester")) {
				System.out.println("Automation Tester Value = " + true);
			} else {
				System.out.println("Automation Tester Value = " + false);
			}
			Thread.sleep(3000);
			// WebElement tool = webDriver.findElement(By.cssSelector(""));
			WebElement tool = webDriver.findElement(By.id("tool-1"));
			tool.click();
			Thread.sleep(5000);
		} catch (Throwable cause) {

			cause.printStackTrace();
		} finally {
			webDriver.close();
		}
	}
}
