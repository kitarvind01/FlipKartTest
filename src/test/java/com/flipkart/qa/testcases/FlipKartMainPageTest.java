package com.flipkart.qa.testcases;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.FlipKartMainPage;

public class FlipKartMainPageTest extends TestBase {
	FlipKartMainPage flipkartmainpage;
	@BeforeTest
	public void setUp() throws FileNotFoundException{
		initialization();
		flipkartmainpage= new FlipKartMainPage();	
	}
	
	@Test(priority=1)
	public void validateTitlePageTest()
	{
		String title= driver.getTitle();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
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
	 
	@Test(priority=3)
	public void addToCartItemTest() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(FlipKartMainPage.addToCartButton));
		 element.click(); 
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		FlipKartMainPage.addIcon.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("The Price of the Product is "+FlipKartMainPage.priceOfProd);
	}
	

}
