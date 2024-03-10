/**
 * 
 */
package com.Mystore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mystore.Base.BaseClass;

/**
 * 
 */
public class OderConfirmationPage extends BaseClass {

	@FindBy(xpath = "//p[contains(text(),'Your order on My Shop is complete.')]")
	WebElement MyShopIsCompleteMeesageText;

	public OderConfirmationPage() {
		PageFactory.initElements(driver, this);

	}

	public String validateMyShopIsCompleteMeesageText() {
		String confirmmessage = MyShopIsCompleteMeesageText.getText();
		return confirmmessage;
	}

}
