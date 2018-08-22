package com.test.frame.common;

import java.lang.reflect.Method;
import java.util.Iterator;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.test.frame.common.CsvProviderUtils.CsvDataProviderFilePathConfigClass;
import com.test.frame.common.logutil.TcRunLog;

@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class BaseBlog extends AbstractTestNGSpringContextTests{
	
	@BeforeClass
	public void init(){
		new MarketCenterBaseTest();
	}
	
	@DataProvider(name = "oCsvDataProviderConfig")
	public static Iterator<Object[]> getCsvTestDataProvider(Method oMethod){
		System.out.println(System.getProperty("user.dir"));
		new MarketCenterBaseTest();
		Class<?> oclass = oMethod.getDeclaringClass();
		Iterator<Object[]> oCsvDataProvider = getCsvTestDataProvider(oclass,oMethod,"src/main/resources/");
		return oCsvDataProvider;
	}
	
	protected static Iterator<Object[]> getCsvTestDataProvider(Class<?> oClass,Method oMethod,String filePath){
		
		Iterator<Object[]> rs = CsvDataProviderFilePathConfigClass.oCsvDataProviderFilePathConfigClass(oClass, oMethod, filePath);
		if(rs == null){
			TcRunLog.error("当前测试类："+oClass.getName()+"当前测试方法："+oMethod.getName());
		}
		return rs;
		
	}
}
