package com.test.frame.WebSelenium.common;

import org.openqa.selenium.By;

public class LockElement {

	public By parseElement(String element,String path){
		
		By lockElement = null;
		
		try{
			if(element.contains("//") || path.equals("xpath")){
				lockElement = By.xpath(element);
			}else if(element.contains(".") || path.equals("css")){
				lockElement = By.cssSelector(element);
			}else if( path.equals("name")){
				lockElement = By.cssSelector(element);
			}else {
				lockElement = By.id(element);
			}
			
			return lockElement;
		}catch (Error e){
			throw new RuntimeException(e);
		}
		
	}
}
