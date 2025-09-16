package web.locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
    public static By demoUsernameInput = By.id("username");
    public static By demoPasswordInput = By.id("password");
    public static By demoLoginButton = By.xpath("//button[contains(text(), 'Login')]");

    public static By prodUsernameInput = By.id("username");
    public static By prodPasswordInput = By.id("password17810739");
    public static By prodLoginButton = By.xpath("//input[@id='submit_form17810739']");

    public static By aditiUsernameInput = By.id("username");
    public static By aditiPasswordInput = By.id("password");
    public static By aditiLoginButton = By.xpath("//button[contains(text(), 'Sign In')]");
}
