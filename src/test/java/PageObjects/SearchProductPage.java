package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductPage extends BasePage {
    
    WebDriver driver;

    public SearchProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    
    @FindBy(name = "search")
    WebElement txtSearchBox;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")  // Update locator if needed
    WebElement btnSearch;

    @FindBy(xpath = "//div[@class='product-thumb']")  // Example: product result container
    WebElement productResult;

    // ======= Action Methods =======
    public void enterProductName(String productName) {
        txtSearchBox.clear();
        txtSearchBox.sendKeys(productName);
    }

    public void clickSearch() {
        btnSearch.click();
    }

    public boolean isProductDisplayed() {
        try {
            return productResult.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
