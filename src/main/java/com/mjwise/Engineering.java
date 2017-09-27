package com.mjwise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ASUS on 2017/9/27.
 */
public class Engineering {

	private static String url = "https://www.engineeringvillage.com/search/quick.url";

	private static WebDriver webDriver;

	public static void main(String[] args){
		Engineering engineering = new Engineering();
		engineering.openBrowser(url);
		engineering.searchKeyword("blockchain");
		engineering.chooseDisplayNumber();
	}

	public void openBrowser(String url){
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		webDriver = new FirefoxDriver();
		webDriver.get(url);
	}

	public void searchKeyword(String keyword){
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-word-1")));//设置等待
		System.out.println("成功打开，开始输入");
		webDriver.findElement(By.id("search-word-1")).sendKeys(keyword);
		System.out.println("开始点击");
		webDriver.findElement(By.id("searchBtn")).click();
	}

	public void chooseDisplayNumber(){
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("results-per-page-select")));//设置等待
		WebElement element = webDriver.findElement(By.id("results-per-page-select"));
		Select number = new Select(element);
		number.selectByVisibleText("100");
	}



}
