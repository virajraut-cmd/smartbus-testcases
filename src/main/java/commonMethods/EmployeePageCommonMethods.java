package commonMethods;

import configurations.common.CommonMethods;
import configurations.common.DatePickerUtils;
import configurations.common.IframesOfApplication;
import org.openqa.selenium.*;
import org.testng.Assert;
import web.locators.AdminPageLocators;
import web.locators.CompanyPageLocators;
import web.locators.EmployeePageLocators;
import configurations.common.WaitUtils;

public class EmployeePageCommonMethods {

    private final WebDriver driver;
    private final CommonMethods commonMethods;
    private final IframesOfApplication iframe;
    private final String password = "Test@123";
    private String firstName;
    private String editedFirstName;
    private String editedLastName;
    private String editedEmailId;
    private final WaitUtils waitUtils;

    public EmployeePageCommonMethods(WebDriver driver) {
        this.driver = driver;
        this.commonMethods = new CommonMethods(driver);
        this.iframe = new IframesOfApplication(driver);
        this.waitUtils = new WaitUtils(driver);
    }

    public void addEmployee() {
        iframe.switchToBottomFrame();
        WebElement addButton = waitUtils.waitForElementToBeClickable(CompanyPageLocators.ADD_BUTTON);
        addButton.click();
        waitUtils.waitForElementToDisappear(CompanyPageLocators.ADD_BUTTON);
    }

    public void selectCompany(String companyName) {
        iframe.switchToContentFrame();
        By companyDropdownLocator = EmployeePageLocators.COMPANY_DROPDOWN;
        By companyOptionLocator = By.xpath(String.format(EmployeePageLocators.COMPANY_DROPDOWN_OPTION, companyName));
        commonMethods.selectFromDropdown(companyDropdownLocator, companyOptionLocator,true);
    }

    public void selectBranch(String branchName) {
        iframe.switchToContentFrame();
        By branchDropdownLocator = EmployeePageLocators.BRANCH_DROPDOWN;
        By branchOptionLocator = By.xpath(String.format(EmployeePageLocators.BRANCH_DROPDOWN_OPTION, branchName));
        commonMethods.selectFromDropdown(branchDropdownLocator, branchOptionLocator,true);
    }

    public void selectDepartment(String departmentName) {
        iframe.switchToContentFrame();
        By departmentDropdownLocator = EmployeePageLocators.DEPARTMENT_DROPDOWN;
        By departmentOptionLocator = By.xpath(String.format(EmployeePageLocators.DEPARTMENT_DROPDOWN_OPTION, departmentName));
        commonMethods.selectFromDropdown(departmentDropdownLocator, departmentOptionLocator,true);
    }

