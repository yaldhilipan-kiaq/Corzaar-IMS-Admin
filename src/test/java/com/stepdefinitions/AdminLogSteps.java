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

	// INVALID EMAIL/VALID PASSWORD

	@Given("The Corzaar application is launched")
	public void the_corzaar_application_is_launched() {

	}

	@When("User Taps the  Sign In button")
	public void user_taps_the_sign_in_button() {
		click(DeviceSessionManager.getDriver(), log.SignIn);
	}

	@When("User Switches to Admin Portal")
	public void user_switches_to_admin_portal() {
		click(DeviceSessionManager.getDriver(), log.admin);
	}

	@When("User enters  InvalidEmail ID in the required field")
	public void user_enters_invalid_email_id_in_the_required_field() {
		sendKeys(DeviceSessionManager.getDriver(), log.adminEmail, "admin@corzaar");
	}

	@When("User enters  Valid Password in the required field")
	public void user_enters_valid_password_in_the_required_field() {
		sendKeys(DeviceSessionManager.getDriver(), log.adminPassword, "Admin@123");
	}

	@When("User taps Continue Securely button to verify")
	public void user_taps_continue_securely_button_to_verify() {
		clickableWait(DeviceSessionManager.getDriver(), log.ContinueSecurelybutton);
		boolean enabled = log.ContinueSecurelybutton.isEnabled();
		Assert.assertTrue("button is Enabled", enabled);

		tapUpperPart(DeviceSessionManager.getDriver(), log.ContinueSecurelybutton);
	}

	@Then("User should remain on the Admin Login Page")
	public void user_should_remain_on_the_admin_login_page() {
		visibilityWait(DeviceSessionManager.getDriver(), log.admin);
		String actual = log.admin.getText();
		String expected = "Admin";
		Assert.assertEquals(expected, actual);

	}
// VALID EMAIL / INVALID PASSWORD----------------------------------------------------------

	@Given("User enters Valid Email in the required field")
	public void user_enters_valid_email_in_the_required_field() {
		sendKeys(DeviceSessionManager.getDriver(), log.adminEmail, "admin@corzaar.com");
	}

	@When("User enters  InValid Password in the required field")
	public void user_enters_in_valid_password_in_the_required_field() {
		sendKeys(DeviceSessionManager.getDriver(), log.adminPassword, "Admin");
	}

	@When("User taps Continue Securely button")
	public void user_taps_continue_securely_button() {
		clickableWait(DeviceSessionManager.getDriver(), log.ContinueSecurelybutton);
		boolean enabled = log.ContinueSecurelybutton.isEnabled();
		Assert.assertTrue("button is Enabled", enabled);

		tapUpperPart(DeviceSessionManager.getDriver(), log.ContinueSecurelybutton);
	}

	@Then("User should not able to naviagte to OTP verification page")
	public void user_should_not_able_to_naviagte_to_otp_verification_page() {
		visibilityWait(DeviceSessionManager.getDriver(), log.admin);
		String actual = log.admin.getText();
		String expected = "Admin";
		Assert.assertEquals(expected, actual);
	}

	// VALID EMAIL / VALID PASSWORD-----------------------------------------------

	@Given("User enters the  Valid Email in the required field")
	public void user_enters_the_valid_email_in_the_required_field() {
		sendKeys(DeviceSessionManager.getDriver(), log.adminEmail, "admin@corzaar.com");
	}

	@When("User enters the  Valid Password in the required field")
	public void user_enters_the_valid_password_in_the_required_field() {
		sendKeys(DeviceSessionManager.getDriver(), log.adminPassword, "Admin@123");
	}

	@When("User taps Continue Securely button for admin access")
	public void user_taps_continue_securely_button_for_admin_access() {

		tapUpperPart(DeviceSessionManager.getDriver(), log.ContinueSecurelybutton);
	}

	@Then("User should naviagtes to OTP verification Page")
	public void user_should_naviagtes_to_otp_verification_page() {
		visibilityWait(DeviceSessionManager.getDriver(), log.verifyAdminAccess);
		String actual = log.verifyAdminAccess.getText();
		String expected = "Verify admin access";
		Assert.assertEquals(expected, actual);

	}

	// INVALID OTP
	// --------------------------------------------------------------------
	@Given("User is on Admin Access Page")
	public void user_is_on_admin_access_page() {

	}

	@When("User enters Invalid OTP in required field")
	public void user_enters_invalid_otp_in_required_field() {
		otpSendKeys(DeviceSessionManager.getDriver(), log.adminOtp, "123");
	}

	@When("User taps Open Admin Portal button")
	public void user_taps_open_admin_portal_button() {
		/// clickableWait(DeviceSessionManager.getDriver(), log.OpenAdminportalbutton);
		boolean enabled = log.OpenAdminportalbutton.isEnabled();
		Assert.assertTrue("button is Enabled", enabled);

		click(DeviceSessionManager.getDriver(), log.OpenAdminportalbutton);
	}

	@Then("User should remain on the Verify access page")
	public void user_should_remain_on_the_verify_access_page() {
		visibilityWait(DeviceSessionManager.getDriver(), log.verifyAdminAccess);
		String actual = log.verifyAdminAccess.getText();
		String expected = "Verify admin access";
		Assert.assertEquals(expected, actual);
	}
//VALID OTP ------------------------------------------------------------------------

	@Given("User enters valid OTP in required field")
	public void user_enters_valid_otp_in_required_field() {
		otpSendKeys(DeviceSessionManager.getDriver(), log.adminOtp, "123456");
	}

	@When("User taps Open Admin Portal button for successful login")
	public void user_taps_open_admin_portal_button_for_successful_login() {
		click(DeviceSessionManager.getDriver(), log.OpenAdminportalbutton);
	}

	@Then("User should navigates to Admin Control Centre")
	public void user_should_navigates_to_admin_control_centre() {
		visibilityWait(DeviceSessionManager.getDriver(), log.AdminControlCentre);
		String actual = log.AdminControlCentre.getText();
		String expected = "ADMIN CONTROL CENTER";
		Assert.assertEquals(expected, actual);
	}

}
