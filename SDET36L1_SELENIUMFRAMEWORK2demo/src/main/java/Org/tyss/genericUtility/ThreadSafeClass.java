package Org.tyss.genericUtility;

import org.openqa.selenium.WebDriver;

public class ThreadSafeClass {
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	public static WebDriver getDriver() {
		return driver.get();
	}
	public static void setDriver(WebDriver actdrDriver) {
		driver.set(actdrDriver);
	}
	

}
