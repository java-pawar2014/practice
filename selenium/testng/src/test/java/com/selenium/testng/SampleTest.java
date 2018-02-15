package com.selenium.testng;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTest {
	private String baseUrl = "http://demo.guru99.com/selenium/newtours/";
	// private String DRIVER_PATH = "/home/bpawar/Documents/practice/geckodriver18";
	private WebDriver driver;
	public String expected;
	public String actual;

	public SampleTest() {
	}

/*	@BeforeTest(alwaysRun = true)
	public void initialize() {
		System.out.println("Invoked initialize()");
		// System.setProperty("webdriver.firefox.marionette", DRIVER_PATH);
		System.setProperty("webdriver.chrome.driver", "/home/bpawar/Documents/practice/sts-bundle/chromedriver");
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Invoked beforeMethod()");
		expected = "Welcome: Mercury Tours";
		actual = driver.getTitle();
		Assert.assertEquals(expected, actual);
	}

	@Test(priority = 3)
	public void cTest() {
		System.out.println("Invoked cTest()");
		Assert.fail();
	}

	@Test(priority = 0)
	public void aTest() {
		System.out.println("Invoked aTest()");
		Assert.assertTrue(true);
	}

	@Test(priority = 1)
	public void bTest() {
		System.out.println("Invoked bTest()");
		throw new SkipException("Skipping bTest() case...");
	}

	@Test
	public void register() {
		WebElement register = driver.findElement(By.linkText("Register here"));
		register.click();
		expected = "Register: Mercury Tours";
		actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Invoked afterMethod()");
		driver.findElement(By.linkText("Home")).click();
	}

	@AfterTest(alwaysRun = true)
	public void destroy() {
		System.out.println("Invoked destroy()");
		driver.close();
	}
*/
	@DataProvider(name = "dataProvider1")
	public Object[][] dataProvider1() {
		return new Object[][] { { "google", new Integer(100) }, { "yahoo", new Integer(200) },
				{ "yahoo", new Integer(200) }, { "google", new Integer(100) }, { "yahoo", new Integer(200) },
				{ "google", new Integer(100) } };
	}

	@Test(dataProvider = "dataProvider2")
	public void verifyData11(String string, Integer integer) {
		Assert.assertEquals("6000", string);
	}

	@Test(dataProvider = "dataProvider2")
	public void verifyData12(String string, Integer integer) {
		Assert.assertEquals(5000, (int) integer);
	}

	@DataProvider(name = "dataProvider2")
	public Object[][] createData(Method method) {
		if (method.getName().startsWith("verifyData12")) {
			return new Object[][] { new Object[] { "5000", 5000 } };
		} else if (method.getName().startsWith("verifyData11")) {
			return new Object[][] { new Object[] { "6000", 6000 } };
		} else {
			return null;
		}
	}

}
