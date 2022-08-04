package org.vtiger.Campaigns;

import java.time.Duration;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignswithProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int randomNumber= new Random().nextInt(1000);
		WebDriverManager.edgedriver().setup();
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		String expectedProductName="Cream"+randomNumber;
		System.out.println("Expected Product name==>"+expectedProductName);
		driver.findElement(By.name("productname")).sendKeys(expectedProductName);
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Updated today')]")));
		WebElement wb=driver.findElement(By.xpath("//a[text()='More']"));
		Actions act= new Actions(driver);
		act.moveToElement(wb).perform();
		driver.findElement(By.xpath("//a[@name=\"Campaigns\"]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Campaign...\"]")).click();
		String expectCampaignName="Test"+randomNumber;
		System.out.println("Expected Campaign name==>"+expectCampaignName);
		driver.findElement(By.name("campaignname")).sendKeys(expectCampaignName);
		driver.findElement(By.xpath("//img[@language='javascript']/../../../tr[5]/td[4]/img[@title='Select']")).click();
		String pid=driver.getWindowHandle();
		Set<String>cid=driver.getWindowHandles();
		for(String i:cid)
		{
			if(!pid.equals(i))
			{
				driver.switchTo().window(i);
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys(expectCampaignName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(expectedProductName)).click();
		driver.switchTo().window(pid);
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		String actualCampaignName=driver.findElement(By.id("dtlview_Campaign Name")).getText();
		String actualProductName=driver.findElement(By.linkText(expectedProductName)).getText();
		if(actualProductName.equals(expectedProductName))
		{
			System.out.println("Product created successfully----> TC is Pass");
			System.out.println("Actual Product name==>"+actualProductName);
		}
		else
		{
			System.out.println("Product not created successfully----> TC is Fail");
		}
		if(actualCampaignName.equals(expectCampaignName))
		{
			System.out.println("Campaign created successfully----> TC is Pass");
			System.out.println("Actual Campaign name==>"+actualCampaignName);
		}
		else
		{
			System.out.println("Campaign not created successfully----> TC is Fail");
		}
		WebElement wb1=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act1= new Actions(driver);
		act1.moveToElement(wb1).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
		
	}

}
