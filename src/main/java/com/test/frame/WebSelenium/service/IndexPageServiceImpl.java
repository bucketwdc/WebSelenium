package com.test.frame.WebSelenium.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.frame.WebSelenium.page.IndexPage;

@Service
public class IndexPageServiceImpl implements IndexPageService{

	@Resource
	IndexPage  indexPage;
	
	@Override
	public void indexPage() {

		indexPage.checkIndex();
	}

}
