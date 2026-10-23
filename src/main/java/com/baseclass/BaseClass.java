package com.baseclass;

import java.awt.Rectangle;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

	private static final Duration TIMEOUT = Duration.ofSeconds(60);

	public static void click(AndroidDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

		wait.until(ExpectedConditions.elementToBeClickable(element));

		element.click();
	}

	public static void relaunchApp(AndroidDriver driver) {
		driver.terminateApp("com.corzaar.app");
		driver.activateApp("com.corzaar.app");
	}

	public static void sendKeys(AndroidDriver driver, WebElement element, String text) {

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

		wait.until(ExpectedConditions.visibilityOf(element));

		element.clear();// element.click();
		element.sendKeys(text);
		driver.hideKeyboard();
	}

	public static void otpSendKeys(AndroidDriver driver, WebElement element, String text) {

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

		wait.until(ExpectedConditions.visibilityOf(element));

		element.clear();// element.click();
		element.sendKeys(text);

	}

	public static boolean displayed(AndroidDriver driver, WebElement element) {

		return element.isDisplayed();
	}

	public static void visibilityWait(AndroidDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void clickableWait(AndroidDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void swipeUp(AndroidDriver driver) {

		driver.executeScript("mobile: swipeGesture",
				Map.of("left", 100, "top", 300, "width", 800, "height", 1000, "direction", "up", "percent", 0.75));
	}

	public static void swipeDown(AndroidDriver driver) {

		driver.executeScript("mobile: scrollGesture",
				Map.of("left", 100, "top", 400, "width", 800, "height", 1400, "direction", "down", "percent", 0.9));
	}

	public static void MobileswipeUp(AndroidDriver driver) {

		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int x = size.width / 2;
		int startY = (int) (size.height * 0.75);
		int endY = (int) (size.height * 0.20);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, startY));
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), x, endY));
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Collections.singletonList(swipe));

	}

	public static void swipeUntillVisible(AndroidDriver driver, WebElement element, WebElement tabRow) {

		for (int i = 0; i < 6 && !isShown(element); i++) {
			swipeLeft(driver, tabRow);
		}
	}

	public static boolean isShown(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public static void MobileswipeDown(AndroidDriver driver) {

		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int left = size.width / 10;
		int top = size.height / 4;
		int width = size.width * 8 / 10;
		int height = size.height / 2;

		driver.executeScript("mobile: scrollGesture",
				Map.of("left", left, "top", top, "width", width, "height", height, "direction", "up", "percent", 1.5));
	}

	public void scrollToElementByText(AndroidDriver driver, String text) {

		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"

				+ ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
	}

	public void tapUpperPart(AndroidDriver driver, WebElement element) {
		org.openqa.selenium.Rectangle rect = element.getRect();
		int x = rect.getX() + (rect.getWidth() / 2);
		int y = rect.getY() + (int) (rect.getHeight() * 0.30);
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence tap = new Sequence(finger, 1);
		tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
		tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Collections.singletonList(tap));

	}

	public static void swipeLeft(AndroidDriver driver, WebElement tabRow) {

		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int y = tabRow.getLocation().getY() + tabRow.getSize().getHeight() / 2;
		int startX = (int) (size.width * 0.80);
		int endX = (int) (size.width * 0.20);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, y));
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(List.of(swipe));
	}

	public static void swipeabove(AndroidDriver driver) {

		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("left", (int) (width * 0.15));
		params.put("top", (int) (height * 0.40));
		params.put("width", (int) (width * 0.70));
		params.put("height", (int) (height * 0.40));
		params.put("direction", "up");
		params.put("percent", 0.50);

		driver.executeScript("mobile: swipeGesture", params);
	}

	public void ScrollLeft(AndroidDriver driver) {

		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int y = (int) (size.getHeight() * 0.42);
		int startX = (int) (size.getWidth() * 0.85);
		int endX = (int) (size.getWidth() * 0.15);
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), endX, y));
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		java.util.List<Sequence> actions = new ArrayList<>();
		actions.add(swipe);
		driver.perform(actions);
	}

	public void scrollUntilvisible(AndroidDriver driver, WebElement element) {
		int screenWWidth = driver.manage().window().getSize().getWidth();
		System.out.println("Screen Width: " + screenWWidth);
		for (int i = 0; i < 10; i++) {

			try {
				org.openqa.selenium.Rectangle rect = element.getRect();
				System.out.println("Try " + i + "-> X=" + rect.getX() + "width=" + rect.getWidth());
				int centerX = rect.getX() + rect.getWidth() / 2;
				if (centerX > 0 && centerX < screenWWidth) {
					return;

				}
			} catch (Exception e) {
				System.out.println("Try" + i + "-> Not found: " + e.getClass().getSimpleName());
			}
			ScrollLeft(driver);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ignored) {

			}
			throw new NoSuchElementException("Category not visible after swiping");
		}

	}
	
	
	

}
