package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartTest() {
        setUP();
        navigateToURL("laptop-tablete/laptop-notebook");

        AddToCartPage addToCartPage = new AddToCartPage(driver);
        addToCartPage.addToCart();
        Assert.assertEquals(addToCartPage.getProductAddedToCart(), addToCartPage.getProductToAddToCart());
    }
}
