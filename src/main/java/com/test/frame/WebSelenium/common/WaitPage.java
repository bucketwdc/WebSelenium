package com.test.frame.WebSelenium.common;

import org.springframework.stereotype.Service;

@Service
public class WaitPage {

	public void wait(int timeout){
		try{
			Thread.sleep(timeout);
		}catch(Exception err){
			//log.error(err.getMessage());
		}
	}
}
