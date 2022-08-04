package org.vtiger.contacts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  driver.get("http://localhost:8888/");
	  driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
	 driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("root");
	  driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
	  driver.findElement(By.xpath("//a[.='Contacts']")).click();
	  driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
	  driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("ramayan");
	  driver.findElement(By.xpath("//b[text()='Contact Information']/../../preceding-sibling::tr/descendant::input[@accesskey=\"S\"]")).click();
	WebElement contactname = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]"));
	 
	 if(contactname.getText().contains("ramayan")) {
		 
		 System.out.println("validatin pass");
	 }
	 else {
		 System.out.println("validatin fail");

	 }
	 
	 
	}

}
