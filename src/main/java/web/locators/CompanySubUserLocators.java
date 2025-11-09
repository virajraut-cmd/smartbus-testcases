package web.locators;

import org.openqa.selenium.By;

public class CompanySubUserLocators {

    public static final By RESELLER_DROPDOWN = By.xpath("//div[@id='reseller_chosen']");
    public static final String RESELLER_DROPDOWN_OPTION = "//div[@id='reseller_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
    public static final By COMPANY_DROPDOWN = By.xpath("//div[@id='company_id_i_chosen']");
    public static final String COMPANY_DROPDOWN_OPTION = "//div[@id='company_id_i_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
    public static By USERNAME_FIELD = By.xpath("//input[@id='-username_i']");
    public static By CONFIRM_USERNAME_FIELD = By.xpath("//input[@id='-confirm_username']");
    public static By PASSWORD_FIELD = By.xpath("//input[@id='-password_i']");
    public static By RETYPE_PASSWORD_FIELD = By.xpath("//input[@id='-retype_password_i']");
    public static final By EMPLOYEE_SELF_DROPDOWN = By.xpath("//div[@id='employee_self_id_chosen']");
    public static final String EMPLOYEE_SELF_DROPDOWN_OPTION = "//div[@id='employee_self_id_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
    public static final By EMPLOYEE_DROPDOWN = By.xpath("//div[@id='vehicle_id_i_chosen']");
    public static final String EMPLOYEE_DROPDOWN_OPTION = "//div[@id='vehicle_id_i_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
    public static By MOBILE_NUMBER_FIELD = By.xpath("//input[@id='-mob_no_i']");
    public static By PASSWORD_RECOVERY_EMAIL_FIELD = By.xpath("//input[@id='-password_recovery_email']");
    public static final By SEND_COMMAND_DROPDOWN = By.xpath("//div[@id='schedule_for_chosen']");
    public static final String SEND_COMMAND_DROPDOWN_OPTION = "//div[@id='schedule_for_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
    public static final By TIMEZONE_DROPDOWN = By.xpath("//div[@id='time_zone_i_chosen']");
    public static final String TIMEZONE_DROPDOWN_OPTION = "//div[@id='time_zone_i_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
    public static final By DATE_FORMAT_DROPDOWN = By.xpath("//select[@name='date_format_i']");
    public static final String DATE_FORMAT_DROPDOWN_OPTION = "//select[@name='date_format_i']/option[text()=\"%s\"]";
    public static final By TIME_FORMAT_DROPDOWN = By.xpath("//select[@name='time_format_i']");
    public static final String TIME_FORMAT_DROPDOWN_OPTION = "//select[@name='time_format_i']/option[text()=\"%s\"]";
    public static final By WEEK_START_DAY_FORMAT_DROPDOWN = By.xpath("//select[@name='week_start_day_i']");
    public static final String WEEK_START_DAY_FORMAT_DROPDOWN_OPTION = "//select[@name='week_start_day_i']/option[text()=\"%s\"]";
    public static final By MONTH_START_DAY_DROPDOWN = By.xpath("//div[@id='month_start_day_i_chosen']");
    public static final String MONTH_START_DAY_DROPDOWN_OPTION = "//div[@id='month_start_day_i_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
    public static final By STARTUP_SCREEN_DROPDOWN = By.xpath("//select[@name='startup_screen']");
    public static final String STARTUP_SCREEN_DROPDOWN_OPTION = "//select[@name='startup_screen']/option[text()=\"%s\"]";
    public static final String USER_STATUS_ACTIVE = "//input[@id='use_active_i_1']";
    public static final String USER_STATUS_INACTIVE = "//input[@id='use_active_i_2']";
    public static final String SHOW_DEFAULT_FIlTER_OPTION_IS_ON = "//input[@id='showdefaultfilter_i_1']";
    public static final String SHOW_DEFAULT_FIlTER_OPTION_IS_OFF = "//input[@id='showdefaultfilter_i_2']";
    public static final String WEB_ACCESS_NONE = "//input[@id='web_access_i_2']";
    public static final String WEB_ACCESS_ALL = "//input[@id='web_access_i_1']";
    public static final String MOBILE_ACCESS_NONE = "//input[@id='mobile_access_i_2']";
    public static final String MOBILE_ACCESS_ALL = "//input[@id='mobile_access_i_1']";
    public static final By AUTHENTICATION_REQUIRED_DROPDOWN = By.xpath("//div[@id='authentication_required_for_chosen']");
    public static final String AUTHENTICATION_REQUIRED_DROPDOWN_OPTION = "//div[@id='authentication_required_for_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
    public static final String PROVIDE_VERIFICATION_MEDIUM_BOTH = "//input[@id='authentication_verification_3']";
    public static final String ADD_BUTTON_INSIDE_COMPANY_SUB_USER = "//div[@id=\"%s\"]/../../../../../../../tr/td/table/tbody/tr/td/a/img";
    public static final By CONFIGURATION_TYPE_DROPDOWN = By.xpath("//select[@name='configuration_type']");
    public static final String CONFIGURATION_TYPE_DROPDOWN_OPTION = "//select[@name='configuration_type']/option[text()=\"%s\"]";
    public static final By PROVIDER_DROPDOWN = By.xpath("//div[@id='sso_provider_chosen']");
    public static final String PROVIDER_DROPDOWN_OPTION = "//div[@id='sso_provider_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
    public static By CLIENT_ID_FIELD = By.xpath("//input[@id='-client_id']");
    public static By CLIENT_SECRET_FIELD = By.xpath("//input[@id='-client_secret']");
    public static By TENANT_FIELD = By.xpath("//input[@id='-tenant_id']");
    public static By SEARCH_FIELD = By.xpath("//input[@name='searchterm']");
    public static final String TABLE_OF_USER_NAME = "//td[@name='username' and @title=\"%s\"]";
    public static final By FILE_FREQUENCY_TYPE_DROPDOWN = By.xpath("//select[@name='file_frequency']");
    public static final String FILE_FREQUENCY_TYPE_DROPDOWN_OPTION = "//select[@name='file_frequency']/option[text()=\"%s\"]";
    public static By SUBMIT_BUTTON = By.xpath("//input[@type='button' and @onclick='DocumentSaveTemp()']");
}
