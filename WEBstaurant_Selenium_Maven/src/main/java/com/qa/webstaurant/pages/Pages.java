package com.qa.webstaurant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pages {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	//page class constructor
	public Pages(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
}
