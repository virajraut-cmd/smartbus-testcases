package web.pages;

import commonMethods.CompanyPageCommonMethods;
import commonMethods.EmployeePageCommonMethods;
import configurations.common.IframesOfApplication;
import configurations.config.ConfigLoader;
import configurations.common.WaitUtils;
import org.openqa.selenium.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.locators.CompanyPageLocators;

public class CompanyPage {
    private static final Logger logger = LogManager.getLogger(CompanyPage.class);
    private final WebDriver driver;
    private final CompanyPageCommonMethods companyPageCommonMethods;
    private final EmployeePageCommonMethods employeePageCommonMethods;
    private final PermissionPage permissionPage;
    private final WaitUtils waitUtils;
    private final IframesOfApplication iframesOfApplication;

    public CompanyPage(WebDriver driver) {
        this.driver = driver;
        this.companyPageCommonMethods = new CompanyPageCommonMethods(driver);
        this.employeePageCommonMethods = new EmployeePageCommonMethods(driver);
        this.permissionPage = new PermissionPage(driver);
        this.waitUtils = new WaitUtils(driver);
        this.iframesOfApplication = new IframesOfApplication(driver);

    }

    public CompanyPage createCompanyUser() {
        logger.info("Creating company user");
        companyPageCommonMethods.addCompany();
        logger.info("Company user creation initiated");
        return this;
    }

    public CompanyPage addMyAccountDetailsOfCompany() {
        logger.info("Adding company details");
        companyPageCommonMethods.selectReseller(ConfigLoader.getInstance().getProperty("reseller.name"));
        waitUtils.waitForMilliseconds(1000);
        companyPageCommonMethods.enterShortName();
        companyPageCommonMethods.enterUserName();
        companyPageCommonMethods.enterConfirmUserName();
        companyPageCommonMethods.enterPassword();
        companyPageCommonMethods.enterRetypePassword();
        companyPageCommonMethods.enterPasswordRecoveryEmail();
        companyPageCommonMethods.enterTelephoneNumber();
        companyPageCommonMethods.enterMobileNumber();
        companyPageCommonMethods.selectCountry("India");
        companyPageCommonMethods.selectState("Gujarat");
        companyPageCommonMethods.enterCity();
        companyPageCommonMethods.enterZipcode();
        companyPageCommonMethods.enterStreet1();
        companyPageCommonMethods.enterStreet2();
        companyPageCommonMethods.enterContactPerson();
        companyPageCommonMethods.enterFaxNumber();
        companyPageCommonMethods.clickOnAddLocationButton();
        companyPageCommonMethods.EnterSchoolRegistrationNumber();
//        companyPageCommonMethods.enterVATINNumber();
        logger.info("Company details added");
        return this;
    }

    public CompanyPage addRuleOfCompany() {
        logger.info("Adding rule to company");
        companyPageCommonMethods.selectTab("Rule");
        companyPageCommonMethods.addButtonInsideRuleOfCompany("__rule_name");
        companyPageCommonMethods.enterRuleName();
        companyPageCommonMethods.validFromDate();
        companyPageCommonMethods.selectEventDateFormat("MM-dd-yyyy");
        companyPageCommonMethods.selectTimeFormatOfRule("24 - hour");
        companyPageCommonMethods.saveButtonOfDialogBox();
        logger.info("Rule added to company");
        return this;
    }

    public CompanyPage addUserSettingOfCompany() {
        logger.info("Configuring user settings for the company");
        companyPageCommonMethods.selectTab("Setting");
        companyPageCommonMethods.selectTimeZone("UTC+01:00 - Africa/Algiers");
        companyPageCommonMethods.selectTimeZone("UTC+05:30 - Asia/Kolkata");
        companyPageCommonMethods.selectDateFormat("MM/dd/yyyy");
        companyPageCommonMethods.selectDateFormat("dd-MM-yyyy");
        companyPageCommonMethods.selectTimeFormat("24 - Hour");
        companyPageCommonMethods.selectTimeFormat("12 - Hour");
        companyPageCommonMethods.selectUnitsOfDistance("Nautical mile");
        companyPageCommonMethods.selectUnitsOfDistance("Kilometer");
        companyPageCommonMethods.selectUserStatus();
        companyPageCommonMethods.selectShowDefaultFilterOption();
        companyPageCommonMethods.checkWebNotification();
        companyPageCommonMethods.selectWebAccess();
        companyPageCommonMethods.selectNMobileAccess();
        logger.info("User settings configured for the company");
        return this;
    }

