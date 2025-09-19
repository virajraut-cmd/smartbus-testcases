package commonMethods;

import javax.xml.xpath.XPath;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import configurations.common.CommonMethods;
import configurations.common.DatePickerUtils;
import configurations.common.IframesOfApplication;
import org.openqa.selenium.*;
import org.testng.Assert;
import web.locators.AdminPageLocators;
import web.locators.CompanyPageLocators;
import configurations.common.WaitUtils;

public class CompanyPageCommonMethods {

    private static final Logger logger = LogManager.getLogger(CompanyPageCommonMethods.class);
    private final WebDriver driver;
    private final CommonMethods commonMethods;
    private final IframesOfApplication iframe;
    private final WaitUtils waitUtils;
    private final String password = "Test@123";
    private String userName;
    private String shortName;
    private String editShortName;
    private String editMobileNumber;
    private String editUserName;

    public CompanyPageCommonMethods(WebDriver driver) {
        logger.info("Initializing CompanyPageCommonMethods");
        this.driver = driver;
        this.commonMethods = new CommonMethods(driver);
        this.iframe = new IframesOfApplication(driver);
        this.waitUtils = new WaitUtils(driver);
        logger.info("CompanyPageCommonMethods initialized");
    }

    public void addCompany() {
        logger.info("Entering addCompany method");
        iframe.switchToBottomFrame();
        WebElement Addbutton = waitUtils.waitForElementToBeClickable(CompanyPageLocators.ADD_BUTTON);
        Addbutton.click();
        logger.info("Exiting addCompany method");
    }

    public void selectReseller(String resellerName) {
        logger.info("Entering selectReseller method with resellerName: {}", resellerName);
        iframe.switchToContentFrame();
        By resellerDropdownLocator = CompanyPageLocators.RESELLER_DROPDOWN;
        By optionLocator = By.xpath(String.format(CompanyPageLocators.RESELLER_DROPDOWN_OPTION, resellerName));
        commonMethods.selectFromDropdown(resellerDropdownLocator, optionLocator,true);
        logger.info("Exiting selectReseller method");
    }

