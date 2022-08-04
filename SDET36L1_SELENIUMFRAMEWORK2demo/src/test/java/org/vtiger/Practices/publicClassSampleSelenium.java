package org.vtiger.Practices;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class publicClassSampleSelenium {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	//get the java representation object of the physical file	
		FileInputStream fis=new FileInputStream("src/test/resources/commonData.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		//read the value using getproperty
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String timeout = properties.getProperty("timeouts");
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("root");
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		

	}

}
