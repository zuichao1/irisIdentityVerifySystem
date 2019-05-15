package com.sunjian.testCases;

import com.sunjian.services.impl.HmsbImpl;
import com.sunjian.services.impl.LoginImpl;
import com.sunjian.utils.TestComplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sunjian.launchs.Browsers;
import com.sunjian.utils.MyLog;

public class HmsbTest {
	private HmsbImpl hmsb;
   
	@Test(groups="hmsb",dependsOnGroups="login",description="虹膜识别测试",priority=3)
	public void testHmsb() throws Exception{
		MyLog.log("开始测试虹膜识别了...");
		String hyjg = "";
		boolean flag = false;
		try {
			hmsb = new HmsbImpl(Browsers.driver);
			//进入虹膜识别
			hmsb.doIntoHmcjPage(LoginImpl.first);
			//业务开始...
			hyjg = hmsb.zjhy();
			MyLog.log("证件核验结果：-->>"+hyjg);
			flag = hyjg.length() > 0?true:false;
		} catch (Exception e) {
			MyLog.log("虹膜识别--出错了...");
			e.printStackTrace();
			TestComplate.complate();
		}
		Assert.assertEquals(flag,true);
	}
}