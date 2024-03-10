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
public class PaymentPage extends BaseClass {

	@FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/p[1]/a[1]")
	WebElement payByBankWiremethod;

	public PaymentPage() {
		PageFactory.initElements(driver, this);

	}

	public OrderSummaryPage clickOnpayByBankWiremethodBtn() {
		Action.click(driver, payByBankWiremethod);
		return new OrderSummaryPage();
	}

}
