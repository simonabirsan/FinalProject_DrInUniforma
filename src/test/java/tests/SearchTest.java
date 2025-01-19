package tests;

import POJO.SearchModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTest extends BaseTest {
    @Test(dataProvider = "searchValidDataProvider", dataProviderClass = data.SearchDataProvider.class)
    public void searchValidTest(SearchModel searchModel) {
        setUP();
        driver.navigate().to(baseURL);
        SearchPage searchPage = new SearchPage(driver);
        System.out.println(searchModel);
        searchPage.search(searchModel.getSearchPhrase());
        System.out.println("Verify valid search results");
        Assert.assertTrue(searchPage.verifyValidSearchResults(searchModel.getSearchPhrase()));
    }

    @Test(dataProvider = "searchInvalidDataProvider", dataProviderClass = data.SearchDataProvider.class)
    public void searchNegativeTest(SearchModel searchModel) {
        setUP();
        driver.navigate().to(baseURL);
        SearchPage searchPage = new SearchPage(driver);
        System.out.println(searchModel);
        searchPage.search(searchModel.getSearchPhrase());
        System.out.println("Verify error message is present");
        Assert.assertTrue(searchPage.verifyNegativeSearchMessage(searchModel.getSearchPhrase()), "Verify error message is present");
    }
}
