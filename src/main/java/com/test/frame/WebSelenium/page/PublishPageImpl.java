package com.test.frame.WebSelenium.page;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.testng.Assert;

import com.test.frame.WebSelenium.action.Selenium;



@Service
public class PublishPageImpl implements PublishPage {
	
	private final static String titieLocation = "//form[@id='articleForm']/div[1]/input";
	private final static String pathLocation = "//form[@id='articleForm']/div[2]/input";
	private final static String lableLocation = "//form[@id='articleForm']/div[3]/div/div/input";
	private final static String classifyLocation = "//form[@id='articleForm']/div[4]/select";
	private final static String contentLocation = "//form[@id='articleForm']/div[8]/textarea";
	private final static String buttonLocation = "//form[@id='articleForm']/div[13]/button[1]";
	private final static String alertDiv="//div[@class='swal2-modal swal2-show']";
	
	@Resource 
	Selenium selenium;

	@Override
	public void publish(String title, String path, String lable,String classify, String content, String exp) {

		selenium.input(titieLocation, title, "xpath");
		selenium.input(pathLocation, path, "xpath");
		selenium.input(lableLocation, lable, "xpath");
		selenium.select(classifyLocation, classify, "xpath");
		selenium.input(contentLocation, content, "xpath");
		selenium.click(buttonLocation, "xpath");
		
		//System.out.print("------------------"+selenium.findElement(alertDiv, "xpath").getText());
		Assert.assertNotNull(selenium.findElement(alertDiv, "xpath").getText());
	}
	

	

}
