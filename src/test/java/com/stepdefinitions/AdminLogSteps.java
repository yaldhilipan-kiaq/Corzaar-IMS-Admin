package com.stepdefinitions;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.AdminLogPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminLogSteps extends BaseClass {

	AdminLogPage log = new AdminLogPage(DeviceSessionManager.getDriver());

	// EMAIL
	// PASSWORD----------------------------------------------------------------------
	@Given("The Corzaar application is launched")
	public void the_corzaar_application_is_launched() {
		relaunchApp(DeviceSessionManager.getDriver());
	}

	@When("User Taps the  Sign In button")
	public void user_taps_the_sign_in_button() {
		click(DeviceSessionManager.getDriver(), log.SignIn);
	}

	@When("User Switches to Admin Portal")
	public void user_switches_to_admin_portal() {
		click(DeviceSessionManager.getDriver(), log.admin);
	}

	@When("User enters Admin Email {string}")
	public void user_enters_admin_email(String string) {
		sendKeys(DeviceSessionManager.getDriver(), log.adminEmail, string);
	}

	@When("User enters Admin Password {string}")
	public void user_enters_admin_password(String string) {
		sendKeys(DeviceSessionManager.getDriver(), log.adminPassword, string);
	}

	@When("user taps Continue securely button")
	public void user_taps_continue_securely_button() {
//		clickableWait(DeviceSessionManager.getDriver(), log.ContinueSecurelybutton);
		boolean enabled = log.ContinueSecurelybutton.isEnabled();
		Assert.assertTrue("button is Enabled", enabled);

		tapUpperPart(DeviceSessionManager.getDriver(), log.ContinueSecurelybutton);
	}

	@Then("User Should be on the {string}")
	public void user_should_be_on_the(String string) {

	}

	// OTP
	// PAGE----------------------------------------------------------------------------

	@Given("User is on the OTP Verification Page")
	public void user_is_on_the_otp_verification_page() {
		visibilityWait(DeviceSessionManager.getDriver(), log.verifyAdminAccess);
		String actual = log.verifyAdminAccess.getText();
		String expected = "Verify admin access";
		Assert.assertEquals(expected, actual);
	}

	@When("User enters the OTP number {string}")
	public void user_enters_the_otp_number(String string) {
		otpSendKeys(DeviceSessionManager.getDriver(), log.adminOtp, string);
	}

	@When("User clicks the open admin portal button")
	public void user_clicks_the_open_admin_portal_button() {
		/// clickableWait(DeviceSessionManager.getDriver(), log.OpenAdminportalbutton);
		boolean enabled = log.OpenAdminportalbutton.isEnabled();
		Assert.assertTrue("button is Enabled", enabled);

		click(DeviceSessionManager.getDriver(), log.OpenAdminportalbutton);
	}

	@Then("User should be on  {string}")
	public void user_should_be_on(String string) {

	}
//	visibilityWait(DeviceSessionManager.getDriver(), log.admin);
//	String actual = log.admin.getText();
//	String expected = "Admin";
//	Assert.assertEquals(expected, actual);

//	visibilityWait(DeviceSessionManager.getDriver(), log.AdminControlCentre);
//	String actual = log.AdminControlCentre.getText();
//	String expected = "ADMIN CONTROL CENTER";
//	Assert.assertEquals(expected, actual);

}
