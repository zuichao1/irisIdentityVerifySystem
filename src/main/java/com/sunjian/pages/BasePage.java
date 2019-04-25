package com.sunjian.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sunjian.datas.DBOp;

public class BasePage {

	private WebDriver driver;
	private DBOp db ;
	
	
	public BasePage(WebDriver driver,String tablename){
		this.driver=driver;
		
		db = new DBOp(tablename);
		db.conn(System.getProperty("user.dir")+"/src/test/tools/xxx.sqlite");
	}
	
	//获取数据库中存储的xpath或者css对应的元素
	public WebElement getElement(String loc){
		
		WebElement we = null;
		
		if(db.getXpath(loc)!=null|| !db.getXpath(loc).equals("")){
			try{
				we = this.driver.findElement(By.xpath(db.getXpath(loc)));
			}catch (Exception e) {
				if(db.getCss(loc)!=null || !db.getCss(loc).equals(""))
					we = this.driver.findElement(By.cssSelector(db.getCss(loc)));
			}
		}else {
			we = this.driver.findElement(By.cssSelector(db.getCss(loc)));
		}
		
		return we;	
	}
	
	//获取数据库中的xpath或者css
	public String getElementStr(String loc){
		
		String str = null;
		
		if(db.getXpath(loc)!=null || !db.getXpath(loc).equals(""))
			str = db.getXpath(loc);
		else 
			if(db.getCss(loc)!=null || !db.getCss(loc).equals(""))
				str = db.getCss(loc);
		return str;
	}
	
	//获取数据库中的指定元素名的指定列的内容
	public String getElementContents(String elementName,String columName){
		
		String str = null;
		
		if(db.getElementName(elementName)!=null || !db.getElementName(elementName).equals("")){
			str = db.getContents(elementName, columName);
		}
		return str;
	}
	
}
