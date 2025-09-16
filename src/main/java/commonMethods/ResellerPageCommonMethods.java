package commonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import configurations.common.CommonMethods;
import configurations.common.IframesOfApplication;
import configurations.common.WaitUtils;
import web.locators.AdminPageLocators;
import web.locators.CompanyPageLocators;
import web.locators.ResellerPageLocators;

public class ResellerPageCommonMethods {
    
	private final WebDriver driver;
    private final CommonMethods commonMethods;
    private final IframesOfApplication iframe;
    private final String password = "Test@123";
    private String userName;
    private String shortName;
    private String editShortName;
    private String editMobileNumber;
    private String editUserName;
    private final WaitUtils waitUtils;
    
    public ResellerPageCommonMethods(WebDriver driver) {
        this.driver = driver;
        this.commonMethods = new CommonMethods(driver);
        this.iframe = new IframesOfApplication(driver);
        this.waitUtils = new WaitUtils(driver);
    }
    
    public void addReseller() {
        iframe.switchToBottomFrame();
        WebElement addButton = waitUtils.waitForElementToBeClickable(CompanyPageLocators.ADD_BUTTON);
        addButton.click();
    }
    
    public void selectCountryForReseller(String countryName) {
        iframe.switchToContentFrame();
        By countryDropdownLocator = ResellerPageLocators.RESELLER_DETAILS_COUNTRY_DROPDOWN;
        By countryOptionLocator = By.xpath(String.format(ResellerPageLocators.RESELLER_DETAILS_COUNTRY_DROPDOWN_OPTION, countryName));
        commonMethods.selectFromDropdown(countryDropdownLocator, countryOptionLocator,true);
    }
    
    public void selectStateForReseller(String stateName) {
        iframe.switchToContentFrame();
        By stateDropdownLocator = ResellerPageLocators.RESELLER_DETAILS_STATE_DROPDOWN;
        By stateOptionLocator = By.xpath(String.format(ResellerPageLocators.RESELLER_DETAILS_STATE_DROPDOWN_OPTION, stateName));
        commonMethods.selectFromDropdown(stateDropdownLocator, stateOptionLocator,true);
    }
    
