/**
 * 
 */
package com.Mystore.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Mystore.Base.BaseClass;
import com.Mystore.PageObjects.IndexPage;

/**
 * @author Name Kishore R K
 */
public class IndexPageTest extends BaseClass {

	public IndexPageTest() {

	}

	IndexPage indexpage;

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
	public void verifyLogo() throws Throwable {
		indexpage = new IndexPage();
		boolean result = indexpage.validateWebsiteLogog();
		Assert.assertTrue(result);
		Thread.sleep(10000);

	}

	@Test(groups = "Smoke")
	public void verifyTitle() throws Throwable {
		String actualTile = indexpage.getMyStoreTitle();
		Assert.assertEquals(actualTile, "My Shop");
		Thread.sleep(10000);

	}

}
