package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PayoutPage {

	public AndroidDriver driver;

	public PayoutPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Payouts\").instance(0)")
	public WebElement payouts;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Settled\").instance(0)")
	public WebElement payoutsSettled;
}
