package com.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	WebDriver driver = null;
	
	//@FindBy(linkText = "New Customer")
	public WebElement newCustomer;
	
	public void setNewCustomer() {
		this.newCustomer = this.findElement(By.linkText("New Customer"));
		this.newCustomer.click();
	}
	
	@FindBy(linkText = "Edit Customer")
	public WebElement editCustomer;
	
	@FindBy(linkText = "Delete Customer")
	public WebElement deleteCustomer;
	
	@FindBy(linkText = "New Account")
	public WebElement newAccount;
	
	public HomePageObject(WebDriver driver) {
		//PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	
	WebElement findElement(By by){
		return this.driver.findElement(by);
	}
}
