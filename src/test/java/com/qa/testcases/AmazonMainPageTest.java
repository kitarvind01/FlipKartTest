package com.qa.testcases;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AmazonMainPage;


public class AmazonMainPageTest extends TestBase{
	AmazonMainPage amazonMainPage;
	String amazonUrl="https://www.amazon.in/";
	String flipkartUrl="https://www.flipkart.com/";
	double amazonPriceIphone=0.0;
	double flipkartPriceIphone=0.0;
	@BeforeTest
	public void setUp() throws FileNotFoundException {
		initialization();
		launchAut(amazonUrl);
		amazonMainPage= new AmazonMainPage();
		
	}
	@Test(priority=1)
	public void verifyAmazonTitlePageTest()
	{
		Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}

	@Test(priority=2)
	public void searchItemTest()
	{
		AmazonMainPage.amazonSearchTextBox.sendKeys("iPhone 7 32 gb(black)");
		AmazonMainPage.amazonGoButton.click();
		
	}
	
	@Test(priority=3)
	public void selectAppleIphone() {
		AmazonMainPage.clickAppleIphone.click();
		Set<String> handles= driver.getWindowHandles();
		System.out.println(handles);
		Iterator<String> itr= handles.iterator();
		
	    itr.next();
		String handle2= itr.next();
		
		driver.switchTo().window(handle2);
	}
	
	@Test(priority=4)
	public void getPrice()
	{
	    String amazonPrice=AmazonMainPage.getPriceOfProd.getText();
		String amazonPriceOrg= amazonPrice.substring(2, amazonPrice.length()-1);
		int getIndex= amazonPriceOrg.indexOf(',');
		String amazonPriceOrg1=amazonPriceOrg.substring(0, getIndex) + amazonPriceOrg.substring(getIndex + 1);
		amazonPriceIphone=Double.parseDouble(amazonPriceOrg1);
		System.out.println("This is original price "+amazonPriceIphone);
		//driver.quit();
	}
	
	@Test(priority=5)
	public void nevigateToFlipkartFormAzazon() throws InterruptedException
	{
		launchAut(flipkartUrl);
		Thread.sleep(3000);
		AmazonMainPage.flipkartCloseWindow.click();
		Thread.sleep(3000);
		AmazonMainPage.flipkartSearchTextBox.sendKeys("iPhone 7 32 gb(black)");
		Thread.sleep(3000);
		AmazonMainPage.clickOnSearchIcon.click();
		Thread.sleep(3000);
		AmazonMainPage.selectIphone.click();
		Thread.sleep(3000);
		String flipkartPrice=AmazonMainPage.getPriceOfProdFlipkart.getText();
		String flipkartPriceOrg= flipkartPrice.substring(1, flipkartPrice.length());
		int getIndex= flipkartPriceOrg.indexOf(',');
		String flipkartPriceOrg1=flipkartPriceOrg.substring(0, getIndex) + flipkartPriceOrg.substring(getIndex + 1);
		flipkartPriceIphone=Integer.parseInt(flipkartPriceOrg1);
		System.out.println(flipkartPriceIphone);
		Assert.assertEquals(amazonPriceIphone, flipkartPriceIphone);
	
	}
}
