package com.qa.webstaurant.pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng;

public class SearchResults {

	protected WebDriver driver;
	
	private By resultsCount = By.xpath("//*[@class='page-header search--title']");
	
	private By filterSearchTextBox = By.name("withinval"); // By.id("search_within");
	
	//private By filterSearchButton = By.xpath("//*[@aria-label='Search']");
	
	
	
	public SearchResults(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public boolean GeneratePageList() {		
		//might be the correct way to do this?
		
		System.out.println("Entered Click Page");
		
		//Did work a couple of times
		//driver.findElement(By.xpath("//*[contains(@class, 'inline-block leading-4')][last()-1]")).click();
		
		/******************************/
		//WebElement lastPage = driver.findElement(By.xpath("//*[contains(@class, 'inline-block leading-4')][last()-1]"));
				
		/*
		 * final List<WebElement> products = driver
		 * .findElements(By.xpath("//*[contains(@class, 'inline-block leading-4')]"));
		 * final List<String> allPages2 = new ArrayList<>();
		 * 
		 * System.out.println(products.size());
		 * 
		 * for (int i = 0; i < products.size(); i++) {
		 * allPages2.add(products.get(i).getText());
		 * 
		 * System.out.println(products.get(i).getText());
		 * 
		 * }
		 */
		
		//Duration timeout = 5;
		
		String pageNumber = driver.findElement(By.xpath("//*[contains(@class, 'inline-block leading-4')][last()-1]")).getText().toString();
		System.out.println(pageNumber);
		
		/*
		new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'inline-block leading-4')][last()-1]")));
		driver.findElement(By.xpath("//*[contains(@class, 'inline-block leading-4')][last()-1]")).click();
		*/
		
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
			driver.findElement(By.xpath("//*[contains(@class, 'inline-block leading-4')][last()-1]")).click();
			result = true;
			System.out.println("Clicked 9");
			//GetLastPage(pageNumber);
			break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
			}
		return result;
					
		//System.out.println("1. Click Page 9");
		
		
		//lastPage.click();
		
		//System.out.println("2. Clicked Page 9");
	}
	
	public String GetLastPage(String pageNo) {
		String lastPage = driver.getCurrentUrl().toString();
		String lastPageNumber[] = lastPage.split("page=");
		System.out.println(lastPageNumber[1]);
		System.out.println("this is the number from click last page function: " + pageNo);	
		
		return lastPageNumber[1];
		
		//Assert.
		
	}
	
	
	
	public String VerifyResultsCount(String filterText) {
		
		String resultText = driver.findElement(resultsCount).getText().toString();
		
		String resultTextParts[] = resultText.split(" ");
		String searchCount = resultTextParts[0];
		
		//System.out.println(resultText);
		
		//System.out.println(searchCount);
		
		return searchCount;
		
		//public WebDriverWait = new WebDriverWait();
		
		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.nsg-button"))).click();
		
		/*
		
		//driver.findElement(filterSearchTextBox).sendKeys(filterText);
		WebElement filterTB = driver.findElement(By.id("searchWithinForm")); //.sendKeys(filterText);
		
		//JavascriptExecutor to click element
	    JavascriptExecutor jse = (JavascriptExecutor) driver;
	    jse.executeScript("arguments[0].click();", filterTB);
	      
		Actions action = new Actions(driver);
		action.moveToElement(filterTB);
		action.perform();
		
		driver.switchTo().activeElement();
		
		driver.findElement(By.id("searchWithinForm")).sendKeys(filterText); //By.id("collapseSearch")
		
		*/
		
		/* *********************************************************************************
		String inputText = "table";
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		
		//final By filterTB = By.xpath("//*[@id='search_within']");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		System.out.println("Passed js instantiation");
		//WebElement myElement2 = wait.until
		
		WebElement myElement = driver.findElement(By.xpath("//*[@id='searchWithinForm']"));
		js.executeScript("arguments[0].click();", myElement);
		
		System.out.println("Passed js textbox click");
		
		String jsString = "arguments[0].value = 'table';";
		js.executeScript("document.getElementById('search_within').value = 'table';");   //("arguments[0].value();", inputText);
		
		System.out.println("Passed js enter value");
		
		List<WebElement> searchWithin = driver.findElements(By.id("search_within"));
		searchWithin.get(1).click();
		searchWithin.get(1).sendKeys("table");
		
		js.executeScript("arguments[0].value = 'table';", searchWithin.get(1));
		
		System.out.println("Entered table in second array element");
		
		
		
		
		//WebElement myElement = driver.findElement(By.id("search_within"));
		       //String js = "arguments[0].setAttribute('value','"+inputText+"')";
		//((JavascriptExecutor) driver).executeScript(js, myElement);
		
		
		WebElement filterSearchButton = driver.findElement(By.xpath("//*[@aria-label='Search']"));
		
		List<WebElement> filtersbutton = driver.findElements(By.xpath("//*[contains(@class,'h-3-1/2')]")); 
		//"//*[@class='h-3-1/2 w-5']"
		
		//driver.findElement(filterSearchButton).click();
		
		//js.executeScript("arguments[0].click();", filterSearchButton);
		
		//System.out.println("No good click.");
		
		//js.executeScript("arguments[0].click();", filtersbutton.get(1));
		
		searchWithin.get(1).sendKeys(Keys.RETURN);
		
		System.out.println("Sent RETURN Key");
		
		//assert.assertEquals(540, 540);
		
		******************************** */
		
		
	}
	
