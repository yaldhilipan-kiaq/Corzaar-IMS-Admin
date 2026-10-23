package com.stepdefinitions;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.CertificatePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CertificateSteps extends BaseClass {

	CertificatePage cert = new CertificatePage(DeviceSessionManager.getDriver());

	// STUDENT NAME

	@Given("User is on Admin Control Centre Page")
	public void user_is_on_admin_control_centre_page() {

	}

	@When("User navigates to Certificate module")
	public void user_navigates_to_certificate_module() {
		swipeUntillVisible(DeviceSessionManager.getDriver(), cert.auditModule, cert.tabRow);

		click(DeviceSessionManager.getDriver(), cert.CertificateModule);
	}

	@When("User Search Certificate by student name")
	public void user_search_certificate_by_student_name() {
		MobileswipeUp(DeviceSessionManager.getDriver());
		visibilityWait(DeviceSessionManager.getDriver(), cert.Search);
		sendKeys(DeviceSessionManager.getDriver(), cert.Search, "NEW STUDENT");
	}

	@When("User Verifies the Revoke Certificate button")
	public void user_verifies_the_revoke_certificate_button() {
		clickableWait(DeviceSessionManager.getDriver(), cert.revokeButton);
		boolean enabled = cert.revokeButton.isEnabled();
		Assert.assertTrue("button is Enabled", enabled);
	}

	@Then("Certificate is displayed for the respected student")
	public void certificate_is_displayed_for_the_respected_student() {
		visibilityWait(DeviceSessionManager.getDriver(), cert.studentName);
		String actual = cert.studentName.getText();
		String expected = "NEW STUDENT  · Selenium Automation Testing";
		Assert.assertEquals(expected, actual);
	}

	// INVALID CERTIFICATE ID
	// ---------------------------------------------------------------------

	@Given("User Search Certificate by Invalid certificate ID")
	public void user_search_certificate_by_invalid_certificate_id() {
		sendKeys(DeviceSessionManager.getDriver(), cert.Search, "CZ-CERT-0000000");
	}

	@Then("No certificates found for Invalid Certificate ID")
	public void no_certificates_found_for_invalid_certificate_id() {
		visibilityWait(DeviceSessionManager.getDriver(), cert.noCertificateMessage);
		String actual = cert.noCertificateMessage.getText();
		String expected = "No certificates found";
		Assert.assertEquals(expected, actual);
	}

	// VALID CERTIFICATE ID
	// ---------------------------------------------------------------------

	@Given("User Search Certificate by certificate ID")
	public void user_search_certificate_by_certificate_id() {
		sendKeys(DeviceSessionManager.getDriver(), cert.Search, "CZ-CERT-22B0538E");
	}

	@Then("Certificate is displayed for the respected ID")
	public void certificate_is_displayed_for_the_respected_id() {
		visibilityWait(DeviceSessionManager.getDriver(), cert.CertificateID);
		String actual = cert.CertificateID.getText();
		String expected = "CZ-CERT-22B0538E";
		Assert.assertEquals(expected, actual);
	}

//INVALID COURSE------------------------------------------------------------------------

	@Given("User Search Certificate by Invalid course name")
	public void user_search_certificate_by_invalid_course_name() {
		sendKeys(DeviceSessionManager.getDriver(), cert.Search, "Gaming");
	}

	@Then("No certificates found for Invalid course name")
	public void no_certificates_found_for_invalid_course_name() {
		visibilityWait(DeviceSessionManager.getDriver(), cert.noCertificateMessage);
		String actual = cert.noCertificateMessage.getText();
		String expected = "No certificates found";
		Assert.assertEquals(expected, actual);
	}

// VALID COURSE -------------------------------------------------------------------------
	@Given("User Search Certificate by course name")
	public void user_search_certificate_by_course_name() {
		sendKeys(DeviceSessionManager.getDriver(), cert.Search, "Digital Marketing Sprint");
	}

	@Then("Certificate is displayed for the respected Course")
	public void certificate_is_displayed_for_the_respected_course() {
		visibilityWait(DeviceSessionManager.getDriver(), cert.Course);
		String actual = cert.Course.getText();
		String expected = "New learner · Digital Marketing Sprint";
		Assert.assertEquals(expected, actual);
	}
	//------------------------------------------------------------------------------------
	
	@Given("User is on Certificates page")
	public void user_is_on_certificates_page() {

	}

	@When("User verifies Revoked certificates")
	public void user_verifies_revoked_certificates() {
	    String revokedcertificates = cert.revokeCount.getText();
	}

	@Then("User verifies the Total revoked certificate count")
	public void user_verifies_the_total_revoked_certificate_count() {
	
	}
	//public int[] countRowsBySwiping() {
//	    Set<String> all = new HashSet<>();
//	    Set<String> revoked = new HashSet<>();
//	    int noNew = 0;
//	    for (int i = 0; i < 200 && noNew < 2; i++) { 
//	        int before = all.size();
//	        By driver = null;
//			for (WebElement e : driver.findElements(cert.certID)) {
//	            try { all.add(e.getText().trim()); } catch (StaleElementReferenceException ignored) { }
//	        }
//	        for (WebElement s : driver.findElements(cert.revokedStatus)) {
//	            try { revoked.add(s.findElement(By.xpath(cert.toString())).getText().trim()); }
//	            catch (StaleElementReferenceException ignored) { }
//	        }
//	        noNew = (all.size() == before) ? noNew + 1 : 0;
//	        MobileswipeUp(DeviceSessionManager.getDriver());
//	    }
//	    return new int[]{all.size(), revoked.size()};
//	}

}


