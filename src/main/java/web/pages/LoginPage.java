package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import commonMethods.LoginPageCommonMethods;

public class LoginPage {
     
  private static final Logger logger = LogManager.getLogger(LoginPage.class);
  final WebDriver driver;
  final LoginPageCommonMethods loginPageCommonMethods;
  
  public LoginPage(WebDriver driver)
  {
	  this.driver = driver;
	  this.loginPageCommonMethods = new LoginPageCommonMethods(driver);
  }
  
  public LoginPage EnterUsername()
  {
	  loginPageCommonMethods.enterUsername("admin");
	  return this;
  }
  
  public LoginPage EnterPassword()
  {
	 loginPageCommonMethods.enterPassword("Uffizio@demo2025");
	 return this;
  }
  
  public LoginPage ClickOnLoginButton()
  {
	  loginPageCommonMethods.clickLoginButton();
	  return this;
  }
}