    public void enterDepartmentName() {
        String departmentName = "DepartmentName-Test";
        iframe.switchToContentFrame();
        WebElement departmentNameField = waitUtils.waitForElementToBeClickable(EmployeePageLocators.DEPARTMENT_NAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", departmentNameField);
        departmentNameField.sendKeys(departmentName);
    }

    public void selectDesignation(String designationName) {
        iframe.switchToContentFrame();
        By designationDropdownLocator = EmployeePageLocators.DESIGNATION_DROPDOWN;
        By designationOptionLocator = By.xpath(String.format(EmployeePageLocators.DESIGNATION_DROPDOWN_OPTION, designationName));
        commonMethods.selectFromDropdown(designationDropdownLocator, designationOptionLocator,true);
    }

    public void enterFirstName() {
        this.firstName = CommonMethods.generateRandomFirstName();
        iframe.switchToContentFrame();
        WebElement firstNameField = waitUtils.waitForElementToBeClickable(EmployeePageLocators.FIRST_NAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", firstNameField);
        firstNameField.sendKeys(this.firstName);
    }

    public void enterMiddleName() {
        String middleName = "Middle Name";
        iframe.switchToContentFrame();
        WebElement middleNameField = waitUtils.waitForElementToBeClickable(EmployeePageLocators.MIDDLE_NAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", middleNameField);
        middleNameField.sendKeys(middleName);
    }

    public void enterLastName() {
        String lastName = CommonMethods.generateRandomFirstName();
        iframe.switchToContentFrame();
        WebElement lastNameField = waitUtils.waitForElementToBeClickable(EmployeePageLocators.LAST_NAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", lastNameField);
        lastNameField.sendKeys(lastName);
    }

    public void enterEmployeeNumber() {
        String employeeNumber = CommonMethods.generateRandomNumber();
        iframe.switchToContentFrame();
        WebElement employeeNumberField = waitUtils.waitForElementToBeClickable(EmployeePageLocators.EMPLOYEE_NUMBER_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", employeeNumberField);
        employeeNumberField.sendKeys(employeeNumber);
    }

    public void selectLanguage(String language) {
        iframe.switchToContentFrame();
        By languageDropdownLocator = EmployeePageLocators.LANGUAGE_DROPDOWN;
        By languageOptionLocator = By.xpath(String.format(EmployeePageLocators.LANGUAGE_DROPDOWN_OPTION, language));
        commonMethods.selectFromDropdown(languageDropdownLocator, languageOptionLocator,true);
    }

    public void selectGender() {
        iframe.switchToContentFrame();
        commonMethods.selectRadioButton(EmployeePageLocators.FEMALE_RADIO_BUTTON);
        commonMethods.selectRadioButton(EmployeePageLocators.MALE_RADIO_BUTTON);
    }

    public void selectVerificationVia() {
        iframe.switchToContentFrame();
        commonMethods.selectRadioButton(EmployeePageLocators.VERIFICATION_VIA_OTP_RADIO_BUTTON);
        commonMethods.selectRadioButton(EmployeePageLocators.VERIFICATION_VIA_PASSWORD_RADIO_BUTTON);
    }

    public void enterPassword() {
        iframe.switchToContentFrame();
        WebElement passwordField = waitUtils.waitForElementToBeClickable(EmployeePageLocators.PASSWORD_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", passwordField);
        passwordField.sendKeys(password);
    }

    public void enterRetypePassword() {
        iframe.switchToContentFrame();
        WebElement retypePasswordField = waitUtils.waitForElementToBeClickable(EmployeePageLocators.RETYPE_PASSWORD_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", retypePasswordField);
        retypePasswordField.sendKeys(password);
    }

    public void enterEmailId() {
        String emailId = CommonMethods.generateRandomEmail();
        iframe.switchToContentFrame();
        WebElement emailIdField = waitUtils.waitForElementToBeClickable(EmployeePageLocators.EMAIL_ID_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", emailIdField);
        emailIdField.sendKeys(emailId);
    }

    public void enterMobileNumber() {
        String mobileNumber = CommonMethods.generateRandomMobileNumber();
        iframe.switchToContentFrame();
        WebElement enterMobileNumberField = waitUtils.waitForElementToBeClickable(EmployeePageLocators.MOBILE_NUMBER_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterMobileNumberField);
        enterMobileNumberField.sendKeys(mobileNumber);
    }

    public void enterEmergencyContactNumber() {
        String emergencyContactNumber = CommonMethods.generateRandomMobileNumber();
        iframe.switchToContentFrame();
        WebElement enterMobileNumberField = waitUtils.waitForElementToBeClickable(EmployeePageLocators.EMERGENCY_CONTACT_NUMBER_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterMobileNumberField);
        enterMobileNumberField.sendKeys(emergencyContactNumber);
    }

    public void selectTimeZone(String timeZoneName) {
        iframe.switchToContentFrame();
        By timeZoneDropdownLocator = EmployeePageLocators.TIMEZONE_DROPDOWN;
        By timeZoneOptionLocator = By.xpath(String.format(EmployeePageLocators.TIMEZONE_DROPDOWN_OPTION, timeZoneName));
        commonMethods.selectFromDropdown(timeZoneDropdownLocator, timeZoneOptionLocator,true);
    }

    public void enterMediclaimNumber() {
        String mediclaimNumber = CommonMethods.generateRandomNumber();
        iframe.switchToContentFrame();
        WebElement mediclaimNumberField = waitUtils.waitForElementToBeClickable(EmployeePageLocators.MEDICLAIM_NUMBER_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", mediclaimNumberField);
        mediclaimNumberField.sendKeys(mediclaimNumber);
    }

    public void enterMediclaimExpiryDate() {
        iframe.switchToContentFrame();
        DatePickerUtils datePickerUtils = new DatePickerUtils(driver);
        datePickerUtils.selectDate(By.id("-hes_expirydate"), 1);
    }

    public void selectSpeedDetection(String speedDetection) {
        iframe.switchToContentFrame();
        By speedDetectionDropdownLocator = EmployeePageLocators.SPEED_DETECTION_DROPDOWN;
        By speedDetectionOptionLocator = By.xpath(String.format(EmployeePageLocators.SPEED_DETECTION_DROPDOWN_OPTION, speedDetection));
        commonMethods.selectFromDropdown(speedDetectionDropdownLocator, speedDetectionOptionLocator,true);
    }

    public void selectLiveDataSyncInterval(String liveDataSyncIntervalTime) {
        iframe.switchToContentFrame();
        By liveDataSyncIntervalDropdownLocator = EmployeePageLocators.LIVE_DATA_SYNC_INTERVAL_DROPDOWN;
        By liveDataSyncIntervalOptionLocator = By.xpath(String.format(EmployeePageLocators.LIVE_DATA_SYNC_INTERVAL_DROPDOWN_OPTION, liveDataSyncIntervalTime));
        commonMethods.selectFromDropdown(liveDataSyncIntervalDropdownLocator, liveDataSyncIntervalOptionLocator,true);
    }

    public void selectGpsAccuracy(String gpsAccuracyName) {
        iframe.switchToContentFrame();
        By gpsAccuracyDropdownLocator = EmployeePageLocators.GPS_ACCURACY_DROPDOWN;
        By gpsAccuracyOptionLocator = By.xpath(String.format(EmployeePageLocators.GPS_ACCURACY_DROPDOWN_OPTION, gpsAccuracyName));
        commonMethods.selectFromDropdown(gpsAccuracyDropdownLocator, gpsAccuracyOptionLocator,true);
    }

    public void clickOnClearTokenButton(){
        iframe.switchToContentFrame();
        WebElement clearTokenButton = waitUtils.waitForElementToBeClickable(EmployeePageLocators.CLEAR_TOKEN_BUTTON);
        clearTokenButton.click();
    }

    public void clickOnClearTokenNoButton(){
        iframe.switchToDivFrame();
        WebElement clearTokenNoButton = waitUtils.waitForElementToBeClickable(EmployeePageLocators.CLEAR_TOKEN_NO_BUTTON);
        clearTokenNoButton.click();
    }

    public void clickOnSyncMobileLogsButton(){
        iframe.switchToContentFrame();
        WebElement syncMobileLogsButton = waitUtils.waitForElementToBeClickable(EmployeePageLocators.SYNC_MOBILE_LOGS_BUTTON);
        syncMobileLogsButton.click();
    }

    public void clickOnSyncMobileLogsCancelButton(){
        iframe.switchToDivFrame();
        WebElement syncMobileLogsCancelButton = waitUtils.waitForElementToBeClickable(EmployeePageLocators.SYNC_MOBILE_LOGS_CANCEL_BUTTON);
        syncMobileLogsCancelButton.click();
    }

    public void selectCustomer(String customerName) {
        iframe.switchToContentFrame();
        By customerNameDropdownLocator = EmployeePageLocators.CUSTOMER_DROPDOWN;
        By customerNameOptionLocator = By.xpath(String.format(EmployeePageLocators.CUSTOMER_DROPDOWN_OPTION, customerName));
        commonMethods.selectFromDropdown(customerNameDropdownLocator, customerNameOptionLocator,true);
        WebElement outSideTap = waitUtils.waitForElementToBeClickable(EmployeePageLocators.OUTSIDE_TAP);
        outSideTap.click();
    }

    public void selectAddress(String addressName) {
        iframe.switchToContentFrame();
        By addressNameDropdownLocator = EmployeePageLocators.ADDRESS_DROPDOWN;
        By addressNameOptionLocator = By.xpath(String.format(EmployeePageLocators.ADDRESS_DROPDOWN_OPTION, addressName));
        commonMethods.selectFromDropdown(addressNameDropdownLocator, addressNameOptionLocator,true);
        WebElement outSideTap = waitUtils.waitForElementToBeClickable(EmployeePageLocators.OUTSIDE_TAP);
        outSideTap.click();
    }

    public void checkOffDutyRestrictionCheckbox() {
        iframe.switchToContentFrame();
        WebElement offDutyRestrictionCheckbox = driver.findElement(By.xpath(EmployeePageLocators.OFF_DUTY_RESTRICTION_CHECKBOX));
        CommonMethods.checkCheckbox(offDutyRestrictionCheckbox);
    }

    public void checkTaskReminderCheckbox() {
        iframe.switchToContentFrame();
        WebElement taskReminderCheckbox = driver.findElement(By.xpath(EmployeePageLocators.TASK_REMINDER_CHECKBOX));
        CommonMethods.checkCheckbox(taskReminderCheckbox);
        WebElement taskReminderUnCheckbox = driver.findElement(By.xpath(EmployeePageLocators.TASK_REMINDER_CHECKBOX));
        CommonMethods.uncheckCheckbox(taskReminderUnCheckbox);
    }

    public void selectTaskConsideration() {
        iframe.switchToContentFrame();
        commonMethods.selectRadioButton(EmployeePageLocators.AUTO_TASK_RADIO_BUTTON);
        commonMethods.selectRadioButton(EmployeePageLocators.MANUAL_TASK_RADIO_BUTTON);
    }

    public void checkQrCodeCheckbox() {
        iframe.switchToContentFrame();
        WebElement qrCodeCheckbox = driver.findElement(By.xpath(EmployeePageLocators.QR_CODE_CHECKBOX));
        CommonMethods.checkCheckbox(qrCodeCheckbox);
    }

    public void unCheckQrCodeCheckbox() {
        iframe.switchToContentFrame();
        WebElement qrCodeCheckbox = driver.findElement(By.xpath(EmployeePageLocators.QR_CODE_CHECKBOX));
        CommonMethods.uncheckCheckbox(qrCodeCheckbox);
    }

    public void selectAuthenticationType(String authenticationType) {
        iframe.switchToContentFrame();
        By authenticationDropdownLocator = EmployeePageLocators.AUTHENTICATION_TYPE_DROPDOWN;
        By authenticationOptionLocator = By.xpath(String.format(EmployeePageLocators.AUTHENTICATION_TYPE_DROPDOWN_OPTION, authenticationType));
        commonMethods.selectFromDropdown(authenticationDropdownLocator, authenticationOptionLocator,true);
    }

    public void selectQrScanEvent(String eventName) {
        iframe.switchToContentFrame();
        By eventNameDropdownLocator = EmployeePageLocators.QR_SCAN_EVENT_DROPDOWN;
        By eventNameOptionLocator = By.xpath(String.format(EmployeePageLocators.QR_SCAN_EVENT_DROPDOWN_OPTION, eventName));
        commonMethods.selectFromDropdown(eventNameDropdownLocator, eventNameOptionLocator, true);
    }

    public void selectQrValidation(String qrValidationName) {
        iframe.switchToContentFrame();
        By qrValidationDropdownLocator = EmployeePageLocators.QR_VALIDATION_DROPDOWN;
        By qrValidationOptionLocator = By.xpath(String.format(EmployeePageLocators.QR_VALIDATION_DROPDOWN_OPTION, qrValidationName));
        commonMethods.selectFromDropdown(qrValidationDropdownLocator, qrValidationOptionLocator,true);
    }

    public void checkTaskApprovalCheckbox() {
        iframe.switchToContentFrame();
        WebElement taskApprovalCheckbox = driver.findElement(By.xpath(EmployeePageLocators.TASK_APPROVAL_CHECKBOX));
        CommonMethods.checkCheckbox(taskApprovalCheckbox);
    }

    public void unCheckTaskApprovalCheckbox() {
        iframe.switchToContentFrame();
        WebElement taskApprovalCheckbox = driver.findElement(By.xpath(EmployeePageLocators.TASK_APPROVAL_CHECKBOX));
        CommonMethods.uncheckCheckbox(taskApprovalCheckbox);
    }

    public void selectShift(String shiftName) {
        iframe.switchToContentFrame();
        By shiftDropdownLocator = EmployeePageLocators.SHIFT_DROPDOWN;
        By shiftOptionLocator = By.xpath(String.format(EmployeePageLocators.SHIFT_DROPDOWN_OPTION, shiftName));
        commonMethods.selectFromDropdown(shiftDropdownLocator, shiftOptionLocator,true);
    }

    public void selectWorkingDays() {
        iframe.switchToContentFrame();
        commonMethods.verifyAllWorkingDaysSelected();
    }

    public void enterStreet1Address() {
        String street1 = "D-203, Sarthak Safal Appartment";
        iframe.switchToContentFrame();
        WebElement enterStreet1Field = waitUtils.waitForElementToBeClickable(EmployeePageLocators.STREET1_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterStreet1Field);
        enterStreet1Field.sendKeys(street1);
    }

    public void editStreet1Address() {
        String street1 = "Applo Hospital";
        iframe.switchToContentFrame();
        WebElement enterStreet1Field = waitUtils.waitForElementToBeClickable(EmployeePageLocators.STREET1_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterStreet1Field);
        enterStreet1Field.sendKeys(street1);
    }

    public void enterStreet2Address() {
        String street2 = "Near Vaidehi Elegance";
        iframe.switchToContentFrame();
        WebElement enterStreet2Field = waitUtils.waitForElementToBeClickable(EmployeePageLocators.STREET2_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterStreet2Field);
        enterStreet2Field.sendKeys(street2);
    }

    public void editStreet2Address() {
        String street2 = "Near Genpact Elegance";
        iframe.switchToContentFrame();
        WebElement enterStreet2Field = waitUtils.waitForElementToBeClickable(EmployeePageLocators.STREET2_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterStreet2Field);
        enterStreet2Field.sendKeys(street2);
    }

    public void enterCityAddress() {
        String city = "Gandhinagar";
        iframe.switchToContentFrame();
        WebElement enterCityField = waitUtils.waitForElementToBeClickable(EmployeePageLocators.CITY_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterCityField);
        enterCityField.sendKeys(city);
    }

    public void editCityAddress() {
        String city = "Ahmedabad";
        iframe.switchToContentFrame();
        WebElement enterCityField = waitUtils.waitForElementToBeClickable(EmployeePageLocators.CITY_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterCityField);
        enterCityField.sendKeys(city);
    }

    public void enterZipCodeAddress() {
        String zipCode = "382016";
        iframe.switchToContentFrame();
        WebElement enterZipCodeField = waitUtils.waitForElementToBeClickable(EmployeePageLocators.ZIPCODE_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterZipCodeField);
        enterZipCodeField.sendKeys(zipCode);
    }

    public void editZipCodeAddress() {
        String zipCode = "380051";
        iframe.switchToContentFrame();
        WebElement enterZipCodeField = waitUtils.waitForElementToBeClickable(EmployeePageLocators.ZIPCODE_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterZipCodeField);
        enterZipCodeField.sendKeys(zipCode);
    }

    public void selectCountry(String countryName) {
        iframe.switchToContentFrame();
        By countryDropdownLocator = EmployeePageLocators.COUNTRY_DROPDOWN;
        By countryOptionLocator = By.xpath(String.format(EmployeePageLocators.COUNTRY_DROPDOWN_OPTION, countryName));
        commonMethods.selectFromDropdown(countryDropdownLocator, countryOptionLocator,true);
    }

    public void addButtonInsideLeaveOfEmployee(String name) {
        iframe.switchToEmployeeLeaveFrame();
        String dynamicXpath = String.format(CompanyPageLocators.ADD_BUTTON_INSIDE_COMPANY, name);
        WebElement addButtonInsideRuleOfCompany = waitUtils.waitForElementToBeClickable(By.xpath(dynamicXpath));
        addButtonInsideRuleOfCompany.click();
        waitUtils.waitForElementToBeClickable(EmployeePageLocators.LEAVE_TYPE_DROPDOWN);
    }

    public void selectLeaveTypeOnLeaveTabOfEmployee(String leaveType) {
        iframe.switchToEmployeeLeaveFrame();
        By leaveTypeDropdownLocator = EmployeePageLocators.LEAVE_TYPE_DROPDOWN;
        By leaveTypeOptionLocator = By.xpath(String.format(EmployeePageLocators.LEAVE_TYPE_DROPDOWN_OPTION, leaveType));
        commonMethods.selectFromDropdown(leaveTypeDropdownLocator, leaveTypeOptionLocator,true);
    }

    public void verifyEditLeaveTypeIsDisabled() {
        iframe.switchToEmployeeLeaveFrame();
        By leaveTypeDropdownLocator = EmployeePageLocators.EDIT_LEAVE_TYPE_DROPDOWN;
        WebElement leaveTypeDropdown = waitUtils.waitForElementToBeVisible(leaveTypeDropdownLocator);
        Assert.assertFalse(leaveTypeDropdown.isEnabled(), "The 'Edit Leave Type' dropdown was expected to be disabled, but it was enabled.");
    }

    public void enterNumberOfDays(String numberOfDays) {
        iframe.switchToEmployeeLeaveFrame();
        WebElement numberOfDaysField = waitUtils.waitForElementToBeClickable(EmployeePageLocators.NO_OF_DAYS_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", numberOfDaysField);
        numberOfDaysField.sendKeys(numberOfDays);
    }

    public void verifyEditNumberOfDaysIsDisabled() {
        iframe.switchToEmployeeLeaveFrame();
        WebElement numberOfDaysField = waitUtils.waitForElementToBeVisible(EmployeePageLocators.EDIT_NO_OF_DAYS_FIELD);
        Assert.assertFalse(numberOfDaysField.isEnabled(), "The 'Edit Number of Days' field was expected to be disabled, but it was enabled.");
    }

    public void validityFromDate() {
        iframe.switchToEmployeeLeaveFrame();
        DatePickerUtils datePickerUtils = new DatePickerUtils(driver);
        datePickerUtils.selectDate(By.id("leave_start_date00"), 0);
    }

    public void verifyEditValidityFromDateIsDisabled() {
        iframe.switchToEmployeeLeaveFrame();
        WebElement validityDateField = waitUtils.waitForElementToBeVisible(By.id("-leave_start_date0"));
        Assert.assertFalse(validityDateField.isEnabled(), "The 'Edit Validity From Date' field was expected to be disabled, but it was enabled.");
    }

    public void checkAutoRenewal() {
        iframe.switchToEmployeeLeaveFrame();
        WebElement autoRenewalCheckbox = driver.findElement(By.xpath(EmployeePageLocators.AUTO_RENEWAL_CHECKBOX));
        CommonMethods.checkCheckbox(autoRenewalCheckbox);
    }

    public void verifyEditAutoRenewalIsDisabled() {
        iframe.switchToEmployeeLeaveFrame();
        WebElement autoRenewalCheckbox = waitUtils.waitForElementToBeVisible(By.xpath(EmployeePageLocators.EDIT_AUTO_RENEWAL_CHECKBOX));
        Assert.assertFalse(autoRenewalCheckbox.isEnabled(), "The 'Edit Auto Renewal' checkbox was expected to be disabled, but it was enabled.");
    }

    public void selectRenewalFrequencyOnLeaveTabOfEmployee(String renewalFrequency) {
        iframe.switchToEmployeeLeaveFrame();
        By renewalFrequencyDropdownLocator = EmployeePageLocators.RENEWAL_FREQUENCY_DROPDOWN;
        By renewalFrequencyOptionLocator = By.xpath(String.format(EmployeePageLocators.RENEWAL_FREQUENCY_DROPDOWN_OPTION, renewalFrequency));
        commonMethods.selectFromDropdown(renewalFrequencyDropdownLocator, renewalFrequencyOptionLocator,true);
    }

    public void verifyEditRenewalFrequencyIsDisabled() {
        iframe.switchToEmployeeLeaveFrame();
        WebElement renewalFrequencyDropdown = waitUtils.waitForElementToBeVisible(EmployeePageLocators.EDIT_RENEWAL_FREQUENCY_DROPDOWN);
        Assert.assertFalse(renewalFrequencyDropdown.isEnabled(), "The 'Edit Renewal Frequency' dropdown was expected to be disabled, but it was enabled.");
    }

    public void checkCarryOver() {
        iframe.switchToEmployeeLeaveFrame();
        WebElement carryOverCheckbox = driver.findElement(By.xpath(EmployeePageLocators.CARRY_OVER_CHECKBOX));
        CommonMethods.checkCheckbox(carryOverCheckbox);
    }

    public void searchTheEmployeeUser() {
        iframe.switchToBottomFrame();
        WebElement searchField = waitUtils.waitForElementToBeClickable(AdminPageLocators.SEARCH_FIELD);
        searchField.sendKeys(this.firstName);
        searchField.sendKeys(Keys.ENTER);
    }

    public void searchTheEditedEmployeeUser() {
        iframe.switchToBottomFrame();
        WebElement searchField = waitUtils.waitForElementToBeClickable(AdminPageLocators.SEARCH_FIELD);
        searchField.sendKeys(this.editedFirstName);
        searchField.sendKeys(Keys.ENTER);
    }

    public void clickOnCreatedEmployee() {
        iframe.switchToContentFrame();
        String formattedXpath = String.format(EmployeePageLocators.TABLE_OF_FIRST_NAME, this.firstName);
        waitUtils.waitForElementToBeClickable(By.xpath(formattedXpath));
        commonMethods.doubleClick(By.xpath(formattedXpath));
    }

    public void clickOnEditedEmployee() {
        iframe.switchToContentFrame();
        String formattedXpath = String.format(EmployeePageLocators.TABLE_OF_FIRST_NAME, this.editedFirstName);
        waitUtils.waitForElementToBeClickable(By.xpath(formattedXpath));
        commonMethods.doubleClick(By.xpath(formattedXpath));
    }

    public void deleteButton() {
        iframe.switchToBottomFrame();
        WebElement deleteButton = waitUtils.waitForElementToBeClickable(CompanyPageLocators.DELETE_BUTTON);
        deleteButton.click();
        waitUtils.waitForAlertToBePresent();
        commonMethods.acceptAlert();
        waitUtils.waitForAlertToDisappear();
    }

    public void assertNoRecordsFoundLabelDisplayed() {
        iframe.switchToContentFrame();
        commonMethods.verifyLabelDisplayedWithText(EmployeePageLocators.NO_RECORDS_FOUND_LABEL, "No Records Found");
    }

    public void saveButtonOfEmployeePage() {
        iframe.switchToBottomFrame();
        WebElement saveButton = waitUtils.waitForElementToBeClickable(CompanyPageLocators.SAVE_BUTTON);
        saveButton.click();
    }

    public void selectPrimaryReporting(String primaryReportingName) {
        iframe.switchToContentFrame();
        By primaryReportingDropdownLocator = EmployeePageLocators.PRIMARY_REPORTING_DROPDOWN;
        By primaryReportingOptionLocator = By.xpath(String.format(EmployeePageLocators.PRIMARY_REPORTING_DROPDOWN_OPTION, primaryReportingName));
        commonMethods.selectFromDropdown(primaryReportingDropdownLocator, primaryReportingOptionLocator,true);
    }

    public void selectSecondaryReporting(String secondaryReportingName) {
        iframe.switchToContentFrame();
        By secondaryReportingDropdownLocator = EmployeePageLocators.SECONDARY_REPORTING_DROPDOWN;
        By secondaryReportingOptionLocator = By.xpath(String.format(EmployeePageLocators.SECONDARY_REPORTING_DROPDOWN_OPTION, secondaryReportingName));
        commonMethods.selectFromDropdown(secondaryReportingDropdownLocator, secondaryReportingOptionLocator,true);
    }

    public void selectDateOfBirth18YearsAgo() {
        DatePickerUtils datePickerUtils = new DatePickerUtils(driver);
        iframe.switchToContentFrame();
        By dobInputLocator = By.xpath(EmployeePageLocators.DOB_INPUT);
        datePickerUtils.selectDateOfBirth18YearsAgo(dobInputLocator);
    }

    public void enterJoiningDate() {
        iframe.switchToContentFrame();
        DatePickerUtils datePickerUtils = new DatePickerUtils(driver);
        datePickerUtils.selectDate(By.id("-date_of_joining"), 0);
    }

    public void editFirstName() {
        this.editedFirstName = CommonMethods.generateRandomFirstName();
        iframe.switchToContentFrame();
        WebElement firstNameField = waitUtils.waitForElementToBeClickable(EmployeePageLocators.FIRST_NAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", firstNameField);
        firstNameField.sendKeys(this.editedFirstName);
    }

    public void editLastName() {
        this.editedLastName = CommonMethods.generateRandomFirstName();
        iframe.switchToContentFrame();
        WebElement lastNameField = waitUtils.waitForElementToBeClickable(EmployeePageLocators.LAST_NAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", lastNameField);
        lastNameField.sendKeys(this.editedLastName);
    }

    public void editEmailId() {
        this.editedEmailId = CommonMethods.generateRandomEmail();
        iframe.switchToContentFrame();
        WebElement emailIdField = waitUtils.waitForElementToBeClickable(EmployeePageLocators.EMAIL_ID_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", emailIdField);
        emailIdField.sendKeys(this.editedEmailId);
    }

    public void verifyThatFirstNameEdited() {
        iframe.switchToContentFrame();
        boolean isEdited = commonMethods.isTextPresentInTable(this.editedFirstName);
        Assert.assertTrue(isEdited, "First Name '" + this.editedFirstName + "' was not edited successfully.");
    }

    public void verifyThatLastNameEdited() {
        iframe.switchToContentFrame();
        boolean isEdited = commonMethods.isTextPresentInTable(this.editedLastName);
        Assert.assertTrue(isEdited, "Last Name '" + this.editedLastName + "' was not edited successfully.");
    }

    public void verifyThatEmailIdEdited() {
        iframe.switchToContentFrame();
        boolean isEdited = commonMethods.isTextPresentInTable(this.editedEmailId);
        Assert.assertTrue(isEdited, "Short Name '" + this.editedEmailId + "' was not edited successfully.");
    }

    public void verifyFieldsArePresent(String[][] fields, String tabName, String fieldLocator) {
        for (String[] field : fields) {
            String label = field[0];
            String xpath = String.format(fieldLocator, label);
            try {
                driver.findElement(By.xpath(xpath));
            } catch (NoSuchElementException e) {
                Assert.fail("Field with label '" + label + "' is not present in the " + tabName + " tab.");
            }
        }
    }
}