package com.wchstrife;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by ASUS on 2017/9/27.
 */
public class TestBaidu {
	public static void main(String[] args){

		//System.setProperty("webdriver.chrome.driver", "D:\\work\\Webdriver\\chromedriver.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		WebDriver webDriver = new FirefoxDriver();
		webDriver.get("http://www.baidu.com");
		webDriver.findElement(By.id("kw")).sendKeys("Java");
		webDriver.findElement(By.id("su")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		webDriver.quit();
	}
}
