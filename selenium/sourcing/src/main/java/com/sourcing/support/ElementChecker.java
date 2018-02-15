package com.sourcing.support;

import org.openqa.selenium.WebElement;

public class ElementChecker {

	public static boolean isEnabled(WebElement element) {
		if (element.isEnabled()) {
			return true;
		} else {
			System.out.println("Element is not enabled.");
			return false;
		}
	}

	public static boolean isDisplayed(WebElement element) {
		if (element.isDisplayed()) {
			return true;
		} else {
			System.out.println("Element is not displayed.");
			return false;
		}
	}

	public static boolean isSelected(WebElement element) {
		if (element.isSelected()) {
			return true;
		} else {
			System.out.println("Element is not selected.");
			return false;
		}
	}
}
