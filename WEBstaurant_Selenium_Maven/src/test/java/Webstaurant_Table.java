import org.openqa.selenium.WebDriver;

import org.testng.*;
import org.testng.annotations.Test;
import org.testng.asserts.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.qa.webstaurant.pages.*;
import org.testng.annotations.BeforeTest;

public class Webstaurant_Table {

	
	//@Test(Test WEBstaurant search and clicks)
	public static void main(String[] args) 
	//public void VerifyTest(String[] args)
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		SearchPage page = new SearchPage(driver);
		SearchResults results = new SearchResults(driver);
		CheckoutPage checkout = new CheckoutPage(driver);
		
		driver.manage().window().maximize();

		driver.get("https://www.webstaurantstore.com/");
		page.EnterSearch("stainless work table");
		page.ClickSearchIcon();
		results.VerifyResultsCount("table");
		results.GeneratePageList();
		results.ClickAddToCart();
		results.ViewCart();
		checkout.ClickDeleteButton();
		
		/*
		public void GetLastPage(String pageNo) {
			this.driver = driver;
			String lastPage = driver.getCurrentUrl().toString();
			String lastPageNumber[] = lastPage.split("table&page=");
			System.out.println(lastPageNumber[1]);
			System.out.println("this is the number from click last page function: " + pageNo);	
						
			assert.equals(lastPageNumber[1], pageNo);
			
		}
		*/
		

		// driver.close();
		// driver.quit();

	}

}
