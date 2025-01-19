package tests;

import POJO.RegistrationModel;
import POJO.RegistrationDetailsModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

    @Test(dataProvider = "registrationValidDataProvider", dataProviderClass = dataproviders.RegistrationDataProvider.class)
    public void registrationValidTest(RegistrationModel registrationModel) {
        registerWithRegisterModel(registrationModel);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        System.out.println("Verify registration successful");
            Assert.assertTrue(registrationPage.successfulLandingURL());
            Assert.assertTrue(registrationPage.verifyRegistrationSuccessful(registrationModel.getRegistrationDetailsModel().getFirstname(), registrationModel.getRegistrationDetailsModel().getLastname()));
    }

    @Test(dataProvider = "registrationNegativeDataProvider", dataProviderClass = dataproviders.RegistrationDataProvider.class)
    public void registrationNegativeTest(RegistrationModel registrationModel) {
        registerWithRegisterModel(registrationModel);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        System.out.println("Verify registration failed message");
        Assert.assertEquals(registrationPage.getRegistrationError(), registrationModel.getRegisterError());
    }

    @Test
    public void requiredAttributePresent() {
        setUP();
        navigateToURL("cont-nou");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        System.out.println("Verify that required attribute is present");
        Assert.assertTrue(registrationPage.verifyElementsAreRequired());
    }

    @Test(dataProvider = "emailFormatDataProvider", dataProviderClass = dataproviders.RegistrationDataProvider.class)
    public void verifyEmailFormat(RegistrationModel registrationModel) {
        setUP();
        navigateToURL("cont-nou");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        System.out.println(registrationModel);

        RegistrationDetailsModel registrationForm = registrationModel.getRegistrationDetailsModel();

        registrationPage.register(registrationForm.getLastname(), registrationForm.getFirstname(),
                registrationForm.getPhone(), registrationForm.getEmail(),
                registrationForm.getAddress(), registrationForm.getCity(), registrationForm.getCounty(),
                registrationForm.getPassword(), registrationForm.getConfirmPassword());
        System.out.println("Verify email format");
        Assert.assertTrue(registrationPage.verifyEmailFormatValidation(registrationModel.getRegisterError()));
    }

    private void registerWithRegisterModel(RegistrationModel registrationModel) {
        setUP();
        navigateToURL("cont-nou");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        System.out.println(registrationModel);
        RegistrationDetailsModel registrationForm = registrationModel.getRegistrationDetailsModel();
        registrationPage.register(registrationForm.getLastname(), registrationForm.getFirstname(),
                registrationForm.getPhone(), registrationForm.getEmail(),
                registrationForm.getAddress(), registrationForm.getCity(), registrationForm.getCounty(),
                registrationForm.getPassword(), registrationForm.getConfirmPassword());
    }
}
