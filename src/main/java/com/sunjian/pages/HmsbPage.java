package com.sunjian.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HmsbPage extends BasePage {

	public WebDriver driver;
	
	public HmsbPage(WebDriver driver){
		super(driver, "HmsbPage");
		this.driver = driver;
	}
	
	protected WebElement kssb(){
		return getElement("kssb");
	}
	protected WebElement kscj(){
		return getElement("kscj");
	}
	protected WebElement dedz(){
		return getElement("dedz");
	}
	protected WebElement sglredz(){
		return getElement("sglredz");
	}
	protected WebElement cz(){
		return getElement("cz");
	}
	protected WebElement bd(){
		return getElement("bd");
	}
	protected WebElement xm(){
		return getElement("xm");
	}
	protected WebElement zjlx_button(){
		return getElement("zjlx_button");
	}
	protected WebElement zjlx(){
		return getElement("zjlx");
	}
	protected WebElement zjh(){
		return getElement("zjh");
	}
	protected WebElement xb_button(){
		return getElement("xb_button");
	}
	protected WebElement xb(){
		return getElement("xb");
	}
	protected WebElement csrq(){
		return getElement("csrq");
	}
	protected WebElement gj_button(){
		return getElement("gj_button");
	}
	protected WebElement gj(){
		return getElement("gj");
	}
	protected WebElement mz_button(){
		return getElement("mz_button");
	}
	protected WebElement mz(){
		return getElement("mz");
	}
	protected WebElement hjdz(){
		return getElement("hjdz");
	}
	protected WebElement zjqfjg(){
		return getElement("zjqfjg");
	}
	protected WebElement zjyxq(){
		return getElement("zjyxq");
	}
	protected WebElement hyResultTips(){
		return getElement("hyResultTips");
	}
	protected WebElement haoshi(){
		return getElement("haoshi");
	}
	protected WebElement lsjl(){
		return getElement("lsjl");
	}
	protected WebElement lsjl_closeButton(){
		return getElement("lsjl_closeButton");
	}
	protected WebElement hyResultBox_qdButton(){
		return getElement("hyResultBox_qdButton");
	}
}
