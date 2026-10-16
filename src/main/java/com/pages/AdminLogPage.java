package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AdminLogPage {
	public AndroidDriver driver;

	public AdminLogPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign in\")")
	public WebElement SignIn;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Admin\")")
	public WebElement admin;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"auth-admin-email\")")
	public WebElement adminEmail;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"auth-admin-password\")")
	public WebElement adminPassword;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"auth-admin-login\")")
	public WebElement ContinueSecurelybutton;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"auth-admin-otp\")")
	public WebElement adminOtp;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Open admin portal\")")
	public WebElement OpenAdminportalbutton;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Verify admin access\")")
	public WebElement verifyAdminAccess;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"ADMIN CONTROL CENTER\")")
	public WebElement AdminControlCentre;

}
