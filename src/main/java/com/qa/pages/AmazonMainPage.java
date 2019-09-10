package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class AmazonMainPage extends TestBase {
	public AmazonMainPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox")
	public static WebElement amazonSearchTextBox;
	
	@FindBy(xpath="//input[@value='Go']")
	public static WebElement amazonGoButton;
	
	@FindBy(xpath="//span[text()='Apple iPhone 7 (32GB) - Black']")
	public static WebElement clickAppleIphone;
	
	@FindBy(id="priceblock_ourprice")
	public static WebElement getPriceOfProd;
	
	@FindBy(xpath="//input[@name='q']")
	public static WebElement flipkartSearchTextBox;
	
	@FindBy(xpath="/html/body/div[2]/div/div/button")
	public static WebElement flipkartCloseWindow;
	
	@FindBy(xpath="//div/button")
	public static WebElement clickOnSearchIcon;
	
	@FindBy(xpath="//div[text()='Apple iPhone 7 (Black, 32 GB)']")
	public static WebElement selectIphone;
	
	@FindBy(xpath="//div[contains(text(),'₹')]")
	public static WebElement getPriceOfProdFlipkart;

}
