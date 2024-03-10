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

/**
 * 
 */
public class AccountCreationTest extends BaseClass {
	AccountCreationPage accCreationPGE;
	IndexPage indexpage;
	HomePage homePGE;
	LoginPage loginPGE;

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

	@Test(groups = "Sanity")
	public void verifyCreateAccountPGETest() throws Throwable {
		indexpage = new IndexPage();
		loginPGE = indexpage.clickOnSignIn();
		accCreationPGE = loginPGE.CreateNewAccount("asdfgh@qwerty.com");
		boolean result = accCreationPGE.validateCreateAnAccountHeader();
		Assert.assertTrue(result);
		accCreationPGE.validateCreateAnAccountHeaderText("Create An Account");

	}
}
