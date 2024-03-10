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
public class SearchResultPage extends BaseClass {
	@FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]/img[1]")
	WebElement produtResult;

	public SearchResultPage() {
		PageFactory.initElements(driver, this);

	}

	public boolean isProductAvaiable() {
		return Action.isDisplayed(driver, produtResult);
	}

	public AddToCartPage clickOnProduct() {
		Action.click(driver, produtResult);
		return new AddToCartPage();
	}

}
