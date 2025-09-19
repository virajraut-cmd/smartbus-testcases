package tests.settings.general;

import configurations.base.TestBase;
import configurations.config.ConfigLoader;
import listeners.CustomTestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import commonMethods.LoginPageCommonMethods;
import web.pages.CompanyPage;
import web.pages.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Listeners({CustomTestListener.class})
public class CompanyTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(CompanyTest.class);
    private static final String MENU_SETTINGS = "Settings";
    private static final String MENU_GENERAL = "General";
    private static final String MENU_COMPANY = "School";
    private final ConfigLoader configLoader = ConfigLoader.getInstance();
    private LoginPageCommonMethods loginPageCommonMethods;
    private HomePage homepage;
    private CompanyPage companyPage;

    @BeforeMethod
    public void setUp() throws Exception {
        setUpWeb();
        driver.get(getWebsiteUrl());
        initializePages();
        loginToApplication();
        navigateToCompanySettings();
    }

    private void initializePages() {
        loginPageCommonMethods = new LoginPageCommonMethods(driver);
        homepage = new HomePage(driver);
        companyPage = new CompanyPage(driver);
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

    private void navigateToCompanySettings() throws InterruptedException {
        logger.info("Navigating to Company settings");
        homepage.selectProject(configLoader.getProperty("project.name"));
        homepage.navigateToMenu(MENU_SETTINGS, MENU_GENERAL, MENU_COMPANY);
    }

    @Test
    public void shouldCreateAndDeleteCompanyWithAllMyAccountDetails() {
        companyPage.createCompanyUser()
                .addMyAccountDetailsOfCompany()
                .saveButtonOfCompany()
                .verifyTheCreatedAndDeleteCompany();
    }

    @Test
    public void shouldCreateAndDeleteCompanyWithAllRuleTabDetails() {
        companyPage.createCompanyUser()
                .addMyAccountDetailsOfCompany()
                .addRuleOfCompany()
                .saveButtonOfCompany()
                .verifyTheCreatedAndDeleteCompany();
    }

    @Test
    public void shouldCreateAndDeleteCompanyWithAllUserSettingsTabDetails() {
        companyPage.createCompanyUser()
                .addMyAccountDetailsOfCompany()
                .addUserSettingOfCompany()
                .saveButtonOfCompany()
                .verifyTheCreatedAndDeleteCompany();
    }

    @Test
    public void shouldCreateAndDeleteCompanyWithAllMapTabDetails() {
        companyPage.createCompanyUser()
                .addMyAccountDetailsOfCompany()
                .addMapOfCompany()
                .saveButtonOfCompany()
                .verifyTheCreatedAndDeleteCompany();
    }

    @Test
    public void shouldCreateAndRemoveCompanyWithDesignationDepartmentTaskAndExpenseDetails() {
        companyPage.createCompanyUser()
                .addMyAccountDetailsOfCompany()
                .addDesignationOfCompany()
                .addDepartmentOfCompany()
                .addTaskCategoryOfCompany()
                .addExpenseCategoryOfCompany()
                .saveButtonOfCompany()
                .verifyTheCreatedAndDeleteCompany();
    }

    @Test
    public void shouldCreateAndRemoveCompanyWithShiftFinanceApproverSosCategoryAndLeaveReasonDetails() {
        companyPage.createCompanyUser()
                .addMyAccountDetailsOfCompany()
                .addShiftOfCompany()
                .addFinanceApproverOfCompany()
                .addSosCategoryOfCompany()
                .addLeaveReasonOfCompany()
                .saveButtonOfCompany()
                .verifyTheCreatedAndDeleteCompany();
    }

    @Test
    public void shouldCreateEditAndDeleteCompanySuccessfully() {
        companyPage.createCompanyUser()
                .addMyAccountDetailsOfCompany()
                .saveButtonOfCompany()
                .searchCompanyUser()
                .clickOnCreatedCompanyUser()
                .editCompanyDetails()
                .verifyThatCompanyDetailsAreEdited()
                .editSearchCompanyUser()
                .clickOnEditedCompanyUser()
                .deleteCompanyUser()
                .editSearchCompanyUser()
                .verifyCompanyUserIsDeleted();
    }

    @Test
    public void shouldShowValidationMessagesWhenCreatingCompanyWithInvalidData() {
        companyPage.createCompanyUser()
                .fillCompanyDetailsWithValidation()
                .fillCompanyRuleDetailsWithValidation()
                .fillCompanyShiftDetailsWithValidation()
                .saveButtonOfCompany()
                .verifyTheCreatedAndDeleteCompany();
    }

    @Test
    public void shouldCreateAndDeleteCompanyWhenUserAlreadyExists() {
        companyPage.createCompanyUser()
                .fillCompanyDetailsWithDuplicateValidation()
                .saveButtonOfCompany()
                .verifyTheCreatedAndDeleteCompany();
    }

    @Test
    public void shouldDisplayAllFieldsOnCreateCompanyPage() {
        companyPage.createCompanyUser()
                .verifyThatMyAccountsTabAllTheFieldsArePresent()
                .verifyThatRuleTabOfCompanyAllTheFieldsArePresent()
                .verifyThatUserSettingTabAllTheFieldsArePresent()
                .verifyThatDataAccessTabAllTheFieldsArePresent()
                .verifyThatMapTabAllTheFieldsArePresent()
                .verifyThatEmailTabAllTheFieldsArePresent()
                .verifyThatSmsTabAllTheFieldsArePresent()
                .verifyThatDesignationTabAllTheFieldsArePresent()
                .verifyThatDepartmentTabAllTheFieldsArePresent()
                .verifyThatTaskCategoryTabAllTheFieldsArePresent()
                .verifyThatExpenseCategoryTabAllTheFieldsArePresent()
                .verifyThatShiftTabOfCompanyAllTheFieldsArePresent()
                .verifyThatFinanceApproverTabAllTheFieldsArePresent()
                .verifyThatSosCategoryTabAllTheFieldsArePresent()
                .verifyThatLeaveReasonTabAllTheFieldsArePresent();
    }

    @AfterMethod
    public void tearDownAfterTest() {
        tearDown();
    }
}
