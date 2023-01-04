package com.staging;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

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

		Boolean logopresent = driver.findElement(By.xpath("//img[@class='cbx-logo-image']")).isDisplayed();
		if (logopresent != null) {
			System.out.println("Logo Displayed");
		} else {
			System.out.println("Logo not Displayed");
		}

		WebElement locationbtn = driver.findElement(
				By.xpath("//a[@class='leaflet-control-mapbox-geocoder-toggle mapbox-icon mapbox-icon-geocoder']"));
		locationbtn.click();

		Thread.sleep(5000);

		WebElement searchBtn = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchBtn.sendKeys("Gloucester, Mass");
		List<WebElement> list = driver
				.findElements(By.xpath("//div[@class='leaflet-control-mapbox-geocoder-results']"));
		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().contains("Gloucester, Massachusetts, United States")) {
				Thread.sleep(5000);
				list.get(i).click();
				break;
			}

		}

		// WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// WebElement element = mywait
		// .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='tab-1021-btnInnerEl']")));
		// element.click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class='fa fa-sign-in']")).click();
		Thread.sleep(2000);

		WebElement EmailTxt = driver.findElement(By.xpath("//input[@id='textfield-1026-inputEl']"));
		EmailTxt.sendKeys("rangu32@gmail.com");

		Thread.sleep(2000);

		WebElement Password = driver.findElement(By.xpath("//input[@id='textfield-1027-inputEl']"));
		Password.sendKeys("rangarajan");

		Thread.sleep(1000);

		WebElement LoginBtn = driver.findElement(By.xpath("//span[@id='login__loginForm-loginAction-btnInnerEl']"));
		LoginBtn.click();
		Thread.sleep(4000);
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='textfield-1032-inputEl']"));
		searchBox.sendKeys("Bass Rocks Golf Club");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Search']")).click();

		driver.findElement(By.xpath("//a[text()='Bass Rocks Golf Club']")).click();

		System.out.println("Displayed Bass Rocks Golf Club Venue");

		driver.findElement(By.id("viewVenueDetail-scrollBtnDesc-btnInnerEl")).click();

		System.out.println("Displayed Bass Rocks Golf Club Venue Description");

		driver.findElement(By.id("viewVenueDetail-scrollBtnPackage-btnInnerEl")).click();

		System.out.println("It should show available Packages");

		driver.findElement(By.xpath("//span[@id='viewVenueDetail__venuePackagesGrid-addThisBtn-15628-btnInnerEl']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Event Details']"));
		driver.findElement(By.xpath("//input[@name='event.name']")).clear();
		Thread.sleep(3000);
		WebElement EventName = driver.findElement(By.xpath("//input[@name='event.name']"));
		EventName.sendKeys("Birthdays");
		Thread.sleep(2000);
		WebElement Phone = driver.findElement(By.xpath("//input[@id='textfield-1035-inputEl']"));
		Phone.sendKeys("766-757-5567");
		driver.findElement(By.xpath("//div[@id='cbx-combo-1034-trigger-picker']")).click();
		driver.findElement(By.cssSelector("input[value='Birthday - Adults']")).click();
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(2000);

		WebElement dest = driver.findElement(By.xpath("//span[text()='Minimum Deposit:']"));

		// JsExecutor - interface
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// scroll down
		js.executeScript("arguments[0].scrollIntoView(true)", dest);

		/*
		 * // To move element to calendar page WebElement calendarlink =
		 * driver.findElement(By.xpath("//td[@id='ext-element-5']")); // to move element
		 * to calendar Actions a = new Actions(driver);
		 * a.moveToElement(calendarlink).build().perform();
		 */

		Thread.sleep(2000);
		// Date picker
		String year = "2023";
		String month = "May";
		String date = "24";
		boolean calenderpick = driver.findElement(By.xpath("//div[@id='cbx-expandeddate-picker-1112-nextEl']"))
				.isDisplayed();
		// boolean calenderpick
		// =driver.findElement(By.xpath("//table[@id='cbx-expandeddate-picker-1112-eventEl']")).isDisplayed();

		while (true) {
			String monthyear = driver.findElement(By.xpath("//span[@id='button-1150-btnInnerEl']")).getText();
			String arr[] = monthyear.split(" ");
			String mon = arr[0];
			String yr = arr[1];
			if (mon.equalsIgnoreCase(month) && yr.equals(year))
				break;

			else
				driver.findElement(By.xpath("//div[@id='cbx-expandeddate-picker-1112-nextEl']")).click();// clicknextmonthbutton

			driver.findElement(By.xpath("//div[text()='24']")).click();

			Thread.sleep(3000);
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}

	}
}
