package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SearchProductPage;
import PageObjects.OrderCheckoutPage;
import testBase.BaseClass;

public class TC007_EndToEnd extends BaseClass {

    @Test(groups = {"E2E", "Regression"})
    public void verify_end_to_end_order_flow() {
        logger.info("**** Starting TC00Z_EndToEnd (End-to-End Order Flow) ****");

        try {
            // Step 1: Login (URL already opened from config in BaseClass)
        	
        	HomePage hp= new HomePage(driver);
    		hp.clickMyAccount();
    		hp.clickLogin();
            LoginPage lp = new LoginPage(driver);
            
            hp.clickMyAccount();
            lp.clickLogin();
            lp.setEmail(p.getProperty("email"));      // from config.properties
            lp.setPassword(p.getProperty("password"));
            lp.clickLogin();
            logger.info("Login successful.");

            // Step 2: Search for a product
            SearchProductPage sp = new SearchProductPage(driver);
            sp.enterProductName("MacBook");
            sp.clickSearch();
            Assert.assertTrue(sp.isProductDisplayed(), "Product not displayed after search.");
            logger.info("Product search successful.");

            // Step 3: Add to cart and proceed to checkout
            OrderCheckoutPage oc = new OrderCheckoutPage(driver);
            oc.addToCart();
            oc.goToCart();
            oc.clickCheckout();
            logger.info("Navigated to checkout page.");

            // Step 4: Complete checkout
            oc.completeCheckout();
            Assert.assertTrue(oc.isOrderConfirmed(), "Order confirmation message not found.");

            logger.info("**** End-to-End order test passed successfully ****");
        } 
        catch (Exception e) {
            logger.error("E2E test failed: " + e.getMessage());
            Assert.fail("End-to-End flow failed due to exception.");
        }
    }
}

