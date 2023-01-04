package com.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Shaws {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// driver.get("https://local.shaws.com/ma.html");
		// driver.get("https://restaurants.applebees.com/en-us/ma/");

		// driver.get("https://www.wholefoodsmarket.com/stores");

		driver.get("https://locations.bertuccis.com/us/ma");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.xpath("//input[@id='store-finder-search-bar']")).sendKeys("Massachusetts");

		List<WebElement> allCities = driver
				.findElements(By.xpath("//div[@class='c-directory-list-content-wrapper']//ul[1]"));

		for (WebElement allCity : allCities) {
			System.out.println(allCity.getText());

		}
		driver.quit();
	}

}
