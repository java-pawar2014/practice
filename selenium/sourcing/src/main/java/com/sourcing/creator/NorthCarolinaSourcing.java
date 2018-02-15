package com.sourcing.creator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sourcing.provider.ConfigReader;
import com.sourcing.provider.Constants;
import com.sourcing.support.ElementChecker;
import com.sourcing.support.TimeSpanAllocator;

/**
 * Handles sourcing for North Carolina state bar association.
 * 
 * @author bpawar
 *
 */
public class NorthCarolinaSourcing {

	private static Logger logger = Logger.getLogger(NorthCarolinaSourcing.class);
	private static final long SLEEP_TIME = 2000;
	private WebDriver webDriver;

	// Gathered all source links to be clicked afterwards
	private List<String> anchors;

	private int fileCounter = 1;
	private int pageCount = 1;
	private int paginationCount = 1;

	// Finds input control for injection of City name
	@FindBy(how = How.ID, using = "vMCITY")
	private WebElement cityInput;

	@FindBy(how = How.ID, using = "vMSTATE")
	private WebElement stateSelect;

	// Finds submit button for form submission
	@FindBy(how = How.CLASS_NAME, using = "MTBtn")
	private WebElement buttonSubmit;

	@FindBy(how = How.XPATH, using = ".//div[@id='TEXTBLOCK1']/table/tbody/tr/td/a")
	private List<WebElement> lawyerLinks;

	/**
	 * Sets {@link WebDriver} instance and invokes {@link PageFactory} initializer
	 * to set paging objects.
	 */
	public NorthCarolinaSourcing(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public void getSource(String city, int pageCount, String fileName) {
		this.pageCount = pageCount;
		System.out.println("Started sourcing of city : " + city);
		// Navigate to URL for searching member information.
		webDriver.navigate().to(ConfigReader.getConfigPropertyVal(Constants.SITE_URL));
		webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		anchors = new ArrayList<String>();

		TimeSpanAllocator.waitTime(SLEEP_TIME);
		if (ElementChecker.isEnabled(cityInput)) {
			cityInput.clear();
			cityInput.sendKeys(city);
			TimeSpanAllocator.waitTime(SLEEP_TIME);
			logger.info("City " + city + " is injected.");
			if (ElementChecker.isDisplayed(stateSelect)) {
				Select state = new Select(stateSelect);
				state.selectByValue("NC");
				TimeSpanAllocator.waitTime(SLEEP_TIME);
				logger.info("State North Carolina is selected.");
				if (ElementChecker.isDisplayed(buttonSubmit)) {
					buttonSubmit.click();
					logger.info("Searching for " + city + "...");
					TimeSpanAllocator.waitTime(SLEEP_TIME);
					for (WebElement anchorTag : lawyerLinks) {
						logger.info(anchorTag.getAttribute("href"));
					}
				} else {
					logger.error("Submit button is not available for city " + city);
				}

			} else {
				logger.error("State select is not displayed for city " + city);
			}
		} else {
			logger.error("City name input field is not enabled  for city " + city);
		}

	}

}
