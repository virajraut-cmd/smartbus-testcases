package web.locators;

import org.openqa.selenium.By;

public class ResellerPageLocators {
   
	 public static final By RESELLER_DETAILS_COUNTRY_DROPDOWN = By.xpath("//div[@id='country_chosen']");
	    public static final String RESELLER_DETAILS_COUNTRY_DROPDOWN_OPTION = "//div[@id='country_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
	    public static final By RESELLER_DETAILS_STATE_DROPDOWN = By.xpath("//div[@id='state_chosen']");
	    public static final String RESELLER_DETAILS_STATE_DROPDOWN_OPTION = "//div[@id='state_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
	    public static final By TIMEZONE_DROPDOWN = By.xpath("//div[@id='zone_name_chosen']");
	    public static final String TIMEZONE_DROPDOWN_OPTION = "//div[@id='zone_name_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
	    public static final String ALL_ALERT_OPTION = "//div[@id='alarm_category_id_chosen']/div/ul/li[@title=\"%s\"]";
	    public static final String TIMEZON_RIGHTS_OPTION = "//div[@id='time_zonerights_chosen']/div/ul/li[@title=\"%s\"]";
	    public static final String SIM_PROVIDER_OPTION = "//div[@id='sim_providers_chosen']/div/ul/li[@title=\"%s\"]";
	    public static final String GATEWAY_NAME_FIELD_DROPDOWN_OPTIONS = "//select[@name='gateway_category_id']/option[text()=\"%s\"]";
	    public static final String IVR_GATEWAY_DROPDOWN_OPTIONS = "//select[@name='ivr_gateway']/option[text()=\"%s\"]";
	    public static final String CONSIDER_ANNOUNCEMENT_CHECKBOX = "//input[@id='social_media_api_consider_c_3']";
	    public static By SCREEN_ELEMENT = By.xpath("//div[@data_id='ContentRights']");
	    public static By DELETE_OK_BUTTON = By.xpath("//input[@id='bulkDeleteOKButton']");
	    public static By SCREEN_ELEMENT_IVR = By.xpath("//input[@id='-account_sid']");
	    public static By PASSWORD_FIELD = By.xpath("//input[@id='-password']");
	    public static By PASSWORD_RECOVERY_EMAIL_FIELD = By.xpath("//input[@id='-password_recovery_email']");
	    public static By HELP_DESK_TELEPHONE_NUMBER_FIELD = By.xpath("//input[@id='-tel_no']");
	    public static By HELP_DESK_EMAIL_FIELD = By.xpath("//input[@id='-help_desk_email']");
	    public static By WHATSAPP_CONTACT_NUMBER_FIELD = By.xpath("//input[@id='-whatsapp_contact_number']");
	    public static By WELCOME_MESSAGE_FIELD = By.xpath("//input[@id='-welcome_msg']");
	    public static By DATA_STORAGE_FIELD = By.xpath("//input[@id='-data_storage']");
	    public static By STREET2_FIELD = By.xpath("//input[@id='-street2']");
	    public static By DESCRIPTION_FIELD = By.xpath("//textarea[@id='-description']");
	    public static By SPEED_CONSIDERATION_MOMENT_FIELD = By.xpath("//input[@id='-speed_tolerance']");
	    public static By MAX_SPEED_VALIDATOR_FIELD = By.xpath("//input[@id='-max_speed_validator']");
	    public static By ALERT_FIELD = By.xpath("//div[@id='alarm_category_id_chosen']");
	    public static By TIMEZONE_RIGHTS_FIELD = By.xpath("//div[@id='time_zonerights_chosen']");
	    public static By SIM_PROVIDER_FIELD = By.xpath("//div[@id='sim_providers_chosen']");
	    public static By MAP_PROJECT_ID_FIELD = By.xpath("//input[@id='-map_project_id']");
	    public static By GATEWAY_NAME_DROPDOWN = By.xpath("//select[@name='gateway_category_id']");
	    public static By GATEWAY_NAME_FIELD = By.xpath("//input[@id='-gateway_custom_name']");
	    public static By CLIENT_ID_FIELD = By.xpath("//input[@id='-param_i']");
	    public static By SECRET_KEY_FIELD = By.xpath("//input[@id='-param_ii']");
	    public static By ACTUAL_NAME_FIELD = By.xpath("//input[@id='-actualproperty_name']");
	    public static By NEW_NAME_FIELD = By.xpath("//input[@id='-newproperty_name']");
	    public static By IVR_GATEWAY_DROPDOWN = By.xpath("//select[@name='ivr_gateway']");
	    public static By ACCOUNT_SID_FIELD = By.xpath("//input[@id='-account_sid']");
	    public static By ACCOUNT_TOKEN_FIELD = By.xpath("//input[@id='-account_token']");
	    public static By FROM_NUMBER_FIELD = By.xpath("//input[@id='-from_number']");
	    public static By BOT_HTTP_TOKEN_FIELD = By.xpath("//textarea[@id='-bot_http_token_v']");
	    public static By EDIT_RULE_BUTTON = By.xpath("//td[@id='editIframeLink0']");
	    public static By EDIT_PAYMENT_GATEWAY_BUTTON = By.xpath("//img[@id='editImageDarkMode']");
	    public static By SECURITY_PIN_CHECKBOX = By.xpath("//input[@id=\"enable_security_pin_1\"]");
	    public static By SECURITY_PIN = By.xpath("//input[@id=\"-security_pin\"]");
	    public static By RETYPE_SECURITY_PIN = By.xpath("//input[@id=\"-retype_security_pin\"]");
	    public static By OKBUTTON_ON_DELETEPOPUP = By.xpath("//input[@id=\"bulkDeleteOKButton\"]");
	    public static By PIN_FIELD_ON_DELETEPOPUP = By.xpath("//input[@id=\"bulkDeleteSecurityPIN\"]");
	    public static By ENTERBUTTON_ON_DELETEPOPUP = By.xpath("//input[@id=\"bulkDeleteAuthenticationOKButton\"]");
	    
	    
	
}
