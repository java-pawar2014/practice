package com.sourcing.creator;

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
import com.sourcing.support.TimeSpanAllocator;

public class MissouriSourcing {

	private WebDriver webDriver;

	private int fileCounter = 1;
	private int pageCount = 1;
	private int paginationCount = 1;

	// Finds input control for injection of City name
	@FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_dropZoneContentBody_uxColumnDisplay_ctl00_uxControlColumn_ctl00_uxWidgetHost_uxWidgetHost_widget_txtCity")
	private WebElement cityInput;

	// Finds submit button for form submission
	@FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_dropZoneContentBody_uxColumnDisplay_ctl00_uxControlColumn_ctl00_uxWidgetHost_uxWidgetHost_widget_btnSearch")
	private WebElement buttonSubmit;

	/**
	 * Sets {@link WebDriver} instance and invokes {@link PageFactory} initializer
	 * to set paging objects.
	 */
	public MissouriSourcing(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public void getSource(String city, int pageCount, String fileName) {

		this.pageCount = pageCount;
		System.out.println("Started sourcing of city : " + city);
		// Navigate to URL for searching member information.
		webDriver.navigate().to(ConfigReader.getConfigPropertyVal(Constants.SITE_URL));
		webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		cityInput.clear();
		cityInput.sendKeys(city);
		buttonSubmit.click();
		List<WebElement> links = webDriver.findElements(By.linkText("Select"));
		for (int i = 2; i < links.size(); i++) {
			WebElement link = webDriver.findElement(By.xpath("id(\"ctl00_ContentPlaceHolder1_dropZoneContentBody_uxColumnDisplay_ctl00_uxControlColumn_ctl00_uxWidgetHost_uxWidgetHost_widget_GridView1\")/tbody[1]/tr["+i+"]/td[1]/a[1]"));
			link.click();
			TimeSpanAllocator.waitTime(Long.parseLong(ConfigReader.getConfigPropertyVal("testExecutionTimeSlot")));
		}
	}
}
