package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.MyAccountPage;
import pageObject.loginPage;
import testBase.BaseClass;



public class TC_002_LoginTest extends BaseClass{
	
	
	@Test(groups={"sanity","master"})
    public void verifylogin() throws InterruptedException 
    {
		try {
		logger.info("*****Login Tets Started*****");
    	HomePage hp=new HomePage(driver);
    	hp.clickMyaacount();
    	hp.clicklogin();
    	
    	logger.info("***Entering Login Detais***");
    	loginPage lp=new loginPage(driver);
    	lp.setEmail(p.getProperty("email"));
    	lp.setPassword(p.getProperty("password"));
    	lp.clickloginbtn();
    	
    	logger.info("***Validating MyAccount Heading***");
    	MyAccountPage macc=new MyAccountPage(driver);
    	
    	boolean MyAccTitleExist=macc.isMyAccountPageExists();
    	Assert.assertEquals(MyAccTitleExist, true);
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
		
    	
    	logger.info("***Test Case Completed****");
    	    
		
    }

}
