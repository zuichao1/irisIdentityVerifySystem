package com.sunjian.utils;

import org.apache.commons.logging.Log;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MyLog {

	private static final Logger log = LogManager.getLogger("MyLog:");

	/**
	 * zhengchang log
	 * @param msg
	 */
	public static void log(String msg){
		StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[2];
		log.info(stackTraceElement.getClassName()+" -- "+stackTraceElement.getMethodName()+" -- "+stackTraceElement.getLineNumber()+" line -- ◆◆◆ --> "+msg);
	}
	
	/**
	 * yichang log
	 * @param e
	 */
	public static void logException(Exception e){
		logException(e,null);
	}

	private static void logException(Exception e, String additionalMsg) {
		StringBuffer stringBuffer = new StringBuffer();
		
		StackTraceElement stackTraceElement;
		
		if (additionalMsg != null) {
			stackTraceElement = Thread.currentThread().getStackTrace()[2];
			stringBuffer.append(stackTraceElement.getClassName()+" ◆◆◆ --> "+stackTraceElement.getMethodName()+"\n");
			
			stringBuffer.append(additionalMsg+"\n");
		}else {
			stackTraceElement = Thread.currentThread().getStackTrace()[3];
			stringBuffer.append(stackTraceElement.getClassName()+" ◆◆◆ --> "+stackTraceElement.getMethodName()+"\n");
		}
		
		StackTraceElement[] stackTraces = e.getStackTrace();
		stringBuffer.append(e.getMessage());
		for(StackTraceElement traceElement:stackTraces){
			stringBuffer.append(traceElement.toString()).append("\n");
		}
		log.warn(stringBuffer.toString());
	}
}
