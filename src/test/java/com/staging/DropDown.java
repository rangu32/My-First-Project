package com.staging;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

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

		// To Select celebration types in dropdown list
		String Events = "Birthday (Adults)";
		driver.findElement(By.xpath("//input[@id='cbx-combo-1030-inputEl']")).click();
		Thread.sleep(3000);

		List<WebElement> Celebrations = driver
				.findElements(By.xpath("(//ul[@id='cbx-combo-1030-picker-listEl']//div)"));
		int Celsize = Celebrations.size();
		System.out.println("The Celebration Options in the Dropdown are:" + Celsize);

		System.out.println("********************");

		for (int i = 0; i < Celebrations.size(); i++) {
			System.out.println(Celebrations.get(i).getText());

			if (Celebrations.get(i).getText().contains(Events)) {
				Celebrations.get(i).click();

			}

		}
		Thread.sleep(3000);
		// To Select Place/Activity types in dropdown list
		String Activity = "Bowling/Pool";

		driver.findElement(By.xpath("//input[@id='cbx-combo-1031-inputEl']")).click();
		Thread.sleep(3000);

		List<WebElement> PlaceActivity = driver.findElements(By.xpath("//ul[@id='cbx-combo-1031-picker-listEl']//div"));
		System.out.println("The Place/Activity Options in the Dropdown are:" + PlaceActivity.size());
		System.out.println("********************");

		for (int i = 0; i < PlaceActivity.size(); i++) {
			System.out.println(PlaceActivity.get(i).getText());
			if (PlaceActivity.get(i).getText().contains(Activity)) {
				PlaceActivity.get(i).click();

			}

		}

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[text()='Search']")).click();
		driver.quit();
	}

}
