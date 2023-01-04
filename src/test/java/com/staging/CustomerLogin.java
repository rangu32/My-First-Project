package com.staging;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomerLogin {
	
	public static void main(String[] args) throws InterruptedException {
	
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		//https://username:password@websiteremaininglink
		
		driver.get("https://researchanalyst:Thalaiva2018@staging.celebratix.com/");
		driver.manage().window().maximize();
		
		WebElement venues = driver.findElement(By.xpath("//span[contains(text(),'Venues')]"));
		
		String a= driver.findElement(By.xpath("//span[contains(text(),'Venues')]")).getText();
		
		if (a==a) {
			System.out.println("Login Sucessfully");
		} 
		else 
		{
			System.out.println("Login Failed");
		}
		
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
		
	}
		
	
	
	
	
	

}
