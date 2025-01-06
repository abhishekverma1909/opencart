package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	//invoke constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//find element
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegistration;
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnklogin;
	
	//Action method
	
	public void clickMyaacount() 
	{
		lnkMyaccount.click();
	}
	
	public void clickReg() 
	{
		lnkRegistration.click();
	}
	
	public void clicklogin() 
	{
		lnklogin.click();
	}
	
	

}
