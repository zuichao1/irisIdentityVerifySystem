package com.sunjian.config;

public interface Constants {

	public static String htmlEncoding = "UTF-8";
	public static String testEngineer = "sunjian's ";
	public static String projectName = "Iris Identity System";
	public static String testReprotTitle = projectName + " TestReport";
	/*邮件发送配置*/
	//请求身份验证
	public static String senderAuth = "true";
	//是否开启调试模式
	public static boolean isDebug = false;
	//设置发送使用的协议
	public static String senderProtocol = "smtp";
	
	/****************************外网邮件发送***************163********************************/
/*	//设置发送服务器的地址
	public static String senderServerAddress = "smtp.163.com";
	//发件人
	public static String senderFrom = "zbql123@163.com";
	//收件人
	public static String recipientTo = "zbql123@163.com,zuichao123@163.com,zuichao124@163.com";
	//抄送人
	public static String recipientCC = "zbql123@163.com,zuichao125@163.com,zuichao123@qq.com";
	//密送人
	public static String recipientBCC = "245907102@qq.com";
	//发送人账号（认证）
	public static String senderUsername = "zbql123";
	//发送人密码（认证）
	public static String senderPassword = "zbql123";*/
	
	/***************************内网邮件发送****************irisking***************************/
	//设置发送服务器的地址
	public static String senderServerAddress = "smtp.irisking.com";
	//发件人
	public static String senderFrom = "sunjian@irisking.com";
	//收件人
	public static String recipientTo = "sunjian@irisking.com";
	//抄送人
	public static String recipientCC = "sunjian@irisking.com";
	//密送人
	public static String recipientBCC = "";
	//发送人账号（认证）
	public static String senderUsername = "sunjian@irisking.com";
	//发送人密码（认证）
	public static String senderPassword = "cronaldo7";
	/*************************************************************************************/
	
	//主题
	public static String subject = "xxx系统测试报告";
	//正文
	public static String mainBody = "<font color=\"red\">(本邮件是程序自动下发的，请勿回复！)</font>"
			+ "<br>各位领导同事，大家好：<br>&nbsp;&nbsp;&nbsp;&nbsp;"+projectName+"测试已完成，测试详情请查看附件测试报告，谢谢。"
			+ "<br><br><br>————————————————————"
			+ "<br>孙健<br>软件测试工程师<br>电话：15510211823<br>Email："+senderFrom;
	//正文类型
	public static String bodytype = "text/html;charset=UTF-8";
	//附件文件夹path
	public static String attachmentPath = "./test-outputs";
	
}
