package com.sunjian.testCases;

import com.sunjian.services.impl.HmcjImpl;
import com.sunjian.services.impl.LoginImpl;
import com.sunjian.utils.TestComplate;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sunjian.launchs.Browsers;
import com.sunjian.utils.MyLog;
import com.sunjian.utils.MyWait;

public class HmcjTest {
	private HmcjImpl hmcj;
   
	@Test(groups="hmcj",dependsOnGroups="login",description="无法采集方式测试",priority=1)
	@Parameters({"num"})
	public void testWfcjWay(int num) throws Exception{
		MyLog.log("开始测试无法采集方式了。。。");
		
		hmcj = new HmcjImpl(Browsers.driver);
		//进入虹膜采集
		hmcj.doIntoHmcjPage(LoginImpl.first);
		
		//业务开始。。。无法采集的方式采集人员
		int count = 0;
		try {			
			for(int i=0;i<num;i++){
				MyWait.threadWait(2);
				hmcj.doWfcjWayGatherPerson();
				count++;
				MyLog.log("第"+(i+1)+"个人员添加完成了");
			}
		} catch (Exception e) {
			MyLog.log("无法采集方式--出错了。。。");
			e.printStackTrace();
			TestComplate.complate();
		} finally {
			MyLog.log("虹膜采集之---无法采集测试完成，本次共添加："+count+"个人员！");
		}
		Assert.assertEquals(count, num);
	}
	
	@Test(groups="hmcj2",dependsOnGroups="login",description="虹膜采集方式测试",priority=2)
	@Parameters({"num2"})
	public void testHmcjWay(@Optional("1")int num2) throws Exception{
		MyLog.log("开始测试虹膜采集方式了。。。");
		
//		if (hmcj.kscjIsDisplay() == false) {			
//			//进入虹膜采集
//			hmcj.doIntoHmcjPage(LoginImpl.first);
//		}
		
		//业务开始。。。无法采集的方式采集人员
		int count2 = 0;
		try {			
			for(int i=0;i<num2;i++){
				MyWait.threadWait(2);
				hmcj.doHmcjWayGatherPerson();
				count2++;
				MyLog.log("第"+(i+1)+"个人员添加完成了");
			}
		} catch (Exception e) {
			MyLog.log("虹膜采集方式--出错了。。。");
			e.printStackTrace();
			TestComplate.complate();
		} finally {
			MyLog.log("虹膜采集之---正常采集测试完成，本次共添加："+count2+"个人员！");
		}
		Assert.assertEquals(count2, num2);
	}
}
