package com.stepdefinitions;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.AuditPage;
import com.pages.PayoutPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PayoutSteps extends BaseClass {

	PayoutPage payout = new PayoutPage(DeviceSessionManager.getDriver());

	@Given("User is on Admin Control Centre page")
	public void user_is_on_admin_control_centre_page() {

	}

	@When("User Click Payout Module")
	public void user_click_payout_module() {
		click(DeviceSessionManager.getDriver(), payout.payouts);
	}

	@Then("User Verifies the payout is settled")
	public void user_verifies_the_payout_is_settled() {
		visibilityWait(DeviceSessionManager.getDriver(), payout.payoutsSettled);
		String actual = payout.payoutsSettled.getText();
		String expected = "Settled";
		Assert.assertEquals(expected, actual);
	}

}
