package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.OrderCheckoutPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SearchProductPage;
import testBase.BaseClass;

public class TC006_OrderCheckout extends BaseClass {

    @Test(groups = {"Regression"})
    public void verify_order_checkout() {
        logger.info("**** Starting TC00Y_OrderCheckout ****");
        try {
            // Step 1: Login (URL handled in BaseClass)
        	HomePage hp= new HomePage(driver);
    		hp.clickMyAccount();
    		hp.clickLogin();
    		
            LoginPage lp = new LoginPage(driver);
        
            lp.setEmail(p.getProperty("email"));
            lp.setPassword(p.getProperty("password"));
            lp.clickLogin();
            logger.info("Login successful.");

            // Step 2: Search and add a product to cart
            SearchProductPage sp = new SearchProductPage(driver);
            sp.enterProductName("MacBook");
            sp.clickSearch();
            Assert.assertTrue(sp.isProductDisplayed(), "Product not found after search.");
            logger.info("Product search successful.");

            // Step 3: Checkout
            OrderCheckoutPage oc = new OrderCheckoutPage(driver);
            oc.addToCart();
            oc.goToCart();
            oc.clickCheckout();
            oc.completeCheckout();
            Assert.assertTrue(oc.isOrderConfirmed(), "Order confirmation not displayed.");

            logger.info("**** Finished TC00Y_OrderCheckout ****");
        } 
        catch (Exception e) {
            logger.error("Order checkout test failed: " + e.getMessage());
            Assert.fail();
        }
    }
}
