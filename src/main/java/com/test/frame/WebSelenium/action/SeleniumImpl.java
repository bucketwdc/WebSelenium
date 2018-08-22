package com.test.frame.WebSelenium.action;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import com.test.frame.WebSelenium.common.LockElement;
import com.test.frame.WebSelenium.common.WaitPage;

@Service
public class SeleniumImpl implements Selenium{
	
	@Resource
	WaitPage waitPage;

	LockElement lockElement =new LockElement();
	public WebDriver driver;
	private long elementTimeout = 200000;
	
	@Override
	public WebDriver openBrower(String url) {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		 ChromeOptions options = new ChromeOptions();
	     options.addArguments("chrome.switches","--disable-extensions");
		driver = new ChromeDriver(options);
		driver.get(url);
		return driver;
		
	}
	
	public WebDriver openLink(String url){
		if(driver == null){
			openBrower(url);
		}
		driver.get(url);
		return driver;
	}
	

	@Override
	public String propertyValue(String element,String property,String path) {

		By elementLocation = isElementLoaded(element, elementTimeout, path);
		return driver.findElement(elementLocation).getAttribute(property);
	}

	@Override
	public void input(String element, String content,String path) {

		By elementLocation = isElementLoaded(element, elementTimeout, path);
		driver.findElement(elementLocation).sendKeys(content);
		
	}
	
	@Override
	public void clear(String element, String path) {

		By elementLocation = isElementLoaded(element, elementTimeout, path);
		driver.findElement(elementLocation).clear();
	}
	

	@Override
	public void click(String element,String path) {

		By elementLocation = isElementLoaded(element,elementTimeout, path);
		driver.findElement(elementLocation).click();
		
	}
	
	/**
	 * 
	 * @param element
	 * @param timeout
	 * @param path
	 * @return
	 */

	private By isElementLoaded(String element,long timeout,String path){
		By elementLocator = null ;
		long partTimeout = timeout/3;
		for(int i=0;i<3;i++){
			elementLocator = waitingForElementLoad(element,partTimeout,path);
			if(elementLocator != null){
				break;
			}
		}
		return elementLocator;
		
	}

	/**
	 * 
	 * @param element
	 * @param partTimeout
	 * @param path
	 * @return
	 */
	private By waitingForElementLoad(String element, long partTimeout,String path) {

		By elementLocation = lockElement.parseElement(element, path);
		boolean loadResult =checkElement(elementLocation,partTimeout);
		
		if(loadResult){
			return elementLocation;
		}

		return null;
	}

	private boolean checkElement(By parseElement, long partTimeout) {

		try{
			long second = partTimeout/1000;
			new WebDriverWait(driver, second).until(ExpectedConditions.
					visibilityOfAllElementsLocatedBy(parseElement));
			
			return true;
		}catch(Error er){
			throw new RuntimeException(er);
			
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
		
	}

	@Override
	public void closeBrower() {

		driver.quit();
	}

	@Override
	public void closeAlert() {
		driver.switchTo().alert().accept();

	}
	
	@Override
	public String getAlertText() {
		waitPage.wait(3000);
		return driver.switchTo().alert().getText();

	}
	

	@Override
	public void refresh() {

		driver.navigate().refresh();
	}

	/*
	 *  截图(non-Javadoc)
	 * @see com.test.frame.WebSelenium.action.Action#catchScreenshot(java.lang.String)
	 */
	public void catchScreenshot(String filename) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        try {
            String rootPath = System.getProperty("E:\\workspace\\WebSelenium");
            String filePath = rootPath+"\\target\\surefire-reports\\"+filename;
            System.out.println("lal-----------------"+filePath);
            FileUtils.copyFile(scrFile, new File(filePath+"_selenium.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override
	public WebDriver switchTo() {

		String sreachHand = driver.getWindowHandle();
	    Set<String> hands = driver.getWindowHandles();
	    for(String wind:hands){
	    	if(wind.equals(sreachHand)){
	    		continue;
	    	}
	    	driver.switchTo().window(wind);
	    }
		return driver;
	}

	@Override
	public void select(String element,String classify,String path) {

		By elementLocation = isElementLoaded(element,elementTimeout, path);
		Select select = new Select(driver.findElement(elementLocation));
		select.selectByValue(classify);
	}

	@Override
	public WebElement findElement(String element, String path) {
		By elementLocation = isElementLoaded(element, elementTimeout, path);
		return driver.findElement(elementLocation);
	}

	
	
	
}
