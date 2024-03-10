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
public class AddressPage extends BaseClass {

	@FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]")
	WebElement proceedToCheckOutBTN_OnAddressPage;

	public AddressPage() {
		PageFactory.initElements(driver, this);

	}

	public ShippingPage clickOnproceedToCheckOutBTN_OnAddressPage() {
		Action.click(driver, proceedToCheckOutBTN_OnAddressPage);
		return new ShippingPage();

	}

}
