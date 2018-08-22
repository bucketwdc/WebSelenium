package com.test.frame.WebSelenium.page;

import javax.annotation.Resource;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;
import org.testng.Assert;
import com.test.frame.WebSelenium.action.Selenium;
import com.test.frame.WebSelenium.common.BasePage;

@Service
public class IndexPageImpl extends BasePage implements IndexPage{
	
	private final static String element="//ul[@class='list-group']/li[1]/a";
	private final static String property="href";

	@Resource
	Selenium action;
	
	@Override
	public void checkIndex() {

		action.click(element, "xpath");
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(action.propertyValue(element, property,"xpath" ));
		//stringBuffer.append("1");

		WebDriver driver = action.switchTo();
		Assert.assertEquals(driver.getCurrentUrl(), stringBuffer.toString());
	}

}
