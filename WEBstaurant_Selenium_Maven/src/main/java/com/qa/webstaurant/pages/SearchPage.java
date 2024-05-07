package com.qa.webstaurant.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

	protected WebDriver driver;

	private By searchField = By.name("searchval");

	private By searchIcon = By.xpath("//*[@type='submit']"); // By.linkText("Search WebstaurantStore"); //
																// By.xpath("//span[@class='sr-only']");

	//private List<WebElement> products;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void EnterSearch(String searchCriteria) {
		driver.findElement(searchField).sendKeys(searchCriteria);
	}

	public void ClickSearchIcon() {
		driver.findElement(searchIcon).click();

	}

	/*public void GeneratePageList() {
		final List<WebElement> products = driver
				.findElements(By.xpath("//*[contains(@class, 'inline-block leading-4')]"));
		final List<String> allPages = new ArrayList<>();

		for (int i = 0; i < products.size(); i++) {
			allPages.add(products.get(i).getText());

			System.out.println(products.get(i).getText());
		}

	}*/

}
