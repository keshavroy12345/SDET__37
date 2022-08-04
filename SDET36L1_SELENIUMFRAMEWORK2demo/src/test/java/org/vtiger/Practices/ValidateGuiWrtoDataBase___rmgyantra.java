package org.vtiger.Practices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateGuiWrtoDataBase___rmgyantra {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();// method chaining
		int randomNumber= new Random().nextInt(1000);
		String expectedProjectName="Testyantra_"+randomNumber;
		System.out.println("ExpectedProjectName==>"+expectedProjectName);
		WebDriver driver= new EdgeDriver();// abstraction
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys(expectedProjectName);
		driver.findElement(By.name("createdBy")).sendKeys("Smruti6");
		WebElement projectStatusDropdown=driver.findElement(By.xpath("//label[.='Project Status ']/following-sibling::select"));
		Select select=new Select(projectStatusDropdown);
		select.selectByValue("Created");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.quit();
		Driver driver1= new Driver();
		DriverManager.registerDriver(driver1);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from project;");
		
		int count=0;
		while(result.next())
		{
			String actualProjectName=result.getString("project_name");
			if(actualProjectName.equals(expectedProjectName))
			{
				System.out.println("data is present in database");
				System.out.println("ActualProjectName==>"+actualProjectName);
				count++;
				break;
			}
		
		}
		if(count==0)
		{
			System.out.println("data is not present in database");
			
		}
		connection.close();
		
	
	}

}
