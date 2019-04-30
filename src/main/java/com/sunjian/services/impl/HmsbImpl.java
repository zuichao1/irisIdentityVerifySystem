package com.sunjian.services.impl;

import com.sunjian.datas.Datas2;
import com.sunjian.pages.FirstPage;
import com.sunjian.pages.HmsbPage;
import com.sunjian.pages.IframePage;
import com.sunjian.services.Hmcj;
import com.sunjian.services.Hmsb;
import com.sunjian.utils.MyLog;
import com.sunjian.utils.MyWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HmsbImpl extends HmsbPage implements Hmsb {

	private WebDriver driver;
	
	public HmsbImpl(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	Datas2 data = new Datas2(System.getProperty("user.dir")+"/src/test/tools/xxx.csv");
	IframePage iframe = new IframePage(driver);
	
	public void intoHmsbIframe() throws Exception{//进入虹膜识别界面的iframe
		driver.switchTo().frame(driver.findElement(By.xpath(iframe.getHmsbIframe())));
		MyWait.threadWait(1);
	}
	public void intoKscjIframe() throws Exception{//进入开始采集界面的iframe
		driver.switchTo().frame(driver.findElement(By.xpath(iframe.getKscjIframe())));
		MyWait.threadWait(1);
	}
	public void intoHmsb2Iframe() throws Exception{//进入证件不一致提示界面的iframe
		driver.switchTo().frame(driver.findElement(By.xpath(iframe.getHmsb2Iframe())));
		MyWait.threadWait(1);
	}
	public void backHomeIframe(){//返回主iframe
		driver.switchTo().defaultContent();
	}
	public void backParentIframe(){//返回上级iframe
		driver.switchTo().parentFrame();
	}
	private void doClickKssb() throws Exception{//点击开始识别
		MyWait.threadWait(1);
		if (kssb().isDisplayed()) {			
			kssb().click();
			MyWait.threadWait(2);
		}else {
			MyLog.log("开始识别按钮没有找到");
		}
	}
	/**
	 * 使用JS click
	 * @param element
	 */
	public void doUseJsClickEelment(WebElement element){
		String js ="arguments[0].click();";
	    ((JavascriptExecutor) driver).executeScript(js,element);
	}
	private void doClickKscj() throws Exception{//点击开始采集
		if (kscj().isDisplayed() && kscj().isEnabled()) {
			doUseJsClickEelment(kscj());
			MyWait.threadWait(10);
		}else {
			MyLog.log("开始采集按钮没有找到");
		}
	}
	private void doClickSglredz(){//点击手工录入二代证
		if (sglredz().isDisplayed()) {
			sglredz().click();
		}else {
			MyLog.log("手工录入按钮没有找到");
		}
	}
	private void doInputXm(){//输入姓名
		xm().sendKeys(data.getTestData("xm", "v1"));
	}
	private void doSelectZjlx(){//选择证件类型
		zjlx_button().click();
		zjlx().click();
	}
	private void doInputZjh(){//输入证件号
		zjh().sendKeys(data.getTestData("zjh", "v1"));
	}
	private void doSelectXb(){//输入性别
		xb_button().click();
		xb().click();
	}
	private void doInputCsrq(){//输入出生日期

		csrq().sendKeys(data.getTestData("csrq", "v1"));
	}
	private void doSelectGj(){//输入国籍
		gj_button().click();
		gj().click();
	}
	private void doSelectMz(){//输入民族
		mz_button().click();
		mz().click();
	}
	private void doInputHjdz(){//输入户籍地址
		hjdz().sendKeys(data.getTestData("hjdz", "v1"));
	}
	private void doInputZjqfjg(){//输入证件签发机构
		zjqfjg().sendKeys(data.getTestData("zjqfjg", "v1"));
	}
	private void doInputZjyxq(){//输入证件有效期
		zjyxq().sendKeys(data.getTestData("zjyxq", "v1"));
	}

	private void doClickDedz(){//点击读二代证
		if (dedz().isDisplayed() || dedz().isEnabled())
			doUseJsClickEelment(dedz());
		else
			MyLog.log("读二代证按钮没有找到");
	}
	private void doClickZjhy(){//点击证件核验按钮
		bd().click();
	}
	private String getHyResultTips(){//核验结果的提示语
		return hyResultTips().getText();
	}
	private void doReadOrInputPersonInfo() throws Exception {//读取或输入待比对的人员信息
		MyWait.threadWait(1);
		if(sglredz().isDisplayed() || sglredz().isEnabled()){//如果手工录入显示
			doClickSglredz();
			//输入信息
			doInputPersonInfo();
			MyLog.log("输入完成了");
		}else if (dedz().isDisplayed() || dedz().isEnabled()) {//显示
			doClickDedz();
			//判断证件是否读取成功
			if (xm().getText() != null || "".equals(xm().getText())) {
				//读取成功了
				MyLog.log("读取成功了");
			}else {
				HmcjImpl hmcj = new HmcjImpl(driver);
				hmcj.doClickQd();
				//输入信息
				doInputPersonInfo();
				MyLog.log("没有读取成功，但是手动输入完成了");
			}
		}else {
			//都不显示
			MyLog.log("读取或录入的按钮没有激活");
		}
		
	}
	private void doInputPersonInfo() {//输入要比对的人员信息
		doInputCsrq();
		doInputXm();
		doSelectZjlx();
		doInputZjh();
		doSelectXb();
		doSelectGj();
		doSelectMz();
	}
	private void doCloseTipsBox(){
		doUseJsClickEelment(hyResultBox_qdButton());
		MyLog.log("关闭核验结果提示框");
	}
	
	public String getHyTime(){//本次核验耗时
		return haoshi().getText();
	}

	/**
	 * 进入虹膜识别界面中
	 * @param first
	 * @throws Exception
	 */
	public void doIntoHmcjPage(FirstPage first) throws Exception {
		backHomeIframe();
		if (first.hmsb().isDisplayed()) {
			//点击虹膜识别
			first.hmsb().click();
			MyWait.threadWait(1);
			intoHmsb2Iframe();
		}else {
			//点击 采集识别
			first.cjsb().click();
			first.hmsb().click();
			MyWait.threadWait(1);
			intoHmsb2Iframe();
		}
	}

	@Override
	public String zjhy() throws Exception{
		doClickKssb();
		intoKscjIframe();//进入开始采集对话框界面
		doClickKscj();
		backHomeIframe();
		intoHmsb2Iframe();//返回到上级界面
		doReadOrInputPersonInfo();//判断读二代证按钮是否显示如果显示点击
		doInputHjdz();
		doInputZjqfjg();
		doInputZjyxq();
		doClickZjhy();//点击证件核验
		MyWait.threadWait(2);
		doCloseTipsBox();
		return getHyResultTips();//获取返回结果
	}

	@Override
	public String onlyHmsb() throws Exception {
		doClickKssb();
		intoKscjIframe();//进入开始采集对话框界面
		doClickKscj();
		backHomeIframe();
		intoHmsb2Iframe();//返回到上级界面

		return getHyTime();
	}
}
