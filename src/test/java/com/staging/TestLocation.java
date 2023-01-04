package com.staging;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLocation {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// https://username:password@websiteremaininglink

		driver.get("https://researchanalyst:Thalaiva2018@staging.celebratix.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String title = driver.getTitle();
		System.out.println(title);
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Launched Website of " + currentUrl);

		// To search any city in location search

		// String City = "Lowell, Massachusetts, United States";
		WebElement locationbtn = driver.findElement(
				By.xpath("//a[@class='leaflet-control-mapbox-geocoder-toggle mapbox-icon mapbox-icon-geocoder']"));
		locationbtn.click();

		// Thread.sleep(5000);
		WebElement searchBtn = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchBtn.sendKeys("Abington, Mass");
		List<WebElement> list = driver
				.findElements(By.xpath("//div[@class='leaflet-control-mapbox-geocoder-results']"));
		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("Abington, Massachusetts, United States")) {
				Thread.sleep(3000);
				list.get(i).click();
				// break;

			}

		}
	}

}
