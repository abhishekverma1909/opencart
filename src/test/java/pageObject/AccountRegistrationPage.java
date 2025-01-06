package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	//invoke constructor
	public  AccountRegistrationPage (WebDriver driver) 
	{
		super(driver);
	}
    
	
	//find Element
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txttelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtconfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement cofirmmessage;
	
	//Action method
	
	public void setfirstname(String fname) 
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setlastname(String lname) 
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String Email) 
	{
		txtEmail.sendKeys(Email);
	}
	
	public void settelephone(String telphone) 
	{
		txttelephone.sendKeys(telphone);
	}
	
	public void setpassword(String pwd) 
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void confirmpassword(String pwd) 
	{
		txtconfirmPassword.sendKeys(pwd);
	}
	
	public void chkdprivacypolicy() 
	{
		chkdPolicy.click();
	}
	
	public void clickContinue() 
	{
		btnContinue.click();
	}
	
	public String getConfirmationText() 
	{
		try {
			return (cofirmmessage.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	
}
