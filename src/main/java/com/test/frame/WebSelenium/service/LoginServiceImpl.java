package com.test.frame.WebSelenium.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.frame.WebSelenium.action.Selenium;
import com.test.frame.WebSelenium.page.LoginPage;


@Service
public class LoginServiceImpl implements LoginService{

	@Resource
	Selenium selenium;
	
	@Resource
	LoginPage loginPage;
	
	@Override
	public void open(String url) {
		
		loginPage.open(url);
	}

	@Override
	public void loginPage(String username, String password, String exp) {
		

		//waitPage.wait(5000);
		selenium.refresh();
		loginPage.loginBlog(username,password,exp);
		
	}

	@Override
	public void closeBrower() {

		loginPage.closeBrower();
	}

	@Override
	public void login() {

		loginPage.login();
	}

	@Override
	public void openLink(String url) {

		loginPage.openLink(url);
	}

}
