package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.SearchProductPage;
import testBase.BaseClass;

public class TC005_SearchProduct extends BaseClass {

    @Test(groups = {"Regression", "Sanity"})
    public void verify_product_search() {
        logger.info("**** Starting TC00X_SearchProduct ****");
        try {

            SearchProductPage sp = new SearchProductPage(driver);
            sp.enterProductName("MacBook");
            sp.clickSearch();

            boolean result = sp.isProductDisplayed();
            Assert.assertTrue(result, "Product search failed.");

            logger.info("**** Finished TC00X_SearchProduct ****");
        } 
        catch (Exception e) {
            logger.error("Search product test failed: " + e.getMessage());
            Assert.fail();
        }
    }
}

