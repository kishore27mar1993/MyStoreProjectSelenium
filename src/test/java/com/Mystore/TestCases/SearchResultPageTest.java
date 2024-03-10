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
import com.Mystore.PageObjects.HomePage;
import com.Mystore.PageObjects.IndexPage;
import com.Mystore.PageObjects.LoginPage;
import com.Mystore.PageObjects.SearchResultPage;

/**
 * 
 */
public class SearchResultPageTest extends BaseClass {
	AccountCreationPage accCreationPGE;
	IndexPage indexpage;
	HomePage homePGE;
	LoginPage loginPGE;
	SearchResultPage srchPGE;

	@BeforeMethod(groups = { "Regression", "Sanity", "Smoke" })
	public void setup() throws InterruptedException {
		launchApp();
		driver.manage().window().maximize();
		Thread.sleep(20000);

	}

	@AfterMethod(groups = { "Regression", "Sanity", "Smoke" })
	public void tearDown() {
		driver.quit();

	}

	@Test(groups = "Smoke")
	public void productAvailabilityTest() throws Throwable {
		indexpage = new IndexPage();
		srchPGE = indexpage.searchProduct("t-shirt");
		boolean result = srchPGE.isProductAvaiable();
		Assert.assertTrue(result);

	}

}