    public CompanyPage addScreenAccessOfCompany() {
        logger.info("Configuring screen access for the company");
        companyPageCommonMethods.selectTab("ScreenRights");
        waitUtils.waitForMilliseconds(1000);
        companyPageCommonMethods.selectCopyFromGroup("Add New");
        waitUtils.waitForMilliseconds(1000);
        permissionPage.clickOnTaskEyeProjectOfScreenAccess();
        waitUtils.waitForMilliseconds(1000);
        permissionPage.clickOnDashboardOfTaskEyeProjectOfScreenAccessOfCompany();
        waitUtils.waitForMilliseconds(1000);
        permissionPage.clickOnTrackingOfTaskEyeProjectOfScreenAccessOfCompany();
        waitUtils.waitForMilliseconds(1000);
        permissionPage.clickOnReportsOfActivityOfTaskEyeProjectOfScreenAccessOfCompany();
        waitUtils.waitForMilliseconds(1000);
        permissionPage.clickOnReportsOfApprovalsOfTaskEyeProjectOfScreenAccessOfCompany();
        waitUtils.waitForMilliseconds(1000);
        permissionPage.clickOnReportsOfGeofencePoiOfTaskEyeProjectOfScreenAccessOfCompany();
        waitUtils.waitForMilliseconds(1000);
        permissionPage.clickOnReportsOfAlertsOfTaskEyeProjectOfScreenAccessOfCompany();
        waitUtils.waitForMilliseconds(1000);
        permissionPage.clickOnReportsOfLogsOfTaskEyeProjectOfScreenAccessOfCompany();
        waitUtils.waitForMilliseconds(1000);
        permissionPage.clickOnChartOfTaskEyeProjectOfScreenAccessOfCompany();
        waitUtils.waitForMilliseconds(1000);
        permissionPage.clickOnSettingsOfGeneralOfTaskEyeProjectOfScreenAccessOfCompany();
        waitUtils.waitForMilliseconds(1000);
        permissionPage.clickOnSettingsOfMasterOfTaskEyeProjectOfScreenAccessOfCompany();
        waitUtils.waitForMilliseconds(1000);
        permissionPage.clickOnSettingsOfOrderManagementOfTaskEyeProjectOfScreenAccessOfCompany();
        waitUtils.waitForMilliseconds(1000);
        logger.info("Screen access configured for the company");
        return this;
    }

    public CompanyPage addDataAccessOfCompany() {
        logger.info("Configuring data access for the company");
        companyPageCommonMethods.selectTab("ContentRights");
        waitUtils.waitForMilliseconds(1000);
        companyPageCommonMethods.selectAlertOnDataAccessTabOfCompany();
        waitUtils.waitForMilliseconds(1000);
        companyPageCommonMethods.selectLanguageOnDataAccessTabOfCompany("Hindi");
        waitUtils.waitForMilliseconds(1000);
        companyPageCommonMethods.selectLanguageOnDataAccessTabOfCompany("English");
        waitUtils.waitForMilliseconds(1000);
        logger.info("Data access configured for the company");
        return this;
    }

    public CompanyPage addMapOfCompany() {
        logger.info("Adding map to the company");
        companyPageCommonMethods.selectTab("Map");
        companyPageCommonMethods.addButtonInsideMapOfCompany("__geomap_id");
        companyPageCommonMethods.selectMapOnMapTabOfCompany("GOOGLE");
        companyPageCommonMethods.enterWebMapKey("12345678-abcd-efgh-ijkl-1234567890ab");
        companyPageCommonMethods.enterMobileMapKey("98765432-zyxw-vuts-qrst-0987654321cd");
        companyPageCommonMethods.checkAddressFromMapProvider();
        companyPageCommonMethods.checkDefaultMap();
        logger.info("Map added to the company");
        return this;
    }

    public CompanyPage addEmailOfCompany() {
        logger.info("Adding email settings for the company");
        companyPageCommonMethods.selectTab("Email");
        logger.info("Email settings added for the company");
        return this;
    }

    public CompanyPage addSmsOfCompany() {
        logger.info("Adding SMS settings for the company");
        companyPageCommonMethods.selectTab("SMS");
        logger.info("SMS settings added for the company");
        return this;
    }

    public CompanyPage addDesignationOfCompany() {
        logger.info("Adding designation to the company");
        companyPageCommonMethods.selectTab("Designation");
        companyPageCommonMethods.addButtonInsideDesignation("__designation_name");
        companyPageCommonMethods.enterDesignationNameInAddDesignation();
        return this;
    }

