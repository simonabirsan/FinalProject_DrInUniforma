package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(id = "user-account")
    private WebElement authenticationHoverButton;

    @FindBy(className = "account-login ltr res layout-1")
    private WebElement signInButton;


    @FindBy(id = "input-email")
    private WebElement emailInput;


    @FindBy(id = "input-password")
    private WebElement passwordInput;


    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
	
    private WebElement loginButton;

    @FindBy(className = "error-message")
    private WebElement errorMessageElement;
	
	Actions actions;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public WebElement getAuthenticationHoverButton() {
        return authenticationHoverButton;
    }
    public void login(String username, String password) {
        System.out.println("Waiting for login page to load");
        waitUntilElementVisible(loginButton);
        this.enterUsername(username);
        this.enterPassword(password);
        this.submit();
    }

    public boolean authenticationButtonDisplayed() {
        waitUntilElementVisible(authenticationHoverButton);
        return authenticationHoverButton.isDisplayed();
    }

    public void moveToAuthenticationButton() {
        actions.moveToElement(authenticationHoverButton).perform();
    }
    public void enterUsername(String username) {
        waitUntilElementVisible(emailInput);
        System.out.println("Enter email:" + username);
        emailInput.clear();
        emailInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(passwordInput);
        System.out.println("Enter password:" + password);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void submit() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        System.out.println("Click sign in button");
        signInButton.click();
    }

    public boolean verifyLoginSuccessful() {
        return authenticationHoverButton.getText().contains("Contul meu");
    }

    public boolean verifyLoginFailed(String errorMessage) {
        waitUntilElementVisible(errorMessageElement);
        System.out.println("Error message displayed: " + errorMessageElement.getText());
        return errorMessageElement.getText().equalsIgnoreCase(errorMessage);
    }
}
