package commonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import configurations.common.WaitUtils;
import web.locators.LoginPageLocators;

public class LoginPageCommonMethods {
    private final WebDriver driver;
    private final WaitUtils waitUtils;
    private final String env;

    public LoginPageCommonMethods(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        this.env = System.getProperty("env", "demo"); // Default to "demo" if not specified
    }

    private By getUsernameInputLocator() {
        switch (env) {
            case "prod":
                return LoginPageLocators.prodUsernameInput;
            case "aditi":
                return LoginPageLocators.aditiUsernameInput;
            default:
                return LoginPageLocators.demoUsernameInput;
        }
    }

    private By getPasswordInputLocator() {
        switch (env) {
            case "prod":
                return LoginPageLocators.prodPasswordInput;
            case "aditi":
                return LoginPageLocators.aditiPasswordInput;
            default:
                return LoginPageLocators.demoPasswordInput;
        }
    }

    private By getLoginButtonLocator() {
        switch (env) {
            case "prod":
                return LoginPageLocators.prodLoginButton;
            case "aditi":
                return LoginPageLocators.aditiLoginButton;
            default:
                return LoginPageLocators.demoLoginButton;
        }
    }

    public void enterUsername(String username) {
        waitUtils.waitForElementToBeVisible(getUsernameInputLocator());
        WebElement usernameField = driver.findElement(getUsernameInputLocator());
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUtils.waitForElementToBeVisible(getPasswordInputLocator());
        WebElement passwordField = driver.findElement(getPasswordInputLocator());
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = waitUtils.waitForElementToBeClickable(getLoginButtonLocator());
        loginButton.click();
    }
}
