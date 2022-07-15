package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPageObject {
	public EditCustomerPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
