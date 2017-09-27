package com.wchstrife;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by ASUS on 2017/9/27.
 */
public class TestGet {

	private static String url = "http://www.webdriver.org/nav1/";

	public static void main(String[] args){
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		WebDriver webDriver = new FirefoxDriver() ;
		webDriver.get(url);
		String title = webDriver.getTitle();
		System.out.println("Title:" + title);
		String handle = webDriver.getWindowHandle();
		System.out.println(handle);
		webDriver.quit();
	}
}
