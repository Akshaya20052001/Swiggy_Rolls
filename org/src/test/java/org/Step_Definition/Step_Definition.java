package org.Step_Definition;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.Base.Base_Class;
import org.Pom.Swiggy_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_Definition extends Base_Class{

    private Swiggy_Page swiggyPage;

    @Before
    public void setUp() {
        swiggyPage = new Swiggy_Page(); // Ensure this is initialized
    }
    
	@Given("user launch browser")
	public void user_launch_browser() {
		launchBrowser();
		
}

	@And("user launch the url")
	public void user_launch_the_url() throws InterruptedException {
		url("https://www.swiggy.com/");
		window_Maximize();
//		implicity_Wait();
		Thread.sleep(10000);
		
	}

	@When("user click on the search button")
	public void user_click_on_the_search_button() throws InterruptedException {
		driver.findElement(swiggyPage.swiggy_Search).click();
		Thread.sleep(10000);
    
	}

	@When("user enter the rolls and search the product")
	public void user_enter_the_rolls_and_search_the_product() throws AWTException {
		
	    driver.findElement(swiggyPage.enter_Dish).sendKeys("rolls");
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    
	}

	@Then("user verify the highest price in rolls")
	public void user_verify_the_highest_price_in_rolls() throws InterruptedException {
		Thread.sleep(3000);
		 List<WebElement> rollsPrice = driver.findElements(By.xpath("//div[@class='sc-bCrHVQ bgFKcV']"));
		 List<WebElement> rollsName = driver.findElements(By.xpath("//div[@class='sc-aXZVg cjJTeQ sc-fjhLSj hwqoJs']"));
		 
		 
		  double maxPrice = 0.0;
	        String maxPriceRollName = "";

	        // Loop through prices to find the highest one
	        for (int i = 0; i < rollsPrice.size(); i++) {
	            String priceText = rollsPrice.get(i).getText();
	          
	            try {
	                double price = Double.parseDouble(priceText);
	                
	                if (price > maxPrice) {	
	                    maxPrice = price;
	                    maxPriceRollName = rollsName.get(i).getText();
	                }
	            } catch (NumberFormatException e) {}
	       
	        }
	        
	        // Print the highest price and its corresponding roll name
	        if (!maxPriceRollName.isEmpty()) {
	            System.out.println("Highest Price Roll: " + maxPriceRollName + " - Price: ₹" + maxPrice);
	        } else {
	            System.out.println("No rolls found.");
	        }
	        

	}
	
	
}
