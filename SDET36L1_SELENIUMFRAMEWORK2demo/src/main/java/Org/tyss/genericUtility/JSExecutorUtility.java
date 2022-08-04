 package Org.tyss.genericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExecutorUtility {
	
	JavascriptExecutor jse;
	WebDriver driver;
	
	/**
	 * Initialize the JavaScript Executor
	 */
	public void initializeJSExecutor()
	{
		jse=(JavascriptExecutor)driver;
	}
	
	/**
	 * Navigate app by using JSExecutor
	 * @param url
	 */
	public void navigateApp(String url)
	{
		jse.executeScript("window.location=arguments[0]", url);
	}
	
	/**
	 * This method is used till the element is visible
	 * @param element
	 */
	public void scrollTillElement(WebElement element) {
		jse.executeScript("arguments[0].scrollIntoView()", element);
	}

	/**
	 * This method is used to highlight the element
	 * @param element
	 */
	public void highlightElement(WebElement element)
	{
		jse.executeScript("arguments[0].setAttribute('style','broder:5px solid red;')",element);
	}
	
	/**
	 * This method is used to scroll till some position
	 * @param y_position
	 * @param strategy
	 */
	public void scrollTillSomePosition(int y_position, String strategy)
	{
		String sign=strategy.equalsIgnoreCase("up") ? "-":"+";
		jse.executeScript("window.scrollBy(0,"+sign+"arguments[0]", y_position);
	}
	
	/**
	 * This method is used to scroll till the end of page
	 * @param strategy
	 */
	public void scrollTillEnd(String strategy)
	{
		String sign=strategy.equalsIgnoreCase("up") ? "-":"+";
		jse.executeScript("window.scrollby(0,"+sign+"document.body.scrollHeight)");
	}
	
	/**
	 * This method is used to send the data to textfield using JSExecutor
	 * @param element
	 * @param data
	 */
	public void enterData(WebElement element, String data) {
		jse.executeScript("arguments[0].value=arguments[1]", element,data);
	}
	
	/**
	 * This method is used to click on element using JSExecutor
	 * @param element
	 */
	public void clickOnElement(WebElement element)
	{
		jse.executeScript("arguments[0].click()", element);
	}
	

}
