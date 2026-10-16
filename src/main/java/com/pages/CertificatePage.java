package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CertificatePage {

	public AndroidDriver driver;

	public CertificatePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"a-tab-Certificates\")")
	public WebElement CertificateModule;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"admin-cert-search\")")
	public WebElement Search;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement SearchSymbol;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"NEW STUDENT  · Selenium Automation Testing\")")
	public WebElement studentName;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Revoke certificate\")")
	public WebElement revokeButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"CZ-CERT-22B0538E\")")
	public WebElement CertificateID;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"New learner · Digital Marketing Sprint\")")
	public WebElement Course;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"No certificates found\")")
	public WebElement noCertificateMessage;
}
