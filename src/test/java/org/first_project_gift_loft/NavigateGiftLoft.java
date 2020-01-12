package org.first_project_gift_loft;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateGiftLoft {

	


	

	//the below method will launch the browser and return WebDriver
	private static WebDriver launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FirstProjectGiftLoft\\drivers\\chromedriver.exe");		
		return new ChromeDriver();	
	}
	
	
	
	//the below method will navigate to a url
	public static void navigateTo(WebDriver driver, String URL)
	{
		driver.get(URL);
	}
	
	//javascript executor variable returning method
	public static JavascriptExecutor returnJSObject( WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		return js;
	}
	
	
	//findElement method
	
	public static WebElement FindElementByXpath(WebDriver driver, String xpath) 
	{
		 return driver.findElement(By.xpath(xpath));
	}
	
	
	//sign up module
	public static void signUp()
	{
		
	}
	
	public static void main(String[] args) 
	{
		WebDriver driver = launchBrowser();
		
		driver.manage().window().maximize();
		
		String URL = "https://www.giftloft.co.nz/";
		
		navigateTo(driver, URL);
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		
		
		returnJSObject(driver).executeScript(arg0, arg1)
		
		
		
		
		
		
	}
	
	

	
	
}
