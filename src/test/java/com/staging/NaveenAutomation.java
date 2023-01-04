package com.staging;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NaveenAutomation {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		Map<String, Object> cooredinatesMap = new HashMap<String, Object>();
		cooredinatesMap.put("latitude", 42.407211);
		cooredinatesMap.put("longitude", -71.382439);
		cooredinatesMap.put("accuracy", 1);

		((ChromeDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", cooredinatesMap);
		driver.get("https://researchanalyst:Thalaiva2018@staging.celebratix.com/");
		// driver.get("https://stores.stopandshop.com/");

	}

}
