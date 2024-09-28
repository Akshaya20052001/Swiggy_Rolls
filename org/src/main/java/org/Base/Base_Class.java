package org.Base;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base_Class {

	public static WebDriver driver;
	
	
	public static void launchBrowser() {
//		 if (browser.equalsIgnoreCase("chrome")){
//	            driver = new ChromeDriver();
//	        } else if (browser.equalsIgnoreCase("firefox")) {
//	            driver = new FirefoxDriver();
//	        }
//	        else {
//	            System.out.println("No browser found");
//	        }
		
		driver = new ChromeDriver();

	}
	
	public static void window_Maximize() {
	 driver.manage().window().maximize();

	}
	
	public static void url(String url) {
	driver.get(url);	
  
	}

	public static void to_CloseBrowser() {
		driver.quit();

	}
	public static void click(WebElement c) {
		c.click();

	}
	
	public static void sendkey(WebElement s, String r) {
		s.sendKeys(r);

	}
	
	public static void implicity_Wait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
