package com.staging;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage {
	
	public static void main(String[] args) throws InterruptedException
		{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		
		//https://username:password@websiteremaininglink
		
		driver.get("https://researchanalyst:Thalaiva2018@staging.celebratix.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		
		 Boolean logopresent = driver.findElement(By.xpath("//img[@class='cbx-logo-image']")).isDisplayed();
		 if (logopresent !=null) {
			 System.out.println("Logo Displayed");
			}
			 else 
			 {
				 System.out.println("Logo not Displayed");
			 }
		 	
		 	

		 	WebElement locationbtn = driver.findElement(By.xpath("//a[@class='leaflet-control-mapbox-geocoder-toggle mapbox-icon mapbox-icon-geocoder']"));
			locationbtn.click();
			
			Thread.sleep(5000);
				
			WebElement searchBtn = driver.findElement(By.xpath("//input[@placeholder='Search']"));
			searchBtn.sendKeys("Gloucester, Mass");		
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='leaflet-control-mapbox-geocoder-results']"));
			System.out.println(list.size());
			
				
			for (int i = 0; i <list.size(); i++) 
			{
				if (list.get(i).getText().contains("Gloucester, Massachusetts, United States"))
				{
					Thread.sleep(3000);
					list.get(i).click();
					break;
				}
						
			}
				
			Thread.sleep(5000);
			WebElement searchBox = driver.findElement(By.xpath("//input[@id='textfield-1032-inputEl']"));
			searchBox.sendKeys("Bass Rocks Golf Club");
			
			//driver.findElement(By.xpath("//span[text()='Search']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@role='button']")).click();
			
			Thread.sleep(1000);
			
			
			
			
			
		}
		 
		
	}

   
