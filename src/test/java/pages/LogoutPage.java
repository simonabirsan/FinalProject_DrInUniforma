package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BasePage {

    @FindBy(xpath = "//*[@class='user-action']//a[contains(text(), 'Logout')]")
    private WebElement logoutButton;

    LoginPage loginPage = new LoginPage(driver);

    public LogoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String verifyLogoutSuccessful() {
        return loginPage.getAuthenticationHoverButton().getText();
    }

    public void logout() {
        loginPage.authenticationButtonDisplayed();
        loginPage.moveToAuthenticationButton();
        System.out.println("Logout button is visible");
        //waitUntilElementIsClickable(logoutButton);
        System.out.println("Click Logout button");
        logoutButton.click();
    }
}
