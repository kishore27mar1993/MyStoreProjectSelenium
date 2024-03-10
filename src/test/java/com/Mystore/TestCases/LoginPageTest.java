/**
 * 
 */
package com.Mystore.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Mystore.Base.BaseClass;
import com.Mystore.PageObjects.HomePage;
import com.Mystore.PageObjects.IndexPage;
import com.Mystore.PageObjects.LoginPage;
import com.Mystore.utility.Log;

/**
 * 
 */
public class LoginPageTest extends BaseClass {
	IndexPage indexpage;
	LoginPage loginPGE;
	HomePage homePGE;

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

	// @Test(dataProvider = "credentials", dataProviderClass = DataProvider.class)
	@Test(dataProvider = "credentials", dataProviderClass = com.Mystore.dataProvider.DataProviders.class, groups = {
			"Smoke", "Sanity" })

	public void LoginTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("LoginTest");
		indexpage = new IndexPage();
		Log.info("user is now going to click on Sign In Button");
		loginPGE = indexpage.clickOnSignIn();
		Log.info("user is now going to enter username and password");
		// homePGE = loginPGE.Login(prop.getProperty("username"),
		// prop.getProperty("password"));
		homePGE = loginPGE.Login(uname, pswd);
		String actualhomePGEURL = homePGE.getCurrentURL();
		String ExpectedHomePGEURL = "http://www.automationpractice.pl/index.php?controller=my-account";
		Log.info("verifying if user is able to login");
		Assert.assertEquals(actualhomePGEURL, ExpectedHomePGEURL);
		Log.info("login is successful");
		Log.endTestCase("LoginTest");
	}

}
