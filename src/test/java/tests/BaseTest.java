package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import pages.BasePage;
import utils.BrowserUtils;
import utils.ConfigUtils;
import utils.ConstantUtils;

public class BaseTest {
    protected WebDriver driver;
    protected String baseURL;
    protected BasePage basePage;


    public void setUP() {
        // TODO:DEFINIRE METODA
    }
    public void getBrowser(String browserName) {
        driver = BrowserUtils.getDriver(browserName);
    }

    public void getBrowser() {
        String browserName = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE,
                "browser", "chrome");
        System.out.println("Load browser type: " + browserName);
        driver = BrowserUtils.getDriver(browserName);
        basePage = new BasePage(driver);
    }

    public void getBrowserWithEnv() {
        String browserName = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE,
                "browser", "chrome");
        String environment = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE,
                "environment", "local");
        System.out.println("Load browser type: " + browserName);
        driver = BrowserUtils.getDriver(browserName, environment);
        basePage = new BasePage(driver);
    }

    public void setUp() {
        getBaseURL();
        getBrowser();
    }

    private void closeBrowserAtEnd() {
        if (driver != null) {
            System.out.println("Close browser at the end of test");
            driver.quit();
        }
    }

    @AfterTest
    public void cleanUp() {
        closeBrowserAtEnd();
    }

    @AfterMethod
    public void cleanUpAfterMethod() {
        closeBrowserAtEnd();
    }

    public void getBaseURL() {
        getBaseURL(ConstantUtils.DEFAULT_CONFIG_FILE);
    }

    public void getBaseURL(String configFileName) {
        baseURL = ConfigUtils.readGenericElementFromConfig(configFileName, "base.url");
    }

    public void navigateToURL(String path) {
        System.out.println("Open next url:" + baseURL + path);
        driver.navigate().to(baseURL + path);
    }

}
