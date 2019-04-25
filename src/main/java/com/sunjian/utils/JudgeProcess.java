package com.sunjian.utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 判断指定的服务进程是否允许
 * @author sunjian
 *
 */
public class JudgeProcess {

	public static boolean whetherRuning(String ipAddress,int port){
		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress(ipAddress, port));
			System.out.println("----------------------->http://"+ipAddress+":"+port+"上的服务已运行，开始测试吧。");
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("----------------------->http://"+ipAddress+":"+port+"上的服务未运行！！！");
			return false;
		}finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
