package com.test.frame.WebSelenium.listener;

import javax.annotation.Resource;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.test.frame.WebSelenium.action.Selenium;

public class CatchScreenshot extends AbstractTestNGSpringContextTests{

	@Resource
	Selenium action;
	
	/*
	 *  失败用例失败则截图保存
	 */
	private void catchScreenshot(){
		
		CaseListener caseListener = new CaseListener();
		String failCaseName = caseListener.failCaseName;
		boolean caseResult = caseListener.failResult;
		if(caseResult){
			try{
				action.catchScreenshot(failCaseName);
			}catch (Exception e){
				e.printStackTrace();
			}
			caseListener.failCaseName = null;
			caseListener.failResult = false;
		}
	}
}
