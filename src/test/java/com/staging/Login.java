package com.staging;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		//https://username:password@websiteremaininglink
		
		driver.get("https://researchanalyst:Thalaiva2018@staging.celebratix.com/");
		driver.manage().window().maximize();
		
		//WebElement venues = driver.findElement(By.xpath("//span[contains(text(),'Venues')]"));
		
		String a= driver.findElement(By.xpath("//span[contains(text(),'Venues')]")).getText();
		
		if (a==a) {
			System.out.println("Login Sucessfully");
		} 
		else 
		{
			System.out.println("Login Failed");
		}
		
	}

}
