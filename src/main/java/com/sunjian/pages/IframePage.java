package com.sunjian.pages;

import org.openqa.selenium.WebDriver;

public class IframePage extends BasePage {
	
	public WebDriver driver;
	
	public IframePage(WebDriver driver){
		super(driver, "IframePage");
		this.driver = driver;
	}

	
	public String getHmcjIframe(){//虹膜采集iframe
		return getElementStr("hmcj_iframe");
	}
		
	public String getKscjIframe(){//开始采集iframe
		return getElementStr("kscj_iframe");
	}	
	
	public String getHmsbIframe(){
		return getElementStr("hmsb_iframe");
	}
	
	public String getHmsb2Iframe(){
		return getElementStr("hmsb_iframe2");
	}
		
	
}