	public void PerformFilterSearch() {


		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//System.out.println("Passed js instantiation");
		//WebElement myElement2 = wait.until
		
		WebElement myElement = driver.findElement(By.xpath("//*[@id='searchWithinForm']"));
		js.executeScript("arguments[0].click();", myElement);
		
		//System.out.println("Passed js textbox click");
		
		String jsString = "arguments[0].value = 'table';";
		js.executeScript("document.getElementById('search_within').value = 'table';");   //("arguments[0].value();", inputText);
		
		//System.out.println("Passed js enter value");
		
		List<WebElement> searchWithin = driver.findElements(By.id("search_within"));
		searchWithin.get(1).click();
		searchWithin.get(1).sendKeys("table");
		
		js.executeScript("arguments[0].value = 'table';", searchWithin.get(1));
		
		System.out.println("Entered table in second array element");
		
		
		/*
		
		WebElement myElement = driver.findElement(By.id("search_within"));
		//String js = "arguments[0].setAttribute('value','"+inputText+"')";
		((JavascriptExecutor) driver).executeScript(js, myElement);
		*/
		
		
		WebElement filterSearchButton = driver.findElement(By.xpath("//*[@aria-label='Search']"));
		
		List<WebElement> filtersbutton = driver.findElements(By.xpath("//*[contains(@class,'h-3-1/2')]")); 
		//"//*[@class='h-3-1/2 w-5']"
		
		//driver.findElement(filterSearchButton).click();
		
		//js.executeScript("arguments[0].click();", filterSearchButton);
		
		//System.out.println("No good click.");
		
		//js.executeScript("arguments[0].click();", filtersbutton.get(1));
		
		searchWithin.get(1).sendKeys(Keys.RETURN);
		
		//System.out.println("Sent RETURN Key");
	}
	
		
	public boolean ClickAddToCart() {		
		//might be the correct way to do this?
		
		//System.out.println("Entered Click Add To Cart");
		
		//Did work a couple of times
		//driver.findElement(By.xpath("//*[contains(@class, 'inline-block leading-4')][last()-1]")).click();
		
		/* **************************** */
		//WebElement lastPage = driver.findElement(By.xpath("//*[contains(@class, 'inline-block leading-4')][last()-1]"));
				
		/*
		 * final List<WebElement> products = driver
		 * .findElements(By.xpath("//*[contains(@class, 'inline-block leading-4')]"));
		 * final List<String> allPages2 = new ArrayList<>();
		 * 
		 * System.out.println(products.size());
		 * 
		 * for (int i = 0; i < products.size(); i++) {
		 * allPages2.add(products.get(i).getText());
		 * 
		 * System.out.println(products.get(i).getText());
		 * 
		 * }
		 */
		
		//Duration timeout = 5;
		
		//String pageNumber = driver.findElement(By.xpath("//*[contains(@class, 'btn btn-cart btn-small')][last()]")).getText().toString();
		//System.out.println(pageNumber);
		
		/*
		new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'inline-block leading-4')][last()-1]")));
		driver.findElement(By.xpath("//*[contains(@class, 'inline-block leading-4')][last()-1]")).click();
		*/
		
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
			driver.findElement(By.xpath("//*[contains(@class, 'btn btn-cart btn-small')][last()]")).click();
			result = true;
			System.out.println("Clicked Add to Cart");			
			break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
			}
		return result;
					
		//System.out.println("1. Click Page 9");
		
		
		//lastPage.click();
		
		//System.out.println("2. Clicked Page 9");
	}
	
	
	public void ViewCart() {
		
		
		driver.findElement(By.xpath("//*[@data-testid='cart-button']")).click();
		
	}
		
		
	
	
	
}
