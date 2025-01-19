package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddToCartPage extends BasePage {

    @FindBy(xpath = "//*[@class='products-list']")
    private List<WebElement> productsList;

    @FindBy(xpath = "//*[@class='heading-holder']/h1/strong[contains(text(),'COMANDA RAPIDA ')]")
    private WebElement shoppingCartPageName;

    @FindBy(xpath = "//*[@id='products-cart-list']//h2/a")
    private WebElement productAddedToCart;

    String productToAddToCart;

    public String getProductToAddToCart() {
        return productToAddToCart;
    }

    public void setProductToAddToCart(String productToAddToCart) {
        this.productToAddToCart = productToAddToCart;
    }

    public AddToCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private void shoppingCartPageIsDisplayed() {
        waitUntilElementVisible(shoppingCartPageName);
        System.out.println("Shopping Cart page is displayed: " + shoppingCartPageName.getText());
        shoppingCartPageName.isDisplayed();
    }

    public String getProductAddedToCart() {
        shoppingCartPageIsDisplayed();
        try {
            System.out.println("Product in the cart: " + productAddedToCart.getText());
            return productAddedToCart.getText();
        } catch (NoSuchElementException e) {
            System.out.println("No product found in the cart.");
            return null;
        }
    }

    public void addToCart() {
        WebElement myProduct = productsList.get(0);
        WebElement productTitle = myProduct.findElement(By.xpath("//*[@class='title']/a"));
        System.out.println("Add product to cart: " + productTitle.getText());
        setProductToAddToCart(productTitle.getText());
        WebElement addToCartButton = myProduct.findElement(By.id("add-to-cart"));
        addToCartButton.click();
    }
}
