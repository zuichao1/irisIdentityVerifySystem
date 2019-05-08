package com.sunjian.testCases;

import com.sunjian.services.impl.LoginImpl;
import com.sunjian.utils.TestComplate;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sunjian.launchs.Browsers;
import com.sunjian.launchs.BrowsersType;
import com.sunjian.utils.MyLog;

public class LoginTest {
	private LoginImpl login;

	@BeforeClass
	public void beforeMethod(){
		new Browsers(BrowsersType.ie);
		MyLog.log("打开浏览器了...");
	}
	@Parameters({"url","username","password"})
	@Test(groups="login",description="正确登录测试",priority=2)
	public void testLogin(String url,String username,String password) throws Exception{
		MyLog.log("开始登录了...");
		boolean flag = false;
		try {
			flag = login.doLogin(url,username, password);
		}catch (Exception e){
			MyLog.log("登录失败了...");
			e.printStackTrace();
			TestComplate.complate();
		}
		Assert.assertEquals(flag,true);
	}
	@Parameters({"url"})
	@Test(groups="login",description="错误登录测试",priority=1)
	public void testLoginFailed(String url) throws Exception{
		String[][] tips_whenEmpty = {
				{"","","必填项不能为空"},
				{"","123456","必填项不能为空"},
				{"123456","","必填项不能为空"},
		};
		String[][] tips_whenFailed = {
				{"sunjian1","1naijnus","用户名或密码错误"},
				{"1naijnus","123456","用户名或密码错误"},
				{"1naijnus","1naijnus","用户名或密码错误"},
		};
		
		for(String[] tip:tips_whenEmpty){
			String musername = tip[0];
			String mpassword = tip[1];
			String tips = tip[2];
			login = new LoginImpl(Browsers.driver);
			String loginBackTips = "";
			try {
				MyLog.log("用户名："+musername+",密码："+mpassword);
				loginBackTips = login.doLoginFailedForEmpty(url, musername, mpassword);
				MyLog.log("用户名或密码为空时提示语："+loginBackTips);				
			} catch (Exception e) {
				MyLog.log("登录失败forEmptyTips测试异常...");
				e.printStackTrace();
				TestComplate.complate();
			}
			Assert.assertEquals(loginBackTips, tips);
		}
		
		for(String[] tip:tips_whenFailed){
			String musername2 = tip[0];
			String mpassword2 = tip[1];
			String tips = tip[2];
			String loginBackTips = "";
			try {
				MyLog.log("用户名："+musername2+",密码："+mpassword2);
				loginBackTips = login.doLoginFailed(url,musername2,mpassword2);
				MyLog.log("用户名or密码错误时的提示语："+loginBackTips);								
			} catch (Exception e) {
				MyLog.log("登录失败forFailedTips测试异常...");
				e.printStackTrace();
				TestComplate.complate();
			}
			Assert.assertEquals(loginBackTips, tips);
		}
	}
}