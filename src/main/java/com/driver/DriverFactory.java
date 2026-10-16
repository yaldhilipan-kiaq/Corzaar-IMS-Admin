package com.driver;

import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverFactory {
	

	public static AndroidDriver createDriver(String deviceName, String udid, String appiumUrl, int systemPort)
			throws Exception {

		UiAutomator2Options options = new UiAutomator2Options();

		options.setPlatformName("Android");
		options.setDeviceName(deviceName);
		options.setUdid(udid);
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.corzaar.app");
		options.setAppActivity("com.corzaar.app.MainActivity");
		options.setNoReset(false);
		options.setCapability("dontStopAppOnReset",true);
		options.setSystemPort(systemPort);

		return new AndroidDriver(new URL(appiumUrl), options);
	}
}


