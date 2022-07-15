package com.pageobjectmodel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseScript {
	public static WebDriver driver = null;
	
	static {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chand\\Desktop\\QA\\driver\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\chand\\Desktop\\QA\\driver\\geckodriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("http://demo.guru99.com/v4");
		driver.manage().window().maximize();
	}
	public static void checkAds(String title) {
		if(driver.getTitle().equals(title)) {
			System.out.println("New Customer Page Opened");
		}else {
			System.out.println("We Got Some Ads");
			try {
				driver.get("https://demo.guru99.com/v4/manager/addcustomerpage.php");
			} catch (Exception e) {
			}
		}
	}
}
