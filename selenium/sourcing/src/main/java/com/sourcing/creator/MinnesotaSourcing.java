package com.sourcing.creator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sourcing.provider.Constants;
import com.sourcing.provider.ConfigReader;
import com.sourcing.support.ElementChecker;
import com.sourcing.support.SourceFileWriter;
import com.sourcing.support.TimeSpanAllocator;

/**
 * Handles sourcing for Minnesota state bar association.
 * 
 * @author bpawar
 *
 */
public class MinnesotaSourcing {

	private WebDriver webDriver;

	// Gathered all source links to be clicked afterwards
	private List<String> anchors;

	private int fileCounter = 1;
	private int pageCount = 1;
	private int paginationCount = 1;

	// Finds input control for injection of City name
	@FindBy(how = How.ID, using = "Header_C001_txtCity")
	private WebElement cityInput;

	// Finds submit button for form submission
	@FindBy(how = How.ID, using = "Header_C001_btnSearchAdvanced")
	private WebElement buttonSubmit;

	/**
	 * Sets {@link WebDriver} instance and invokes {@link PageFactory} initializer
	 * to set paging objects.
	 */
	public MinnesotaSourcing(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	/**
	 * Open URL of state bar member search, inject city name and hits submit.<br>
	 * Gathers all links of profiles of member from pages upto given
	 * <i>pageCount</i> and adds it into <code><i>anchors</i></code> instance.<br>
	 * Invokes <code>getSource</code> on <code>this</code> instance.
	 * 
	 * @param city
	 *            Name of the city to search members
	 * @param pageCount
	 *            Number of pages to be paginated
	 * @param fileName
	 *            Name of the file to save sourced data
	 */
	public void getSource(String city, int pageCount, String fileName) {
		this.pageCount = pageCount;
		System.out.println("Started sourcing of city : " + city);
		// Navigate to URL for searching member information.
		webDriver.navigate().to(ConfigReader.getConfigPropertyVal(Constants.SITE_URL));
		webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		anchors = new ArrayList<String>();

		if (ElementChecker.isEnabled(cityInput)) {
			cityInput.clear();
			cityInput.sendKeys(city);
			System.out.println("City value injected.");
			if (ElementChecker.isEnabled(buttonSubmit)) {
				buttonSubmit.click();
				System.out.println("Form submitted.");
				System.out.println("Getting links and source from page " + paginationCount);
				// Get links from first page
				getLinks(webDriver);
				try {
					WebElement pagination = webDriver.findElement(By.className("paging-style"));
					if (ElementChecker.isDisplayed(pagination)) {
						List<WebElement> pageAnchors = pagination.findElements(By.tagName("a"));
						if (pageAnchors.size() > 0) {
							System.out.println("-----------Pagination started---------------");
							/**
							 * Get all member links from next pages by clicking pagination links
							 */
							for (int i = 0; i < pageAnchors.size(); i++) {
								// break if already reached to number of requested pages
								if (this.pageCount == 1) {
									break;
								}
								// Continue to get links from paginated pages
								this.paginationCount++;
								System.out.println("Getting links and source from page " + paginationCount);
								WebElement pagination1 = webDriver.findElement(By.className("paging-style"));
								// Get pagination link at i'th position
								WebElement anchor = pagination1.findElements(By.tagName("a")).get(i);
								if (anchor.isDisplayed()) {
									// Click on pagination link which takes you to next page
									anchor.click();
									// Get all links of members from i'th page
									getLinks(webDriver);
									this.pageCount--;
								}
							}
						}
					}
				} catch (Exception e) {
					System.out.println("Skipping pagination...");
				}
				getSource(webDriver, city);
			} else {
				System.out.println("search button not found");
			}
		} else {
			System.out.println("city text box not found");
		}
		System.out.println("Sourcing of city " + city + " is completed..!!");
	}

	/**
	 * Retrieves all links of the member profiles and adds to
	 * <code><i>anchors</i></code> instance
	 * 
	 * @param webDriver
	 *            Instance of {@link WebDriver} to get information form HTML source
	 */
	private void getLinks(WebDriver webDriver) {
		List<WebElement> rows = webDriver.findElements(By.className("GridItemStyle"));
		for (WebElement row : rows) {
			anchors.add(row.findElement(By.tagName("a")).getAttribute("href").trim());
		}

	}

	/**
	 * Actual sourcing of member profile.<br>
	 * Iterates on <code>anchors</code> and navigates on a profile link to get page
	 * source of bar member.<br>
	 * Saves file to the path and puts {@link Thread} to sleep for a given interval
	 * by reading from <code>config.properties</code>
	 * 
	 * @param webDriver
	 *            Instance of {@link WebDriver} for HTML interactions
	 * @param city
	 *            Name of the city to be sourced
	 */
	private void getSource(WebDriver webDriver, String city) {
		System.out.println("Total links : " + anchors.size());
		// Iterate on anchors list
		for (String link : anchors) {
			System.out.println("Sourcing File " + fileCounter);
			// Hit profile link and get page source
			webDriver.navigate().to(link);
			String pageSource = webDriver.getPageSource();
			// Write source to file
			SourceFileWriter.write(pageSource, ConfigReader.getConfigPropertyVal(Constants.FILE_PATH),
					city + "_MN_" + fileCounter + ".txt");
			this.fileCounter++;
			TimeSpanAllocator.waitTime(Long.parseLong(ConfigReader.getConfigPropertyVal("testExecutionTimeSlot")));
		}
	}
}
