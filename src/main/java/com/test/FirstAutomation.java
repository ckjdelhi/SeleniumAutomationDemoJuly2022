package com.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstAutomation {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chand\\Desktop\\QA\\driver\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\chand\\Desktop\\QA\\driver\\geckodriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("http://demo.guru99.com/v4");
		driver.manage().window().maximize();
		driver.findElement(By.name("uid")).sendKeys("mgr123");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("mgr!23");
		try {
			driver.findElement(By.name("btnLogin")).submit();
		} catch (Exception e) {}
		
		//File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(file, new File("C:\\Users\\chand\\Desktop\\QA\\screenshot_homepage.jpg"));	
		
		driver.findElement(By.linkText("New Customer")).click();
		if(driver.getTitle().equals("Guru99 Bank New Customer Entry Page")) {
			System.out.println("New Customer Page Opened");
		}else {
			System.out.println("We Got Some Ads");
			try {
				driver.get("https://demo.guru99.com/v4/manager/addcustomerpage.php");
			} catch (Exception e) {
			}
		}
		
		driver.findElement(By.name("name")).sendKeys("Chandan Kumar");
		driver.findElements(By.name("rad1")).get(0).click();
		driver.findElement(By.id("dob")).sendKeys("01012000");
		
		try {
			driver.findElement(By.linkText("New Account")).click();
		} catch (Exception e) {
		}
		if(driver.getTitle().equals("Guru99 bank add new account")) {
			System.out.println("New Account Page Opened");
		}else {
			System.out.println("We Got Some Ads");
			try {
				driver.get("https://demo.guru99.com/v4/manager/addAccount.php");
			} catch (Exception e) {
			}
		}
		
		driver.findElement(By.name("cusid")).sendKeys("Ram");
		
		Select dropdown=new Select(driver.findElement(By.name("selaccount")));
		dropdown.selectByIndex(1);
		
		
	}

}
