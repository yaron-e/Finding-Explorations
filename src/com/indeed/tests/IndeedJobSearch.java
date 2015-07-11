package com.indeed.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IndeedJobSearch {
	/*
	 * 
	 * Got tutoriel from https://www.youtube.com/watch?v=-eJ2cZXyJ0E 
	 */
	public static void main(String[] args) {
		
		
		// Create Firefox driver to drive the browser
		WebDriver driver = new FirefoxDriver();
		
		// Open indeed home page
		driver.get("http://www.indeed.co.uk");		
		
		// Find what field and enter selenium
		driver.findElement(By.id("what")).clear();
		driver.findElement(By.id("what")).sendKeys("Selenium");;
		
		// Find location field and enter London
		driver.findElement(By.id("where")).clear();
		driver.findElement(By.id("where")).sendKeys("London");
		//Find FindJobs button and click on it 
		driver.findElement(By.id("fj")).click();
		//From job search result page, get page title and jobs count message
		String title = driver.getTitle();
		String count =driver.findElement(By.id("searchCount")).getText();
		
		System.out.println("Title: "+ title + "\n\nSearch Count :"+ count );
		//
		driver.close();
	System.out.println("Done!");
	}

}
