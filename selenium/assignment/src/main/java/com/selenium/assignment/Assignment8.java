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
public class Assignment8 {

	public static void run() {
		System.out.println("Executing Assignment 8");
		WebDriver webDriver = null;

		webDriver = new ChromeDriver();
		try {
			webDriver.get("http://toolsqa.com/automation-practice-form/");
			webDriver.manage().window().fullscreen();
			Thread.sleep(2000);
			Select seleniumCommands = new Select(webDriver.findElement(By.id("selenium_commands")));
			seleniumCommands.selectByVisibleText("Navigation Commands");
			Thread.sleep(1000);
			seleniumCommands.selectByVisibleText("Switch Commands");
			Thread.sleep(1000);
			seleniumCommands.deselectByVisibleText("Navigation Commands");
			Thread.sleep(1000);
			seleniumCommands.selectByVisibleText("Wait Commands");
			Thread.sleep(1000);
			for (WebElement option : seleniumCommands.getAllSelectedOptions()) {
				System.out.println(option.getText());
			}
			seleniumCommands.deselectAll();
			Thread.sleep(2000);
		} catch (Throwable cause) {
			cause.printStackTrace();
		} finally {
			webDriver.quit();
		}
	}
}
