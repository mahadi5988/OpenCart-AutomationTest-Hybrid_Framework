package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderCheckoutPage extends BasePage {

    WebDriver driver;

    public OrderCheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // ======= Web Elements =======
    @FindBy(xpath = "//button[contains(@onclick,'cart.add')]")
    WebElement btnAddToCart;

    @FindBy(xpath = "//span[text()='Shopping Cart']")
    WebElement linkShoppingCart;

    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement linkCheckout;

    @FindBy(id = "button-payment-address")
    WebElement btnPaymentContinue;

    @FindBy(id = "button-shipping-address")
    WebElement btnShippingContinue;

    @FindBy(id = "button-shipping-method")
    WebElement btnShippingMethodContinue;

    @FindBy(name = "agree")
    WebElement chkTerms;

    @FindBy(id = "button-payment-method")
    WebElement btnPaymentMethodContinue;

    @FindBy(id = "button-confirm")
    WebElement btnConfirmOrder;

    @FindBy(xpath = "//h1[contains(text(),'Your order has been placed!')]")
    WebElement msgOrderConfirmation;

    // ======= Action Methods =======
    public void addToCart() {
        btnAddToCart.click();
    }

    public void goToCart() {
        linkShoppingCart.click();
    }

    public void clickCheckout() {
        linkCheckout.click();
    }

    public void completeCheckout() {
        btnPaymentContinue.click();
        btnShippingContinue.click();
        btnShippingMethodContinue.click();
        chkTerms.click();
        btnPaymentMethodContinue.click();
        btnConfirmOrder.click();
    }

    public boolean isOrderConfirmed() {
        try {
            return msgOrderConfirmation.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