    public void enterShortNameForReseller() {
        this.shortName = CommonMethods.generateRandomFirstName();
        iframe.switchToContentFrame();
        WebElement enterShortNameField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.SHORT_NAME_FIELD);
        enterShortNameField.sendKeys(this.shortName);
    }
    
    public void enterUserNameForReseller() {
        this.userName = CommonMethods.generateRandomEmail();
        iframe.switchToContentFrame();
        WebElement enterUserNameField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.USERNAME_FIELD);
        enterUserNameField.sendKeys(this.userName);
    }
	
    public void enterConfirmUserNameForReseller() {
        iframe.switchToContentFrame();
        WebElement enterConfirmUserNameField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.CONFIRM_USERNAME_FIELD);
        enterConfirmUserNameField.sendKeys(this.userName);
    }
    
    public void enterPasswordForReseller() {
        iframe.switchToContentFrame();
        WebElement passwordField = waitUtils.waitForElementToBeClickable(ResellerPageLocators.PASSWORD_FIELD);
        passwordField.sendKeys(password);
    }
    
    public void enterRetypePasswordForReseller() {
        iframe.switchToContentFrame();
        WebElement retypePasswordField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.RETYPE_PASSWORD_FIELD);
        retypePasswordField.sendKeys(password);
    }
    
    public void ClickSecurityPinCheckBox()
    {
    	iframe.switchToContentFrame();
    	WebElement securityPinCheckBox = waitUtils.waitForElementToBeClickable(ResellerPageLocators.SECURITY_PIN_CHECKBOX);
    	securityPinCheckBox.click();
    }
    
    public void EnterSecurityPin(String pin)
    {
    	iframe.switchToContentFrame();
    	WebElement securityPinfield = waitUtils.waitForElementToBeClickable(ResellerPageLocators.SECURITY_PIN);
    	securityPinfield.sendKeys(pin);
    }
    
    public void ReEnterSecurityPin(String pin)
    {
    	iframe.switchToContentFrame();
    	WebElement resecurityPinfield = waitUtils.waitForElementToBeClickable(ResellerPageLocators.RETYPE_SECURITY_PIN);
    	resecurityPinfield.sendKeys(pin);
    }
    
    public void enterHelpDeskTelephoneNumberForReseller() {
        String helpDeskTelephoneNumber = CommonMethods.generateRandomMobileNumber();
        iframe.switchToContentFrame();
        WebElement enterTelephoneNumber = waitUtils.waitForElementToBeClickable(ResellerPageLocators.HELP_DESK_TELEPHONE_NUMBER_FIELD);
        enterTelephoneNumber.sendKeys(helpDeskTelephoneNumber);
    }

    public void enterMobileNumberForReseller() {
        String mobileNumber = CommonMethods.generateRandomMobileNumber();
        iframe.switchToContentFrame();
        WebElement enterMobileNumber = waitUtils.waitForElementToBeClickable(CompanyPageLocators.MOBILE_NUMBER_FIELD);
        enterMobileNumber.sendKeys(mobileNumber);
    }

    public void enterCityForReseller() {
        String city = "Gandhinagar";
        iframe.switchToContentFrame();
        WebElement enterCityField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.CITY_FIELD);
        enterCityField.sendKeys(city);
    }

    public void enterZipcodeForReseller() {
        String zipCode = "382016";
        iframe.switchToContentFrame();
        WebElement enterZipCodeField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.ZIP_CODE_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterZipCodeField);
        enterZipCodeField.sendKeys(zipCode);
    }

    public void enterStreet1ForReseller() {
        String street1 = "Prem Bang-low";
        iframe.switchToContentFrame();
        WebElement enterStreet1Field = waitUtils.waitForElementToBeClickable(CompanyPageLocators.STREET1_FIELD);
        enterStreet1Field.sendKeys(street1);
    }

    public void enterStreet2ForReseller() {
        String street2 = "Street Road";
        iframe.switchToContentFrame();
        WebElement enterStreet2Field = waitUtils.waitForElementToBeClickable(ResellerPageLocators.STREET2_FIELD);
        enterStreet2Field.sendKeys(street2);
    }

    public void enterContactPersonForReseller() {
        String contactPerson = "Vimal Khatri";
        iframe.switchToContentFrame();
        WebElement contactPersonField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.CONTACT_PERSON_FIELD);
        contactPersonField.sendKeys(contactPerson);
    }

    public void enterHelpDeskEmailForReseller() {
        String helpDeskEmail = CommonMethods.generateRandomEmail();
        iframe.switchToContentFrame();
        WebElement enterUserNameField = waitUtils.waitForElementToBeClickable(ResellerPageLocators.HELP_DESK_EMAIL_FIELD);
        enterUserNameField.sendKeys(helpDeskEmail);
    }

    public void enterWhatsappContactNumberForReseller() {
        String whatsappMobileNumber = CommonMethods.generateRandomMobileNumber();
        iframe.switchToContentFrame();
        WebElement enterMobileNumber = waitUtils.waitForElementToBeClickable(ResellerPageLocators.WHATSAPP_CONTACT_NUMBER_FIELD);
        enterMobileNumber.sendKeys(whatsappMobileNumber);
    }

    public void enterFaxNumberForReseller() {
        String faxNumber = CommonMethods.generateRandomMobileNumber();
        iframe.switchToContentFrame();
        WebElement enterFaxNumber = waitUtils.waitForElementToBeClickable(CompanyPageLocators.FAX_NUMBER_FIELD);
        enterFaxNumber.sendKeys(faxNumber);
    }

    public void enterWelcomeMessageForReseller() {
        String welcomeMessage = "Welcome to the Testing Team !!!";
        iframe.switchToContentFrame();
        WebElement welcomeMessageField = waitUtils.waitForElementToBeClickable(ResellerPageLocators.WELCOME_MESSAGE_FIELD);
        welcomeMessageField.sendKeys(welcomeMessage);
    }

    public void enterDataStorageForReseller() {
        String dataStorageValue = "90";
        iframe.switchToContentFrame();
        WebElement dataStorageField = waitUtils.waitForElementToBeClickable(ResellerPageLocators.DATA_STORAGE_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", dataStorageField);
        dataStorageField.sendKeys(dataStorageValue);
    }

    public void enterAdminCodeForReseller() {
        String dataStorageValue = "001";
        iframe.switchToContentFrame();
        WebElement adminCodeField = waitUtils.waitForElementToBeClickable(AdminPageLocators.ADMIN_CODE_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", adminCodeField);
        adminCodeField.sendKeys(dataStorageValue);
    }

    public void enterPasswordRecoveryEmailForReseller() {
        String passwordRecoveryEmail = CommonMethods.generateRandomEmail();
        iframe.switchToContentFrame();
        WebElement enterPasswordRecoveryEmail = waitUtils.waitForElementToBeClickable(ResellerPageLocators.PASSWORD_RECOVERY_EMAIL_FIELD);
        enterPasswordRecoveryEmail.sendKeys(passwordRecoveryEmail);
    }

    public void addButtonInsideRuleOfReseller(String name) {
        iframe.switchToRuleContentFrame();
        String dynamicXpath = String.format(CompanyPageLocators.ADD_BUTTON_INSIDE_COMPANY, name);
        WebElement addButtonInsideRuleOfCompany = waitUtils.waitForElementToBeClickable(By.xpath(dynamicXpath));
        addButtonInsideRuleOfCompany.click();
    }

    public void enterDescriptionOfRuleTab() {
        String city = "TestRule1";
        iframe.switchToPopUpDialogFrame();
        WebElement enterDescriptionField = waitUtils.waitForElementToBeClickable(ResellerPageLocators.DESCRIPTION_FIELD);
        enterDescriptionField.sendKeys(city);
    }

    public void enterSpeedConsiderationMomentOfRuleTab() {
        String speedConsiderationMoment = "5";
        iframe.switchToPopUpDialogFrame();
        WebElement speedConsiderationMomentField = waitUtils.waitForElementToBeClickable(ResellerPageLocators.SPEED_CONSIDERATION_MOMENT_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", speedConsiderationMomentField);
        speedConsiderationMomentField.sendKeys(speedConsiderationMoment);
    }

    public void enterMaxSpeedValidatorOfRuleTab() {
        String maxSpeedValidator = "200";
        iframe.switchToPopUpDialogFrame();
        WebElement maxSpeedValidatorField = waitUtils.waitForElementToBeClickable(ResellerPageLocators.MAX_SPEED_VALIDATOR_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", maxSpeedValidatorField);
        maxSpeedValidatorField.sendKeys(maxSpeedValidator);
    }

    public void selectTimeZone(String timezoneName) {
        iframe.switchToContentFrame();
        By timezoneDropdownLocator = ResellerPageLocators.TIMEZONE_DROPDOWN;
        By timezoneOptionLocator = By.xpath(String.format(ResellerPageLocators.TIMEZONE_DROPDOWN_OPTION, timezoneName));
        commonMethods.selectFromDropdown(timezoneDropdownLocator, timezoneOptionLocator,true);
    }

    public void selectAlertOnDataAccessTabOfReseller(String Alert) {
        iframe.switchToContentFrame();
        By selectAlertField = ResellerPageLocators.ALERT_FIELD;
        By selectAllAlert = By.xpath(String.format(ResellerPageLocators.ALL_ALERT_OPTION, Alert));
        commonMethods.selectFromDropdown(selectAlertField, selectAllAlert,true);
        WebElement screenElement = waitUtils.waitForElementToBeClickable(ResellerPageLocators.SCREEN_ELEMENT);
        screenElement.click();
    }

    public void selectTimeZoneRightsOnDataAccessTabOfReseller(String timeZone) {
        iframe.switchToContentFrame();
        By selectTimeZoneRightsField = ResellerPageLocators.TIMEZONE_RIGHTS_FIELD;
        By selectTimeZoneRightsOption = By.xpath(String.format(ResellerPageLocators.TIMEZON_RIGHTS_OPTION, timeZone));
        commonMethods.selectFromDropdown(selectTimeZoneRightsField, selectTimeZoneRightsOption,true);
        WebElement screenElement = waitUtils.waitForElementToBeClickable(ResellerPageLocators.SCREEN_ELEMENT);
        screenElement.click();
    }

    public void selectSimProviderOnDataAccessTabOfReseller(String providerName) {
        iframe.switchToContentFrame();
        By selectSimProviderField = ResellerPageLocators.SIM_PROVIDER_FIELD;
        By selectSimProviderOption = By.xpath(String.format(ResellerPageLocators.SIM_PROVIDER_OPTION, providerName));
        commonMethods.selectFromDropdown(selectSimProviderField, selectSimProviderOption,true);
        WebElement screenElement = waitUtils.waitForElementToBeClickable(ResellerPageLocators.SCREEN_ELEMENT);
        screenElement.click();
    }

    public void enterMapProjectIdOnMapOfReseller(String mapProjectId) {
        iframe.switchToCompanyMapContentFrame();
        WebElement enterMapProjectId = waitUtils.waitForElementToBeClickable(ResellerPageLocators.MAP_PROJECT_ID_FIELD);
        enterMapProjectId.sendKeys(mapProjectId);
    }

    public void addButtonInsidePaymentGatewayOfReseller(String name) {
        iframe.switchToPaymentGatewayFrame();
        String dynamicXpath = String.format(CompanyPageLocators.ADD_BUTTON_INSIDE_COMPANY, name);
        WebElement addButtonInsidePaymentGatewayOfReseller = waitUtils.waitForElementToBeClickable(By.xpath(dynamicXpath));
        addButtonInsidePaymentGatewayOfReseller.click();
    }

    public void selectGatewayOnPaymentGatewayTabOfReseller(String gatewayName) {
        iframe.switchToPopUpDialogFrame();
        By gatewayField = ResellerPageLocators.GATEWAY_NAME_DROPDOWN;
        By datewayFieldOptions = By.xpath(String.format(ResellerPageLocators.GATEWAY_NAME_FIELD_DROPDOWN_OPTIONS, gatewayName));
        commonMethods.selectFromDropdown(gatewayField, datewayFieldOptions,true);
    }

    public void enterPayementGatewayNameForReseller() {
        iframe.switchToPopUpDialogFrame();
        String gatewayName = "PayPal REST API";
        WebElement gatewayNameField = waitUtils.waitForElementToBeClickable(ResellerPageLocators.GATEWAY_NAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", gatewayNameField);
        gatewayNameField.sendKeys(gatewayName);
    }

    public void enterPayementGatewayClientIdForReseller() {
        iframe.switchToPopUpDialogFrame();
        String clientId = "AXL1rSx5OZkfj2vTfLdc5R9n5DQXhd7rZnQz0P-KYs0Oly7y2kmQy5q5z6fMc0wVg6tBzGoOxUpzEjK3l7kYnVVVVyL_FGMeQ";
        WebElement clientIdField = waitUtils.waitForElementToBeClickable(ResellerPageLocators.CLIENT_ID_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", clientIdField);
        clientIdField.sendKeys(clientId);
    }

    public void enterPayementGatewaySecretKeyForReseller() {
        iframe.switchToPopUpDialogFrame();
        String secretKey = "EECrNxWoTbQXYmFe1oZPjcivZP2gJDe-K4g8o8CPOzA4WlnF1pWTm-V9ehF32uEFh5IW5I3aT8W3gUwq4Rpa4tZOrF8V1a0Zow";
        WebElement secretKeyField = waitUtils.waitForElementToBeClickable(ResellerPageLocators.SECRET_KEY_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", secretKeyField);
        secretKeyField.sendKeys(secretKey);
    }

    public void addButtonInsideRenameLabelOfReseller(String name) {
        iframe.switchToRenameLabelFrame();
        String dynamicXpath = String.format(CompanyPageLocators.ADD_BUTTON_INSIDE_COMPANY, name);
        WebElement addButtonInsideRenameLabelOfReseller = waitUtils.waitForElementToBeClickable(By.xpath(dynamicXpath));
        addButtonInsideRenameLabelOfReseller.click();
    }

    public void enterRenameLabelActualNameForReseller() {
        iframe.switchToRenameLabelFrame();
        String actualName = "Testing Purpose";
        WebElement actualNameField = waitUtils.waitForElementToBeClickable(ResellerPageLocators.ACTUAL_NAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", actualNameField);
        actualNameField.sendKeys(actualName);
    }

    public void enterRenameLabelNewNameForReseller() {
        iframe.switchToRenameLabelFrame();
        String newName = "Testing Purpose";
        WebElement newNameField = waitUtils.waitForElementToBeClickable(ResellerPageLocators.NEW_NAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", newNameField);
        newNameField.sendKeys(newName);
    }

    public void selectIvrGatewayOnIvrTabOfReseller(String ivrGatewayName) {
        iframe.switchToContentFrame();
        By ivrGatewayField = ResellerPageLocators.IVR_GATEWAY_DROPDOWN;
        By ivrGatewayDropdownOptions = By.xpath(String.format(ResellerPageLocators.IVR_GATEWAY_DROPDOWN_OPTIONS, ivrGatewayName));
        commonMethods.selectFromDropdown(ivrGatewayField, ivrGatewayDropdownOptions,true);
        WebElement screenElementOfIvr = waitUtils.waitForElementToBeClickable(ResellerPageLocators.SCREEN_ELEMENT_IVR);
        screenElementOfIvr.click();
    }

    public void enterIvrAccountSidForReseller() {
        iframe.switchToContentFrame();
        String accountSId = "Testing Purpose";
        WebElement accountSIdField = waitUtils.waitForElementToBeClickable(ResellerPageLocators.ACCOUNT_SID_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", accountSIdField);
        accountSIdField.sendKeys(accountSId);
    }

    public void enterIvrAccountTokenForReseller() {
        iframe.switchToContentFrame();
        String accountToken = "EECrNxWoTbQXYmFe1oZPjcivZP2gJDe-K4g8o8CPOzA4WlnF1pWTm";
        WebElement accountTokenField = waitUtils.waitForElementToBeClickable(ResellerPageLocators.ACCOUNT_TOKEN_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", accountTokenField);
        accountTokenField.sendKeys(accountToken);
    }

    public void enterIvrFromNumberForReseller() {
        iframe.switchToContentFrame();
        String fromNumber = "9181937981821";
        WebElement fromNumberField = waitUtils.waitForElementToBeClickable(ResellerPageLocators.FROM_NUMBER_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", fromNumberField);
        fromNumberField.sendKeys(fromNumber);
    }

    public void addButtonInsideScoialMediaApiOfReseller(String name) {
        iframe.switchToSocialMediaApiFrame();
        String dynamicXpath = String.format(CompanyPageLocators.ADD_BUTTON_INSIDE_COMPANY, name);
        WebElement addButtonInsideRenameLabelOfReseller = waitUtils.waitForElementToBeClickable(By.xpath(dynamicXpath));
        addButtonInsideRenameLabelOfReseller.click();
    }

    public void enterSocialMediaApiBotHttpTokenForReseller() {
        iframe.switchToPopUpDialogFrame();
        String botHttpToken = "EECrNxWoTbQXYmFe1oZPjcivZP2gJDe-EECrNxWoTbQXYmFe1oZPjcivZP2gJDe";
        WebElement botHttpTokenField = waitUtils.waitForElementToBeClickable(ResellerPageLocators.BOT_HTTP_TOKEN_FIELD);
        botHttpTokenField.sendKeys(botHttpToken);
    }

    public void isConsiderAnnouncementCheck() {
        iframe.switchToPopUpDialogFrame();
        WebElement considerAnnouncementCheck = driver.findElement(By.xpath(ResellerPageLocators.CONSIDER_ANNOUNCEMENT_CHECKBOX));
        CommonMethods.checkCheckbox(considerAnnouncementCheck);
    }

    public void saveButtonOfResellerPage() {
        iframe.switchToBottomFrame();
        WebElement saveButton = waitUtils.waitForElementToBeClickable(CompanyPageLocators.SAVE_BUTTON);
        saveButton.click();
    }

    public void clickOnCreatedReseller(){
        iframe.switchToContentFrame();
        String formattedXpath = String.format(CompanyPageLocators.TABLE_OF_SHORT_NAME, this.shortName);
        commonMethods.doubleClick(By.xpath(formattedXpath));
    }

    public void deleteButtonReseller() {
        iframe.switchToBottomFrame();
        WebElement deleteButton = waitUtils.waitForElementToBeClickable(CompanyPageLocators.DELETE_BUTTON);
        deleteButton.click();
        iframe.switchToDivFrame();
        WebElement deleteOkButton = waitUtils.waitForElementToBeClickable(ResellerPageLocators.DELETE_OK_BUTTON);
        deleteOkButton.click();
    }

    public void editResellerShortName() {
        this.editShortName = CommonMethods.generateRandomFirstName();
        iframe.switchToContentFrame();
        WebElement enterShortNameField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.SHORT_NAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterShortNameField);
        enterShortNameField.sendKeys(this.editShortName);
    }

    public void editResellerUserName() {
        this.editUserName = CommonMethods.generateRandomEmail();
        iframe.switchToContentFrame();
        WebElement enterUserNameField = waitUtils.waitForElementToBeClickable(CompanyPageLocators.USERNAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterUserNameField);
        enterUserNameField.sendKeys(this.editUserName);
    }

    public void editResellerMobileNumber() {
        this.editMobileNumber = CommonMethods.generateRandomMobileNumber();
        iframe.switchToContentFrame();
        WebElement enterMobileNumber = waitUtils.waitForElementToBeClickable(CompanyPageLocators.MOBILE_NUMBER_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterMobileNumber);
        enterMobileNumber.sendKeys(this.editMobileNumber);
    }

    public void editResellerTelephoneNumber() {
        String editTelephoneNumber = CommonMethods.generateRandomMobileNumber();
        iframe.switchToContentFrame();
        WebElement enterTelephoneNumber = waitUtils.waitForElementToBeClickable(CompanyPageLocators.TELEPHONE_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterTelephoneNumber);
        enterTelephoneNumber.sendKeys(editTelephoneNumber);
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

    public void clickOnEditedReseller() {
        iframe.switchToContentFrame();
        String formattedXpath = String.format(CompanyPageLocators.TABLE_OF_SHORT_NAME, this.editShortName);
        commonMethods.doubleClick(By.xpath(formattedXpath));
    }

    public void clickOnEditRuleOfReseller() {
        iframe.switchToRuleContentFrame();
        WebElement editRule = waitUtils.waitForElementToBeClickable(ResellerPageLocators.EDIT_RULE_BUTTON);
        editRule.click();
    }

    public void editRuleName() {
        String editRuleName = "EditRuleTesting1";
        iframe.switchToPopUpDialogFrame();
        WebElement enterRuleName = waitUtils.waitForElementToBeClickable(CompanyPageLocators.RULE_NAME_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterRuleName);
        enterRuleName.sendKeys(editRuleName);
    }

    public void editDescriptionOfRuleTab() {
        String editRuleDescription = "EditDescriptionTestRule1";
        iframe.switchToPopUpDialogFrame();
        WebElement enterDescriptionField = waitUtils.waitForElementToBeClickable(ResellerPageLocators.DESCRIPTION_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", enterDescriptionField);
        enterDescriptionField.sendKeys(editRuleDescription);
    }

    public void editMapProjectIdOnMapOfReseller(String editMapProjectId) {
        iframe.switchToCompanyMapContentFrame();
        WebElement editedMapProjectId = waitUtils.waitForElementToBeClickable(ResellerPageLocators.MAP_PROJECT_ID_FIELD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", editedMapProjectId);
        editedMapProjectId.sendKeys(editMapProjectId);
    }

    public void clickOnEditPaymentGatewayOfReseller() {
        iframe.switchToPaymentGatewayFrame();
        WebElement templateProperties = waitUtils.waitForElementToBeClickable(ResellerPageLocators.EDIT_PAYMENT_GATEWAY_BUTTON);
        templateProperties.click();
    }

    public void searchTheResellerUser() {
        iframe.switchToBottomFrame();
        WebElement searchField = waitUtils.waitForElementToBeClickable(AdminPageLocators.SEARCH_FIELD);
        searchField.sendKeys(this.shortName);
        searchField.sendKeys(Keys.ENTER);
    }

    public void searchTheEditedResellerUser() {
        iframe.switchToBottomFrame();
        WebElement searchField = waitUtils.waitForElementToBeClickable(AdminPageLocators.SEARCH_FIELD);
        searchField.sendKeys(this.editUserName);
        searchField.sendKeys(Keys.ENTER);
    }
    
    public void clickOnOkButtonOnDeletePopUp()
    {
    	iframe.switchToDivFrame();
    	WebElement okbutton = waitUtils.waitForElementToBeClickable(ResellerPageLocators.OKBUTTON_ON_DELETEPOPUP);
    	okbutton.click();
    }
    
    public void enterPinOnPINFieldOnDeletePopup(String pin)
    {
    	
        WebElement enterPin = waitUtils.waitForElementToBeClickable(ResellerPageLocators.OKBUTTON_ON_DELETEPOPUP);
        enterPin.sendKeys(pin);
    }
    
    public void clickOnEnterButtonOnDeletePopUp()
    {
    	
    	WebElement clickOnEnterButton = waitUtils.waitForElementToBeClickable(ResellerPageLocators.ENTERBUTTON_ON_DELETEPOPUP);
    	clickOnEnterButton.click();
    }
    
}
