package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass
{  

	
	@Test(groups={"reg","master"})
	public void accountRegistion() 
	{
		logger.info("*****Test Case Started*******");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyaacount();
		hp.clickReg();
		
		logger.info("Clicked on Registration link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setfirstname(randomeString());
		regpage.setlastname(randomeString());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.settelephone(randomeint());
		
		String pass=randomAlphaNumaric();
		regpage.setpassword(pass);
		regpage.confirmpassword(pass);
		regpage.chkdprivacypolicy();
		regpage.clickContinue();
		
		logger.info("Clicked on continue button");
		
		String cof_txt =regpage.getConfirmationText();
		Assert.assertEquals(cof_txt, "Your Account Has Been Created!");
		logger.info("Test case Pass");
		}
		catch(Exception e) 
		{
			logger.error("Test Case failed"+e.getMessage());
			Assert.fail("Test Case fail"+e.getMessage());
		}
		finally {
		logger.info("Text case completed Successfully");
		}
	}
	
		
}
