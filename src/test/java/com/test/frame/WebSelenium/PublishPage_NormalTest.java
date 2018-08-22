package com.test.frame.WebSelenium;

import javax.annotation.Resource;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.frame.WebSelenium.service.LoginService;
import com.test.frame.WebSelenium.service.PublishPageService;
import com.test.frame.common.BaseBlog;

public class PublishPage_NormalTest extends BaseBlog{
	
	@Resource
	LoginService loginService;
	
	@Resource
	PublishPageService publishPageService;
	
	@BeforeClass
	public void beforeClass(){
		
		loginService.login();
		loginService.openLink("http://111.231.94.245:8081/admin/article/publish");
	}
	
	
	@Test(dataProvider = "oCsvDataProviderConfig")
	public void publish_Normal(String title, String path, String lable,String classify, String content, String exp){
		
		publishPageService.publish(title, path, lable,classify, content, exp);
		
	}
	
	@AfterClass
	public void afterClass(){
		
		loginService.closeBrower();
	}
	
}

