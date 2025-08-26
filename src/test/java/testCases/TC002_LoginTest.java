package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass {
	
	
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		
		logger.info("******Starting TC002********");
		
		try {
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		//Login
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		Assert.assertTrue(targetPage);
	
			}
	catch(Exception e) {
		Assert.fail();
	}
	
	logger.info("********TC002_LoginTest is finished*******");
	}

		}