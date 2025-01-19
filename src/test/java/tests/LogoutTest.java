package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutTest extends BaseTest {
    @Test
    public void logoutTest() {
        setUP();
        driver.navigate().to(baseURL);
        LogoutPage logoutPage = new LogoutPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("simona.hirean@gmail.com", "Testing123!");
        if (loginPage.verifyLoginSuccessful()) {
            System.out.println("Proceed with logout");
            logoutPage.logout();
            System.out.println("Verify logout successful");
           Assert.assertEquals(logoutPage.verifyLogoutSuccessful(), "Autentificare");
        } else {
           Assert.fail("Login was not performed successfully");
        }
    }
}