    public CompanyPage addDepartmentOfCompany() {
        logger.info("Adding department to the company");
        companyPageCommonMethods.selectTab("Department");
        companyPageCommonMethods.addButtonInsideDepartment("__department_name_i");
        companyPageCommonMethods.enterDepartmentNameInAddDepartment();
        companyPageCommonMethods.enterDescriptionInAddDepartment();
        logger.info("Department added to the company");
        return this;
    }

    public CompanyPage addTaskCategoryOfCompany() {
        logger.info("Adding task category to the company");
        companyPageCommonMethods.selectTab("TaskCategory");
        companyPageCommonMethods.addButtonInsideTaskCategory("__task_category_name_i");
        companyPageCommonMethods.enterTaskCategoryNameInTaskCategory();
        companyPageCommonMethods.enterDescriptionInTaskCategory();
        logger.info("Task category added to the company");
        return this;
    }

    public CompanyPage addExpenseCategoryOfCompany() {
        logger.info("Adding expense category to the company");
        companyPageCommonMethods.selectTab("ExpenseCategory");
        companyPageCommonMethods.addButtonInsideExpenseCategory("__task_expense_category_name_i");
        companyPageCommonMethods.enterExpenseCategoryNameInExpenseCategory();
        companyPageCommonMethods.enterDescriptionInExpenseCategory();
        companyPageCommonMethods.isClaimableInExpenseCategory();
        logger.info("Expense category added to the company");
        return this;
    }

