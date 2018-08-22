package com.test.frame.WebSelenium;

import javax.annotation.Resource;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.frame.WebSelenium.service.IndexPageService;
import com.test.frame.WebSelenium.service.LoginService;
import com.test.frame.common.BaseBlog;

public class IndexPage_NormalTest extends BaseBlog{
	
	@Resource
	LoginService loginService;
	
	@Resource
	IndexPageService indexPageService;
	
	@BeforeClass
	public void beforeClass(){
		
		loginService.login();
	}
	

	@Test
	public void indexPage_Normal(){
		
		indexPageService.indexPage();
		
	}
	
	@AfterClass
	public void afterClass(){
		
		loginService.closeBrower();
	}
	
}
