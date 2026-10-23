package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AuditPage {

	public AndroidDriver driver;

	public AuditPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Audit\").instance(0)")
	public WebElement audit;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Coupon approved\")")
	public WebElement approved;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Coupon rejected\")")
	public WebElement rejected;
}
