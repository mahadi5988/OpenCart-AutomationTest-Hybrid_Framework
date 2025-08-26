package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups={"Datadriven", "Master"})  //LoginData is named in DataProviders.java and as the data provider is in another file thats why used dataProviderClass.
	public void verify_loginDDT(String email, String pwd, String exp){
		
		logger.info("*********TC003 is Started***************");
	try {
	HomePage hp= new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	
	//Login
	LoginPage lp= new LoginPage(driver);
	lp.setEmail(email);
	lp.setPassword(pwd);
	lp.clickLogin();
	
	
	//MyAccount
	MyAccountPage macc=new MyAccountPage(driver);
	boolean targetPage=macc.isMyAccountPageExists();
	
	if(exp.equalsIgnoreCase("Valid")) {
		if(targetPage==true) {
			macc.clickLogout();
			Assert.assertTrue(true);
			
		}
		else
		{
		Assert.assertTrue(false);	
		}
	}
	
	if(exp.equalsIgnoreCase("Invalid")) {
		if(targetPage==true) {
			macc.clickLogout();
			Assert.assertTrue(false);
			
		}else
		{
			Assert.assertTrue(true);
		}
	}		}
	catch(Exception e) {
		Assert.fail();
	}
	
	
	
	logger.info("********* TC003 is finished************");
			}
	}
