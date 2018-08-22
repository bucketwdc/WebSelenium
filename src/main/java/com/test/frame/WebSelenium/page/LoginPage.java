package com.test.frame.WebSelenium.page;

public interface LoginPage {

	 void open(String url);
	 void loginBlog(String username, String password, String exp);
	 void closeBrower();
	 void login();
	 void openLink(String url);
}
