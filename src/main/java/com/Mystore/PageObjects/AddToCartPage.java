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
public class AddToCartPage extends BaseClass {

	@FindBy(xpath = "//a[@id='color_14']")
	WebElement Colourcode;

	@FindBy(xpath = "//input[@id='quantity_wanted']")
	WebElement quantityField;

	@FindBy(xpath = "//select[@id='group_1']")
	WebElement sizeDropDown;

	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	WebElement AddToCartBtn;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[1]/h2[1]")
	WebElement productaddedToCartSuccessfullyText;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]")
	WebElement proceedToCheckOutBtn;

	public AddToCartPage() {
		PageFactory.initElements(driver, this);

	}

	public void clickOnColourBtn() {
		Action.click(driver, Colourcode);
	}

	public void enterQuantity(String qty) {
		Action.type(quantityField, qty);

	}

	public void selectSizefromDropDown(String size) {
		Action.selectByVisibleText(size, sizeDropDown);
	}

	public void clickOnAddToCartBtn() {
		Action.click(driver, AddToCartBtn);
	}

	public boolean validateproductaddedToCartSuccessfullyText() {

		// Action.implicitWait(driver, 10);
		Action.fluentWait(driver, productaddedToCartSuccessfullyText, 10);
		return Action.isDisplayed(driver, productaddedToCartSuccessfullyText);

	}

	public OrderPage clickOnproceedToCheckOutBtn() {
		Action.JSClick(driver, proceedToCheckOutBtn);
		Action.fluentWait(driver, proceedToCheckOutBtn, 10);
		return new OrderPage();
	}

}
