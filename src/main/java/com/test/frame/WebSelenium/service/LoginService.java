package com.test.frame.WebSelenium.service;

/**
 * Hello world!
 *
 */
public interface LoginService 
{
	void open(String url);
    void loginPage(String username, String password, String exp);
    void login();
    void openLink(String url);
    void closeBrower();
}
