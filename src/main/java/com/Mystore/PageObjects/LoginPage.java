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
 * @author name Kishore R K
 */
public class LoginPage extends BaseClass {

	@FindBy(xpath = "//input[@id='email']")
	WebElement enterEmailAddressField;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement enterPasswordField;

	@FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/p[2]/button[1]/span[1]")
	WebElement signInBtn;

	@FindBy(xpath = "//input[@id='email_create']")
	WebElement createAccountemailAddressFiled;

	@FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/button[1]/span[1]")
	WebElement createAccountButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	public HomePage Login(String uname, String pwd) {
		Action.type(enterEmailAddressField, uname);
		Action.type(enterPasswordField, pwd);
		Action.click(driver, signInBtn);
		return new HomePage();
	}

	public AddressPage Login1(String uname, String pwd) {
		Action.type(enterEmailAddressField, uname);
		Action.type(enterPasswordField, pwd);
		Action.click(driver, signInBtn);
		return new AddressPage();
	}

	public AddressPage LoginviaSHOPPING_CART_SUMMARY(String uname, String pwd) {
		Action.type(enterEmailAddressField, uname);
		Action.type(enterPasswordField, pwd);
		Action.click(driver, signInBtn);
		return new AddressPage();
	}

	public AccountCreationPage CreateNewAccount(String newEmail) {
		Action.type(createAccountemailAddressFiled, newEmail);
		Action.click(driver, createAccountButton);
		return new AccountCreationPage();

	}
}
