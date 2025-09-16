package web.pages;

import commonMethods.CompanyPageCommonMethods;
import commonMethods.EmployeePageCommonMethods;
import commonMethods.ResellerPageCommonMethods;
import org.openqa.selenium.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ResellerPage {
    private static final Logger logger = LogManager.getLogger(ResellerPage.class);
    private final WebDriver driver;
    private final ResellerPageCommonMethods resellerPageCommonMethods;
    private final EmployeePageCommonMethods employeePageCommonMethods;
    private final CompanyPageCommonMethods companyPage;


    public ResellerPage(WebDriver driver) {
        this.driver = driver;
        this.resellerPageCommonMethods = new ResellerPageCommonMethods(driver);
        this.companyPage = new CompanyPageCommonMethods(driver);
        this.employeePageCommonMethods = new EmployeePageCommonMethods(driver);
    }

    public ResellerPage createResellerUser() {
        logger.info("Creating reseller user");
        resellerPageCommonMethods.addReseller();
        logger.info("Reseller user creation initiated");
        return this;
    }

    public ResellerPage addResellerDetails() {
        logger.info("Adding reseller details");
        resellerPageCommonMethods.selectCountryForReseller("India");
        resellerPageCommonMethods.selectStateForReseller("Gujarat");
        resellerPageCommonMethods.enterShortNameForReseller();
        resellerPageCommonMethods.enterUserNameForReseller();
        resellerPageCommonMethods.enterConfirmUserNameForReseller();
        resellerPageCommonMethods.enterPasswordForReseller();
        resellerPageCommonMethods.enterRetypePasswordForReseller();
        resellerPageCommonMethods.enterPasswordRecoveryEmailForReseller();
//        resellerPageCommonMethods.ClickSecurityPinCheckBox();
//        resellerPageCommonMethods.EnterSecurityPin("123123");
//        resellerPageCommonMethods.ReEnterSecurityPin("123123");
        resellerPageCommonMethods.enterCityForReseller();
        resellerPageCommonMethods.enterZipcodeForReseller();
        resellerPageCommonMethods.enterStreet1ForReseller();
        resellerPageCommonMethods.enterStreet2ForReseller();
        resellerPageCommonMethods.enterContactPersonForReseller();
        resellerPageCommonMethods.enterHelpDeskTelephoneNumberForReseller();
        resellerPageCommonMethods.enterHelpDeskEmailForReseller();
        resellerPageCommonMethods.enterMobileNumberForReseller();
        resellerPageCommonMethods.enterWhatsappContactNumberForReseller();
        resellerPageCommonMethods.enterFaxNumberForReseller();
        resellerPageCommonMethods.enterWelcomeMessageForReseller();
        resellerPageCommonMethods.enterDataStorageForReseller();
        logger.info("Reseller details added");
        return this;
    }

    public ResellerPage addRuleOfReseller() {
        logger.info("Adding rule for reseller");
        companyPage.selectTab("Rule");
        resellerPageCommonMethods.addButtonInsideRuleOfReseller("__rule_name");
        companyPage.enterRuleName();
        resellerPageCommonMethods.enterDescriptionOfRuleTab();
        companyPage.validFromDate();
        resellerPageCommonMethods.enterSpeedConsiderationMomentOfRuleTab();
        resellerPageCommonMethods.enterMaxSpeedValidatorOfRuleTab();
        companyPage.saveButtonOfDialogBox();
        logger.info("Rule added for reseller");
        return this;
    }

    public ResellerPage addUserSettingOfReseller() {
        logger.info("Configuring user settings for reseller");
        companyPage.selectTab("Settings");
        resellerPageCommonMethods.selectTimeZone("UTC+01:00 - Africa/Algiers");
        resellerPageCommonMethods.selectTimeZone("UTC+05:30 - Asia/Kolkata");
        companyPage.selectDateFormat("MM/dd/yyyy");
        companyPage.selectDateFormat("dd-MM-yyyy");
        companyPage.selectTimeFormat("24 - Hour");
        companyPage.selectTimeFormat("12 - Hour");
        companyPage.selectUserStatus();
        companyPage.selectShowDefaultFilterOption();
        logger.info("User settings configured for reseller");
        return this;
    }

    public ResellerPage addDataAccessOfReseller() {
        logger.info("Configuring data access for reseller");
        companyPage.selectTab("ContentRights");
        resellerPageCommonMethods.selectAlertOnDataAccessTabOfReseller("All");
        resellerPageCommonMethods.selectAlertOnDataAccessTabOfReseller("Battery");
        resellerPageCommonMethods.selectTimeZoneRightsOnDataAccessTabOfReseller("UTC+10:00 - Australia/Hobart");
        resellerPageCommonMethods.selectSimProviderOnDataAccessTabOfReseller("All");
        resellerPageCommonMethods.selectSimProviderOnDataAccessTabOfReseller("Vodafone");
        logger.info("Data access configured for reseller");
        return this;
    }

    public ResellerPage addMapOfReseller() {
        logger.info("Configuring map for reseller");
        companyPage.selectTab("Map");
        companyPage.addButtonInsideMapOfCompany("__geomap_id");
        companyPage.selectMapOnMapTabOfCompany("GOOGLE");
        companyPage.enterWebMapKey("12345678-abcd-efgh-ijkl-1234567890ab");
        companyPage.enterMobileMapKey("98765432-zyxw-vuts-qrst-0987654321cd");
        resellerPageCommonMethods.enterMapProjectIdOnMapOfReseller("0987654321cd-98765432-ijkl");
        companyPage.checkDefaultMap();
        logger.info("Map configured for reseller");
        return this;
    }

    public ResellerPage addEmailOfReseller() {
        logger.info("Configuring email settings for reseller");
        companyPage.selectTab("Email");
        logger.info("Email settings configured for reseller");
        return this;
    }

    public ResellerPage addSmsOfReseller() {
        logger.info("Configuring SMS settings for reseller");
        companyPage.selectTab("SMS");
        logger.info("SMS settings configured for reseller");
        return this;
    }

    public ResellerPage addPaymentGatewayOfReseller() {
        logger.info("Configuring payment gateway for reseller");
        companyPage.selectTab("PaymentGateway");
        resellerPageCommonMethods.addButtonInsidePaymentGatewayOfReseller("__gateway_name");
        resellerPageCommonMethods.selectGatewayOnPaymentGatewayTabOfReseller("PayPal");
        resellerPageCommonMethods.enterPayementGatewayNameForReseller();
        resellerPageCommonMethods.enterPayementGatewayClientIdForReseller();
        resellerPageCommonMethods.enterPayementGatewaySecretKeyForReseller();
        companyPage.saveButtonOfDialogBox();
        logger.info("Payment gateway configured for reseller");
        return this;
    }

    public ResellerPage addRenameLabelOfReseller() {
        logger.info("Configuring rename label for reseller");
        companyPage.selectTab("RenameLabel");
        resellerPageCommonMethods.addButtonInsideRenameLabelOfReseller("__actualproperty_name");
        resellerPageCommonMethods.enterRenameLabelActualNameForReseller();
        resellerPageCommonMethods.enterRenameLabelNewNameForReseller();
        logger.info("Rename label configured for reseller");
        return this;
    }

    public ResellerPage addIVROfReseller() {
        logger.info("Configuring IVR settings for reseller");
        companyPage.selectTab("ivrcall");
        resellerPageCommonMethods.selectIvrGatewayOnIvrTabOfReseller("Custom");
        resellerPageCommonMethods.enterIvrAccountSidForReseller();
        resellerPageCommonMethods.enterIvrAccountTokenForReseller();
        resellerPageCommonMethods.enterIvrFromNumberForReseller();
        logger.info("IVR settings configured for reseller");
        return this;
    }

    public ResellerPage addChatbotOfReseller() {
        logger.info("Configuring chatbot settings for reseller");
        companyPage.selectTab("ChatBot");
        logger.info("Chatbot settings configured for reseller");
        return this;
    }

    public ResellerPage addSocialMediaApiOfReseller() {
        logger.info("Configuring social media API settings for reseller");
        companyPage.selectTab("SocialMediaAPI");
        resellerPageCommonMethods.addButtonInsideScoialMediaApiOfReseller("__social_gateway");
        resellerPageCommonMethods.enterSocialMediaApiBotHttpTokenForReseller();
        resellerPageCommonMethods.isConsiderAnnouncementCheck();
        companyPage.saveButtonOfDialogBox();
        logger.info("Social media API settings configured for reseller");
        return this;
    }

    public ResellerPage addDocumentOfReseller() {
        logger.info("Adding document for reseller");
        companyPage.selectTab("Document");
        logger.info("Document added for reseller");
        return this;
    }

    public ResellerPage addAuthenticationOfReseller() {
        logger.info("Configuring authentication settings for reseller");
        companyPage.selectTab("Authentication");
        logger.info("Authentication settings configured for reseller");
        return this;
    }

    public ResellerPage addSingleSignOnOfReseller() {
        logger.info("Configuring single sign-on settings for reseller");
        companyPage.selectTab("SSO");
        logger.info("Single sign-on settings configured for reseller");
        return this;
    }

    public void verifyTheCreatedAndDeleteReseller() {
        logger.info("Verifying and deleting the created reseller");
        resellerPageCommonMethods.searchTheResellerUser();
        resellerPageCommonMethods.clickOnCreatedReseller();
        resellerPageCommonMethods.deleteButtonReseller();
//        resellerPageCommonMethods.clickOnOkButtonOnDeletePopUp();
//        resellerPageCommonMethods.enterPinOnPINFieldOnDeletePopup("123123");
//        resellerPageCommonMethods.clickOnEnterButtonOnDeletePopUp();
        resellerPageCommonMethods.searchTheResellerUser();
        employeePageCommonMethods.assertNoRecordsFoundLabelDisplayed();
        logger.info("Created reseller verified and deleted");
    }

    public ResellerPage fillResellerDetailsWithValidation() {
        logger.info("Filling reseller details with validation");
        resellerPageCommonMethods.selectCountryForReseller("India");
        resellerPageCommonMethods.selectStateForReseller("Gujarat");
        resellerPageCommonMethods.saveButtonOfResellerPage();
        companyPage.verifyHeaderOfValidationPopup("Short Name", "Header text does not match!");
        companyPage.verifyContentOfValidationPopUp("Field can not be blank", "Content text does not match!");
        companyPage.closeButtonOfPopUp();
        resellerPageCommonMethods.enterShortNameForReseller();
        resellerPageCommonMethods.saveButtonOfResellerPage();
        companyPage.verifyHeaderOfValidationPopup("User Name", "Header text does not match!");
        companyPage.verifyContentOfValidationPopUp("Field can not be blank", "Content text does not match!");
        companyPage.closeButtonOfPopUp();
        resellerPageCommonMethods.enterUserNameForReseller();
        resellerPageCommonMethods.saveButtonOfResellerPage();
        companyPage.verifyHeaderOfValidationPopup("Confirm Username", "Header text does not match!");
        companyPage.verifyContentOfValidationPopUp("Field can not be blank", "Content text does not match!");
        companyPage.closeButtonOfPopUp();
        resellerPageCommonMethods.enterConfirmUserNameForReseller();
        resellerPageCommonMethods.saveButtonOfResellerPage();
        companyPage.verifyHeaderOfValidationPopup("Password", "Header text does not match!");
        companyPage.verifyContentOfValidationPopUp("Field can not be blank", "Content text does not match!");
        companyPage.closeButtonOfPopUp();
        resellerPageCommonMethods.enterPasswordForReseller();
        resellerPageCommonMethods.saveButtonOfResellerPage();
        companyPage.verifyHeaderOfValidationPopup("Retype Password", "Header text does not match!");
        companyPage.verifyContentOfValidationPopUp("Field can not be blank", "Content text does not match!");
        companyPage.closeButtonOfPopUp();
        resellerPageCommonMethods.enterRetypePasswordForReseller();
        resellerPageCommonMethods.enterPasswordRecoveryEmailForReseller();
        resellerPageCommonMethods.enterCityForReseller();
        resellerPageCommonMethods.enterZipcodeForReseller();
        resellerPageCommonMethods.enterStreet1ForReseller();
        resellerPageCommonMethods.enterStreet2ForReseller();
        resellerPageCommonMethods.enterContactPersonForReseller();
        resellerPageCommonMethods.enterHelpDeskTelephoneNumberForReseller();
        resellerPageCommonMethods.enterHelpDeskEmailForReseller();
        resellerPageCommonMethods.enterMobileNumberForReseller();
        resellerPageCommonMethods.enterWhatsappContactNumberForReseller();
        resellerPageCommonMethods.enterFaxNumberForReseller();
        resellerPageCommonMethods.enterWelcomeMessageForReseller();
        resellerPageCommonMethods.enterDataStorageForReseller();
        logger.info("Reseller details filled and validated");
        return this;
    }

    public ResellerPage fillResellerRuleDetailsWithValidation() {
        logger.info("Filling reseller rule details with validation");
        companyPage.selectTab("Rule");
        resellerPageCommonMethods.addButtonInsideRuleOfReseller("__rule_name");
        companyPage.saveButtonOfDialogBox();
        companyPage.verifyHeaderOfValidationPopup("Rule Name", "Header text does not match!");
        companyPage.verifyContentOfValidationPopUp("Field can not be blank", "Content text does not match!");
        companyPage.closeButtonOfPopUp();
        companyPage.enterRuleName();
        resellerPageCommonMethods.enterDescriptionOfRuleTab();
        companyPage.saveButtonOfDialogBox();
        companyPage.verifyHeaderOfValidationPopup("Valid From", "Header text does not match!");
        companyPage.verifyContentOfValidationPopUp("Field can not be blank", "Content text does not match!");
        companyPage.closeButtonOfPopUp();
        companyPage.validFromDate();
        resellerPageCommonMethods.enterSpeedConsiderationMomentOfRuleTab();
        resellerPageCommonMethods.enterMaxSpeedValidatorOfRuleTab();
        companyPage.saveButtonOfDialogBox();
        logger.info("Reseller rule details filled and validated");
        return this;
    }

    public ResellerPage fillResellerPaymentGatewayDetailsWithValidation() {
        logger.info("Filling reseller payment gateway details with validation");
        companyPage.selectTab("PaymentGateway");
        resellerPageCommonMethods.addButtonInsidePaymentGatewayOfReseller("__gateway_name");
        companyPage.saveButtonOfDialogBox();
        companyPage.verifyHeaderOfValidationPopup("Gateway", "Header text does not match!");
        companyPage.verifyContentOfValidationPopUp("Please select value from dropdown", "Content text does not match!");
        companyPage.closeButtonOfPopUp();
        resellerPageCommonMethods.selectGatewayOnPaymentGatewayTabOfReseller("PayPal");
        companyPage.saveButtonOfDialogBox();
        companyPage.verifyHeaderOfValidationPopup("Gateway Name", "Header text does not match!");
        companyPage.verifyContentOfValidationPopUp("Field can not be blank", "Content text does not match!");
        companyPage.closeButtonOfPopUp();
        resellerPageCommonMethods.enterPayementGatewayNameForReseller();
        companyPage.saveButtonOfDialogBox();
        companyPage.verifyHeaderOfValidationPopup("Client ID", "Header text does not match!");
        companyPage.verifyContentOfValidationPopUp("Field can not be blank", "Content text does not match!");
        companyPage.closeButtonOfPopUp();
        resellerPageCommonMethods.enterPayementGatewayClientIdForReseller();
        companyPage.saveButtonOfDialogBox();
        companyPage.verifyHeaderOfValidationPopup("Secret key", "Header text does not match!");
        companyPage.verifyContentOfValidationPopUp("Field can not be blank", "Content text does not match!");
        companyPage.closeButtonOfPopUp();
        resellerPageCommonMethods.enterPayementGatewaySecretKeyForReseller();
        companyPage.saveButtonOfDialogBox();
        logger.info("Reseller payment gateway details filled and validated");
        return this;
    }

    public ResellerPage editResellerDetails() {
        logger.info("Editing reseller details");
        resellerPageCommonMethods.editResellerShortName();
        resellerPageCommonMethods.editResellerUserName();
        resellerPageCommonMethods.editResellerTelephoneNumber();
        resellerPageCommonMethods.editResellerMobileNumber();
        resellerPageCommonMethods.selectCountryForReseller("India");
        resellerPageCommonMethods.selectStateForReseller("Gujarat");
        logger.info("Reseller details edited");
        return this;
    }

    public ResellerPage verifyThatResellerDetailsAreEdited() {
        logger.info("Verifying that reseller details are edited");
        resellerPageCommonMethods.verifyThatUserNameEdited();
        resellerPageCommonMethods.verifyThatMobileNumberEdited();
        logger.info("Reseller details verified as edited");
        return this;
    }

    public ResellerPage editRuleDetailsOfReseller() {
        logger.info("Editing rule details of reseller");
        companyPage.selectTab("Rule");
        resellerPageCommonMethods.clickOnEditRuleOfReseller();
        resellerPageCommonMethods.editRuleName();
        resellerPageCommonMethods.editDescriptionOfRuleTab();
        resellerPageCommonMethods.enterSpeedConsiderationMomentOfRuleTab();
        resellerPageCommonMethods.enterMaxSpeedValidatorOfRuleTab();
        companyPage.saveButtonOfDialogBox();
        logger.info("Rule details of reseller edited");
        return this;
    }

    public ResellerPage editUserSettingOfReseller() {
        logger.info("Editing user settings of reseller");
        companyPage.selectTab("Settings");
        resellerPageCommonMethods.selectTimeZone("UTC+01:00 - Africa/Algiers");
        companyPage.selectDateFormat("MM/dd/yyyy");
        companyPage.selectTimeFormat("24 - Hour");
        companyPage.selectUserStatus();
        companyPage.selectShowDefaultFilterOption();
        logger.info("User settings of reseller edited");
        return this;
    }

    public ResellerPage editDataAccessOfReseller() {
        logger.info("Editing data access settings of reseller");
        companyPage.selectTab("ContentRights");
        resellerPageCommonMethods.selectAlertOnDataAccessTabOfReseller("Battery");
        resellerPageCommonMethods.selectTimeZoneRightsOnDataAccessTabOfReseller("UTC+00:00 - Africa/Bissau");
        resellerPageCommonMethods.selectSimProviderOnDataAccessTabOfReseller("Vodafone");
        resellerPageCommonMethods.selectSimProviderOnDataAccessTabOfReseller("Reliance");
        logger.info("Data access settings of reseller edited");
        return this;
    }

    public ResellerPage editMapOfReseller() {
        logger.info("Editing map settings of reseller");
        companyPage.selectTab("Map");
        companyPage.editWebMapKey("efgh-abcd-efgh-efgh-0987654321cd");
        companyPage.editMobileMapKey("qrst-zyxw-vuts-0987654321cd-0987654321cd");
        resellerPageCommonMethods.editMapProjectIdOnMapOfReseller("0987654321cd-98765432-abcd");
        logger.info("Map settings of reseller edited");
        return this;
    }

    public ResellerPage editPaymentGatewayOfReseller() {
        logger.info("Editing payment gateway settings of reseller");
        companyPage.selectTab("PaymentGateway");
        resellerPageCommonMethods.clickOnEditPaymentGatewayOfReseller();
        resellerPageCommonMethods.enterPayementGatewayNameForReseller();
        resellerPageCommonMethods.enterPayementGatewayClientIdForReseller();
        resellerPageCommonMethods.enterPayementGatewaySecretKeyForReseller();
        companyPage.saveButtonOfDialogBox();
        logger.info("Payment gateway settings of reseller edited");
        return this;
    }

    public ResellerPage editRenameLabelOfReseller() {
        logger.info("Editing rename label settings of reseller");
        companyPage.selectTab("RenameLabel");
        resellerPageCommonMethods.enterRenameLabelActualNameForReseller();
        resellerPageCommonMethods.enterRenameLabelNewNameForReseller();
        logger.info("Rename label settings of reseller edited");
        return this;
    }

    public ResellerPage editIVROfReseller() {
        logger.info("Editing IVR settings of reseller");
        companyPage.selectTab("ivrcall");
        resellerPageCommonMethods.enterIvrAccountSidForReseller();
        resellerPageCommonMethods.enterIvrAccountTokenForReseller();
        resellerPageCommonMethods.enterIvrFromNumberForReseller();
        logger.info("IVR settings of reseller edited");
        return this;
    }

    public ResellerPage saveButtonOfReseller() {
        logger.info("Saving reseller details");
        resellerPageCommonMethods.saveButtonOfResellerPage();
        logger.info("Reseller details saved");
        return this;
    }

    public ResellerPage searchResellerUser() {
        logger.info("Searching for reseller user");
        resellerPageCommonMethods.searchTheResellerUser();
        logger.info("Search for reseller user completed");
        return this;
    }

    public ResellerPage searchEditedResellerUser() {
        logger.info("Searching for edited reseller user");
        resellerPageCommonMethods.searchTheEditedResellerUser();
        logger.info("Search for edited reseller user completed");
        return this;
    }

    public ResellerPage clickOnCreatedResellerUser() {
        logger.info("Clicking on created reseller user");
        resellerPageCommonMethods.clickOnCreatedReseller();
        logger.info("Clicked on created reseller user");
        return this;
    }

    public ResellerPage clickOnEditedResellerUser() {
        logger.info("Clicking on edited reseller user");
        resellerPageCommonMethods.clickOnEditedReseller();
        logger.info("Clicked on edited reseller user");
        return this;
    }

    public ResellerPage deleteResellerUser() {
        logger.info("Deleting reseller user");
        resellerPageCommonMethods.deleteButtonReseller();
        logger.info("Reseller user deleted");
        return this;
    }

    public void verifyResellerUserIsDeleted() {
        logger.info("Verifying that reseller user is deleted");
        employeePageCommonMethods.assertNoRecordsFoundLabelDisplayed();
        logger.info("Reseller user verified as deleted");
    }
}