package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.MyAccountPage;
import pageObject.loginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass 
{
	@Test(dataProvider="logindata",dataProviderClass=DataProviders.class)
    public void verifyLoginTest(String email, String password, String exp) 
    {
    	
		logger.info("**** Starting TC_003_LoginDDT *****");
		//Homepage
		HomePage hp=new HomePage(driver);
    	hp.clickMyaacount();
    	hp.clicklogin();
    	
    	//Login
    	logger.info("***Entering Login Detais***");
    	loginPage lp=new loginPage(driver);
    	lp.setEmail(email);
    	lp.setPassword(password);
    	lp.clickloginbtn(); 
    	
    	//MyAccont 
    	 MyAccountPage mac=new  MyAccountPage(driver);
    	 boolean targetpage=mac.isMyAccountPageExists();
    	
    	 if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetpage==true)
				{
					mac.logout();;
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetpage==true)
				{
					mac.logout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
    	 
    	
    	
    }
	

}
