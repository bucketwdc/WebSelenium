package com.test.frame.WebSelenium.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.frame.WebSelenium.action.Selenium;
import com.test.frame.WebSelenium.page.PublishPage;

@Service
public class PublishPageServiceImpl implements PublishPageService{

	@Resource
	Selenium selenium;
	
	@Resource
	PublishPage publishPage;
	
	@Override
	public void publish(String title, String path, String lable,String classify, String content, String exp) {

		selenium.refresh();
		publishPage.publish(title, path, lable,classify, content, exp);
	}

}
