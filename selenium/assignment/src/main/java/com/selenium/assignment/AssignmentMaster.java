package com.selenium.assignment;

/**
 * @author bpawar
 *
 */
public class AssignmentMaster {
	static {
		System.setProperty("webdriver.gecko.driver", "/home/bpawar/Documents/practice/sts-bundle/geckodriver");
		System.setProperty("webdriver.chrome.driver", "/home/bpawar/Documents/practice/sts-bundle/chromedriver");
	}

	public static void main(String[] args) {
		try {
			System.out.println("Execution of the assignments is started....");
			Assignment1.run();
			Thread.sleep(1000);
			Assignment2.run();
			Thread.sleep(1000);
			Assignment3.run();
			Thread.sleep(1000);
			Assignment4.run();
			Thread.sleep(1000);
			Assignment5.run();
			Thread.sleep(1000);
			Assignment6.run();
			Thread.sleep(1000);
			Assignment7.run();
			Thread.sleep(1000);
			Assignment8.run();
			System.out.println("Execution of the assignments is completed.");
		} catch (Throwable cause) {
			cause.printStackTrace();
		}
	}
}
