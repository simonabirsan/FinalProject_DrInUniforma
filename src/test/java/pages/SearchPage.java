package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//*[@id='quick-search']/form/input")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id='quick-search']/form/a")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@class='products-list']")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//*[@id='content']//p[contains(text(), 'Ne pare rau! Aceasta cautare nu a intors niciun rezultat!')]")
    private WebElement noResultsMessage;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void search(String searchPhrase) {
        this.searchBoxIsDisplayed();
        this.enterSearchPhrase(searchPhrase);
        this.submit();
    }

    public void searchBoxIsDisplayed() {
        waitUntilElementVisible(searchField);
        searchField.isDisplayed();
    }

    public void enterSearchPhrase(String searchPhrase) {
        waitUntilElementVisible(searchField);
        System.out.println("Search input: " + searchPhrase);
        searchField.clear();
        searchField.sendKeys(searchPhrase);
    }

    public void submit() {
        waitUntilElementVisible(searchButton);
        System.out.println("Click on search button");
        searchButton.click();
    }

    public boolean verifyValidSearchResults(String searchPhrase) {
        for (WebElement element : searchResults) {
            String resultText = element.getText().toLowerCase();
            if (!resultText.contains(searchPhrase.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyNegativeSearchMessage(String searchPhrase) {
        String defaultURL = "https://digitalvision.ro/";
        if (searchPhrase.isEmpty()) {
            String currentURL = driver.getCurrentUrl();
            defaultURL.equals(currentURL);
        } else {
            try {
                System.out.println("No results message is displayed: " + noResultsMessage.getText());
                noResultsMessage.isDisplayed();
            } catch (NoSuchElementException e) {
                System.out.println("No error message found");
                return false;
            }
        }
        return true;
    }
}
