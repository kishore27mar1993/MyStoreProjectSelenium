package com.Mystore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mystore.ActionDrivers.Action;
import com.Mystore.Base.BaseClass;

public class IndexPage extends BaseClass {
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signInBtn;

	@FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[1]/a[1]/img[1]")
	WebElement websiteLogo;

	@FindBy(xpath = "//input[@id='search_query_top']")
	WebElement searchFiled;

	@FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")
	WebElement searchProdutBtnIcon;

	public IndexPage() {
		PageFactory.initElements(driver, this);

	}

	public LoginPage clickOnSignIn() throws Throwable {
		Action.click(driver, signInBtn);
		return new LoginPage();

	}

	public boolean validateWebsiteLogog() throws Throwable {
		return Action.isDisplayed(driver, websiteLogo);

	}

	public String getMyStoreTitle() throws Throwable {
		String getMyStore_Title = driver.getTitle();
		return getMyStore_Title;
	}

	public SearchResultPage searchProduct(String productName) throws Throwable {
		Action.type(searchFiled, productName);
		Action.click(driver, searchProdutBtnIcon);
		return new SearchResultPage();

	}

}
