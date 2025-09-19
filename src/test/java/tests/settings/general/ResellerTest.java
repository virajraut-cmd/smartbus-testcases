package tests.settings.general;

import configurations.base.TestBase;
import configurations.config.ConfigLoader;
import listeners.CustomTestListener;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import commonMethods.LoginPageCommonMethods;
import web.pages.HomePage;
import web.pages.ResellerPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Listeners({CustomTestListener.class})
public class ResellerTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(ResellerTest.class);
    private static final String MENU_SETTINGS = "Settings";
    private static final String MENU_GENERAL = "General";
    private static final String MENU_RESELLER = "Reseller";
    private final ConfigLoader configLoader = ConfigLoader.getInstance();
    private LoginPageCommonMethods loginPageCommonMethods;
    private HomePage homepage;
    private ResellerPage resellerPage;

    @BeforeMethod
    public void setUp() throws Exception {
        setUpWeb();
        driver.get(getWebsiteUrl());
        initializePages();
        loginToApplication();
        navigateToResellerSettings();
    }

    private void initializePages() {
        loginPageCommonMethods = new LoginPageCommonMethods(driver);
        homepage = new HomePage(driver);
        resellerPage = new ResellerPage(driver);
    }

    private void loginToApplication() {
        String userType = System.getProperty("userType", "admin");
        String credentials = configLoader.getUserCredentials(userType);
        String[] credentialParts = credentials.split(":");
        String username = credentialParts[0];
        String password = credentialParts[1];
        logger.info("Logging in as user: {}", username);
        loginPageCommonMethods.enterUsername(username);
        loginPageCommonMethods.enterPassword(password);
        loginPageCommonMethods.clickLoginButton();
    }

    private void navigateToResellerSettings() throws InterruptedException {
        logger.info("Navigating to Reseller settings");
        homepage.selectProject(configLoader.getProperty("project.name"));
        homepage.navigateToMenu(MENU_SETTINGS, MENU_GENERAL, MENU_RESELLER);
    }

    @Test
    public void shouldCreateResellerWhenAllDetailsAreProvided() {
        resellerPage.createResellerUser()
                .addResellerDetails()
                .addRuleOfReseller()
                .addUserSettingOfReseller()
                .addDataAccessOfReseller()
                .addMapOfReseller()
                .addEmailOfReseller()
                .addSmsOfReseller()
                .addPaymentGatewayOfReseller()
                .addRenameLabelOfReseller()
                .addIVROfReseller()
                .addChatbotOfReseller()
                .addSocialMediaApiOfReseller()
                .addDocumentOfReseller()
                .addAuthenticationOfReseller()
                .addSingleSignOnOfReseller()
                .saveButtonOfReseller()
                .verifyTheCreatedAndDeleteReseller();
    }

    @Test
    public void shouldCreateEditAndDeleteResellerSuccessfully() {
        resellerPage.createResellerUser()
                .addResellerDetails()
                .addRuleOfReseller()
                .addUserSettingOfReseller()
                .addDataAccessOfReseller()
                .addMapOfReseller()
                .addEmailOfReseller()
                .addSmsOfReseller()
                .addPaymentGatewayOfReseller()
                .addRenameLabelOfReseller()
                .addIVROfReseller()
                .addChatbotOfReseller()
                .addSocialMediaApiOfReseller()
                .addDocumentOfReseller()
                .addAuthenticationOfReseller()
                .addSingleSignOnOfReseller()
                .saveButtonOfReseller()
                .searchResellerUser()
                .clickOnCreatedResellerUser()
                .editResellerDetails()
                .editRuleDetailsOfReseller()
                .editUserSettingOfReseller()
                .editDataAccessOfReseller()
                .editMapOfReseller()
                .editPaymentGatewayOfReseller()
                .editRenameLabelOfReseller()
                .editIVROfReseller()
                .saveButtonOfReseller()
                .searchEditedResellerUser()
                .verifyThatResellerDetailsAreEdited()
                .clickOnEditedResellerUser()
                .deleteResellerUser()
                .searchEditedResellerUser()
                .verifyResellerUserIsDeleted();
    }

    @Test
    public void shouldShowValidationMessagesWhenCreatingResellerWithInvalidData() {
        resellerPage.createResellerUser()
                .fillResellerDetailsWithValidation()
                .fillResellerRuleDetailsWithValidation()
                .fillResellerPaymentGatewayDetailsWithValidation()
                .saveButtonOfReseller()
                .verifyTheCreatedAndDeleteReseller();
    }

    @AfterMethod
    public void tearDownAfterTest() {
        tearDown();
    }
}
