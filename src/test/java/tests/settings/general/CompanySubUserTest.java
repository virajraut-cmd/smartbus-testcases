package tests.settings.general;

import commonMethods.LoginPageCommonMethods;
import configurations.base.TestBase;
import configurations.config.ConfigLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.pages.CompanySubUserPage;
import web.pages.HomePage;

public class CompanySubUserTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(CompanySubUserTest.class);
    private static final String MENU_SETTINGS = "Settings";
    private static final String MENU_GENERAL = "General";
    private static final String MENU_COMPANY_SUBUSER = "Company Subuser";
    private final ConfigLoader configLoader = ConfigLoader.getInstance();
    private LoginPageCommonMethods loginPageCommonMethods;
    private CompanySubUserPage companySubUserPage;
    private HomePage homepage;


    @BeforeMethod
    public void setUp() throws Exception {
        setUpWeb();
        driver.get(getWebsiteUrl());
        initializePages();
        loginToApplication();
        navigateToCompanySubuserSettings();
    }

    private void initializePages() {
        loginPageCommonMethods = new LoginPageCommonMethods(driver);
        homepage = new HomePage(driver);
        companySubUserPage = new CompanySubUserPage(driver);

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

    private void navigateToCompanySubuserSettings() throws InterruptedException {
        logger.info("Navigating to Company Subuser settings");
        homepage.selectProject(configLoader.getProperty("project.name"));
        homepage.navigateToMenu(MENU_SETTINGS, MENU_GENERAL, MENU_COMPANY_SUBUSER);
    }

    @Test
    public void shouldCreateCompanySubUserWhenAllDetailsAreProvided() {
        companySubUserPage.createCompanySubUser()
                .addMyAccountDetailsOfCompanySubUser()
                .addDataAccessForCompanySubUser()
                .addUserSettingsForCompanySubUser()
                .addAuthenticationForCompanySubUser()
                .addSSOForCompanySubUser()
                .saveButtonOfCompanySubUser()
                .selectFileFrequencyCompanySubUser()
                .submitButton()
                .verifyTheCreatedAndDeleteCompany();
    }

  
}
