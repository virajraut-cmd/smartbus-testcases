package web.locators;

import org.openqa.selenium.By;

public class AdminPageLocators {

    public static final By ADMIN_DETAILS_COUNTRY_DROPDOWN = By.xpath("//div[@id='country_id_chosen']");
    public static final String ADMIN_DETAILS_COUNTRY_DROPDOWN_OPTION = "//div[@id='country_id_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
    public static final By ADMIN_DETAILS_STATE_DROPDOWN = By.xpath("//div[@id='state_id_chosen']");
    public static final String ADMIN_DETAILS_STATE_DROPDOWN_OPTION = "//div[@id='state_id_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
    public static final By TIMEZONE_DROPDOWN = By.xpath("//div[@id='zone_name_chosen']");
    public static final String TIMEZONE_DROPDOWN_OPTION = "//div[@id='zone_name_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
    public static final By WEEK_START_DAY_DROPDOWN = By.xpath("//div[@id='week_start_day_chosen']");
    public static final String WEEK_START_DAY_DROPDOWN_OPTION = "//div[@id='week_start_day_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
    public static final By COPY_FROM_GROUP_DROPDOWN = By.xpath("//div[@id='user_groups_chosen']");
    public static final String COPY_FROM_GROUP_DROPDOWN_OPTION = "//div[@id='user_groups_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
    public static By PASSWORD_FIELD = By.xpath("//input[@id='-password_value']");
    public static By ADMIN_CODE_FIELD = By.xpath("//input[@id='-admin_code']");
    public static By SERVER_IP_FIELD = By.xpath("//input[@id='-server_ip']");
    public static By SOS_AUTHORIZED_IP_FIELD = By.xpath("//input[@id='-sos_authorised_ip_d']");
    public static By DOMAIN_FIELD = By.xpath("//input[@id='-domain_name']");
    public static By ANDROID_APP_LINK_FIELD = By.xpath("//textarea[@id='-android_app_link']");
    public static By IOS_APP_LINK_FIELD = By.xpath("//textarea[@id='-ios_app_link']");
    public static By SEARCH_FIELD = By.xpath("//input[@name='searchterm']");
    public static By EDIT_RULE_BUTTON = By.xpath("//img[@id='editImageDarkMode']");
    public static By DELETE_SUB_ADMIN_USER_BUTTON = By.xpath("//img[@id='deleteFrameIcon']");
    public static By USERNAME_FIELD_SUB_ADMIN_USER = By.xpath("//input[@id='-username_i']");
    public static By CONFIRM_USERNAME_FIELD_SUB_ADMIN_USER = By.xpath("//input[@id='-confirm_username']");
    public static By PASSWORD_FIELD_SUB_ADMIN_USER = By.xpath("//input[@id='-password_i']");
    public static By RETYPE_PASSWORD_FIELD_SUB_ADMIN_USER = By.xpath("//input[@id='-retype_password_i']");
    public static By MOBILE_NUMBER_FIELD_SUB_ADMIN_USER = By.xpath("//input[@id='-mob_no_i']");
    public static By PASSWORD_RECOVERY_EMAIL_FIELD_SUB_ADMIN_USER = By.xpath("//input[@id='-password_recovery_email']");
}