package com.Mystore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mystore.ActionDrivers.Action;
import com.Mystore.Base.BaseClass;

public class HomePage extends BaseClass {
	@FindBy(xpath = "//span[contains(text(),'Order history and details')]")
	WebElement OrderHistoryAndDetailsBtn;

	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	public String getCurrentURL() {
		String homePageURL = driver.getCurrentUrl();
		return homePageURL;

	}

	public boolean validateOrderHistoryAndDetailsBtn() {
		return Action.isDisplayed(driver, OrderHistoryAndDetailsBtn);
	}

}
