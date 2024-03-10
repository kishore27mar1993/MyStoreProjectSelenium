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
import com.Mystore.PageObjects.AddressPage;
import com.Mystore.PageObjects.HomePage;
import com.Mystore.PageObjects.IndexPage;
import com.Mystore.PageObjects.LoginPage;
import com.Mystore.PageObjects.OderConfirmationPage;
import com.Mystore.PageObjects.OrderPage;
import com.Mystore.PageObjects.OrderSummaryPage;
import com.Mystore.PageObjects.PaymentPage;
import com.Mystore.PageObjects.SearchResultPage;
import com.Mystore.PageObjects.ShippingPage;

/**
 * 
 */
public class EndToEndTest extends BaseClass {

	AccountCreationPage accCreationPGE;
	IndexPage indexpage;
	HomePage homePGE;
	LoginPage loginPGE;
	SearchResultPage srchPGE;
	AddToCartPage addToCartPGE;
	OrderPage orderPGE;
	ShippingPage shippingPGE;
	AddressPage adressPGE;
	PaymentPage paymentpge;
	OrderSummaryPage ordersummarryPGE;
	OderConfirmationPage orderconfirmationPGE;

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
	public void EndToEndTest() throws Throwable {
		indexpage = new IndexPage();
		srchPGE = indexpage.searchProduct("t-shirts");
		addToCartPGE = srchPGE.clickOnProduct();
		addToCartPGE.clickOnColourBtn();
		addToCartPGE.enterQuantity("2");
		addToCartPGE.selectSizefromDropDown("L");
		Thread.sleep(5000);
		addToCartPGE.clickOnAddToCartBtn();
		Thread.sleep(3000);
		orderPGE = addToCartPGE.clickOnproceedToCheckOutBtn();
		// Thread.sleep(5000);
		loginPGE = orderPGE.clickOnproceedtToCheckOutBtn();
		// Thread.sleep(5000);
		adressPGE = loginPGE.Login1(prop.getProperty("username"), prop.getProperty("password"));
		// Thread.sleep(5000);
		shippingPGE = adressPGE.clickOnproceedToCheckOutBTN_OnAddressPage();
		// Thread.sleep(5000);
		shippingPGE.clickonTermsOfServices();
		// Thread.sleep(5000);
		paymentpge = shippingPGE.clickOnProceedToCheckoutOnShippingModue();
		// Thread.sleep(5000);
		ordersummarryPGE = paymentpge.clickOnpayByBankWiremethodBtn();
		// Thread.sleep(5000);
		orderconfirmationPGE = ordersummarryPGE.clickOnIConfirmMyOrderBTNOnORDERSUMMARY_BTN();
		// Thread.sleep(5000);
		String actualMessage = orderconfirmationPGE.validateMyShopIsCompleteMeesageText();
		// Thread.sleep(5000);
		String expectedMessage = "Your order on My Shop is complete.";
		// Thread.sleep(5000);
		Assert.assertEquals(actualMessage, expectedMessage);

	}

}