    public CompanyPage addShiftOfCompany() {
        logger.info("Adding shift to the company");
        companyPageCommonMethods.selectTab("Shift");
        companyPageCommonMethods.addButtonInsideShift("__shift_name");
        companyPageCommonMethods.enterShiftNameInShift();
        companyPageCommonMethods.selectValidFromDateForShift();
        companyPageCommonMethods.selectValidToDateForShift();
        companyPageCommonMethods.selectShiftType();
        companyPageCommonMethods.selectWorkingDays("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
        companyPageCommonMethods.selectDailyWorkingHourWithMinutes("08", "30");
        companyPageCommonMethods.saveButtonOfDialogBox();
        logger.info("Shift added to the company");
        return this;
    }

    public CompanyPage addFinanceApproverOfCompany() {
        logger.info("Adding finance Approver to the company");
        companyPageCommonMethods.selectTab("finance_approver");
        logger.info("Shift finance Approver to the company");
        return this;
    }

    public CompanyPage addSosCategoryOfCompany() {
        logger.info("Adding SOS Category to the company");
        companyPageCommonMethods.selectTab("sos_category");
        companyPageCommonMethods.addButtonInsideSosCategory("__category_type_id");
        companyPageCommonMethods.selectCategoryOnSOSCategoryTabOfCompany("High");
        companyPageCommonMethods.enterCategoryType("Accident Case");
        logger.info("SOS Category to the company");
        return this;
    }

    public CompanyPage addLeaveReasonOfCompany() {
        logger.info("Adding Leave Reason to the company");
        companyPageCommonMethods.selectTab("leave_reason");
        companyPageCommonMethods.addButtonInsideLeaveReason("__leave_reason_i");
        companyPageCommonMethods.enterLeaveReason("Vacation Leave");
        companyPageCommonMethods.enterLeaveReasonDescription("I need to go out for vacation");
        logger.info("Leave Reason to the company");
        return this;
    }

    public CompanyPage editScreenAccessOfCompany() {
        logger.info("Editing screen access for the company");
        companyPageCommonMethods.selectTab("ScreenRights");
        waitUtils.waitForMilliseconds(1000);
        permissionPage.clickOnTaskEyeProjectOfScreenAccess();
        waitUtils.waitForMilliseconds(1000);
        permissionPage.editOnDashboardOfTaskEyeProjectOfScreenAccessOfCompany();
        logger.info("Screen access edited for the company");
        return this;
    }

    public CompanyPage editUserSettingOfCompany() {
        logger.info("Editing user settings for the company");
        companyPageCommonMethods.selectTab("Setting");
        companyPageCommonMethods.selectTimeZone("UTC+01:00 - Africa/Algiers");
        companyPageCommonMethods.selectDateFormat("MM/dd/yyyy");
        companyPageCommonMethods.selectTimeFormat("24 - Hour");
        companyPageCommonMethods.selectUnitsOfDistance("Nautical mile");
        companyPageCommonMethods.selectUserStatus();
        companyPageCommonMethods.selectShowDefaultFilterOption();
        companyPageCommonMethods.checkWebNotification();
        companyPageCommonMethods.selectWebAccess();
        companyPageCommonMethods.selectNMobileAccess();
        logger.info("User settings edited for the company");
        return this;
    }

    public CompanyPage editDataAccessOfCompany() {
        logger.info("Editing data access for the company");
        companyPageCommonMethods.selectTab("ContentRights");
        companyPageCommonMethods.selectAlertOnDataAccessTabOfCompany();
        waitUtils.waitForMilliseconds(1000);
        companyPageCommonMethods.selectLanguageOnDataAccessTabOfCompany("Hindi");
        waitUtils.waitForMilliseconds(1000);
        logger.info("Data access edited for the company");
        return this;
    }

    public CompanyPage editMapOfCompany() {
        logger.info("Editing map for the company");
        companyPageCommonMethods.selectTab("Map");
        companyPageCommonMethods.editWebMapKey("12345678-abcd-efgh-ijkl-1234567890ab");
        companyPageCommonMethods.editMobileMapKey("98765432-zyxw-vuts-qrst-0987654321cd");
        companyPageCommonMethods.editUncheckAddressFromMapProvider();
        companyPageCommonMethods.editUncheckDefaultMap();
        logger.info("Map edited for the company");
        return this;
    }

    public CompanyPage editCompanyDetails() {
        logger.info("Editing company details");
        companyPageCommonMethods.editShortName();
        companyPageCommonMethods.editUserName();
        companyPageCommonMethods.editTelephoneNumber();
        companyPageCommonMethods.editMobileNumber();
        companyPageCommonMethods.selectCountry("India");
        companyPageCommonMethods.selectState("Delhi");
        companyPageCommonMethods.saveButton();
        logger.info("Company details edited");
        return this;
    }

    public CompanyPage editDepartmentDetails() {
        logger.info("Editing department details of the company");
        companyPageCommonMethods.selectTab("Department");
        companyPageCommonMethods.editDepartmentNameInEditDepartment();
        companyPageCommonMethods.editDescriptionInEditDepartment();
        logger.info("Department details edited for the company");
        return this;
    }

    public CompanyPage editTaskCategoryDetails() {
        logger.info("Editing task category details of the company");
        companyPageCommonMethods.selectTab("TaskCategory");
        companyPageCommonMethods.editTaskCategoryNameInEditTaskCategory();
        companyPageCommonMethods.editTaskCategoryDescriptionInEditTaskCategory();
        logger.info("Task category details edited for the company");
        return this;
    }

    public CompanyPage editExpenseCategoryDetails() {
        logger.info("Editing expense category details of the company");
        companyPageCommonMethods.selectTab("ExpenseCategory");
        companyPageCommonMethods.editExpenseCategoryNameInEditExpenseCategory();
        companyPageCommonMethods.editDescriptionInEditExpenseCategory();
        companyPageCommonMethods.editIsClaimableInEditExpenseCategory();
        logger.info("Expense category details edited for the company");
        return this;
    }

    public CompanyPage editShiftDetails() {
        logger.info("Editing shift details of the company");
        companyPageCommonMethods.selectTab("Shift");
        companyPageCommonMethods.clickOnEditShift();
        companyPageCommonMethods.editShiftNameInShift();
        companyPageCommonMethods.selectWorkingDays("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
        companyPageCommonMethods.selectShiftType();
        companyPageCommonMethods.selectDailyWorkingHourWithMinutes("09", "00");
        companyPageCommonMethods.saveButtonOfDialogBox();
        logger.info("Shift details edited for the company");
        return this;
    }

    public CompanyPage fillCompanyDetailsWithValidation() {
        logger.info("Filling company details with validation");
        companyPageCommonMethods.selectReseller(ConfigLoader.getInstance().getProperty("reseller.name"));
        companyPageCommonMethods.saveButton();
        companyPageCommonMethods.verifyHeaderOfValidationPopup("Short Name", "Header text does not match!");
        companyPageCommonMethods.verifyContentOfValidationPopUp("Field can not be blank", "Content text does not match!");
        companyPageCommonMethods.closeButtonOfPopUp();
        companyPageCommonMethods.enterShortName();
        companyPageCommonMethods.saveButton();
        companyPageCommonMethods.verifyHeaderOfValidationPopup("User Name", "Header text does not match!");
        companyPageCommonMethods.verifyContentOfValidationPopUp("Field can not be blank", "Content text does not match!");
        companyPageCommonMethods.closeButtonOfPopUp();
        companyPageCommonMethods.enterUserName();
        companyPageCommonMethods.enterConfirmUserName();
        companyPageCommonMethods.saveButton();
        companyPageCommonMethods.verifyHeaderOfValidationPopup("Password", "Header text does not match!");
        companyPageCommonMethods.verifyContentOfValidationPopUp("Field can not be blank", "Content text does not match!");
        companyPageCommonMethods.closeButtonOfPopUp();
        companyPageCommonMethods.enterPassword();
        companyPageCommonMethods.saveButton();
        companyPageCommonMethods.verifyHeaderOfValidationPopup("RetypePassword", "Header text does not match!");
        companyPageCommonMethods.verifyContentOfValidationPopUp("Field can not be blank", "Content text does not match!");
        companyPageCommonMethods.closeButtonOfPopUp();
        companyPageCommonMethods.enterRetypePassword();
        companyPageCommonMethods.enterTelephoneNumber();
        companyPageCommonMethods.enterMobileNumber();
        companyPageCommonMethods.selectCountry("India");
        companyPageCommonMethods.selectState("Gujarat");
        companyPageCommonMethods.enterCity();
        companyPageCommonMethods.enterZipcode();
        companyPageCommonMethods.enterStreet1();
        companyPageCommonMethods.enterStreet2();
        companyPageCommonMethods.enterContactPerson();
        companyPageCommonMethods.enterFaxNumber();
        companyPageCommonMethods.enterVATINNumber();
        logger.info("Company details filled with validation");
        return this;
    }

    public CompanyPage fillCompanyRuleDetailsWithValidation() {
        logger.info("Filling company rule details with validation");
        companyPageCommonMethods.selectTab("Rule");
        companyPageCommonMethods.addButtonInsideRuleOfCompany("__rule_name");
        companyPageCommonMethods.saveButtonOfDialogBox();
        companyPageCommonMethods.verifyHeaderOfValidationPopup("Rule Name", "Header text does not match!");
        companyPageCommonMethods.verifyContentOfValidationPopUp("Field Can Not Be Blank", "Content text does not match!");
        companyPageCommonMethods.closeButtonOfPopUp();
        companyPageCommonMethods.enterRuleName();
        companyPageCommonMethods.saveButtonOfDialogBox();
        companyPageCommonMethods.verifyHeaderOfValidationPopup("Valid", "Header text does not match!");
        companyPageCommonMethods.verifyContentOfValidationPopUp("Field Can Not Be Blank", "Content text does not match!");
        companyPageCommonMethods.closeButtonOfPopUp();
        companyPageCommonMethods.validFromDate();
        companyPageCommonMethods.saveButtonOfDialogBox();
        logger.info("Company rule details filled with validation");
        return this;
    }

    public CompanyPage fillCompanyShiftDetailsWithValidation() {
        logger.info("Filling company shift details with validation");
        companyPageCommonMethods.selectTab("Shift");
        companyPageCommonMethods.addButtonInsideShift("__shift_name");
        companyPageCommonMethods.saveButtonOfDialogBox();
        companyPageCommonMethods.verifyHeaderOfValidationPopup("Shift Name ", "Header text does not match!");
        companyPageCommonMethods.verifyContentOfValidationPopUp("Field cannot be blank", "Content text does not match!");
        companyPageCommonMethods.closeButtonOfPopUp();
        companyPageCommonMethods.enterShiftNameInShift();
        companyPageCommonMethods.saveButtonOfDialogBox();
        companyPageCommonMethods.verifyHeaderOfValidationPopup("Valid From ", "Header text does not match!");
        companyPageCommonMethods.verifyContentOfValidationPopUp("Field cannot be blank", "Content text does not match!");
        companyPageCommonMethods.closeButtonOfPopUp();
        companyPageCommonMethods.selectValidFromDateForShift();
        companyPageCommonMethods.saveButtonOfDialogBox();
        companyPageCommonMethods.verifyHeaderOfValidationPopup("Valid To ", "Header text does not match!");
        companyPageCommonMethods.verifyContentOfValidationPopUp("Field cannot be blank", "Content text does not match!");
        companyPageCommonMethods.closeButtonOfPopUp();
        companyPageCommonMethods.selectValidToDateForShift();
        companyPageCommonMethods.saveButtonOfDialogBox();
        companyPageCommonMethods.verifyHeaderOfValidationPopup("Working Day", "Header text does not match!");
        companyPageCommonMethods.verifyContentOfValidationPopUp("Select Working Days", "Content text does not match!");
        companyPageCommonMethods.closeButtonOfPopUp();
        companyPageCommonMethods.selectShiftType();
        companyPageCommonMethods.selectWorkingDays("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
        companyPageCommonMethods.saveButtonOfDialogBox();
        companyPageCommonMethods.verifyHeaderOfValidationPopup("Daily Working Hour", "Header text does not match!");
        companyPageCommonMethods.verifyContentOfValidationPopUp("Select a value dropdown", "Content text does not match!");
        companyPageCommonMethods.closeButtonOfPopUp();
        companyPageCommonMethods.selectDailyWorkingHourWithMinutes("08", "30");
        companyPageCommonMethods.saveButtonOfDialogBox();
        logger.info("Company shift details filled with validation");
        return this;
    }

    public CompanyPage fillCompanyDetailsWithDuplicateValidation() {
        logger.info("Filling company details with duplicate validation");
        companyPageCommonMethods.selectReseller(ConfigLoader.getInstance().getProperty("reseller.name"));
        waitUtils.waitForMilliseconds(1000);
        companyPageCommonMethods.enterShortName();
        waitUtils.waitForMilliseconds(1000);
        companyPageCommonMethods.enterStaticUserName();
        waitUtils.waitForMilliseconds(1000);
        companyPageCommonMethods.enterStaticConfirmUserName();
        waitUtils.waitForMilliseconds(1000);
        companyPageCommonMethods.enterPassword();
        waitUtils.waitForMilliseconds(1000);
        companyPageCommonMethods.enterRetypePassword();
        waitUtils.waitForMilliseconds(1000);
        companyPageCommonMethods.enterTelephoneNumber();
        waitUtils.waitForMilliseconds(1000);
        companyPageCommonMethods.enterMobileNumber();
        waitUtils.waitForMilliseconds(1000);
        companyPageCommonMethods.selectCountry("India");
        companyPageCommonMethods.selectState("Gujarat");
        companyPageCommonMethods.enterCity();
        companyPageCommonMethods.enterZipcode();
        companyPageCommonMethods.enterStreet1();
        companyPageCommonMethods.enterStreet2();
        companyPageCommonMethods.enterContactPerson();
        companyPageCommonMethods.enterFaxNumber();
        companyPageCommonMethods.enterVATINNumber();
        companyPageCommonMethods.saveButton();
        waitUtils.waitForMilliseconds(1000);
        companyPageCommonMethods.verifyHeaderOfValidationPopup("User Name", "Header text does not match!");
        companyPageCommonMethods.verifyContentOfValidationPopUp("Duplicate Username", "Content text does not match!");
        waitUtils.waitForMilliseconds(1000);
        companyPageCommonMethods.closeButtonOfPopUp();
        waitUtils.waitForMilliseconds(1000);
        companyPageCommonMethods.enterUserName();
        companyPageCommonMethods.enterConfirmUserName();
        logger.info("Company details filled with duplicate validation");
        return this;
    }

    public CompanyPage verifyThatCompanyDetailsAreEdited() {
        logger.info("Verifying that company details are edited");
        companyPageCommonMethods.verifyThatShortNameEdited();
        companyPageCommonMethods.verifyThatUserNameEdited();
        companyPageCommonMethods.verifyThatMobileNumberEdited();
        logger.info("Company details verified as edited");
        return this;
    }

    public void verifyTheCreatedAndDeleteCompany() {
        logger.info("Verifying the created and delete company");
        companyPageCommonMethods.searchTheCompanyUser();
        companyPageCommonMethods.clickOnCreatedCompany();
        companyPageCommonMethods.deleteCompanyButton();
        companyPageCommonMethods.searchTheCompanyUser();
        employeePageCommonMethods.assertNoRecordsFoundLabelDisplayed();
        logger.info("Created company verified and deleted");
    }

    public CompanyPage saveButtonOfCompany() {
        logger.info("Saving company details");
        companyPageCommonMethods.saveButton();
        logger.info("Company details saved");
        return this;
    }

    public CompanyPage searchCompanyUser() {
        logger.info("Searching for company user");
        companyPageCommonMethods.searchTheCompanyUser();
        logger.info("Search for company user completed");
        return this;
    }

    public CompanyPage editSearchCompanyUser() {
        logger.info("Searching for edited company user");
        companyPageCommonMethods.editedSearchTheCompanyUser();
        logger.info("Search for edited company user completed");
        return this;
    }

    public CompanyPage clickOnCreatedCompanyUser() {
        logger.info("Clicking on created company user");
        companyPageCommonMethods.clickOnCreatedCompany();
        logger.info("Clicked on created company user");
        return this;
    }

    public CompanyPage clickOnEditedCompanyUser() {
        logger.info("Clicking on edited company user");
        companyPageCommonMethods.clickOnEditedCompany();
        logger.info("Clicked on edited company user");
        return this;
    }

    public CompanyPage deleteCompanyUser() {
        logger.info("Deleting company user");
        companyPageCommonMethods.deleteCompanyButton();
        logger.info("Company user deleted");
        return this;
    }

    public void verifyCompanyUserIsDeleted() {
        logger.info("Verifying that company user is deleted");
        employeePageCommonMethods.assertNoRecordsFoundLabelDisplayed();
        logger.info("Company user verified as deleted");
    }

    private void verifyAreaFields(String tabId, String areaName, String[][] fields, String fieldLocator, Runnable frameSwitcher, Runnable preVerificationAction, Runnable postVerificationAction) {
        logger.info("Verifying that all fields are present on the company {}", areaName);

        if (tabId != null && !tabId.isEmpty()) {
            companyPageCommonMethods.selectTab(tabId);
        }

        if (preVerificationAction != null) {
            preVerificationAction.run();
        }

        frameSwitcher.run();

        companyPageCommonMethods.verifyFieldsArePresent(fields, areaName, fieldLocator);

        if (postVerificationAction != null) {
            postVerificationAction.run();
        }

        logger.info("All fields verified on the company {}", areaName);
    }

    private void verifyAreaFields(String tabId, String areaName, String[][] fields, Runnable frameSwitcher, Runnable preVerificationAction, Runnable postVerificationAction) {
        verifyAreaFields(tabId, areaName, fields, CompanyPageLocators.GENERIC_LABEL_XPATH, frameSwitcher, preVerificationAction, postVerificationAction);
    }

    public CompanyPage verifyThatMyAccountsTabAllTheFieldsArePresent() {
        String[][] fields = {
                {"Reseller"}, {"Short Name"}, {"User Name"}, {"Confirm User Name"},
                {"Password"}, {"Retype  Password"}, {"2 Step Authentication"}, {"Telephone Number"},
                {"Mobile Number"}, {"Country"}, {"State"}, {"City"}, {"Zip - Code"},
                {"Street 1"}, {"Street 2"}, {"Contact Person"}, {"Fax Number"}, {"VATIN No"}
        };
        verifyAreaFields(null, "My Account tab", fields,
                iframesOfApplication::switchToContentFrame, null, null);
        return this;
    }

    public CompanyPage verifyThatRuleTabOfCompanyAllTheFieldsArePresent() {
        String[][] fields = {
                {"Rule Name"}, {"Valid from"}, {"Event Date Format"}, {"Time Format"},
                {"Device Accuracy Tolerance"}, {"Inactive Time"}, {"Stoppage Time"}, {"Show Cluster"},
                {"Startup Screen"}, {"POI Tolerance"}, {"Expense"}, {"Play SOS Sound"}
        };
        verifyAreaFields("Rule", "Rule tab dialog", fields,
                iframesOfApplication::switchToPopUpDialogFrame,
                () -> companyPageCommonMethods.addButtonInsideRuleOfCompany("__rule_name"),
                companyPageCommonMethods::closeButtonInsideRuleOfCompany);
        return this;
    }

    public CompanyPage verifyThatUserSettingTabAllTheFieldsArePresent() {
        String[][] fields = {
                {"Time Zone"}, {"Date Format"}, {"Time Format"}, {"Units Of Distance"},
                {"Week Start Day"}, {"Month Start Day"}, {"User Status"}, {"Show Default Filter Option"},
                {"Notification"}, {"Web Access"}, {"Mobile Access"}, {"Upload Logo"}, {"GPS Based Off Duty"}
        };
        verifyAreaFields("Setting", "User Setting tab", fields,
                iframesOfApplication::switchToContentFrame, null, null);
        return this;
    }

    public CompanyPage verifyThatDataAccessTabAllTheFieldsArePresent() {
        String[][] fields = {
                {"Alert"}, {"Default Language"}, {"Override Address on Location"}
        };
        verifyAreaFields("ContentRights", "Data Access tab", fields,
                iframesOfApplication::switchToContentFrame, null, null);
        return this;
    }

    public CompanyPage verifyThatMapTabAllTheFieldsArePresent() {
        String[][] fields = {
                {"Web Map Key"}, {"Mobile Map Key"}, {"Address From Map Provider"}, {"Default"}
        };
        verifyAreaFields("Map", "Map", fields,
                CompanyPageLocators.MAP_TAB_XPATH,
                iframesOfApplication::switchToCompanyMapContentFrame,
                null,
                null);
        return this;
    }

    public CompanyPage verifyThatEmailTabAllTheFieldsArePresent() {
        String[][] fields = {
                {"From Email Address"}, {"Username"}, {"Password"}, {"Host"}, {"Outgoing port"},
                {"SMTP Authentication"}, {"TLS Authentication"}, {"Email Verification"}
        };
        verifyAreaFields("Email", "Email", fields,
                iframesOfApplication::switchToContentFrame, null, null);
        return this;
    }

    public CompanyPage verifyThatSmsTabAllTheFieldsArePresent() {
        String[][] fields = {
                {"SMS Gateway"}, {"SMS Gateway URL"}, {"Example"}, {"Variables"}
        };
        verifyAreaFields("SMS", "SMS", fields,
                iframesOfApplication::switchToContentFrame, null, null);
        return this;
    }

    public CompanyPage verifyThatDesignationTabAllTheFieldsArePresent() {
        String[][] fields = {
                {"Designation Name"}, {"Level"}
        };
        verifyAreaFields("Designation", "Designation", fields,
                CompanyPageLocators.MAP_TAB_XPATH,
                iframesOfApplication::switchToDesignationContentFrame,
                null,
                null);
        return this;
    }

    public CompanyPage verifyThatDepartmentTabAllTheFieldsArePresent() {
        String[][] fields = {
                {"Department Name"}, {"Description"}
        };
        verifyAreaFields("Department", "Department", fields,
                CompanyPageLocators.MAP_TAB_XPATH,
                iframesOfApplication::switchToDepartmentContentFrame,
                null,
                null);
        return this;
    }

    public CompanyPage verifyThatTaskCategoryTabAllTheFieldsArePresent() {
        String[][] fields = {
                {"Task Category Name"}, {"Description"}
        };
        verifyAreaFields("TaskCategory", "TaskCategory", fields,
                CompanyPageLocators.MAP_TAB_XPATH,
                iframesOfApplication::switchTaskCategoryContentFrame,
                null,
                null);
        return this;
    }

    public CompanyPage verifyThatExpenseCategoryTabAllTheFieldsArePresent() {
        String[][] fields = {
                {"Expense Category Name"}, {"Description"}, {"Is Claimable"}
        };
        verifyAreaFields("ExpenseCategory", "ExpenseCategory", fields,
                CompanyPageLocators.MAP_TAB_XPATH,
                iframesOfApplication::switchExpenseCategoryContentFrame,
                null,
                null);
        return this;
    }

    public CompanyPage verifyThatShiftTabOfCompanyAllTheFieldsArePresent() {
        String[][] fields = {
                {"Shift Name"}, {"Valid From"}, {"Valid To"}, {"Working Day"},
                {"Shift type"}, {"Early Start Time"}, {"Late Start Time"}, {"Early End Time"},
                {"Late End Time"}, {"Daily Working Hour"}, {"Buffer Time"}, {"Consider Overtime"},
                {"Allow Break Hours"}
        };
        verifyAreaFields("Shift", "Shift tab dialog", fields,
                iframesOfApplication::switchToPopUpDialogFrame,
                () -> companyPageCommonMethods.addButtonInsideShift("__shift_name"),
                companyPageCommonMethods::closeButtonInsideRuleOfCompany);
        return this;
    }

    public CompanyPage verifyThatFinanceApproverTabAllTheFieldsArePresent() {
        String[][] fields = {
                {"Department"}, {"Primary Approver"}, {"Secondary Approver"}
        };
        verifyAreaFields("finance_approver", "Finance Approver", fields,
                iframesOfApplication::switchToContentFrame, null, null);
        return this;
    }

    public CompanyPage verifyThatSosCategoryTabAllTheFieldsArePresent() {
        String[][] fields = {
                {"Category"}, {"Type"}
        };
        verifyAreaFields("sos_category", "SOS Category", fields,
                CompanyPageLocators.MAP_TAB_XPATH,
                iframesOfApplication::switchToSosCategoryContentFrame,
                null,
                null);
        return this;
    }

    public void verifyThatLeaveReasonTabAllTheFieldsArePresent() {
        String[][] fields = {
                {"Leave Reason"}, {"Description"}
        };
        verifyAreaFields("leave_reason", "Leave Reason", fields,
                CompanyPageLocators.MAP_TAB_XPATH,
                iframesOfApplication::switchToLeaveReasonContentFrame,
                null,
                null);
    }
}
