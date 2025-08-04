package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginPageTests extends BaseTest {

    @Test
    public void testLoginButtonDisabledWhenFieldsAreEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertFalse(loginPage.isLoginButtonEnabled(), "Login button should be disabled when fields are empty");
    }

    @Test
    public void testPasswordMaskingToggle() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword("test123");
        Assert.assertTrue(loginPage.isPasswordMasked(), "Password should be masked by default");
        loginPage.togglePasswordVisibility();
        Assert.assertFalse(loginPage.isPasswordMasked(), "Password should be unmasked after clicking the eye icon");
    }

    @Test
    public void testInvalidLoginShowsError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserId("wronguser");
        loginPage.enterPassword("wrongpass");
        loginPage.clickLogin();

        try { Thread.sleep(2000); } catch (Exception e) {}  // Small wait

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.length() > 0, "Error message should be displayed");
        System.out.println("Error message: " + error);
    }

    @Test
    public void testPageElementsVisibility() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.areElementsVisible(), "All login elements should be visible");
    }
}
