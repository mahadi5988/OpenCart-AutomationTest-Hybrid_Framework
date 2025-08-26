package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstName;

@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLastName;

@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmail;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath="//input[@name='agree']")
WebElement chkPolicy;

@FindBy(xpath="//button[normalize-space()='Continue']")
WebElement btnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;

public void setFirstName(String fname) {
	txtFirstName.sendKeys(fname);
}

public void setLastName(String lname) {
	txtLastName.sendKeys(lname);
}

public void setEmail(String email) {
	txtEmail.sendKeys(email);
}

public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);
}

public void clickPolicy() {
	//WebElement policyCheckbox = driver.findElement(By.xpath("//input[@name='agree']"));

	// Scroll into view
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", chkPolicy);

	// Force JS click
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", chkPolicy);
	
	
}



public void clickContinue() {
	btnContinue.click();
}



public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	}
	catch(Exception e) {
		return(e.getMessage());
	}
}

}
