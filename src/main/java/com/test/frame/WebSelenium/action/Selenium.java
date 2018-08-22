package com.test.frame.WebSelenium.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface Selenium {

	WebDriver openBrower(String url);
	public WebDriver openLink(String url);
	String propertyValue(String element,String property,String path);
	void input(String element,String content,String path);
	void clear(String element,String path);
	void click(String element,String path);
	void closeBrower();
	void closeAlert();
	String getAlertText();
	void refresh();
	void catchScreenshot(String filename);
	WebDriver switchTo();
	void select(String element,String classify,String path);
	WebElement findElement(String element,String path);
	
}
