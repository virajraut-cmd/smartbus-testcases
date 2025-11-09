package web.pages;

import commonMethods.CompanyPageCommonMethods;
import commonMethods.EmployeePageCommonMethods;
import configurations.common.CommonMethods;
import configurations.common.IframesOfApplication;
import configurations.common.WaitUtils;
import configurations.config.ConfigLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.Assert;
import web.locators.CompanySubUserLocators;

public class CompanySubUserPage {

    private static final Logger logger = LogManager.getLogger(CompanySubUserPage.class);
    private final WebDriver driver;
    private final CompanyPageCommonMethods companyPageCommonMethods;
    private final EmployeePageCommonMethods employeePageCommonMethods;
    private final WaitUtils waitUtils;
    private final IframesOfApplication iframesOfApplication;
    private final CommonMethods commonMethods;
    private final String password = "Test@123";
    private String editmobileNumber = "Test@123";
    private String userName;

    public CompanySubUserPage(WebDriver driver) {
        this.driver = driver;
        this.companyPageCommonMethods = new CompanyPageCommonMethods(driver);
        this.employeePageCommonMethods = new EmployeePageCommonMethods(driver);
        this.waitUtils = new WaitUtils(driver);
        this.iframesOfApplication = new IframesOfApplication(driver);
        this.commonMethods = new CommonMethods(driver);
    }

    public CompanySubUserPage createCompanySubUser() {
        logger.info("Creating company sub user");
        companyPageCommonMethods.addCompany();
        logger.info("Company sub user creation initiated");
        return this;
    }

    public CompanySubUserPage addMyAccountDetailsOfCompanySubUser() {
        logger.info("Adding company sub user details");
        selectCompanyInCompanySubUser("Alfonso");
        enterUserName();
        enterConfirmUserName();
        enterPassword();
        enterRetypePassword();
        enterMobileNumber();
        enterEmailId();
        logger.info("Company sub user details added");
        return this;
    }

    public CompanySubUserPage addDataAccessForCompanySubUser() {
        logger.info("Adding data access for company sub user");
        companyPageCommonMethods.selectTab("ContentRights");
        selectSendCommandInCompanySubUser("Hourly");
        logger.info("data access added to company sub user");
        return this;
    }

    public CompanySubUserPage addUserSettingsForCompanySubUser() {
        logger.info("Adding User Settings for company sub user");
        companyPageCommonMethods.selectTab("Settings");
        selectTimeZoneInUserSettingOfCompanySubUser("UTC+01:00 - Africa/Algiers");
        selectTimeZoneInUserSettingOfCompanySubUser("UTC+05:30 - Asia/Kolkata");
        selectDateFormatOfCompanySubUser("MM/dd/yyyy");
        selectTimeFormatOfCompanySubUser("24 - Hour");
        selectWeekStartDayOfCompanySubUser("Monday");
        selectStartUpScreenOfCompanySubUser("Dashboard");
        selectUserStatusOfCompanySubUser();
        selectShowDefaultFilterOptionOfCompanySubUser();
        selectWebAccessOfCompanySubUser();
        selectMobileAccessOfCompanySubUser();
        logger.info("User Settings added to company sub user");
        return this;
    }

    public CompanySubUserPage addAuthenticationForCompanySubUser() {
        logger.info("Adding Authentication for company sub user");
        companyPageCommonMethods.selectTab("Authentication");
        selectAuthenticationRequiredOfCompanySubUser("User Login");
        selectProvideVerificationMediumOfCompanySubUser();
        logger.info("Authentication added to company sub user");
        return this;
    }

    public CompanySubUserPage addSSOForCompanySubUser() {
        logger.info("Adding SSO for company sub user");
        companyPageCommonMethods.selectTab("SSO");
        addButtonInsideSsoOfCompanySubUser("__sso_provider_name");
        selectConfigurationOfCompanySubUser("Inherit");
        selectConfigurationOfCompanySubUser("Custom");
        selectProviderOfCompanySubUser("OKTA");
        selectProviderOfCompanySubUser("Azure");
        enterClientId("00000000-0000-0000-0000-000000000000");
        enterClientSecret("dummy-client-secret-1234567890");
        enterTenantId("11111111-1111-1111-1111-111111111111");
        companyPageCommonMethods.saveButtonOfDialogBox();
        logger.info("SSO added to company sub user");
        return this;
    }

