package com.sourcing.handler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sourcing.creator.MinnesotaSourcing;
import com.sourcing.creator.NorthCarolinaSourcing;
import com.sourcing.provider.ConfigReader;
import com.sourcing.provider.Constants;
import com.sourcing.provider.SourceDataProvider;

import bsh.Capabilities;

/**
 * Hit the tests to source out members.
 * 
 * @author bpawar
 *
 */
public class SourceHandlerTest {

	private WebDriver webDriver;

	/**
	 * Set the {@link WebDriver} system property before execution of Suite
	 */
	@BeforeSuite(alwaysRun = true, enabled = true)
	public void setSystemProperty() {
		System.setProperty(ConfigReader.getConfigPropertyVal(Constants.DRIVER_CLASS),
				ConfigReader.getConfigPropertyVal(Constants.DRIVER_VALUE));
	}

	/**
	 * Initialize the <code>webDriver</code> instance with given browser in
	 * <code>config.properties</code> and maximize the window before test.
	 * 
	 * @throws InterruptedException
	 *             If sleeping of thread is interrupted
	 */
	@BeforeTest(alwaysRun = true)
	public void initialize() throws InterruptedException {

		Capabilities capabilities = new Capabilities();
		ChromeOptions chromeOptions = new ChromeOptions();
		webDriver = new ChromeDriver(chromeOptions);
		Thread.sleep(1000);
		webDriver.manage().window().maximize();
	}

	/**
	 * <b>Minnesota Sourcing Test</b><br>
	 * Test to start sourcing of Minnesota state bar which takes parametes from
	 * {@link SourceDataProvider} which acts as the instance of
	 * {@link DataProvider}.<br>
	 * Invokes <code>getSource</code> on {@link MinnesotaSourcing} for source.
	 * 
	 * @param city
	 *            Name of the city for which source the data
	 * @param pageCountValue
	 *            Number of paginated pages to be sourced
	 * @param fileName
	 *            Name of the file to write the member profile source
	 */
	@Test(dataProvider = "cities-data", dataProviderClass = SourceDataProvider.class, enabled = false, testName = "Minnesota Sourcing")
	public void minnesotaSourceTest(String city, String pageCountValue, String fileName) {
		MinnesotaSourcing minnesotaSourcing = null;
		int pageCount = 0;

		minnesotaSourcing = new MinnesotaSourcing(webDriver);
		pageCount = Integer.parseInt(pageCountValue);
		minnesotaSourcing.getSource(city, pageCount, fileName);
	}

	@Test(dataProvider = "cities-data", dataProviderClass = SourceDataProvider.class, enabled = true, testName = "North-Carolina Sourcing")
	public void northCarolinaSourceTest(String city, String pageCountValue, String fileName) {
		NorthCarolinaSourcing northCarolinaSourcing = null;
		int pageCount = 0;

		northCarolinaSourcing = new NorthCarolinaSourcing(webDriver);
		pageCount = Integer.parseInt(pageCountValue);
		northCarolinaSourcing.getSource(city, pageCount, fileName);
	}

	/**
	 * Close the browser after test execution
	 */
	@AfterTest(alwaysRun = true)
	public void destroy() {
		webDriver.quit();
	}
}
