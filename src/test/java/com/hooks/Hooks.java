package com.hooks;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {

	@Before
	public void setUp() throws Exception {
		if (!DeviceSessionManager.isDriverActive()) {
			System.out.println("===== Starting Mobile Device =====");
			DeviceSessionManager.startDevices();
		}
	}

	@After
	public void tearDown() {

//	        System.out.println("===== Closing Mobile Devices =====");
//
//	        DeviceSessionManager.quitDevice();
//
//	        System.out.println("===== All Devices Closed =====");
	}

}
