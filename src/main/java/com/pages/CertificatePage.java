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
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Refresh\").instance(1)")
	public WebElement refresh;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Refunds\")")
	public WebElement refund;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Certificates\")")
	public WebElement certificate;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'37')]")
	public WebElement revokeCount;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'revoked')]")
	public WebElement revokedCertificatestotal;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Payouts\")")
	public WebElement payout;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Audit\")")
	public WebElement audit;
	
	@AndroidFindBy(xpath = "//*[@text='Audit']")
	public WebElement auditModule;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[starts-with(@resource-id,'a-tab')]")
	public WebElement tabRow;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"No certificates found\")")
	public WebElement noCertificateMessage;
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[18]")
	public WebElement revokedCardCount;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='revoked']")
	public WebElement revokedStatus;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'CZ-CERT-')]")
	public WebElement certID;
	@AndroidFindBy(xpath = "./ancestor::android.view.ViewGroup[.//android.widget.TextView[contains(@text,'CERT-')]][1]"+ "//android.widget.TextView[contains(@text,'CERT-')]\"")
	public WebElement rowID;
	
	
	//android.widget.TextView[@text='Revoked']/preceding-sibling::android.widget.TextView[15]
}
