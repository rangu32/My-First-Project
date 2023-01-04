package com.staging;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IrctcWebsite {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.irctc.co.in/nget/train-search");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String title = driver.getTitle();
		System.out.println(title);
		String currentUrl = driver.getCurrentUrl();
		Thread.sleep(5000);

		WebElement FromTxt = driver.findElement(By.xpath("//input[contains(@class,'ng-tns-c57-8 ui-inputtext')]"));
		FromTxt.sendKeys("SA");
		Thread.sleep(3000);
		FromTxt.sendKeys(Keys.TAB);

		WebElement ToTxt = driver.findElement(By.xpath("//input[contains(@class,'ng-tns-c57-9 ui-inputtext')]"));
		ToTxt.sendKeys("MAS");
		Thread.sleep(3000);

		ToTxt.sendKeys(Keys.TAB);

		// Select the Journey Date

		driver.findElement(By.xpath("//input[contains(@class,'ng-tns-c58-10 ui-inputtext')]")).click();

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ui-datepicker-title ng-tns-c58-10']")));

		String monthYearVal = driver.findElement(By.xpath("//div[@class='ui-datepicker-title ng-tns-c58-10']"))
				.getText();
		System.out.println(monthYearVal); // December2022

		String month = monthYearVal.split("")[0].trim();
		String year = monthYearVal.split("")[1].trim();

		while (!(month.equals("June") && year.equals("2023"))) {
			driver.findElement(By.xpath("//span[contains(@class,'ui-datepicker-next-icon pi')]")).click();
			monthYearVal = driver.findElement(By.xpath("//div[@class='ui-datepicker-title ng-tns-c58-10']")).getText();

			System.out.println(monthYearVal); // December2022
			month = monthYearVal.split("")[0].trim();
			year = monthYearVal.split("")[1].trim();

		}

		driver.findElement(By.xpath("//a[text()='15']")).click();

	}
}
