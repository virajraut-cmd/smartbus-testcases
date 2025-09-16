package commonMethods;

import configurations.common.CommonMethods;
import configurations.common.IframesOfApplication;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import web.locators.HomePageLocators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import configurations.common.WaitUtils;


public class HomePageCommonMethods {
    private static final Logger logger = LogManager.getLogger(HomePageCommonMethods.class);

    private final WebDriver driver;
    private final CommonMethods commonMethods;
    private final IframesOfApplication iframe;
    private final WaitUtils waitUtils;

    public HomePageCommonMethods(WebDriver driver) {
        this.driver = driver;
        this.commonMethods = new CommonMethods(driver);
        this.iframe = new IframesOfApplication(driver);
        this.waitUtils = new WaitUtils(driver);
    }

    public void navigateToScreen(String mainModule, String subModule, String screen) throws InterruptedException {
        logger.info("Navigating to screen: {} > {} > {}", mainModule, subModule, screen);
        iframe.switchToDivFrame();
        try {
            commonMethods.clickOnAnyButtonWithNameAndXpath(mainModule, String.format(HomePageLocators.MAIN_MODULE_BUTTON_XPATH, mainModule));
            commonMethods.clickOnAnyButtonWithNameAndXpath(subModule, String.format(HomePageLocators.SUB_MODULE_BUTTON_XPATH, subModule, subModule));
            commonMethods.clickOnAnyButtonWithNameAndXpath(screen, String.format(HomePageLocators.SCREEN_BUTTON_XPATH, screen, screen));
            Thread.sleep(1000);
            logger.info("Navigation to screen complete: {} > {} > {}", mainModule, subModule, screen);
        } catch (Exception e) {
            logger.error("Error navigating to screen: {} > {} > {}: {}", mainModule, subModule, screen, e.getMessage());
            throw e;
        }
    }

    public void clickOnUserInfoButton() {
        logger.info("Clicking on user info button");
        iframe.switchToDivFrame();
        WebElement userInfoButton = waitUtils.waitForElementToBeClickable(HomePageLocators.USER_BUTTON);
        userInfoButton.click();
        logger.info("User info button clicked");
    }

    public void selectProject(String projectName) {
        logger.info("Selecting project from applications menu: {}", projectName);
        waitUtils.waitForElementToBeVisible(HomePageLocators.APPLICATIONS_MENU);
        WebElement applicationsElement = driver.findElement(HomePageLocators.APPLICATIONS_MENU);
        Actions actions = new Actions(driver);
        actions.moveToElement(applicationsElement).perform();
        waitUtils.waitForElementToBeVisible(HomePageLocators.SIDE_DRAWER);
        By projectLocator = HomePageLocators.getProjectByName(projectName);
        waitUtils.waitForElementToBePresent(projectLocator);
        WebElement projectElement = driver.findElement(projectLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", projectElement);
        waitUtils.waitForElementToBeClickable(projectLocator);
        try {
            projectElement.click();
            logger.info("Project selected: {}", projectName);
        } catch (Exception e) {
            logger.error("Error selecting project '{}': {}", projectName, e.getMessage());
            throw e;
        }
    }
}