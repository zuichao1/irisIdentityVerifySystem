package com.sunjian.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstPage extends BasePage {
	
	public WebDriver driver;
	
	public FirstPage(WebDriver driver){
		super(driver, "FirstPage");
		this.driver = driver;
	}
	
	public WebElement getUserName(){
		return getElement("userName");
	}
	public WebElement cjsb(){
		return getElement("cjsb");
	}
	public WebElement hmcj(){
		return getElement("hmcj");
	}
	public WebElement hmsb(){
		return getElement("hmsb");
	}
	public WebElement cjcxtj(){
		return getElement("cjcxtj");
	}
	public WebElement cjjlcx(){
		return getElement("cjjlcx");
	}
	public WebElement asjtj(){
		return getElement("asjtj");
	}
	public WebElement acjrtj(){
		return getElement("acjrtj");
	}
	public WebElement plcx(){
		return getElement("plcx");
	}
	public WebElement sbcxtj(){
		return getElement("sbcxtj");
	}
	public WebElement sbjlcx(){
		return getElement("sbjlcx");
	}
	public WebElement asjtj2(){
		return getElement("asjtj2");
	}
	public WebElement asbrtj(){
		return getElement("asbrtj");
	}
	public WebElement bjxxcx(){
		return getElement("bjxxcx");
	}
	public WebElement xxwh(){
		return getElement("xxwh");
	}
	public WebElement ryxxwh(){
		return getElement("ryxxwh");
	}
	public WebElement xtsz(){
		return getElement("xtsz");
	}
	public WebElement zhgl(){
		return getElement("zhgl");
	}
	public WebElement zzjggl(){
		return getElement("zzjggl");
	}
	public WebElement ycdygl(){
		return getElement("ycdygl");
	}
	
}
