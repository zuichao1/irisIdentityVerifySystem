package com.sunjian.utils;

import java.util.concurrent.TimeUnit;

/**
 * 显式等待与隐式等待
 */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyWait {
	
	/**
	 * 显式等待，使用ExpectedConditions类中自带方法
	 * 只有满足显式等待的条件，测试代码才会继续向后执行后续的测试逻辑，
	 * 如果超过设定的最大显式等待时间阈值， 这测试程序会抛出异常。
	 * （1）页面元素是否在页面上可用和可被单击：elementToBeClickable(By locator)
	 * （2）页面元素处于被选中状态：elementToBeSelected(WebElement element)
	 * （3）页面元素在页面中存在：presenceOfElementLocated(By locator)
	 * （4）在页面元素中是否包含特定的文本：textToBePresentInElement(By locator)
	 * （5）页面元素值：textToBePresentInElementValue(By locator, java.lang.String text)
	 * （6）标题 (title)：titleContains(java.lang.String title)
	 * @param driver
	 * selenium的WebElement
	 * @param time
	 * 显式等待时间，单位秒
	 * @param str
	 * 页面元素的定位表达式
	 */
	
	//等待time秒元素是否显示，如果time秒之内显示继续操作不需等待time秒
	public static void showTypeWait(WebDriver driver,int time,String str){
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str)));
	}
	
	//等待time秒元素是否显示，如果time秒之内显示，返回此元素，不需要等待time秒
	public static WebElement showTypeWait2(WebDriver driver,int time,String str){
		WebElement myElement = (new WebDriverWait(driver, time)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(str))); 
		return myElement;
	}	
	
	/**
	 * 隐示等待，隐性等待是指当要查找元素，而这个元素没有马上出现时，告诉WebDriver查询Dom一定时间。
	 * 默认值是0,但是设置之后，这个时间将在WebDriver对象实例整个生命周期都起作用。
	 * @param driver
	 * selenium的WebElement
	 * @param time
	 * 隐式等待时间，单位秒
	 */
	
	//隐式等待time秒
	public static void hideTypeWait(WebDriver driver,int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	/**
	 * 线程等待，使线程休眠time秒后，再继续执行后续操作
	 * @param time
	 * 线程等待时间，单位秒
	 * @throws Exception
	 * 线程异常
	 */
	
	public static void threadWait(int time) throws Exception{
		Thread.sleep(time*1000);
	}
	public static void millisWait(int time) throws Exception{
		Thread.sleep(time);
	}

	/**
	 * javaScript方式操作页面的元素
	 * @param driver
	 * selenium的WebDriver
	 * @param js
	 * javaScript的代码
	 * @param str
	 * 页面元素的定位表达式
	 * 
	 * （1）"arguments[0].click();"  
	 *  这个是javaScript的点击代码
	 */
	
	//javaScript等待
	public static void javaScriptWait(WebDriver driver,String js,String str){
		WebElement element = driver.findElement(By.xpath(str));
		((JavascriptExecutor)driver).executeScript(js, element);
	}
	
}
