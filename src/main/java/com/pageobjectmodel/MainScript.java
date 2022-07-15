package com.pageobjectmodel;

import org.openqa.selenium.support.PageFactory;
/*
 * java.lang.NullPointerException: Cannot invoke "org.openqa.selenium.SearchContext.findElement(org.openqa.selenium.By)" because "this.searchContext" is null
	at org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:70)
	at org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:39)
	at jdk.proxy2/jdk.proxy2.$Proxy9.sendKeys(Unknown Source)
	at com.TestPageObject.MainTest.main(MainTest.java:15)
 */
public class MainScript extends BaseScript{

	public static void main(String[] args) {
		
		/*Login Page Object*/
		LoginPageObject loginPage = PageFactory.initElements(driver, LoginPageObject.class);
		loginPage.setUserId("mgr123");
		loginPage.password.sendKeys("mgr!23");
		try {
			loginPage.loginButton.submit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*Home Page Object*/
		HomePageObject homePage=new HomePageObject(driver);
		homePage.setNewCustomer();
		
		System.out.println(driver.getCurrentUrl());
		checkAds("Guru99 Bank New Customer Entry Page");
		
		/*New Customer Page Object*/
		NewCustomerPageObject newCustomerPage = new NewCustomerPageObject(driver);
		newCustomerPage.customerName.sendKeys("Chandan Kumar");
		
	}

}
