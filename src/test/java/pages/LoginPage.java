package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By userIdInput = By.name("username");
    By passwordInput = By.name("password");
    By loginButton = By.cssSelector("button[type='submit']");
    By eyeIcon = By.cssSelector("button[aria-label='toggle password visibility']");
    By errorMsg = By.cssSelector(".MuiFormHelperText-root");

    // Actions
    public void enterUserId(String userId) {
        driver.findElement(userIdInput).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginButton).isEnabled();
    }

    public boolean isPasswordMasked() {
        WebElement passwordField = driver.findElement(passwordInput);
        return passwordField.getAttribute("type").equals("password");
    }

    public void togglePasswordVisibility() {
        driver.findElement(eyeIcon).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }

    public boolean areElementsVisible() {
        return driver.findElement(userIdInput).isDisplayed() &&
               driver.findElement(passwordInput).isDisplayed() &&
               driver.findElement(loginButton).isDisplayed() &&
               driver.findElement(eyeIcon).isDisplayed();
    }
}
