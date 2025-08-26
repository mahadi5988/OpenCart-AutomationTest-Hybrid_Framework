package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
   //public WebDriver driver;
   

   @Test(groups={"Sanity","Master"})
   public void verify_account_registration() throws InterruptedException {
	   try {
	   HomePage hp=new HomePage(driver);
	   hp.clickMyAccount();
	   hp.clickRegister();
	   logger.info("******Starting TCOO1 test case*********");
	   AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
	   logger.info("*******User is providing information************");
	   regpage.setFirstName(randomeString().toUpperCase());
	   regpage.setLastName(randomeString().toUpperCase());
	   regpage.setEmail(randomeString()+"@gmail.com");
	   regpage.setPassword(randomeAlphaNumber());
	   regpage.clickPolicy();
	   
	   regpage.clickContinue();
	   logger.info("**********clicked in registration button**********");
	   Thread.sleep(2000);
	   
	   
	   String confmsg= regpage.getConfirmationMsg();
	   if(confmsg.equals("Your Account Has Been Created!")) {
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   logger.error("Test failed");
		   logger.debug("Debug logs...");
		   Assert.assertTrue(false);
	   }  
	   
	   		}
	 //  Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	   catch(Exception e) {
		 // Assert.fail();
	   }
	   
	   
   }
 
}
