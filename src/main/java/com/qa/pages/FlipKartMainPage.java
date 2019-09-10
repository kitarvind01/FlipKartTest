package com.qa.pages;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class FlipKartMainPage extends TestBase{
	@FindBy(xpath="//span[text()='Electronics']")
	public static WebElement Electronics;
	
	@FindBy(xpath="//a[text()='Pixel 3a | 3a XL']")
	public static WebElement pixel3a;
	
	@FindBy(xpath="/html/body/div[2]/div/div/button")
	public static WebElement closeWindow;
	
	@FindBy(xpath="//div[contains(text(),'Google Pixel 3a')]")
	public static WebElement clickOnFirstItem;
	
	@FindBy(xpath="//ul[@class='row']//li/button")
	public static WebElement addToCartButton;
	
	
	
	@FindBy(xpath="//button[text()='+']")
	public static WebElement addIcon;
	
	@FindBy(xpath="//span[contains(text(),'₹')]")
	public static WebElement priceOfProd;
	
	
	
	public FlipKartMainPage()
	{
		PageFactory.initElements(driver, this);
	}
}
