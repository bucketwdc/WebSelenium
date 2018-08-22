package com.test.frame.WebSelenium.page;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.testng.Assert;

import com.test.frame.WebSelenium.action.Selenium;
import com.test.frame.WebSelenium.common.BasePage;

@Service
public class LoginPageImpl extends BasePage implements LoginPage{

	private final static String usernameLocation="//form[@class='form-horizontal m-t-20']/div[1]/div[1]/input[@name='username']";
	private final static String passwordLocation="//form[@class='form-horizontal m-t-20']/div[2]/div[1]/input[@name='password']";
	private final static String buttonLocation="//form[@class='form-horizontal m-t-20']/div[4]/div[1]/button";
	
	@Resource
	Selenium selenium;
	

	
	public void open(String url){
		
		this.webDriver = selenium.openBrower(url);
	}
	
	@Override
	public void loginBlog(String username, String password,String exp) {

		selenium.input(usernameLocation, username, "xpath");
		selenium.input(passwordLocation, password, "xpath");
		selenium.click(buttonLocation, "xpath");
		Assert.assertEquals(webDriver.getCurrentUrl(), exp);
	}

	public void closeBrower(){
		
		selenium.closeBrower();
	}

	@Override
	public void login() {

		this.webDriver = selenium.openBrower("http://111.231.94.245:8081/admin/login");
		selenium.input(usernameLocation, "admin", "xpath");
		selenium.input(passwordLocation, "123456", "xpath");
		selenium.click(buttonLocation, "xpath");
	}


	@Override
	public void openLink(String url) {

		selenium.openLink(url);
	}
	
}
