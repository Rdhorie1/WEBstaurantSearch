package com.qa.WEBstaurant.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.webstaurant.pages.CheckoutPage;
import com.qa.webstaurant.pages.SearchPage;
import com.qa.webstaurant.pages.SearchResults;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ItemSearch {
	
	//WebDriverManager.chromedriver().setup();
	//WebDriver driver = new ChromeDriver();
	public WebDriver driver;
	public SearchPage page; // = new SearchPage(driver);
	public SearchResults results; // = new SearchResults(driver);
	public CheckoutPage checkout; // = new CheckoutPage(driver);
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.webstaurantstore.com/");
		
		page = new SearchPage(driver);
		results = new SearchResults(driver);
		checkout = new CheckoutPage(driver);
	}
	
	
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
