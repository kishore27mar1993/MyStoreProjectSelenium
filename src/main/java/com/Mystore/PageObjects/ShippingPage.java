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
public class ShippingPage extends BaseClass {

	@FindBy(xpath = "//input[@id='cgv']")
	WebElement checkBoxTermsOfServices;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/p[1]/button[1]/span[1]")
	WebElement ProceedToCheckoutOnShippingModue;

	public ShippingPage() {
		PageFactory.initElements(driver, this);

	}

	public void clickonTermsOfServices() {
		Action.click(driver, checkBoxTermsOfServices);

	}

	public PaymentPage clickOnProceedToCheckoutOnShippingModue() {
		Action.click(driver, ProceedToCheckoutOnShippingModue);
		return new PaymentPage();
	}

}
