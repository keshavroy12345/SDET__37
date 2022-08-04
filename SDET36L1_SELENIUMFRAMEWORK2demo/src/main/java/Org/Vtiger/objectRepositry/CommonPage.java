package Org.Vtiger.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Org.tyss.genericUtility.WebdriverUtility;

public class CommonPage {
	 
		public CommonPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//td[@onmouseover=\"fnvshobjMore(this,'allMenu','');\"]")
		private WebElement allMenuTab;
		@FindBy(xpath="//a[@name='Campaigns']")
		private WebElement campaignsTab;
		@FindBy(xpath="//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")
		private WebElement adminstratorIcon;
		@FindBy(xpath="//a[text()='Sign Out']")
		private WebElement signOutLink;
		
		//business library
		/**
		 * This method is used to click on campaign tab in common page
		 * @param webdriverUtility
		 */
		public void clickCampaign(WebdriverUtility webDriverUtility)
		{
			webDriverUtility.mouseOverElement(allMenuTab);
			campaignsTab.click();
		}
		/**
		 * This method is used to signout from the application
		 * @param webdriverUtility
		 */
		public void logoutAction(WebdriverUtility webDriverUtility)
		{
			webDriverUtility.mouseOverElement(adminstratorIcon);
			signOutLink.click();
		}

	}
	
