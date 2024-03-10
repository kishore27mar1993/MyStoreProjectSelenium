/**
 * 
 */
package com.Mystore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mystore.ActionDrivers.Action;
import com.Mystore.Base.BaseClass;

/**
 * 
 */
public class AccountCreationPage extends BaseClass {
	@FindBy(xpath = "//h1[contains(text(),'Create an account')]")
	WebElement CreateAnAccountHeader;

	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateCreateAnAccountHeader() {
		return Action.isDisplayed(driver, CreateAnAccountHeader);

	}

	public void validateCreateAnAccountHeaderText(String createAccountText) {
		if (createAccountText == CreateAnAccountHeader.getText()) {
			System.out.println("Create An Account Page is displayed");
		}
	}
}
