/**
 * 
 */
package com.Mystore.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Mystore.Base.BaseClass;
import com.Mystore.PageObjects.AccountCreationPage;
import com.Mystore.PageObjects.AddToCartPage;
import com.Mystore.PageObjects.HomePage;
import com.Mystore.PageObjects.IndexPage;
import com.Mystore.PageObjects.LoginPage;
import com.Mystore.PageObjects.OrderPage;
import com.Mystore.PageObjects.SearchResultPage;

/**
 * 
 */
public class OrderPageTest extends BaseClass {
	AccountCreationPage accCreationPGE;
	IndexPage indexpage;
	HomePage homePGE;
	LoginPage loginPGE;
	SearchResultPage srchPGE;
	AddToCartPage addToCartPGE;
	OrderPage orderPGE;

	@BeforeMethod(groups = { "Regression", "Sanity", "Smoke" })
	public void setup() throws InterruptedException {
		launchApp();
		driver.manage().window().maximize();
		Thread.sleep(5000);

	}

	@AfterMethod(groups = { "Regression", "Sanity", "Smoke" })
	public void tearDown() {
		driver.quit();

	}

	@Test(groups = "Regression")
	public void validateTotalPrice() throws Throwable {
		indexpage = new IndexPage();
		srchPGE = indexpage.searchProduct("t-shirts");
		addToCartPGE = srchPGE.clickOnProduct();
		addToCartPGE.clickOnColourBtn();
		addToCartPGE.enterQuantity("2");
		addToCartPGE.selectSizefromDropDown("L");
		addToCartPGE.clickOnAddToCartBtn();
		orderPGE = addToCartPGE.clickOnproceedToCheckOutBtn();
		double unitvalueresult = orderPGE.getUnitPrice();
		double totalvalueresult = orderPGE.getTotalAmountPrice();
		double totalExpectedFinal = (unitvalueresult * 2) + 2;
		Assert.assertEquals(totalvalueresult, totalExpectedFinal);
		loginPGE = orderPGE.clickOnproceedtToCheckOutBtn();
		Thread.sleep(10000);

	}

}