    public void enterShortName() {
        this.shortName = CommonMethods.generateRandomFirstName();
        logger.info("Entering short name for company: {}", this.shortName);
        iframe.switchToContentFrame();
        WebElement enterShortNameField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.SHORT_NAME_FIELD);
        enterShortNameField.sendKeys(this.shortName);
        logger.info("Short name entered for company: {}", this.shortName);
    }

    public void enterUserName() {
        this.userName = CommonMethods.generateRandomEmail();
        logger.info("Entering username for company: {}", this.userName);
        iframe.switchToContentFrame();
        WebElement enterUserNameField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.USERNAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterUserNameField);
        enterUserNameField.sendKeys(this.userName);
        logger.info("Username entered for company: {}", this.userName);
    }

    public void enterConfirmUserName() {
        logger.info("Entering confirmation username for company");
        iframe.switchToContentFrame();
        WebElement enterConfirmUserNameField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.CONFIRM_USERNAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterConfirmUserNameField);
        enterConfirmUserNameField.sendKeys(this.userName);
        logger.info("Confirmation username entered for company");
    }

    public void enterPassword() {
        logger.info("Entering password for company");
        iframe.switchToContentFrame();
        WebElement passwordField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.PASSWORD_FIELD);
        passwordField.sendKeys(password);
        logger.info("Password entered for company");
    }

    public void enterRetypePassword() {
        logger.info("Entering retype password for company");
        iframe.switchToContentFrame();
        WebElement retypePasswordField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.RETYPE_PASSWORD_FIELD);
        retypePasswordField.sendKeys(password);
        logger.info("Retype password entered for company");
    }
    
   

    public void checkAndUncheck2StepAuthentication() {
        logger.info("check and uncheck 2 step authentication for the company");
        iframe.switchToContentFrame();
        WebElement twoStepAuthenticationCheckbox = driver.findElement(By.xpath(CompanyPageLocators.TWO_STEP_AUTHENTICATION_CHECKBOX));
        CommonMethods.checkCheckbox(twoStepAuthenticationCheckbox);
        
        WebElement twoStepAuthenticationUnCheckbox = driver.findElement(By.xpath(CompanyPageLocators.TWO_STEP_AUTHENTICATION_CHECKBOX));
        CommonMethods.uncheckCheckbox(twoStepAuthenticationUnCheckbox);
        logger.info("checked and unchecked 2 step authentication for the company");
    }
    
    public void enterPasswordRecoveryEmail()
    {
    	iframe.switchToContentFrame();
    	WebElement recorveryMail = driver.findElement(By.xpath(CompanyPageLocators.PASSWORD_RECOVERY_EMAIL));
    	recorveryMail.sendKeys("regressionAdmin@gmail.com");
    }
    
    public void clickOnAddLocationButton()
    { 
    	logger.info("click on add lcoation butotn");
    	iframe.switchToContentFrame();
    	WebElement AddLocationButton = driver.findElement(By.xpath(CompanyPageLocators.ADD_GEOLOCATION));
    	AddLocationButton.click();
    	WebElement gEOLOCATION_INPUT_FIELDElement = driver.findElement(By.xpath(CompanyPageLocators.GEOCODE_INPUT_FIELD)); 
    	gEOLOCATION_INPUT_FIELDElement.sendKeys("21.08433304301649, 72.7190545319735");
    	WebElement savebtton = driver.findElement(By.xpath(CompanyPageLocators.GEOCODE_SAVE_BUTTON));
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        savebtton.click();
    	
    }
    
    public void EnterSchoolRegistrationNumber()
    {
    	logger.info("entered the school registration number");
    	iframe.switchToContentFrame();
    	WebElement SchoolRegistrationNumberField = driver.findElement(CompanyPageLocators.sCHOOL_REGISTRATION_NUMBER);
    	SchoolRegistrationNumberField.sendKeys("SCHRG001");
    	iframe.switchToParentFrame();
    }

    public void enterTelephoneNumber() {
        String telephoneNumber = CommonMethods.generateRandomMobileNumber();
        logger.info("Entering telephone number for company: {}", telephoneNumber);
        iframe.switchToContentFrame();
        WebElement enterTelephoneNumber = waitUtils.waitForElementToBeClickable(CompanyPageLocators.TELEPHONE_FIELD);
        enterTelephoneNumber.sendKeys(telephoneNumber);
        logger.info("Telephone number entered for company: {}", telephoneNumber);
    }

    public void enterMobileNumber() {
        String mobileNumber = CommonMethods.generateRandomMobileNumber();
        logger.info("Entering mobile number for company: {}", mobileNumber);
        iframe.switchToContentFrame();
        WebElement enterMobileNumber = waitUtils.waitForElementToBeClickable(CompanyPageLocators.MOBILE_NUMBER_FIELD);
        enterMobileNumber.sendKeys(mobileNumber);
        logger.info("Mobile number entered for company: {}", mobileNumber);
    }

    public void selectCountry(String countryName) {
        logger.info("Selecting country for company: {}", countryName);
        iframe.switchToContentFrame();
        By countryDropdownLocator = CompanyPageLocators.COMPANY_DETAILS_COUNTRY_DROPDOWN;
        By countryOptionLocator = By.xpath(String.format(CompanyPageLocators.COMPANY_DETAILS_COUNTRY_DROPDOWN_OPTION, countryName));
        commonMethods.selectFromDropdown(countryDropdownLocator, countryOptionLocator,true);
        logger.info("Country selected for company: {}", countryName);
    }

    public void selectState(String stateName) {
        logger.info("Selecting state for company: {}", stateName);
        waitUtils.waitForMilliseconds(500);
        iframe.switchToContentFrame();
        By stateDropdownLocator = CompanyPageLocators.COMPANY_DETAILS_STATE_DROPDOWN;
        By stateOptionLocator = By.xpath(String.format(CompanyPageLocators.COMPANY_DETAILS_STATE_DROPDOWN_OPTION, stateName));
        commonMethods.selectFromDropdown(stateDropdownLocator, stateOptionLocator,true);
        logger.info("State selected for company: {}", stateName);
    }

    public void enterCity() {
        String city = "Gandhinagar";
        logger.info("Entering city for company: {}", city);
        iframe.switchToContentFrame();
        WebElement enterCityField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.CITY_FIELD);
        enterCityField.sendKeys(city);
        logger.info("City entered for company: {}", city);
    }

    public void enterZipcode() {
        String zipCode = "382016";
        logger.info("Entering zip code for company: {}", zipCode);
        iframe.switchToContentFrame();
        WebElement enterZipCodeField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.ZIP_CODE_FIELD);
        enterZipCodeField.sendKeys(zipCode);
        logger.info("Zip code entered for company: {}", zipCode);
    }

    public void enterStreet1() {
        String street1 = "Prem Bang-low";
        logger.info("Entering street1 for company: {}", street1);
        iframe.switchToContentFrame();
        WebElement enterStreet1Field = waitUtils.waitForElementToBeClickable(CompanyPageLocators.STREET1_FIELD);
        enterStreet1Field.sendKeys(street1);
        logger.info("Street1 entered for company: {}", street1);
    }

    public void enterStreet2() {
        String street2 = "Street Road";
        logger.info("Entering street2 for company: {}", street2);
        iframe.switchToContentFrame();
        WebElement enterStreet2Field = waitUtils.waitForElementToBeClickable(CompanyPageLocators.STREET2_FIELD);
        enterStreet2Field.sendKeys(street2);
        logger.info("Street2 entered for company: {}", street2);
    }

    public void enterContactPerson() {
        String contactPerson = "Vimal Khatri";
        logger.info("Entering contact person for company: {}", contactPerson);
        iframe.switchToContentFrame();
        WebElement contactPersonField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.CONTACT_PERSON_FIELD);
        contactPersonField.sendKeys(contactPerson);
        logger.info("Contact person entered for company: {}", contactPerson);
    }

    public void enterFaxNumber() {
        String faxNumber = CommonMethods.generateRandomMobileNumber();
        logger.info("Entering fax number for company: {}", faxNumber);
        iframe.switchToContentFrame();
        WebElement enterFaxNumberField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.FAX_NUMBER_FIELD);
        enterFaxNumberField.sendKeys(faxNumber);
        logger.info("Fax number entered for company: {}", faxNumber);
    }
    

    public void enterVATINNumber() {
        logger.info("Entering enterVATINNumber method");
        String vatinNumber = CommonMethods.generateRandomMobileNumber();
        iframe.switchToContentFrame();
        WebElement enterVatinNumber = waitUtils.waitForElementToBeClickable(CompanyPageLocators.VATIN_NUMBER_FIELD);
        enterVatinNumber.sendKeys(vatinNumber);
        logger.info("Exiting enterVATINNumber method");
    }

    public void saveButton() {
        logger.info("Entering saveButton method");
            
        
     // Try different frame contexts
       
        iframe.switchToBottomFrame();
        
        // OR try content frame if that's where the button is
        // iframe.switchToContentFrame();
        
        WebElement saveButton = waitUtils.waitForElementToBeClickable(CompanyPageLocators.SAVE_BUTTON);
        saveButton.click();
        waitUtils.waitForMilliseconds(1000);
        logger.info("Exiting saveButton method");
        
        iframe.switchToContentFrame();
        WebElement checkbox = waitUtils.waitForElementToBeClickable(CompanyPageLocators.school_Confirmation_Checkbox);
        checkbox.click();
        waitUtils.waitForMilliseconds(1000);
        
        
        WebElement savebutton = waitUtils.waitForElementToBeClickable(By.xpath("//div[@class=\"buttons-box-save\"]//input[@id=\"save_button\"]"));
        savebutton.click();
        waitUtils.waitForMilliseconds(1000);
    }
    
  

    public void selectTab(String tabName) {
        logger.info("Entering selectTab method with tabName: {}", tabName);
        String xpathTemplate = CompanyPageLocators.TABS;
        commonMethods.selectTab(tabName, xpathTemplate);
        logger.info("Exiting selectTab method");
    }

    public void verifyHeaderOfValidationPopup(String expectedText, String message) {
        iframe.switchToDivFrame();
        commonMethods.assertText(CompanyPageLocators.VALIDATION_POPUP_HEADER, expectedText, message);
    }

    public void verifyContentOfValidationPopUp(String expectedText, String message) {
        iframe.switchToDivFrame();
        commonMethods.assertText(CompanyPageLocators.VALIDATION_MESSAGE, expectedText, message);
    }

    public void verifyContentOfValidationContent(String expectedText, String message) {
        iframe.switchToDivFrame();
        commonMethods.assertText(CompanyPageLocators.VALIDATION_MESSAGE2, expectedText, message);
    }

    public void closeButtonOfPopUp() {
        logger.info("Entering closeButtonOfPopUp method");
        iframe.switchToDivFrame();
        WebElement closeButton = waitUtils.waitForElementToBeClickable(CompanyPageLocators.CLOSE_BUTTON_OF_POPUP);
        closeButton.click();
        logger.info("Exiting closeButtonOfPopUp method");
    }

    public void clickOnCreatedCompany() {
        logger.info("Entering clickOnCreatedCompany method");
        waitUtils.waitForMilliseconds(3000);
        iframe.switchToContentFrame();
        String formattedXpath = String.format(CompanyPageLocators.TABLE_OF_SHORT_NAME, this.shortName);
        commonMethods.doubleClick(By.xpath(formattedXpath));
        logger.info("Exiting clickOnCreatedCompany method");
    }

    public void deleteCompanyButton() {
        logger.info("Entering deleteCompanyButton method");
        iframe.switchToBottomFrame();
        WebElement deleteButton = waitUtils.waitForElementToBeClickable(CompanyPageLocators.DELETE_BUTTON);
        deleteButton.click();
        waitUtils.waitForMilliseconds(1000);
        iframe.switchToDivFrame();
        WebElement bulkokbutton = waitUtils.waitForElementToBeClickable(By.xpath("//input[@id='bulkDeleteOKButton']"));
        bulkokbutton.click();
        logger.info("Exiting deleteCompanyButton method");
    }

    public void clickOnEditedCompany() {
        logger.info("Entering clickOnEditedCompany method");
        iframe.switchToContentFrame();
        String formattedXpath = String.format(CompanyPageLocators.TABLE_OF_SHORT_NAME, this.editShortName);
        commonMethods.doubleClick(By.xpath(formattedXpath));
        logger.info("Exiting clickOnEditedCompany method");
    }

    public void addButtonInsideRuleOfCompany(String name) {
        logger.info("Entering addButtonInsideRuleOfCompany method with name: {}", name);
        iframe.switchToCompanyRuleContentFrame();
        String dynamicXpath = String.format(CompanyPageLocators.ADD_BUTTON_INSIDE_COMPANY, name);
        WebElement addButtonInsideRuleOfCompany = waitUtils.waitForElementToBeClickable(By.xpath(dynamicXpath));
        addButtonInsideRuleOfCompany.click();
        logger.info("Exiting addButtonInsideRuleOfCompany method");
    }

    public void closeButtonInsideRuleOfCompany() {
        logger.info("Clicking closeButtonInsideRuleOfCompany method");
        iframe.switchToContentFrame();
        WebElement closeButton = waitUtils.waitForElementToBeClickable(CompanyPageLocators.CLOSE_BUTTON_OF_RULE_TAB);
        closeButton.click();
        logger.info("Clicked closeButtonInsideRuleOfCompany method");
    }

    public void enterRuleName() {
        logger.info("Entering enterRuleName method");
        String city = "Test1";
        iframe.switchToPopUpDialogFrame();
        WebElement enterCityField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.RULE_NAME_FIELD);
        enterCityField.sendKeys(city);
        logger.info("Exiting enterRuleName method");
    }

    public void validFromDate() {
        logger.info("Entering validFromDate method");
        iframe.switchToPopUpDialogFrame();
        DatePickerUtils datePickerUtils = new DatePickerUtils(driver);
        datePickerUtils.selectDate(By.id("-valid_from"), 0);
        logger.info("Exiting validFromDate method");
    }

    public void selectEventDateFormat(String dateFormat) {
        iframe.switchToPopUpDialogFrame();
        By eventDateFormatDropdownLocator = CompanyPageLocators.EVENT_DATE_FORMAT_DROPDOWN;
        By eventDateFormatOptionLocator = By.xpath(String.format(CompanyPageLocators.EVENT_DATE_FORMAT_DROPDOWN_OPTION, dateFormat));
        commonMethods.selectFromDropdown(eventDateFormatDropdownLocator, eventDateFormatOptionLocator,true);
    }

    public void selectTimeFormatOfRule(String timeFormat) {
        iframe.switchToPopUpDialogFrame();
        By dateFormatDropdownLocator = CompanyPageLocators.DATE_FORMAT_DROPDOWN;
        By dateFormatOptionLocator = By.xpath(String.format(CompanyPageLocators.DATE_FORMAT_DROPDOWN_OPTION, timeFormat));
        commonMethods.selectFromDropdown(dateFormatDropdownLocator, dateFormatOptionLocator,true);
    }


    public void saveButtonOfDialogBox() {
        logger.info("Entering saveButtonOfDialogBox method");
        iframe.switchToContentFrame();
        WebElement saveButton = waitUtils.waitForElementToBeClickable(CompanyPageLocators.SAVE_BUTTON_OF_DIALOG_BOX);
        saveButton.click();
        waitUtils.waitForMilliseconds(1000);
        logger.info("Exiting saveButtonOfDialogBox method");
    }

    public void addButtonInsideDesignation(String name) {
        logger.info("Entering addButtonInsideDesignation method with name: {}", name);
        iframe.switchToDesignationContentFrame();
        String dynamicXpath = String.format(CompanyPageLocators.ADD_BUTTON_INSIDE_DESIGNATION_OF_COMPANY, name);
        WebElement addButtonInsideDesignationOfCompany = waitUtils.waitForElementToBeClickable(By.xpath(dynamicXpath));
        addButtonInsideDesignationOfCompany.click();
        logger.info("Exiting addButtonInsideDesignation method");
    }

    public void enterDesignationNameInAddDesignation() {
        logger.info("Entering enterDesignationNameInAddDesignation method");
        String designationName = "Quality Assurance Engineer";
        iframe.switchToDesignationContentFrame();
        WebElement designationNameField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.DESIGNATION_NAME_FIELD);
        designationNameField.sendKeys(designationName);
        logger.info("Exiting enterDesignationNameInAddDesignation method");
    }

    public void addButtonInsideDepartment(String name) {
        logger.info("Entering addButtonInsideDepartment method with name: {}", name);
        iframe.switchToDepartmentContentFrame();
        String dynamicXpath = String.format(CompanyPageLocators.ADD_BUTTON_INSIDE_COMPANY, name);
        WebElement addButtonInsideCompany = waitUtils.waitForElementToBeClickable(By.xpath(dynamicXpath));
        addButtonInsideCompany.click();
        logger.info("Exiting addButtonInsideDepartment method");
    }

    public void enterDepartmentNameInAddDepartment() {
        logger.info("Entering enterDepartmentNameInAddDepartment method");
        String departmentName = "Quality Department";
        iframe.switchToDepartmentContentFrame();
        WebElement contactPersonField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.DEPARTMENT_NAME_FIELD);
        contactPersonField.sendKeys(departmentName);
        logger.info("Exiting enterDepartmentNameInAddDepartment method");
    }

    public void enterDescriptionInAddDepartment() {
        logger.info("Entering enterDescriptionInAddDepartment method");
        String departmentDescription = "Testing Process";
        iframe.switchToDepartmentContentFrame();
        WebElement contactPersonField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.DEPARTMENT_DESCRIPTION_FIELD);
        contactPersonField.sendKeys(departmentDescription);
        logger.info("Exiting enterDescriptionInAddDepartment method");
    }

    public void addButtonInsideTaskCategory(String name) {
        logger.info("Entering addButtonInsideTaskCategory method with name: {}", name);
        iframe.switchTaskCategoryContentFrame();
        String dynamicXpath = String.format(CompanyPageLocators.ADD_BUTTON_INSIDE_COMPANY, name);
        WebElement addButtonInsideCompany = waitUtils.waitForElementToBeClickable(By.xpath(dynamicXpath));
        addButtonInsideCompany.click();
        logger.info("Exiting addButtonInsideTaskCategory method");
    }

    public void enterTaskCategoryNameInTaskCategory() {
        logger.info("Entering enterTaskCategoryNameInTaskCategory method");
        String taskCategoryName = "QA Automation";
        iframe.switchTaskCategoryContentFrame();
        WebElement contactPersonField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.TASK_CATEGORY_NAME_FIELD);
        contactPersonField.sendKeys(taskCategoryName);
        logger.info("Exiting enterTaskCategoryNameInTaskCategory method");
    }

    public void enterDescriptionInTaskCategory() {
        logger.info("Entering enterDescriptionInTaskCategory method");
        String categoryDescription = "Testing Process";
        iframe.switchTaskCategoryContentFrame();
        WebElement contactPersonField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.TASK_DESCRIPTION_FIELD);
        contactPersonField.sendKeys(categoryDescription);
        logger.info("Exiting enterDescriptionInTaskCategory method");
    }

    public void addButtonInsideExpenseCategory(String name) {
        logger.info("Entering addButtonInsideExpenseCategory method with name: {}", name);
        iframe.switchExpenseCategoryContentFrame();
        String dynamicXpath = String.format(CompanyPageLocators.ADD_BUTTON_INSIDE_COMPANY, name);
        WebElement addButtonInsideCompany = waitUtils.waitForElementToBeClickable(By.xpath(dynamicXpath));
        addButtonInsideCompany.click();
        logger.info("Exiting addButtonInsideExpenseCategory method");
    }

    public void enterExpenseCategoryNameInExpenseCategory() {
        logger.info("Entering enterExpenseCategoryNameInExpenseCategory method");
        String expenseCategoryName = "Petrol Expense";
        iframe.switchExpenseCategoryContentFrame();
        WebElement contactPersonField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.EXPENSE_CATEGORY_NAME_FIELD);
        contactPersonField.sendKeys(expenseCategoryName);
        logger.info("Exiting enterExpenseCategoryNameInExpenseCategory method");
    }

    public void enterDescriptionInExpenseCategory() {
        logger.info("Entering enterDescriptionInExpenseCategory method");
        String expenseDescription = "This is only for Petrol Expense";
        iframe.switchExpenseCategoryContentFrame();
        WebElement contactPersonField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.EXPENSE_DESCRIPTION_FIELD);
        contactPersonField.sendKeys(expenseDescription);
        logger.info("Exiting enterDescriptionInExpenseCategory method");
    }

    public void isClaimableInExpenseCategory() {
        logger.info("Entering isClaimableInExpenseCategory method");
        iframe.switchExpenseCategoryContentFrame();
        WebElement expenseClaimableCheckbox = driver.findElement(By.xpath(CompanyPageLocators.EXPENSE_CLAIMABLE_CHECKBOX));
        CommonMethods.checkCheckbox(expenseClaimableCheckbox);
        logger.info("Exiting isClaimableInExpenseCategory method");
    }

    public void addButtonInsideShift(String name) {
        logger.info("Entering addButtonInsideShift method with name: {}", name);
        iframe.switchShiftContentFrame();
        String dynamicXpath = String.format(CompanyPageLocators.ADD_BUTTON_INSIDE_COMPANY, name);
        WebElement addButtonInsideCompany = waitUtils.waitForElementToBeClickable(By.xpath(dynamicXpath));
        addButtonInsideCompany.click();
        logger.info("Exiting addButtonInsideShift method");
    }

    public void addButtonInsideSosCategory(String name) {
        logger.info("Entering addButtonInsideSosCategory method with name: {}", name);
        iframe.switchToSosCategoryContentFrame();
        String dynamicXpath = String.format(CompanyPageLocators.ADD_BUTTON_INSIDE_DESIGNATION_OF_COMPANY, name);
        WebElement addButtonInsideSosCategoryOfCompany = waitUtils.waitForElementToBeClickable(By.xpath(dynamicXpath));
        addButtonInsideSosCategoryOfCompany.click();
        logger.info("Exiting addButtonInsideSosCategory method");
    }

    public void selectCategoryOnSOSCategoryTabOfCompany(String categoryName) {
        iframe.switchToSosCategoryContentFrame();
        By sosCategoryDropdownLocator = CompanyPageLocators.SOS_CATEGORY_DROPDOWN;
        By sosCategoryOptionLocator = By.xpath(String.format(CompanyPageLocators.SOS_CATEGORY_DROPDOWN_OPTION, categoryName));
        commonMethods.selectFromDropdown(sosCategoryDropdownLocator, sosCategoryOptionLocator,true);
    }

    public void enterCategoryType(String CategoryType) {
        logger.info("Entering enterCategoryType method");
        iframe.switchToSosCategoryContentFrame();
        WebElement enterCategoryType = waitUtils.waitForElementToBeClickable(CompanyPageLocators.SOS_CATEGORY_TYPE_FIELD);
        enterCategoryType.sendKeys(CategoryType);
        logger.info("Exiting enterCategoryType method");
    }

    public void addButtonInsideLeaveReason(String leaveReasonName) {
        logger.info("Entering addButtonInsideLeaveReason method with name: {}", leaveReasonName);
        iframe.switchToLeaveReasonContentFrame();
        String dynamicXpath = String.format(CompanyPageLocators.ADD_BUTTON_INSIDE_DESIGNATION_OF_COMPANY, leaveReasonName);
        WebElement addButtonInsideSosCategoryOfCompany = waitUtils.waitForElementToBeClickable(By.xpath(dynamicXpath));
        addButtonInsideSosCategoryOfCompany.click();
        logger.info("Exiting addButtonInsideLeaveReason method");
    }

    public void enterLeaveReason(String leaveReason) {
        logger.info("Entering enterLeaveReason method");
        iframe.switchToLeaveReasonContentFrame();
        WebElement enterLeaveReason = waitUtils.waitForElementToBeClickable(CompanyPageLocators.LEAVE_REASON_FIELD);
        enterLeaveReason.sendKeys(leaveReason);
        logger.info("Exiting enterLeaveReason method");
    }

    public void enterLeaveReasonDescription(String leaveReasonDescription) {
        logger.info("Entering enterLeaveReasonDescription method");
        iframe.switchToLeaveReasonContentFrame();
        WebElement enterLeaveReasonDescription = waitUtils.waitForElementToBeClickable(CompanyPageLocators.SOS_REASON_DESCRIPTION_FIELD);
        enterLeaveReasonDescription.sendKeys(leaveReasonDescription);
        logger.info("Exiting enterLeaveReasonDescription method");
    }

    public void enterShiftNameInShift() {
        logger.info("Entering enterShiftNameInShift method");
        String shiftName = "Morning Shift";
        iframe.switchToPopUpDialogFrame();
        WebElement contactPersonField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.SHIFT_NAME_FIELD);
        contactPersonField.sendKeys(shiftName);
        logger.info("Exiting enterShiftNameInShift method");
    }

    public void selectValidFromDateForShift() {
        logger.info("Entering selectValidFromDateForShift method");
        iframe.switchToPopUpDialogFrame();
        DatePickerUtils datePickerUtils = new DatePickerUtils(driver);
        datePickerUtils.selectFromAndToDate(CompanyPageLocators.SHIFT_VALID_FROM, 1);
        logger.info("Exiting selectValidFromDateForShift method");
    }

    public void selectValidToDateForShift() {
        logger.info("Entering selectValidToDateForShift method");
        iframe.switchToPopUpDialogFrame();
        DatePickerUtils datePickerUtils = new DatePickerUtils(driver);
        datePickerUtils.selectFromAndToDate(CompanyPageLocators.SHIFT_VALID_TO, 365);
        logger.info("Exiting selectValidToDateForShift method");
    }

    public void selectWorkingDays(String... daysToSelect) {
        logger.info("Entering selectWorkingDays method with daysToSelect: {}", (Object[]) daysToSelect);
        iframe.switchToPopUpDialogFrame();
        commonMethods.selectWorkingDays(daysToSelect);
        logger.info("Exiting selectWorkingDays method");
    }

    public void selectShiftType() {
        logger.info("Entering selectShiftType method");
        iframe.switchToPopUpDialogFrame();
        commonMethods.selectRadioButton(CompanyPageLocators.FLEXIBLE_SHIFT);
        logger.info("Exiting selectShiftType method");
    }

    public void selectDailyWorkingHourWithMinutes(String hourValue, String minuteValue) {
        logger.info("Entering selectDailyWorkingHourWithMinutes method with hourValue: {} and minuteValue: {}", hourValue, minuteValue);
        iframe.switchToPopUpDialogFrame();
        By dailyWorkingHourDropdown = By.name("daily_working_hour_hr");
        commonMethods.selectFromSelectDropdown(dailyWorkingHourDropdown, hourValue);
        By dailyWorkingMinutesDropdown = By.name("daily_working_hour_hr_min");
        commonMethods.selectFromSelectDropdown(dailyWorkingMinutesDropdown, minuteValue);
        logger.info("Exiting selectDailyWorkingHourWithMinutes method");
    }

    public void editShortName() {
        this.editShortName = CommonMethods.generateRandomFirstName();
        iframe.switchToContentFrame();
        WebElement enterShortNameField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.SHORT_NAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterShortNameField);
        enterShortNameField.sendKeys(this.editShortName);
    }

    public void editUserName() {
        this.editUserName = CommonMethods.generateRandomEmail();
        iframe.switchToContentFrame();
        WebElement enterUserNameField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.USERNAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterUserNameField);
        enterUserNameField.sendKeys(this.editUserName);
    }

    public void editMobileNumber() {
        this.editMobileNumber = CommonMethods.generateRandomMobileNumber();
        iframe.switchToContentFrame();
        WebElement enterMobileNumber = waitUtils.waitForElementToBeClickable(CompanyPageLocators.MOBILE_NUMBER_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterMobileNumber);
        enterMobileNumber.sendKeys(this.editMobileNumber);
    }

    public void editTelephoneNumber() {
        String editTelephoneNumber = CommonMethods.generateRandomMobileNumber();
        iframe.switchToContentFrame();
        WebElement enterTelephoneNumber = waitUtils.waitForElementToBeClickable(CompanyPageLocators.TELEPHONE_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterTelephoneNumber);
        enterTelephoneNumber.sendKeys(editTelephoneNumber);
    }

    public void verifyThatShortNameEdited() {
        iframe.switchToContentFrame();
        boolean isEdited = commonMethods.isTextPresentInTable(this.editShortName);
        Assert.assertTrue(isEdited, "Short Name '" + this.editShortName + "' was not edited successfully.");
    }

    public void verifyThatMobileNumberEdited() {
        iframe.switchToContentFrame();
        boolean isEdited = commonMethods.isTextPresentInTable(this.editMobileNumber);
        Assert.assertTrue(isEdited, "Short Name '" + this.editMobileNumber + "' was not edited successfully.");
    }

    public void verifyThatUserNameEdited() {
        iframe.switchToContentFrame();
        boolean isEdited = commonMethods.isTextPresentInTable(this.editUserName);
        Assert.assertTrue(isEdited, "Short Name '" + this.editUserName + "' was not edited successfully.");
    }

    public void editDepartmentNameInEditDepartment() {
        String editedDepartmentName = "SDET";
        iframe.switchToDepartmentContentFrame();
        WebElement departmentNameField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.DEPARTMENT_NAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", departmentNameField);
        departmentNameField.sendKeys(editedDepartmentName);
    }

    public void editDescriptionInEditDepartment() {
        String editedDepartmentDescription = "Testing Mobile";
        iframe.switchToDepartmentContentFrame();
        WebElement departmentDescriptionField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.DEPARTMENT_DESCRIPTION_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", departmentDescriptionField);
        departmentDescriptionField.sendKeys(editedDepartmentDescription);
    }

    public void editTaskCategoryNameInEditTaskCategory() {
        logger.info("Entering editTaskCategoryNameInEditTaskCategory method");
        String taskCategoryName = "Web Automation";
        iframe.switchTaskCategoryContentFrame();
        WebElement taskCategoryField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.TASK_CATEGORY_NAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", taskCategoryField);
        taskCategoryField.sendKeys(taskCategoryName);
        logger.info("Exiting editTaskCategoryNameInEditTaskCategory method");
    }

    public void editTaskCategoryDescriptionInEditTaskCategory() {
        logger.info("Entering editTaskCategoryDescriptionInEditTaskCategory method");
        String categoryDescription = "Manual testing";
        iframe.switchTaskCategoryContentFrame();
        WebElement taskCategoryDescriptionField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.TASK_DESCRIPTION_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", taskCategoryDescriptionField);
        taskCategoryDescriptionField.sendKeys(categoryDescription);
        logger.info("Exiting editTaskCategoryDescriptionInEditTaskCategory method");
    }

    public void editExpenseCategoryNameInEditExpenseCategory() {
        logger.info("Entering editExpenseCategoryNameInEditExpenseCategory method");
        String expenseCategoryName = "Crud Oil Expense";
        iframe.switchExpenseCategoryContentFrame();
        WebElement expenseCategoryNameField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.EXPENSE_CATEGORY_NAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", expenseCategoryNameField);
        expenseCategoryNameField.sendKeys(expenseCategoryName);
        logger.info("Exiting editExpenseCategoryNameInEditExpenseCategory method");
    }

    public void editDescriptionInEditExpenseCategory() {
        logger.info("Entering editDescriptionInEditExpenseCategory method");
        String expenseDescription = "Recharge You Vehicle Expense";
        iframe.switchExpenseCategoryContentFrame();
        WebElement expenseDescriptionField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.EXPENSE_DESCRIPTION_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", expenseDescriptionField);
        expenseDescriptionField.sendKeys(expenseDescription);
        logger.info("Exiting editDescriptionInEditExpenseCategory method");
    }

    public void editIsClaimableInEditExpenseCategory() {
        logger.info("Entering editIsClaimableInEditExpenseCategory method");
        iframe.switchExpenseCategoryContentFrame();
        WebElement expenseClaimableUncheckCheckbox = driver.findElement(By.xpath(CompanyPageLocators.EXPENSE_CLAIMABLE_CHECKBOX));
        CommonMethods.uncheckCheckbox(expenseClaimableUncheckCheckbox);
        WebElement expenseClaimableCheckCheckbox = driver.findElement(By.xpath(CompanyPageLocators.EXPENSE_CLAIMABLE_CHECKBOX));
        CommonMethods.checkCheckbox(expenseClaimableCheckCheckbox);
        logger.info("Exiting editIsClaimableInEditExpenseCategory method");
    }

    public void selectTimeZone(String timezoneName) {
        iframe.switchToContentFrame();
        By timezoneDropdownLocator = CompanyPageLocators.TIMEZONE_DROPDOWN;
        By timezoneOptionLocator = By.xpath(String.format(CompanyPageLocators.TIMEZONE_DROPDOWN_OPTION, timezoneName));
        commonMethods.selectFromDropdown(timezoneDropdownLocator, timezoneOptionLocator,true);
    }

    public void selectDateFormat(String dateFormat) {
        iframe.switchToContentFrame();
        By dateFormatDropdownLocator = CompanyPageLocators.DATE_FORMAT_DROPDOWN;
        By dateFormatOptionLocator = By.xpath(String.format(CompanyPageLocators.DATE_FORMAT_DROPDOWN_OPTION, dateFormat));
        commonMethods.selectFromDropdown(dateFormatDropdownLocator, dateFormatOptionLocator,true);
    }

    public void selectTimeFormat(String timeFormat) {
        iframe.switchToContentFrame();
        By timeFormatDropdownLocator = CompanyPageLocators.TIME_FORMAT_DROPDOWN;
        By timeFormatOptionLocator = By.xpath(String.format(CompanyPageLocators.TIME_FORMAT_DROPDOWN_OPTION, timeFormat));
        commonMethods.selectFromDropdown(timeFormatDropdownLocator, timeFormatOptionLocator,true);
    }

    public void selectUnitsOfDistance(String unitOfDistance) {
        iframe.switchToContentFrame();
        By unitOfDistanceDropdownLocator = CompanyPageLocators.UNITS_OF_DISTANCE_DROPDOWN;
        By unitOfDistanceOptionLocator = By.xpath(String.format(CompanyPageLocators.UNITS_OF_DISTANCE_DROPDOWN_OPTION, unitOfDistance));
        commonMethods.selectFromDropdown(unitOfDistanceDropdownLocator, unitOfDistanceOptionLocator,true);
    }

    public void selectUserStatus() {
        iframe.switchToContentFrame();
        commonMethods.selectRadioButton(CompanyPageLocators.USER_STATUS_INACTIVE);
        commonMethods.selectRadioButton(CompanyPageLocators.USER_STATUS_ACTIVE);
    }

    public void selectShowDefaultFilterOption() {
        iframe.switchToContentFrame();
        commonMethods.selectRadioButton(CompanyPageLocators.SHOW_DEFAULT_FIlTER_OPTION_IS_OFF);
        commonMethods.selectRadioButton(CompanyPageLocators.SHOW_DEFAULT_FIlTER_OPTION_IS_ON);
    }

    public void checkWebNotification() {
        iframe.switchToContentFrame();
        WebElement webNotificationCheckbox = driver.findElement(By.xpath(CompanyPageLocators.WEB_NOTIFICATION_CHECKBOX));
        CommonMethods.checkCheckbox(webNotificationCheckbox);
    }

    public void selectWebAccess() {
        iframe.switchToContentFrame();
        commonMethods.selectRadioButton(CompanyPageLocators.WEB_ACCESS_NONE);
        commonMethods.selectRadioButton(CompanyPageLocators.WEB_ACCESS_ALL);
    }

    public void selectNMobileAccess() {
        iframe.switchToContentFrame();
        commonMethods.selectRadioButton(CompanyPageLocators.MOBILE_ACCESS_NONE);
        commonMethods.selectRadioButton(CompanyPageLocators.MOBILE_ACCESS_ALL);
    }

    public void selectCopyFromGroup(String groupName) {
        iframe.switchToContentFrame();
        By groupNameDropdownLocator = AdminPageLocators.COPY_FROM_GROUP_DROPDOWN;
        By groupNameOptionLocator = By.xpath(String.format(AdminPageLocators.COPY_FROM_GROUP_DROPDOWN_OPTION, groupName));
        commonMethods.selectFromDropdown(groupNameDropdownLocator, groupNameOptionLocator,true);
    }

    public void selectAlertOnDataAccessTabOfCompany() {
        iframe.switchToContentFrame();
        WebElement selectChargerAlert = waitUtils.waitForElementToBeClickable(CompanyPageLocators.CHARGER_ALERT_OPTION);
        selectChargerAlert.click();
        WebElement selectAllAlert = waitUtils.waitForElementToBeClickable(CompanyPageLocators.ALL_ALERT_OPTION);
        selectAllAlert.click();
    }

    public void selectLanguageOnDataAccessTabOfCompany(String languageName) {
        iframe.switchToContentFrame();
        By languageDropdownLocator = CompanyPageLocators.LANGUAGE_DROPDOWN;
        By languageOptionLocator = By.xpath(String.format(CompanyPageLocators.LANGUAGE_DROPDOWN_OPTION, languageName));
        commonMethods.selectFromDropdown(languageDropdownLocator, languageOptionLocator,true);
    }

    public void addButtonInsideMapOfCompany(String name) {
        iframe.switchToCompanyMapContentFrame();
        String dynamicXpath = String.format(CompanyPageLocators.ADD_BUTTON_INSIDE_COMPANY, name);
        WebElement addButtonInsideCompany = waitUtils.waitForElementToBeClickable(By.xpath(dynamicXpath));
        addButtonInsideCompany.click();
    }

    public void selectMapOnMapTabOfCompany(String mapName) {
        iframe.switchToCompanyMapContentFrame();
        By mapDropdownLocator = CompanyPageLocators.MAP_DROPDOWN;
        By mapOptionLocator = By.xpath(String.format(CompanyPageLocators.MAP_DROPDOWN_OPTION, mapName));
        commonMethods.selectFromDropdown(mapDropdownLocator, mapOptionLocator,true);
    }

    public void enterWebMapKey(String WebMapKey) {
        logger.info("Entering enterWebMapKey method");
        iframe.switchToCompanyMapContentFrame();
        WebElement enterWebMapKey = waitUtils.waitForElementToBeClickable(CompanyPageLocators.WEB_MAP_KEY_FIELD);
        enterWebMapKey.sendKeys(WebMapKey);
        logger.info("Exiting enterWebMapKey method");
    }

    public void enterMobileMapKey(String MobileMapKey) {
        logger.info("Entering enterMobileMapKey method");
        iframe.switchToCompanyMapContentFrame();
        WebElement enterMobileMapKey = waitUtils.waitForElementToBeClickable(CompanyPageLocators.MOBILE_MAP_KEY_FIELD);
        enterMobileMapKey.sendKeys(MobileMapKey);
        logger.info("Exiting enterMobileMapKey method");
    }

    public void checkAddressFromMapProvider() {
        logger.info("Entering checkAddressFromMapProvider method");
        iframe.switchToCompanyMapContentFrame();
        WebElement addressFromMapProviderCheckBox = driver.findElement(By.xpath(CompanyPageLocators.ADDRESS_FROM_MAP_PROVIDER_CHECKBOX));
        CommonMethods.checkCheckbox(addressFromMapProviderCheckBox);
        logger.info("Exiting checkAddressFromMapProvider method");
    }

    public void editUncheckAddressFromMapProvider() {
        logger.info("Entering uncheckAddressFromMapProvider method");
        iframe.switchToCompanyMapContentFrame();
        WebElement addressFromMapProviderCheckBox = driver.findElement(By.xpath(CompanyPageLocators.ADDRESS_FROM_MAP_PROVIDER_CHECKBOX));
        CommonMethods.uncheckCheckbox(addressFromMapProviderCheckBox);
        logger.info("Exiting uncheckAddressFromMapProvider method");
    }

    public void checkDefaultMap() {
        logger.info("Entering checkDefaultMap method");
        iframe.switchToCompanyMapContentFrame();
        WebElement defaultMapCheckBox = driver.findElement(By.xpath(CompanyPageLocators.DEFAULT_MAP_CHECKBOX));
        CommonMethods.checkCheckbox(defaultMapCheckBox);
        logger.info("Exiting checkDefaultMap method");
    }

    public void editUncheckDefaultMap() {
        logger.info("Entering uncheckDefaultMap method");
        iframe.switchToCompanyMapContentFrame();
        WebElement defaultMapCheckBox = driver.findElement(By.xpath(CompanyPageLocators.DEFAULT_MAP_CHECKBOX));
        CommonMethods.uncheckCheckbox(defaultMapCheckBox);
        logger.info("Exiting uncheckDefaultMap method");
    }

    public void enterFromEmailAddressInEmailTabOfCompany(String FromEmailAddress) {
        logger.info("Entering enterFromEmailAddressInEmailTabOfCompany method");
        iframe.switchToContentFrame();
        WebElement enterFromEmailAddress = waitUtils.waitForElementToBeClickable(CompanyPageLocators.FROM_EMAIL_ADDRESS_FIELD_IN_EMAIL_TAB);
        enterFromEmailAddress.sendKeys(FromEmailAddress);
        logger.info("Exiting enterFromEmailAddressInEmailTabOfCompany method");
    }

    public void enterUserNameInEmailTabOfCompany(String UserNameOfEmailTab) {
        logger.info("Entering enterUserNameInEmailTabOfCompany method");
        iframe.switchToContentFrame();
        WebElement enterUserNameInEmailTabOfCompany = waitUtils.waitForElementToBeClickable(CompanyPageLocators.USERNAME_FIELD_IN_EMAIL_TAB);
        enterUserNameInEmailTabOfCompany.sendKeys(UserNameOfEmailTab);
        logger.info("Exiting enterUserNameInEmailTabOfCompany method");
    }

    public void enterPasswordInEmailTabOfCompany(String PasswordOfEmailTab) {
        logger.info("Entering enterPasswordInEmailTabOfCompany method");
        iframe.switchToContentFrame();
        WebElement enterPasswordInEmailTabOfCompany = waitUtils.waitForElementToBeClickable(CompanyPageLocators.PASSWORD_FIELD_IN_EMAIL_TAB);
        enterPasswordInEmailTabOfCompany.sendKeys(PasswordOfEmailTab);
        logger.info("Exiting enterPasswordInEmailTabOfCompany method");
    }

    public void enterHostInEmailTabOfCompany(String HostOfEmailTab) {
        logger.info("Entering enterHostInEmailTabOfCompany method");
        iframe.switchToContentFrame();
        WebElement enterHostInEmailTabOfCompany = waitUtils.waitForElementToBeClickable(CompanyPageLocators.HOST_FIELD_IN_EMAIL_TAB);
        enterHostInEmailTabOfCompany.sendKeys(HostOfEmailTab);
        logger.info("Exiting enterHostInEmailTabOfCompany method");
    }

    public void enterOutgoingPortInEmailTabOfCompany(String OutgoingPortOfEmailTab) {
        logger.info("Entering enterOutgoingPortInEmailTabOfCompany method");
        iframe.switchToContentFrame();
        WebElement enterOutgoingPortInEmailTabOfCompany = waitUtils.waitForElementToBeClickable(CompanyPageLocators.OUTGOING_PORT_FIELD_IN_EMAIL_TAB);
        enterOutgoingPortInEmailTabOfCompany.sendKeys(OutgoingPortOfEmailTab);
        logger.info("Exiting enterOutgoingPortInEmailTabOfCompany method");
    }

    public void clickOnTestConfigurationButtonInEmailTabOfCompany() {
        logger.info("Entering clickOnTestConfigurationButtonInEmailTabOfCompany method");
        iframe.switchToContentFrame();
        WebElement testConfigurationButton = waitUtils.waitForElementToBeClickable(CompanyPageLocators.TEST_CONFIGURATION_BUTTON_IN_EMAIL_TAB);
        testConfigurationButton.click();
        logger.info("Exiting clickOnTestConfigurationButtonInEmailTabOfCompany method");
    }

    public void enterVerifyEmailToInEmailTabOfCompany(String VerifyEmailId) {
        logger.info("Entering enterVerifyEmailToInEmailTabOfCompany method");
        iframe.switchToContentFrame();
        WebElement enterVerifyEmailToInEmailTabOfCompany = waitUtils.waitForElementToBeClickable(CompanyPageLocators.EMAIL_VERIFICATION_FIELD_IN_EMAIL_TAB);
        enterVerifyEmailToInEmailTabOfCompany.sendKeys(VerifyEmailId);
        logger.info("Exiting enterVerifyEmailToInEmailTabOfCompany method");
    }

    public void clickOnEmailVerifyButtonInEmailTabOfCompany() {
        logger.info("Entering clickOnEmailVerifyButtonInEmailTabOfCompany method");
        iframe.switchToContentFrame();
        WebElement verifyButton = waitUtils.waitForElementToBeClickable(CompanyPageLocators.EMAIL_VERIFICATION_BUTTON_IN_EMAIL_TAB);
        verifyButton.click();
        logger.info("Exiting clickOnEmailVerifyButtonInEmailTabOfCompany method");
    }

    public void clickOnEditShift() {
        iframe.switchShiftContentFrame();
        WebElement editShift = waitUtils.waitForElementToBeClickable(CompanyPageLocators.EDIT_SHIFT);
        editShift.click();
    }

    public void editShiftNameInShift() {
        logger.info("Entering editShiftNameInShift method");
        String shiftName = "Edit Morning Shift";
        iframe.switchToPopUpDialogFrame();
        WebElement contactPersonField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.SHIFT_NAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", contactPersonField);
        contactPersonField.sendKeys(shiftName);
        logger.info("Exiting editShiftNameInShift method");
    }

    public void editWebMapKey(String WebMapKey) {
        logger.info("Entering editWebMapKey method");
        iframe.switchToCompanyMapContentFrame();
        WebElement enterWebMapKey = waitUtils.waitForElementToBeClickable(CompanyPageLocators.WEB_MAP_KEY_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterWebMapKey);
        enterWebMapKey.sendKeys(WebMapKey);
        logger.info("Exiting editWebMapKey method");
    }

    public void editMobileMapKey(String MobileMapKey) {
        logger.info("Entering editMobileMapKey method");
        iframe.switchToCompanyMapContentFrame();
        WebElement enterMobileMapKey = waitUtils.waitForElementToBeClickable(CompanyPageLocators.MOBILE_MAP_KEY_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterMobileMapKey);
        enterMobileMapKey.sendKeys(MobileMapKey);
        logger.info("Exiting editMobileMapKey method");
    }

    public void enterStaticUserName() {
        logger.info("Entering enterStaticUserName method");
        String userName = "BodiwalaCompany@yopmail.com";
        iframe.switchToContentFrame();
        WebElement enterUserNameField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.USERNAME_FIELD);
        enterUserNameField.sendKeys(userName);
        logger.info("Exiting enterStaticUserName method");
    }

    public void enterStaticConfirmUserName() {
        logger.info("Entering enterStaticConfirmUserName method");
        String userName = "BodiwalaCompany@yopmail.com";
        iframe.switchToContentFrame();
        WebElement enterConfirmUserNameField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.CONFIRM_USERNAME_FIELD);
        enterConfirmUserNameField.sendKeys(userName);
        logger.info("Exiting enterStaticConfirmUserName method");
    }

    public void searchTheCompanyUser() {
        logger.info("Entering searchTheCompanyUser method");
        iframe.switchToBottomFrame();
        WebElement searchField = waitUtils.waitForElementToBeClickable(AdminPageLocators.SEARCH_FIELD);
        searchField.sendKeys(this.shortName);
        searchField.sendKeys(Keys.ENTER);
        logger.info("Exiting searchTheCompanyUser method");
    }

    public void editedSearchTheCompanyUser() {
        logger.info("Entering editedSearchTheCompanyUser method");
        iframe.switchToBottomFrame();
        WebElement searchField = waitUtils.waitForElementToBeClickable(AdminPageLocators.SEARCH_FIELD);
        searchField.sendKeys(this.editShortName);
        searchField.sendKeys(Keys.ENTER);
        logger.info("Exiting editedSearchTheCompanyUser method");
    }

    public void verifyFieldsArePresent(String[][] fields, String areaName, String fieldLocator) {
        for (String[] field : fields) {
            String label = field[0];
            String xpath = String.format(fieldLocator, label);
            try {
                driver.findElement(By.xpath(xpath));
            } catch (NoSuchElementException e) {
                Assert.fail("Field with label '" + label + "' is not present in the " + areaName + " area. Locator used: " + xpath);
            }
        }
    }
}
