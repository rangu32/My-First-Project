package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchFlight {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//input[@dir='auto'])[1]")).click();
		driver.findElement(By.xpath("(//input[@dir='auto'])[1]")).sendKeys("BLR");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@dir='auto'])[2]")).sendKeys("DEL");

		// driver.findElement(By.xpath("(//div[contains(@class,'css-76zvg2
		// css-bfa6kz')])[2]")).click();

		String year = "2023";
		String month = "May";
		String date = "24";
		boolean calendarpick = driver.findElement(By.xpath("")).isDisplayed();

		// (//div[contains(@class,'css-76zvg2 css-bfa6kz')])[2]
		while (true) {
			String monthyear = driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-picker']"))
					.getText();
			String arr[] = monthyear.split(" ");
			String mon = arr[0];
			String yr = arr[1];
			if (mon.equalsIgnoreCase(month) && yr.equals(year))
				break;

			else
				driver.findElement(By.xpath(
						"//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']']"))
						.click();// clicknextmonthbutton

			driver.findElement(By.xpath("//div[text()='24']")).click();
		}
	}

}
