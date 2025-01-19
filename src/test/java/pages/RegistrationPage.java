package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//*[@id = 'template-register']//h1[contains(text(), 'Cont nou')]")
    private WebElement pageIdentifier;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id='person-0']")
    private WebElement individualAccount;

    @FindBy(id = "person-1")
    private WebElement businessAccount;

    @FindBy(id = "address")
    private WebElement addressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "state")
    private WebElement countyInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "cpassword")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//*[@class='buttons']/a")
    private WebElement registrationButton;

    @FindBy(xpath = "//*[@class='jquery-lightbox-html']//h5[contains(text(), 'Actiune nereusita!')]")
    private WebElement registrationError;

    @FindBy(xpath = "/html/body/div[1]/div/a[contains(text(), 'Am inteles!')]")
    WebElement dismissCookies;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void register(String lastname, String firstname, String phone, String email,
                         String address, String city, String county,
                         String password, String confirmPassword) {
        waitUntilElementVisible(pageIdentifier);
        this.dismissCookieMessage();
        this.enterLastName(lastname);
        this.enterFirstName(firstname);
        this.enterPhoneNumber(phone);
        this.enterEmail(email);
        this.clickOnIndividualAccount();
        this.enterAddress(address);
        this.enterCity(city);
        this.enterCounty(county);
        this.enterPassword(password);
        this.enterConfirmPassword(confirmPassword);
        this.submit();
    }

    private void enterLastName(String lastName) {
        waitUntilElementVisible(lastNameInput);
        System.out.println("Enter lastName: " + lastName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    private void enterFirstName(String firstName) {
        waitUntilElementVisible(firstNameInput);
        System.out.println("Enter firstname: " + firstName);
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    private void enterPhoneNumber(String phone) {
        waitUntilElementVisible(phoneInput);
        System.out.println("Enter phone number: " + phone);
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    private void enterEmail(String email) {
        waitUntilElementVisible(emailInput);
        System.out.println("Enter email: " + email);
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    private void clickOnIndividualAccount() {
        waitUntilElementVisible(individualAccount);
        System.out.println("Choose individual account");
        individualAccount.click();
    }

    private void enterAddress(String address) {
        waitUntilElementVisible(addressInput);
        System.out.println("Enter your address: " + address);
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    private void enterCity(String city) {
        waitUntilElementVisible(cityInput);
        System.out.println("Enter city: " + city);
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    private void enterCounty(String county) {
        waitUntilElementVisible(countyInput);
        System.out.println("Enter county: " + county);
        countyInput.clear();
        countyInput.sendKeys(county);
    }

    private void enterPassword(String password) {
        waitUntilElementVisible(passwordInput);
        System.out.println("Enter password: " + password);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    private void enterConfirmPassword(String confirmPassword) {
        waitUntilElementVisible(confirmPasswordInput);
        System.out.println("Enter confirm password: " + confirmPassword);
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    private void submit() {
        waitUntilElementVisible(registrationButton);
        System.out.println("Click on registration button");
        registrationButton.click();
    }

    public boolean verifyRegistrationSuccessful(String firstname, String lastname) {
        String xpath = "//p[contains(text(), 'Esti logat ca " + firstname + " " + lastname + "')]";
        WebElement welcomeMessage = waitUntilElementVisible(By.xpath(xpath));
        System.out.println("Welcome message is displayed: " + welcomeMessage.getText());
        return welcomeMessage.isDisplayed();
    }

    public boolean successfulLandingURL() {
        String registrationSuccessfulURL = "https:/www.digitalvision.ro/contul-meu";
        return registrationSuccessfulURL.equals(driver.getCurrentUrl());
    }

    public String getRegistrationError() {
        waitUntilElementVisible(registrationError);
        return registrationError.getText();
    }

    public void dismissCookieMessage() {
        waitUntilElementVisible(dismissCookies);
        dismissCookies.click();
    }

    private boolean verifyElementIsRequired(WebElement element) {
        System.out.println("Field: " + element.getAccessibleName() + " => required attribute value: " + element.getAttribute("required"));
        return element.getAttribute("required").equals("true");
    }

    public boolean verifyElementsAreRequired() {
        List<WebElement> requiredFields = Arrays.asList(lastNameInput, firstNameInput, phoneInput, emailInput,
                addressInput, cityInput, countyInput, passwordInput, confirmPasswordInput);
        for (WebElement element : requiredFields) {
            if (!verifyElementIsRequired(element)) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyEmailFormatValidation(String registerError) {
        String validationMessage = emailInput.getAttribute("validationMessage");
        return registerError.equals(validationMessage);
    }
}



