package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myaccheading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btnlogout;
	
	public boolean isMyAccountPageExists() 
	{
		try {
		boolean myacch =myaccheading.isDisplayed();
		return myacch;
		}
		catch(Exception e) 
		{
			return false;
		}
		
	}
	
	
	public void logout() 
	{
		btnlogout.click();
	}

}
