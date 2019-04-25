package com.sunjian.services.impl;

import com.sunjian.launchs.Browsers;
import com.sunjian.pages.FirstPage;
import com.sunjian.pages.LoginPage;
import com.sunjian.services.Login;
import com.sunjian.utils.MyLog;
import com.sunjian.utils.MyWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginImpl extends LoginPage implements Login {

	private WebDriver driver;
	public static FirstPage first = new FirstPage(Browsers.driver);
	
	public LoginImpl(WebDriver driver){
		super(driver);
		this.driver = driver;
	}

	@Override
	public boolean doLogin(String url,String username,String password) throws Exception{
		boolean flag = false;
		//this.driver.get(getURL());
		this.driver.get(url);
		MyWait.threadWait(1);
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getSubmit().click();
		MyWait.threadWait(3);
		WebElement usernameValue = first.getUserName();
		if (usernameValue.isDisplayed() || !usernameValue.getText().isEmpty()) {
			flag = true;
			MyLog.log("login successfully---->>用户："+usernameValue.getText());
		}else {
			MyLog.log("login unsuccessfully");
		}
		return flag;
	}
	@Override
	public String doLoginFailedForEmpty(String url, String username, String password) throws Exception {
		this.driver.get(url);
		MyWait.threadWait(1);
		if (!getUsername().isDisplayed()) {
			Browsers.driver.quit();
			MyLog.log("login unsuccessfully, because don't find loginBox, maybe the service is not on!!!");
		}
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getSubmit().click();
		
		if (getTips_whenEmpty().isDisplayed())
			return getTips_whenEmpty().getText();
		else{
			MyWait.threadWait(1);
			return getTips_whenEmpty().getText();
		}
	}
	@Override
	public String doLoginFailed(String url, String username, String password) throws Exception {
		this.driver.get(url);
		MyWait.threadWait(1);
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getSubmit().click();

		if(getTips_whenFailed().isDisplayed())
			return getTips_whenFailed().getText();
		else {
			MyWait.threadWait(1);
			return getTips_whenFailed().getText();
		}
	}
}
