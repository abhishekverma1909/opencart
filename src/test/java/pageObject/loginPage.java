package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage {
	
	public loginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_login;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnlogin;
	
	public void setEmail(String email) 
	{
		txt_login.sendKeys(email);
	}
	
	public void setPassword(String pass) 
	{
		txt_password.sendKeys(pass);
	}
	
	public void clickloginbtn() 
	{
		btnlogin.click();
	}
	
	

}
