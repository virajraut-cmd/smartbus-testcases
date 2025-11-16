package tests.settings.general;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonMethods.LoginPageCommonMethods;
import configurations.base.TestBase;
import configurations.config.ConfigLoader;
import web.pages.CompanyPage;
import web.pages.HomePage;
import web.pages.TransporterPage;

public class TransporterTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(TransporterTest.class);

    private static final String MENU_SETTINGS = "Settings";
    private static final String MENU_GENERAL = "General";
    private static final String MENU_TRANSPORTER = "Transporter";

    private final ConfigLoader configLoader = ConfigLoader.getInstance();

    private LoginPageCommonMethods loginPageCommonMethods;
    private HomePage homepage;
    private TransporterPage transporterPage;

    /**
     * Setup method executed before each test.
     */
    @BeforeMethod
    public void setUp() throws InterruptedException {
        setUpWeb();   // ✅ FIX: calls TestBase.setUp(), avoids recursion

        driver.get(getWebsiteUrl());
        initializePages();
        loginToApplication();
        navigateToTransporterSettings();
    }

    /**
     * Initialize page objects.
     */
    private void initializePages() {
        loginPageCommonMethods = new LoginPageCommonMethods(driver);
        homepage = new HomePage(driver);
        transporterPage = new TransporterPage(driver);
    }

    /**
     * Login helper.
     */
    private void loginToApplication() {
        String userType = System.getProperty("userType", "admin");
        String credentials = configLoader.getUserCredentials(userType);

        String[] credentialParts = credentials.split(":");
        if (credentialParts.length < 2) {
            throw new IllegalArgumentException("Invalid credential format. Expected username:password");
        }

        String username = credentialParts[0];
        String password = credentialParts[1];

        logger.info("Logging in as user: {}", username);

        loginPageCommonMethods.enterUsername(username);
        loginPageCommonMethods.enterPassword(password);
        loginPageCommonMethods.clickLoginButton();
    }

    /**
     * Navigate through menu to reach Transporter settings.
     */
    private void navigateToTransporterSettings() throws InterruptedException {
        logger.info("Navigating to Transporter settings");

        homepage.selectProject(configLoader.getProperty("project.name"));
        homepage.navigateToMenu(MENU_SETTINGS, MENU_GENERAL, MENU_TRANSPORTER);

        Thread.sleep(2000); // keep as-is unless you want WebDriverWait
    }

    @Test
    public void testMethod() {
        System.out.println("Test executed.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
