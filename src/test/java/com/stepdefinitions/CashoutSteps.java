package com.stepdefinitions;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.CashoutPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CashoutSteps extends BaseClass {

	CashoutPage cash = new CashoutPage(DeviceSessionManager.getDriver());

	@Given("User is on Admin Control Centre")
	public void user_is_on_admin_control_centre() {

	}

	@When("User Click Cashout Module")
	public void user_click_cashout_module() {
		click(DeviceSessionManager.getDriver(), cash.Cashout);
	}

	@Then("No Cashout message should be displayed")
	public void no_cashout_message_should_be_displayed() {
		// MobileswipeUp(DeviceSessionManager.getDriver());

		visibilityWait(DeviceSessionManager.getDriver(), cash.cashOuttext);
		String actual = cash.cashOuttext.getText();
		String expected = "No cashouts to process";
		Assert.assertEquals(expected, actual);
	}
}
