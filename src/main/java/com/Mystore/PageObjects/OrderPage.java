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
public class OrderPage extends BaseClass {

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[4]/ul[1]/li[1]")
	WebElement UnitPrice;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tfoot[1]/tr[5]/td[2]/span[1]")
	WebElement TotalAmount;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]/span[1]")
	WebElement proceedtToCheckOutBtn;

	public OrderPage() {
		PageFactory.initElements(driver, this);

	}

	public double getUnitPrice() {
		String unitPriceValue = UnitPrice.getText();
		// below function or methods replaces if there are any special symbols or
		// characters present in a value
		String rectifiedunitPriceValue = unitPriceValue.replaceAll("[^a-zA-Z0-9]", "");
		double final_rectifiedunitPriceValue = Double.parseDouble(rectifiedunitPriceValue);
		return final_rectifiedunitPriceValue / 100;

	}

	public double getTotalAmountPrice() {
		String TotalAmountvalue = TotalAmount.getText();
		String rectifiedunitTotalAmountvalue = TotalAmountvalue.replaceAll("[^a-zA-Z0-9]", "");
		double final_rectifiedunitTotalAmountvalue = Double.parseDouble(rectifiedunitTotalAmountvalue);
		return final_rectifiedunitTotalAmountvalue / 100;

	}

	public LoginPage clickOnproceedtToCheckOutBtn() {
		Action.click(driver, proceedtToCheckOutBtn);
		return new LoginPage();
	}

}