    public void selectResellerInCompanySubUser(String resellerName) {
        logger.info("Entering selectReseller method with resellerName: {}", resellerName);
        iframesOfApplication.switchToContentFrame();
        By resellerDropdownLocator = CompanySubUserLocators.RESELLER_DROPDOWN;
        By resellerOtionLocator = By.xpath(String.format(CompanySubUserLocators.RESELLER_DROPDOWN_OPTION, resellerName));
        commonMethods.selectFromDropdown(resellerDropdownLocator, resellerOtionLocator, true);
        logger.info("Exiting selectReseller method");
    }

    public void selectCompanyInCompanySubUser(String companyName) {
        logger.info("Entering select company method with companyName: {}", companyName);
        iframesOfApplication.switchToContentFrame();
        By companyDropdownLocator = CompanySubUserLocators.COMPANY_DROPDOWN;
        By companyOtionLocator = By.xpath(String.format(CompanySubUserLocators.COMPANY_DROPDOWN_OPTION, companyName));
        commonMethods.selectFromDropdown(companyDropdownLocator, companyOtionLocator,true);
        logger.info("Exiting select company method");
    }

    public void enterUserName() {
        this.userName = CommonMethods.generateRandomEmail();
        logger.info("Entering username for company sub user: {}", this.userName);
        iframesOfApplication.switchToContentFrame();
        WebElement enterUserNameField = waitUtils.waitForElementToBeClickable(CompanySubUserLocators.USERNAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterUserNameField);
        enterUserNameField.sendKeys(this.userName);
        logger.info("Username entered for company sub user: {}", this.userName);
    }

    public void enterConfirmUserName() {
        logger.info("Entering confirmation username for company sub user");
        iframesOfApplication.switchToContentFrame();
        WebElement enterConfirmUserNameField = waitUtils.waitForElementToBeClickable(CompanySubUserLocators.CONFIRM_USERNAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterConfirmUserNameField);
        enterConfirmUserNameField.sendKeys(this.userName);
        logger.info("Confirmation username entered for company sub user");
    }

    public void enterPassword() {
        logger.info("Entering password for company sub user");
        iframesOfApplication.switchToContentFrame();
        WebElement passwordField = waitUtils.waitForElementToBeClickable(CompanySubUserLocators.PASSWORD_FIELD);
        passwordField.sendKeys(password);
        logger.info("Password entered for company sub user");
    }

    public void enterRetypePassword() {
        logger.info("Entering retype password for company sub user");
        iframesOfApplication.switchToContentFrame();
        WebElement retypePasswordField = waitUtils.waitForElementToBeClickable(CompanySubUserLocators.RETYPE_PASSWORD_FIELD);
        retypePasswordField.sendKeys(password);
        logger.info("Retype password entered for company sub user");
    }

    public void selectEmployeeSelfInCompanySubUser(String employeeSelfName) {
        logger.info("Entering select employee self method with employeeName {}", employeeSelfName);
        iframesOfApplication.switchToContentFrame();
        By employeeSelfDropdownLocator = CompanySubUserLocators.EMPLOYEE_SELF_DROPDOWN;
        By employeeSelfOptionLocator = By.xpath(String.format(CompanySubUserLocators.EMPLOYEE_SELF_DROPDOWN_OPTION, employeeSelfName));
        commonMethods.selectFromDropdown(employeeSelfDropdownLocator, employeeSelfOptionLocator,true);
        logger.info("Exiting select employee self method");
    }

    public void selectEmployeeInCompanySubUser(String employeeName) {
        logger.info("Entering select employee method with employeeName {}", employeeName);
        iframesOfApplication.switchToContentFrame();
        By employeeDropdownLocator = CompanySubUserLocators.EMPLOYEE_DROPDOWN;
        By employeeOtionLocator = By.xpath(String.format(CompanySubUserLocators.EMPLOYEE_DROPDOWN_OPTION, employeeName));
        commonMethods.selectFromDropdown(employeeDropdownLocator, employeeOtionLocator,true);
        logger.info("Exiting select employee method");
    }

