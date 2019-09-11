package com.qa.testcases;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.FlipKartMainPage;

public class FlipKartMainPageTest extends TestBase {
	FlipKartMainPage flipkartmainpage;
	
	String flipkart="https://www.flipkart.com/";
	
	@BeforeTest
	public void setUp() throws FileNotFoundException{
		initialization();
		flipkartmainpage= new FlipKartMainPage();
		launchAut(flipkart);
		
	}
	
	//Getting and validating the title of the page
	
	@Test(priority=1)
	public void validateTitlePageTest()
	{
		String title= driver.getTitle();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
	//Selecting the item from list of the items
	@Test(priority=2)
	public void selectItemTest() throws InterruptedException
	{
		FlipKartMainPage.closeWindow.click();
		Actions act= new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		act.moveToElement(FlipKartMainPage.Electronics).perform();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		FlipKartMainPage.pixel3a.click();
		FlipKartMainPage.clickOnFirstItem.click();
		Set<String> handles= driver.getWindowHandles();
		System.out.println(handles);
		Iterator<String> itr= handles.iterator();
		
	    itr.next();
		String handle2= itr.next();
		
		driver.switchTo().window(handle2);
		
		Assert.assertTrue(FlipKartMainPage.addToCartButton.isEnabled());
	}
	 //Adding the item into the cart and calculating the price of the product
	@Test(priority=3)
	public void addToCartItemTest() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		//wait.until(ExpectedConditions.elementToBeClickable(FlipKartMainPage.addToCartButton));
		Thread.sleep(3000);
		FlipKartMainPage.addToCartButton.click();
		Thread.sleep(3000);
		FlipKartMainPage.addIcon.click();
		Thread.sleep(3000);
		System.out.println("The Price of the Product is "+FlipKartMainPage.priceOfProd.getText());
	}
	@AfterTest
	public void closeSetUp()
	{
		driver.quit();
	}
	

}
