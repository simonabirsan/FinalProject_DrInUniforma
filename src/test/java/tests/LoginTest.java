package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {


    @Test(dataProvider = "loginDataProvider", dataProviderClass = dataproviders.LoginDataProvider.class)
    public void testLogin(String username, String password, String browser) {
        getBrowser(browser);
        getBaseURL();

        navigateToURL("/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        System.out.println("Verify login successful");
        Assert.assertTrue(loginPage.verifyLoginSuccessful());
    }
}
