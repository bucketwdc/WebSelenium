package com.test.frame.common;

import org.testng.annotations.Listeners;

import com.test.frame.common.CsvProviderUtils.CsvDataProvideBase;

@Listeners(com.test.frame.common.TCRunConfigManage.TCRuningListener.class)
public class MarketCenterBaseTest extends CsvDataProvideBase{

	public MarketCenterBaseTest(){
		super();
	}
}
