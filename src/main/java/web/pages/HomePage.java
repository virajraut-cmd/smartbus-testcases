package web.pages;

import configurations.config.ConfigLoader;
import org.openqa.selenium.*;
import commonMethods.HomePageCommonMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class);
    private final WebDriver driver;
    private final HomePageCommonMethods homePageCommonMethods;
    private final ConfigLoader configLoader = ConfigLoader.getInstance();

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.homePageCommonMethods = new HomePageCommonMethods(driver);
    }

    public void selectProject(String projectName) {
        String env = System.getProperty("env");
        if (env != null && env.equalsIgnoreCase("demo")) {
            logger.info("Selecting project: {}", projectName);
            homePageCommonMethods.clickOnUserInfoButton();
            homePageCommonMethods.selectProject(projectName);
            logger.info("Project selected: {}", projectName);
        }
    }

    public void navigateToMenu(String mainModule, String subModule, String screen) throws InterruptedException {
        logger.info("Navigating to menu: {} > {} > {}", mainModule, subModule, screen);
        homePageCommonMethods.navigateToScreen(mainModule,subModule,screen);
        logger.info("Navigation to menu complete: {} > {} > {}", mainModule, subModule, screen);
    }
}
