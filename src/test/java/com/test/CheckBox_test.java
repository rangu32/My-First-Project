// Handling Checkbox

package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox_test {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.spicejet.com/");
		driver.manage().window().maximize();

		System.out.println(driver.findElement(By.xpath("//div[text()='Senior Citizen']")).isSelected());
		WebElement checkbox = driver.findElement(By.xpath("//div[text()='Senior Citizen']"));
		checkbox.click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[text()='Senior Citizen']")).isEnabled());

		driver.quit();

	}
}
