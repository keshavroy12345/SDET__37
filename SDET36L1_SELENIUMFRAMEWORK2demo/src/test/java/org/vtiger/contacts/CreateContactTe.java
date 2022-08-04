package org.vtiger.contacts;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       WebDriverManager.chromedriver().setup();
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
 	  driver.get("http://localhost:8888/");
 	  driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
 	 driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("root");
 	  driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
 	  driver.findElement(By.xpath("//a[.='Contacts']")).click();
 	  driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
 	  driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("ritu");
 	  driver.findElement(By.xpath("//b[.='Contact Information']/../../preceding-sibling::tr/descendant::input[@accesskey=\"S\"]")).click();
 	  
     String contactname = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
 if(contactname.contains("ritu")) {
		 
		 System.out.println("validatin pass");
	 }
	 else {
		 System.out.println("validatin fail");

	 }
	 
	 
	}

}

