package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.*;

public class TestBase {


	public static WebDriver driver;
	public static Properties prop=new Properties();
	
	public TestBase(){
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resource/configs/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void initialization() throws FileNotFoundException{
		String browserName = prop.getProperty("browser");


		if(browserName.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resource\\drivers\\chromedriver.exe");

			String st=System.getProperty("user.dir")+"\\src\\test\\resource\\drivers\\chromedriver.exe";
			System.out.println(st);
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resource\\drivers\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	
	public static void launchAut(String url) {
		driver.get(url);
	}
}
