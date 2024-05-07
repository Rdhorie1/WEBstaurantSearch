package com.qa.WEBstaurant.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SearchTest extends ItemSearch {

	@Test(priority=1)
	public void verifyItemSearchAndDelete() {
		
		
		page.EnterSearch("stainless work table");
		page.ClickSearchIcon();
		//results.VerifyResultsCount("table");
		
		String resultText = driver.findElement(By.xpath("//*[@class='page-header search--title']")).getText().toString();		
		String resultTextParts[] = resultText.split(" ");
		String searchCount = resultTextParts[0];
		
		
		results.PerformFilterSearch();
		
		
		String filterReturn = driver.findElement(By.xpath("//*[contains(@class, 'font-semibold -mt-2 absolute')][last()]")).getText().toString();
		//WebElement filterReturn = driver.findElement(By.xpath("//*[(@class='font-semibold -mt-2 absolute right-10 top-1/2 lt:font-normal lt:right-2-1/2') and (@partialLinkText='" + searchCount + "')]"));
		
		System.out.println("Webelement of 540 was found!: " + filterReturn);
		
		//Assert.assertEquals(searchCount,filterReturn);
		results.GeneratePageList();
		results.ClickAddToCart();
		results.ViewCart();
		checkout.ClickDeleteButton();
		
		
		//String emptyCart = driver.findElement(By.xpath("//*[@class='header-1']")).getText().toString();
		//Assert.assertEquals(emptyCart, "Your cart is empty.");
		
	}
	
	
	
	
	
}
