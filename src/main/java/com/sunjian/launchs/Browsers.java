package com.sunjian.launchs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browsers {
	
	public static WebDriver driver = null;
	
	public Browsers (BrowsersType browserstype){
		switch (browserstype) {
		case chrome:
			try {
				System.setProperty("webdriver.chrome.driver","E:/selenium/chrome1/chromedriver.exe");		
			} catch (Exception e) {
				System.out.println("not find Chrome_browsers location!");
			}
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			break;
			
		case firefox:
			try {
				System.setProperty("webdriver.firefox.bin", "E:/selenium/firefox/firefox.exe");
			} catch (Exception e) {
				System.out.println("not find Firefox_browsers location!");
			}
			driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
			
			break;
			
		case ie:
			try {
				System.setProperty("webdriver.ie.driver", "C:\\Progra~2\\Intern~1\\IEDriverServer.exe");
			} catch (Exception e) {
				System.out.println("not find IE_browsers location!");
			}
			driver = new InternetExplorerDriver();
			
			driver.manage().window().maximize();
			
			break;
			
		default:
			System.out.println("Browser Input Error...");
		}
			
	}
}
