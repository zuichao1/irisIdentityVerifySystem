package com.sunjian.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HmcjPage extends BasePage {
	
	public WebDriver driver;
	
	public HmcjPage(WebDriver driver){
		super(driver, "HmcjPage");
		this.driver = driver;
	}

	protected WebElement ryfl(){
		return getElement("ryfl");
	}
	protected WebElement xm(){
		return getElement("xm");
	}
	protected WebElement zjlx(){
		return getElement("zjlx");
	}
	protected WebElement zjh(){
		return getElement("zjh");
	}
	protected WebElement xb(){
		return getElement("xb");
	}
	protected WebElement gj(){
		return getElement("gj");
	}
	protected WebElement mz(){
		return getElement("mz");
	}
	protected WebElement csrq(){
		return getElement("csrq");
	}
	protected WebElement hjdz(){
		return getElement("hjdz");
	}
	protected WebElement zjqfjg(){
		return getElement("zjqfjg");
	}
	protected WebElement yxqx(){
		return getElement("yxqx");
	}
	protected WebElement xjzdz(){
		return getElement("xjzdz");
	}
	protected WebElement sjhm(){
		return getElement("sjhm");
	}
	protected WebElement qtlxdh(){
		return getElement("qtlxdh");
	}
	protected WebElement wfcj(){
		return getElement("wfcj");
	}
	protected WebElement wfcj_select(){
		return getElement("wfcj_select");
	}
	protected WebElement bz(){
		return getElement("bz");
	}
	protected WebElement tj(){
		return getElement("tj");
	}
	protected WebElement cz(){
		return getElement("cz");
	}
	protected WebElement dedz(){
		return getElement("dedz");
	}
	protected WebElement kscj(){
		return getElement("kscj");
	}
	protected WebElement kscj2(){
		return getElement("kscj2");
	}
	protected WebElement qzcj(){
		return getElement("qzcj");
	}
	protected WebElement zy(){
		return getElement("zy");
	}
	protected WebElement yy(){
		return getElement("yy");
	}
	protected WebElement qx(){
		return getElement("qx");
	}
	protected String ryfl_button_str(){
		return getElementStr("ryfl_button");
	}
	protected WebElement ryfl_button(){
		return getElement("ryfl_button");
	}
	protected String zjlx_button_str(){
		return getElementStr("zjlx_button");
	}
	protected WebElement zjlx_button(){
		return getElement("zjlx_button");
	}
	protected String xb_button_str(){
		return getElementStr("xb_button");
	}
	protected WebElement xb_button(){
		return getElement("xb_button");
	}
	protected String gj_button_str(){
		return getElementStr("gj_button");
	}
	protected WebElement gj_button(){
		return getElement("gj_button");
	}
	protected String mz_button_str(){
		return getElementStr("mz_button");
	}
	protected WebElement mz_button(){
		return getElement("mz_button");
	}
	protected String wfcj_button_str(){
		return getElementStr("wfcj_button");
	}
	protected WebElement wfcj_button(){
		return getElement("wfcj_button");
	}
	protected String qd_str(){
		return getElementStr("qd");
	}
	protected WebElement qd(){
		return getElement("qd");
	}
	protected WebElement tsy(){
		return getElement("tsy");
	}
	protected WebElement tzcj(){
		return getElement("tzcj");
	}
}
