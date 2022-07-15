package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	
	@FindBy(name = "uid")
	private WebElement userId;
	
	@FindBy(xpath = "//*[@name='password']")
	public WebElement password;
	
	@FindBy(name = "btnLogin")
	public WebElement loginButton;
	
	@FindBy(name = "btnReset")
	public WebElement resetButton;
	
	public void setUserId(String userId) {
		this.userId.sendKeys(userId);
	}
	
	/*public LoginPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}*/
}
