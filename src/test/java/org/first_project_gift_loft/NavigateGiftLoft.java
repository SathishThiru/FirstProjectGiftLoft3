package org.first_project_gift_loft;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.glass.events.KeyEvent;

public class NavigateGiftLoft {	

	
	//the below method will launch the browser and return WebDriver
	private static WebDriver launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FirstProjectGiftLoft\\drivers\\chromedriver.exe");		
		return new ChromeDriver();	
	}
	//launch browser module ends
	
	
	//the below method will navigate to a url
	public static void navigateTo(WebDriver driver, String URL) throws IOException
	{
		driver.get(URL);
		takeScreenshot(driver, "C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FirstProjectGiftLoft3\\Screenshots\\1openingURL.jpeg");
	}
	//navigate url module ends
	
	
	//javascript executor variable returning method
	public static JavascriptExecutor returnJSObject( WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		return js;
	}
	//javascript module ends
	
	
	
	//findElement method
	
	public static WebElement FindElementByXpath(WebDriver driver, String xpath) 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 return driver.findElement(By.xpath(xpath));
	}
	//findelement module ends
	
	
	//login
	public static void login(WebDriver driver) throws IOException
	{
		takeScreenshot(driver, "C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FirstProjectGiftLoft3\\Screenshots\\2SignInPage.jpeg");
		
		WebElement linkSignIn = FindElementByXpath(driver, "//a[@id='customer_login_link']");
		
		linkSignIn.click();
		
		WebElement txtUserName = FindElementByXpath(driver, "//input[@id='customer_email']");
		txtUserName.sendKeys(ExcelRead.getSignInCredentials(1, 0));	
		
		WebElement txtPassword = FindElementByXpath(driver, "//input[@id='customer_password']");
		txtPassword.sendKeys(ExcelRead.getSignInCredentials(1, 1));
		
		WebElement btnLogin = FindElementByXpath(driver, "//input[@value='Sign In']");
		btnLogin.click();
		
		takeScreenshot(driver, "C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FirstProjectGiftLoft3\\Screenshots\\3SignInSuccessful.jpeg");

	}
	//login module ends
	
	
	
	//take screenshot
	public static void takeScreenshot(WebDriver driver, String filePath) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(filePath));
	}
	//take Screenshot module ends
	
	
	//search product
	public static void searchProduct(WebDriver driver) throws AWTException, IOException
	{
		WebElement txtSearchBox = FindElementByXpath(driver, "//input[@type='text']");
		txtSearchBox.sendKeys("blanket");
		
		Robot r = new Robot();
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		takeScreenshot(driver, "C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FirstProjectGiftLoft3\\Screenshots\\4SearchProduct.jpeg");

	}
	//search product ends
	
	
	
	//add to cart
	public static void addToCart(WebDriver driver) throws IOException, InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement linkProduct = FindElementByXpath(driver, "//span[contains(text(), 'Anais White')]");
				
		linkProduct.click();
		
		WebElement btnAddToCart = FindElementByXpath(driver, "(//span[text()='Add to Cart'])[1]");
		btnAddToCart.click();
		Thread.sleep(2000);
		takeScreenshot(driver, "C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FirstProjectGiftLoft3\\Screenshots\\5AddToCartSuccessFull.jpeg");

	}
	//add to cart module ends
	
	
	//checkout
	public static void checkout(WebDriver driver) throws IOException
	{
		WebElement btnCheckout = FindElementByXpath(driver, "(//input[@type='submit'])[1]");
		btnCheckout.click();
		takeScreenshot(driver, "C:\\Users\\sathishPC\\Desktop\\selenium\\Programs\\FirstProjectGiftLoft3\\Screenshots\\6.checkoutSuccessFull.jpeg");

	}
	//checkout module ends
	
	
	
	//get item name and price
	public static void getItemDetails(WebDriver driver) throws IOException
	{
		String itemName =FindElementByXpath(driver, "//span[contains(text(),'Anais')]").getText();
		String itemPrice = FindElementByXpath(driver, "(//span[text()='$80.00'])[2]").getText();
		
		ExcelWrite.recordItemPriceInExcel(itemName, itemPrice);
	}
	
	
	
	
	public static void main(String[] args) throws IOException, InterruptedException, AWTException 
	{
		WebDriver driver = launchBrowser();
		
		driver.manage().window().maximize();
		
		String URL = "https://www.giftloft.co.nz/";
		
		navigateTo(driver, URL);
				
		//Thread.sleep(5000);
		
		login(driver);	
		
		searchProduct(driver);
		
		addToCart(driver);
		
		checkout(driver);
		
		getItemDetails(driver);
		
	}
	
}
