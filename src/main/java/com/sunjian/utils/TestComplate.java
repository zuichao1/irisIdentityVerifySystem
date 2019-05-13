package com.sunjian.utils;

import com.sunjian.launchs.Browsers;
import com.sunjian.utils.MyLog;
import com.sunjian.utils.SendMailUtils;

import java.io.*;

public class TestComplate {

	public static void complate(){
		Browsers.driver.quit();
		MyLog.log("退出浏览器了...");
		try {
			SendMailUtils.sendMails();
			MyLog.log("邮件发送了...");
			clearTestResultFile();
		}catch (Exception e){
			MyLog.log("邮件发送失败了...");
			MyLog.logException(e);
		}
	}

	private static void clearTestResultFile() {
		//存放测试报告路径
		String testReportPath = System.getProperty("user.dir")+"/test-reports";
		String testReportPathBak = System.getProperty("user.dir")+"/test-reports-bak";

		//src文件
		File file = new File(testReportPath+"/testReport.html");
		//存放测试报告的目录
		File dir = new File(testReportPath);
		//备份的目录
		File newDir = new File(testReportPathBak);
		//新文件name
		String newFileA = testReportPathBak+"/testReport";
		String newFileB = ".html";

		if(file.exists()){
			boolean flag = false;
			if(!newDir.exists() || !newDir.isDirectory()){
				newDir.mkdir();
			}

			File[] files = newDir.listFiles();
			int fileNum = files.length;
			//创建一个新的文件
			File newFile = new File(newFileA+(fileNum+1)+newFileB);

			//剪切文件
			InputStream input = null;
			OutputStream out = null;
			try {
				input = new FileInputStream(file);
				out = new FileOutputStream(newFile);

				int temp = 0;
				while ((temp = input.read()) != -1) {
					out.write(temp);
				}
				out.flush();
				flag = true;
				MyLog.log("报告已经帮你备份到test-outputs-old目录下了");
			} catch (Exception e) {
				e.printStackTrace();
				MyLog.log("备份上份测试报告时出错了...");
			} finally {
				try {
					out.close();
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (flag == true) {
				boolean bool = file.delete();
				int count = 0;
				while (!bool && count++ < 10){
					System.gc();
					bool = file.delete();
				}
			}
		}else {
			MyLog.log("没有生成测试报告文件...");
		}
	}
}
