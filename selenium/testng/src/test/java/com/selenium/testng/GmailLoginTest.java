package com.selenium.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GmailLoginTest {

	private final String url = "https://www.google.co.in/";
	private final String driverUrl = "/home/bpawar/Documents/practice/sts-bundle/chromedriver";
	private final String driverName = "webdriver.chrome.driver";

	private WebDriver webDriver;

	public GmailLoginTest() {
		System.setProperty(driverName, driverUrl);
	}

	@BeforeSuite(alwaysRun = true, enabled = true)
	public void initializeSuite() throws InterruptedException {
		webDriver = new ChromeDriver();
		webDriver.get(url);
		webDriver.manage().window().maximize();
		Thread.sleep(1000);
	}

	@BeforeTest(alwaysRun = true, enabled = true)
	public void initializeTest() throws InterruptedException {
		WebElement gmailLink = webDriver.findElement(By.linkText("Gmail"));
		if (gmailLink.isEnabled()) {
			Thread.sleep(2000);
			gmailLink.click();
		}
		/*
		 * WebElement signinLink = webDriver.findElement(By.linkText("Sign In")); if
		 * (signinLink.isEnabled()) { Thread.sleep(10000); signinLink.click(); }
		 */
	}

	@Test(priority = 0, testName = "Login Test", alwaysRun = true, dataProvider = "loginDataProvider", dataProviderClass = LoginDataProvider.class, description = "Handling login of gmail", enabled = true, suiteName = "Gmail Authentication")
	public void login(String username, String password) throws InterruptedException {
		Thread.sleep(1000);
		WebElement usernameInput = webDriver.findElement(By.id("identifierId"));
		usernameInput.sendKeys(username);
		Thread.sleep(1000);
		WebElement usernameNext = webDriver.findElement(By.id("identifierNext"));
		usernameNext.click();
		Thread.sleep(1000);
		WebElement passwordInput = webDriver.findElement(By.name("password"));
		passwordInput.sendKeys(password);
		Thread.sleep(1000);
		WebElement passwordNext = webDriver.findElement(By.id("passwordNext"));
		passwordNext.click();
		Thread.sleep(10000);
	}

	@Test(priority = 1)
	public void logout() throws InterruptedException {

		Thread.sleep(1000);
		WebElement logoutMenu = webDriver.findElement(By.className("gbii"));
		logoutMenu.click();
		Thread.sleep(3000);

		WebElement logoutButton = webDriver.findElement(By.id("gb_71"));
		logoutButton.click();
		Thread.sleep(2000);
	}

	@AfterTest(alwaysRun = true, enabled = true)
	public void destroyTest() throws InterruptedException {
		Thread.sleep(2000);
		webDriver.quit();
	}

	@AfterSuite(enabled = true)
	public void destroySuite() {
		System.out.println("Execution finished.");
	}
}
