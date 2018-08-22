package com.test.frame.WebSelenium.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	private int retryCount = 1;
	private int maxRetryCount = 3;
	
	@Override
	public boolean retry(ITestResult result) {
		if(retryCount<maxRetryCount){
			retryCount++;
            return true;
        }
        return false;
	}

	/*
	 *   跑失败的用例重试三次
	 */
	
}
