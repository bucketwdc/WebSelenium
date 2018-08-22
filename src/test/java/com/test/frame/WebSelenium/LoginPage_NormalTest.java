package com.test.frame.WebSelenium;

import javax.annotation.Resource;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.frame.WebSelenium.service.LoginService;
import com.test.frame.common.BaseBlog;

public class LoginPage_NormalTest extends BaseBlog{
	
	@Resource
	LoginService loginService;
	
	@BeforeClass
	public void beforeClass(){
		
		loginService.open("http://111.231.94.245:8081/admin/login");
	}
	
	
	@Test(dataProvider = "oCsvDataProviderConfig")
	public void login_Normal(String username,String password,String exp){
		
		loginService.loginPage(username,password,exp);
		
	}
	
	@AfterClass
	public void afterClass(){
		
		loginService.closeBrower();
	}
	
}

