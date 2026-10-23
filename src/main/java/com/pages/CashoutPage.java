package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CashoutPage {

	public AndroidDriver driver;

	public CashoutPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Cashouts\")")
	public WebElement Cashout;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"No cashouts to process\")")
	public WebElement cashOuttext;

}
