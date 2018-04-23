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

import com.sourcing.provider.ConfigReader;
import com.sourcing.provider.Constants;
import com.sourcing.support.ElementChecker;
import com.sourcing.support.SourceFileWriter;
import com.sourcing.support.TimeSpanAllocator;

public class LouisianaSourcing {

	private static final long SLEEP_TIME = 500;
	private WebDriver webDriver;

	private int fileCounter = 1;
	private int pageCount = 1;
	private int paginationCount = 1;

	@FindBy(how = How.ID, using = "TextBoxCity")
	private WebElement cityInput;

	@FindBy(how = How.ID, using = "ButtonSearch")
	private WebElement buttonSubmit;

	@FindBy(how = How.XPATH, using = ".//a[contains(@id,'ListView')]")
	private List<WebElement> detailLinks;

	@FindBy(how = How.XPATH, using = ".//div[@id='DIvPager']//input[@value='Next']")
	private WebElement nextButton;

	public LouisianaSourcing(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public void getSource(String city, int pageCount, String fileName) {
		this.pageCount = pageCount;
		System.out.println("Started sourcing of city : " + city);
		// Navigate to URL for searching member information.
		webDriver.navigate().to(ConfigReader.getConfigPropertyVal(Constants.SITE_URL));
		webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		TimeSpanAllocator.waitTime(SLEEP_TIME);
		if (ElementChecker.isEnabled(cityInput)) {
			cityInput.clear();
			cityInput.sendKeys(city);
			TimeSpanAllocator.waitTime(SLEEP_TIME);
			System.out.println("City value injected.");
			if (ElementChecker.isEnabled(buttonSubmit)) {
				buttonSubmit.click();
				System.out.println("Form submitted.");
				TimeSpanAllocator.waitTime(SLEEP_TIME);
				loadLinksAndGetSource(city);

				do {
					if (ElementChecker.isDisplayed(nextButton) && ElementChecker.isEnabled(nextButton)) {
						nextButton.click();
						loadLinksAndGetSource(city);
					}
				} while (ElementChecker.isDisplayed(nextButton) && ElementChecker.isEnabled(nextButton));

			} else {
				System.out.println("search button not found");
			}
		} else {
			System.out.println("city text box not found");
		}
		System.out.println("Sourcing of city " + city + " is completed..!!");
	}

	private void loadLinksAndGetSource(String city) {
		System.out.println("Detail links : " + detailLinks.size());
		if (!detailLinks.isEmpty()) {
			for (int x = 0; x < detailLinks.size() - 3; x++) {
				WebElement detailLink = webDriver.findElement(By.id("ListView1_ctrl" + x + "_LinkButton1"));
				if (ElementChecker.isEnabled(detailLink) && ElementChecker.isDisplayed(detailLink)) {
					detailLink.click();
					TimeSpanAllocator.waitTime(SLEEP_TIME);
					getSource(webDriver, city);
					TimeSpanAllocator.waitTime(SLEEP_TIME);
				}
				webDriver.navigate().back();
			}
		}

	}

	private void getSource(WebDriver webDriver, String city) {
		String pageSource = webDriver.getPageSource();
		// Write source to file
		SourceFileWriter.write(pageSource, ConfigReader.getConfigPropertyVal(Constants.FILE_PATH),
				city + "_LS_" + fileCounter + ".txt");
		this.fileCounter++;
	}

}
