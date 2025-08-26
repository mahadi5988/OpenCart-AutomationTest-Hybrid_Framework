package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h1[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	
	public boolean isMyAccountPageExists() {
		try {
			return (msgHeading.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void clickLogout() {
		//lnkLogout.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lnkLogout);

		// Force JS click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", lnkLogout);
	}
}
