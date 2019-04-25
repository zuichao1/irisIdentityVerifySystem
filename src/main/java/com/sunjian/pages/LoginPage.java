package com.sunjian.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver){
		super(driver, "LoginPage");
		this.driver = driver;
	}
	
	protected String getURL(){
		return getElementContents("url", "value");
	}
	protected WebElement getUsername(){
		return getElement("username");
	}
	protected String getUsernameValue(){
		return getElementContents("username","value");
	}
	protected WebElement getPassword(){
		return getElement("password");
	}
	protected String getPasswordValue(){
		return getElementContents("password","value");
	}
	protected WebElement getSubmit(){
		return getElement("submit");
	}
	
	protected WebElement getTips_whenEmpty(){
		return getElement("tips_whenEmpty");
	}
	protected WebElement getTips_whenFailed(){
		return getElement("tips_whenFailed");
	}
}