    public void enterMobileNumber() {
        String mobileNumber = CommonMethods.generateRandomMobileNumber();
        logger.info("Entering mobile number for company sub user: {}", mobileNumber);
        iframesOfApplication.switchToContentFrame();
        WebElement enterMobileNumber = waitUtils.waitForElementToBeClickable(CompanySubUserLocators.MOBILE_NUMBER_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", enterMobileNumber);
        enterMobileNumber.sendKeys(mobileNumber);
        logger.info("Mobile number entered for company sub user: {}", mobileNumber);
    }

    public CompanySubUserPage editMobileNumber() {
        this.editmobileNumber = CommonMethods.generateRandomMobileNumber();
        logger.info("Entering edit mobile number for company sub user: {}", editmobileNumber);
        iframesOfApplication.switchToContentFrame();
        WebElement enterMobileNumber = waitUtils.waitForElementToBeClickable(CompanySubUserLocators.MOBILE_NUMBER_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", enterMobileNumber);
        enterMobileNumber.sendKeys(this.editmobileNumber);
        logger.info("edit Mobile number entered for company sub user: {}", editmobileNumber);
        return this;
    }

    public void enterEmailId() {
        String emailId = CommonMethods.generateRandomEmail();
        iframesOfApplication.switchToContentFrame();
        WebElement emailIdField = waitUtils.waitForElementToBeClickable(CompanySubUserLocators.PASSWORD_RECOVERY_EMAIL_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", emailIdField);
        emailIdField.sendKeys(emailId);
    }

    public void selectSendCommandInCompanySubUser(String scheduleFor) {
        logger.info(" Selecting send command method with scheduler {}", scheduleFor);
        iframesOfApplication.switchToContentFrame();
        By sendCommandDropdownLocator = CompanySubUserLocators.SEND_COMMAND_DROPDOWN;
        By sendCommandOtionLocator = By.xpath(String.format(CompanySubUserLocators.SEND_COMMAND_DROPDOWN_OPTION, scheduleFor));
        commonMethods.selectFromDropdown(sendCommandDropdownLocator, sendCommandOtionLocator,true);
        logger.info("Exiting select send command method with scheduler");
    }

    public void selectTimeZoneInUserSettingOfCompanySubUser(String timezoneName) {
        logger.info("Selecting timezone in user settings for company sub user: {}", timezoneName);
        iframesOfApplication.switchToContentFrame();
        By timezoneDropdownLocator = CompanySubUserLocators.TIMEZONE_DROPDOWN;
        By timezoneOptionLocator = By.xpath(String.format(CompanySubUserLocators.TIMEZONE_DROPDOWN_OPTION, timezoneName));
        commonMethods.selectFromDropdown(timezoneDropdownLocator, timezoneOptionLocator,true);
        logger.info("Timezone selected in user settings for company sub user: {}", timezoneName);
    }

    public void selectDateFormatOfCompanySubUser(String dateFormat) {
        iframesOfApplication.switchToContentFrame();
        By dateFormatDropdownLocator = CompanySubUserLocators.DATE_FORMAT_DROPDOWN;
        By dateFormatOptionLocator = By.xpath(String.format(CompanySubUserLocators.DATE_FORMAT_DROPDOWN_OPTION, dateFormat));
        commonMethods.selectFromDropdown(dateFormatDropdownLocator, dateFormatOptionLocator,true);
    }

    public void selectTimeFormatOfCompanySubUser(String timeFormat) {
        iframesOfApplication.switchToContentFrame();
        By timeFormatDropdownLocator = CompanySubUserLocators.TIME_FORMAT_DROPDOWN;
        By timeFormatOptionLocator = By.xpath(String.format(CompanySubUserLocators.TIME_FORMAT_DROPDOWN_OPTION, timeFormat));
        commonMethods.selectFromDropdown(timeFormatDropdownLocator, timeFormatOptionLocator,true);
    }

    public void selectWeekStartDayOfCompanySubUser(String days) {
        logger.info("Selecting week start day for company sub user: {}", days);
        iframesOfApplication.switchToContentFrame();
        By weekStartDayDropdownLocator = CompanySubUserLocators.WEEK_START_DAY_FORMAT_DROPDOWN;
        By weekStartDayOptionLocator = By.xpath(String.format(CompanySubUserLocators.WEEK_START_DAY_FORMAT_DROPDOWN_OPTION, days));
        commonMethods.selectFromDropdown(weekStartDayDropdownLocator, weekStartDayOptionLocator,true);
        logger.info("Week start day selected for company sub user: {}", days);
    }

    public void selectMonthStartDayOfCompanySubUser(String days) {
        logger.info("Selecting Month start day for company sub user: {}", days);
        iframesOfApplication.switchToContentFrame();
        By monthStartDayDropdownLocator = CompanySubUserLocators.MONTH_START_DAY_DROPDOWN;
        By monthStartDayOptionLocator = By.xpath(String.format(CompanySubUserLocators.MONTH_START_DAY_DROPDOWN_OPTION, days));
        commonMethods.selectFromDropdown(monthStartDayDropdownLocator, monthStartDayOptionLocator,true);
        logger.info("Month start day selected for company sub user: {}", days);
    }

    public void selectStartUpScreenOfCompanySubUser(String screenName) {
        iframesOfApplication.switchToContentFrame();
        By startUpScreenDropdownLocator = CompanySubUserLocators.STARTUP_SCREEN_DROPDOWN;
        By startUpScreenOptionLocator = By.xpath(String.format(CompanySubUserLocators.STARTUP_SCREEN_DROPDOWN_OPTION, screenName));
        commonMethods.selectFromDropdown(startUpScreenDropdownLocator, startUpScreenOptionLocator,true);
    }

    public void selectUserStatusOfCompanySubUser() {
        iframesOfApplication.switchToContentFrame();
        commonMethods.selectRadioButton(CompanySubUserLocators.USER_STATUS_INACTIVE);
        commonMethods.selectRadioButton(CompanySubUserLocators.USER_STATUS_ACTIVE);
    }

    public void selectShowDefaultFilterOptionOfCompanySubUser() {
        iframesOfApplication.switchToContentFrame();
        commonMethods.selectRadioButton(CompanySubUserLocators.SHOW_DEFAULT_FIlTER_OPTION_IS_OFF);
        commonMethods.selectRadioButton(CompanySubUserLocators.SHOW_DEFAULT_FIlTER_OPTION_IS_ON);
    }

    public void selectWebAccessOfCompanySubUser() {
        iframesOfApplication.switchToContentFrame();
        commonMethods.selectRadioButton(CompanySubUserLocators.WEB_ACCESS_NONE);
        commonMethods.selectRadioButton(CompanySubUserLocators.WEB_ACCESS_ALL);
    }

    public void selectMobileAccessOfCompanySubUser() {
        iframesOfApplication.switchToContentFrame();
        commonMethods.selectRadioButton(CompanySubUserLocators.MOBILE_ACCESS_NONE);
        commonMethods.selectRadioButton(CompanySubUserLocators.MOBILE_ACCESS_ALL);
    }

    public void selectAuthenticationRequiredOfCompanySubUser(String authenticationRequiredOption) {
        logger.info("Selecting Authentication Required for company sub user: {}", authenticationRequiredOption);
        iframesOfApplication.switchToContentFrame();
        By authenticationRequiredDropdownLocator = CompanySubUserLocators.AUTHENTICATION_REQUIRED_DROPDOWN;
        By authenticationRequiredOptionLocator = By.xpath(String.format(CompanySubUserLocators.AUTHENTICATION_REQUIRED_DROPDOWN_OPTION, authenticationRequiredOption));
        commonMethods.selectFromDropdown(authenticationRequiredDropdownLocator, authenticationRequiredOptionLocator,true);
        logger.info("Authentication Required for selected for company sub user: {}", authenticationRequiredOption);
    }

    public void selectProvideVerificationMediumOfCompanySubUser() {
        iframesOfApplication.switchToContentFrame();
        commonMethods.selectRadioButton(CompanySubUserLocators.PROVIDE_VERIFICATION_MEDIUM_BOTH);
    }

    public void addButtonInsideSsoOfCompanySubUser(String name) {
        logger.info("Entering addButtonInsideSsoOfCompanySubUser method with name: {}", name);
        iframesOfApplication.switchToCompanySubUserSsoContentFrame();
        String dynamicXpath = String.format(CompanySubUserLocators.ADD_BUTTON_INSIDE_COMPANY_SUB_USER, name);
        WebElement addButtonInsideSsoOfCompanySubUser = waitUtils.waitForElementToBeClickable(By.xpath(dynamicXpath));
        addButtonInsideSsoOfCompanySubUser.click();
        logger.info("Exiting addButtonInsideSsoOfCompanySubUser method");
    }

    public void selectConfigurationOfCompanySubUser(String configurationType) {
        iframesOfApplication.switchToPopUpDialogFrame();
        By configurationTypeDropdownLocator = CompanySubUserLocators.CONFIGURATION_TYPE_DROPDOWN;
        By configurationTypeOptionLocator = By.xpath(String.format(CompanySubUserLocators.CONFIGURATION_TYPE_DROPDOWN_OPTION, configurationType));
        commonMethods.selectFromDropdown(configurationTypeDropdownLocator, configurationTypeOptionLocator,true);
    }

    public void selectProviderOfCompanySubUser(String providerName) {
        logger.info("Selecting provider for company sub user: {}", providerName);
        iframesOfApplication.switchToPopUpDialogFrame();
        By providerDropdownLocator = CompanySubUserLocators.PROVIDER_DROPDOWN;
        By providerOptionLocator = By.xpath(String.format(CompanySubUserLocators.PROVIDER_DROPDOWN_OPTION, providerName));
        commonMethods.selectFromDropdown(providerDropdownLocator, providerOptionLocator,true);
        logger.info("provider for selected for company sub user: {}", providerName);
    }

    public void enterClientId(String clientId) {
        iframesOfApplication.switchToPopUpDialogFrame();
        WebElement enterUserNameField = waitUtils.waitForElementToBeClickable(CompanySubUserLocators.CLIENT_ID_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterUserNameField);
        enterUserNameField.sendKeys(clientId);
    }

    public void enterClientSecret(String clientSecret) {
        iframesOfApplication.switchToPopUpDialogFrame();
        WebElement enterUserNameField = waitUtils.waitForElementToBeClickable(CompanySubUserLocators.CLIENT_SECRET_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterUserNameField);
        enterUserNameField.sendKeys(clientSecret);
    }

    public void enterTenantId(String tenantId) {
        iframesOfApplication.switchToPopUpDialogFrame();
        WebElement enterUserNameField = waitUtils.waitForElementToBeClickable(CompanySubUserLocators.TENANT_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterUserNameField);
        enterUserNameField.sendKeys(tenantId);
    }

    public CompanySubUserPage saveButtonOfCompanySubUser() {
        logger.info("Saving company details sub user");
        companyPageCommonMethods.saveButton();
        logger.info("Company details saved sub user");
        return this;
    }

    public CompanySubUserPage selectFileFrequencyCompanySubUser() {
        String fileFrequencyType = "Weekly";
        iframesOfApplication.switchToContentFrame();
        By fileFrequencyTypeDropdownLocator = CompanySubUserLocators.FILE_FREQUENCY_TYPE_DROPDOWN;
        By fileFrequencyTypeOptionLocator = By.xpath(String.format(CompanySubUserLocators.FILE_FREQUENCY_TYPE_DROPDOWN_OPTION, fileFrequencyType));
        commonMethods.selectFromDropdown(fileFrequencyTypeDropdownLocator, fileFrequencyTypeOptionLocator,true);
        return this;
    }

    public CompanySubUserPage submitButton() {
        logger.info("Entering submitButton method");
        iframesOfApplication.switchToContentFrame();
        WebElement saveButton = waitUtils.waitForElementToBeClickable(CompanySubUserLocators.SUBMIT_BUTTON);
        saveButton.click();
        waitUtils.waitForMilliseconds(1000);
        logger.info("Exiting submitButton method");
        return this;
    }

    public void verifyTheCreatedAndDeleteCompany() {
        logger.info("Verifying the created and delete company sub user");
        searchTheCompanySubUser();
        clickOnCreatedCompanySubUser();
        companyPageCommonMethods.deleteCompanyButton();
        searchTheCompanySubUser();
        employeePageCommonMethods.assertNoRecordsFoundLabelDisplayed();
        logger.info("Created company sub user verified and deleted");
    }

    public CompanySubUserPage searchTheCompanySubUser() {
        logger.info("Entering searchTheCompanySubUser method");
        iframesOfApplication.switchToBottomFrame();
        WebElement searchField = waitUtils.waitForElementToBeClickable(CompanySubUserLocators.SEARCH_FIELD);
        searchField.sendKeys(this.userName);
        searchField.sendKeys(Keys.ENTER);
        logger.info("Exiting searchTheCompanySubUser method");
        return this;
    }

    public CompanySubUserPage clickOnCreatedCompanySubUser() {
        logger.info("Entering clickOnCreatedCompanySubUser method");
        waitUtils.waitForMilliseconds(3000);
        iframesOfApplication.switchToContentFrame();
        String formattedXpath = String.format(CompanySubUserLocators.TABLE_OF_USER_NAME, this.userName);
        commonMethods.doubleClick(By.xpath(formattedXpath));
        logger.info("Exiting clickOnCreatedCompanySubUser method");
        return this;
    }

    public CompanySubUserPage verifyThatMobileNumberEdited() {
        iframesOfApplication.switchToContentFrame();
        boolean isEdited = commonMethods.isTextPresentInTable(this.editmobileNumber);
        Assert.assertTrue(isEdited, "Short Name '" + this.editmobileNumber + "' was not edited successfully.");
        return this;
    }
}
