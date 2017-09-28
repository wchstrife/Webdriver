package com.mjwise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ASUS on 2017/9/27.
 */
public class Engineering {

	//网站的首页
	private static String url = "https://www.engineeringvillage.com/search/quick.url";

	//每页展示的数据多少
	private static String DISPLAY_NUMBER = "100";

	//查询之后总共有多少数据
	private int resultCount;

	//总共有多少页
	private int pageNumber;

	//当前是多少页
	private int nowPageNumber = 1;

	private static WebDriver webDriver;

	public static void main(String[] args){
		Engineering engineering = new Engineering();
		engineering.openBrowser(url);
		engineering.searchKeyword("blockchain");
		engineering.chooseDisplayNumber();
		engineering.countPageNumber();
		engineering.download();
	}

	/**
	 * 打开浏览器
	 * @param url
	 */
	public void openBrowser(String url){
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		webDriver = new FirefoxDriver();
		webDriver.get(url);
	}

	/**
	 * 搜索框输入关键字
	 * @param keyword
	 */
	public void searchKeyword(String keyword){
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-word-1")));//设置等待
		System.out.println("成功打开，开始输入");
		webDriver.findElement(By.id("search-word-1")).sendKeys(keyword);
		System.out.println("开始点击");
		webDriver.findElement(By.id("searchBtn")).click();
	}

	/**
	 * 设置每页100条数据
	 */
	public void chooseDisplayNumber(){
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("results-per-page-select")));//设置等待
		WebElement element = webDriver.findElement(By.id("results-per-page-select"));
		Select number = new Select(element);
		number.selectByVisibleText(DISPLAY_NUMBER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result_99")));
	}

	/**
	 * 计算多少条记录，共多少页
	 * 这里使用的是正则提取共多少条数据，然后根据resultCount计算出有多少页
	 */
	public void countPageNumber(){
		String count = webDriver.findElement(By.id("results-count")).getText();
		String regEx = "[^0-9]";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(count);
		count = matcher.replaceAll("");
		pageNumber = Integer.parseInt(count)/Integer.parseInt(DISPLAY_NUMBER) + 1;
		System.out.println(pageNumber);
	}

	/**
	 * 下载
	 */
	public void download(){
		for(int i = 1; i <= pageNumber; i++){
			WebDriverWait wait = new WebDriverWait(webDriver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/section/div[3]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/label")));
			webDriver.findElement(By.id("select-page-menu")).click();
			webDriver.findElement(By.id("select-page-link")).click();//设置全选
			//webDriver.findElement(By.className("ss-download")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-title")));//等待弹窗出现
			webDriver.findElement(By.id("savePrefsButton")).click();

			nowPageNumber++;
			break;
		}
	}

}
