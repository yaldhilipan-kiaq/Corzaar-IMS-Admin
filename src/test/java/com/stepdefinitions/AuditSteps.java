package com.stepdefinitions;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.AuditPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuditSteps extends BaseClass {

	AuditPage audit = new AuditPage(DeviceSessionManager.getDriver());

	@Given("User is on admin Controlcentre")
	public void user_is_on_admin_controlcentre() {

	}

	@When("User Click Audit Module")
	public void user_click_audit_module() {
		click(DeviceSessionManager.getDriver(), audit.audit);
	}

	@When("User Verifies Coupon is rejected")
	public void user_verifies_coupon_is_rejected() {
		visibilityWait(DeviceSessionManager.getDriver(), audit.rejected);
		String actual = audit.rejected.getText();
		String expected = "Coupon rejected";
		Assert.assertEquals(expected, actual);
	}

	@Then("user Verifies Coupon is approved")
	public void user_verifies_coupon_is_approved() {
		visibilityWait(DeviceSessionManager.getDriver(), audit.approved);
		String actual = audit.approved.getText();
		String expected = "Coupon approved";
		Assert.assertEquals(expected, actual);
	}
}
