package web.locators;

import org.openqa.selenium.By;

public class BranchPageLocators {
   
	
	public static By ADD_NEW = By.xpath("//a[@title=\"New\"]");
	public static By COMPANY_DROPDOWN = By.xpath("//div[@id=\'company_id_chosen\']");
    public static final String COMPANY_DROPDOWN_OPTION = "//div[@id='company_id_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
    public static final By BranchName = By.xpath("//input[@id='-short_name_i']");
    public static final By BRANCH_DETAILS_COUNTRY_DROPDOWN = By.xpath("//div[@id='country_chosen']");
    public static final String BRANCH_DETAILS_COUNTRY_DROPDOWN_OPTION = "//div[@id='country_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
    public static final By BRANCH_DETAILS_STATE_DROPDOWN = By.xpath("//div[@id='state_chosen']");
    public static final String BRANCH_DETAILS_STATE_DROPDOWN_OPTION = "//div[@id='state_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
	public static final By CITY = By.xpath("//input[@id='-city_i']");
	public static final By ZIPCODE = By.xpath("//input[@id='-zipcode']");
	public static final By STREETONE = By.xpath("//input[@id='-streetone_i']");
	public static final By STREETTWO =  By.xpath("//input[@id='-street_2']");
	public static final By CONTACT_PERSON = By.xpath("//input[@id='-contact_person_i']");
	public static final By MOBILE_NUMBER = By.xpath("//input[@id='-mob_no_i']");
	public static final By EMAIL = By.xpath("//input[@id='-email']");
	public static final By FAX_NO =  By.xpath("//input[@id='-fax_no']");
	public static final By BRANCH_CODE = By.xpath("//input[@id='-branch_code']");
	public static final By LAT_LONG = By.xpath("//input[@id='-lat_long_i']");
	public static final By SCHOOL_REG_NO = By.xpath("//input[@id='-registeration_number_i']");
	public static final String ADD_GEOLOCATION = "//img[@id=\"add_geolocation\"]";
    public static final String GEOCODE_INPUT_FIELD = "//input[@id=\'geocoder_input\']";
    public static final String GEOCODE_SAVE_BUTTON = "//input[@id=\"btn_save\"]";
    public static final By SAVE_BUTTON = By.xpath("//a[@title='Save']");
    public static final By OVERVIEW_SEARCHBOX = By.xpath("//input[@name='searchterm']");
    public static final By OVERVIEW_SEARCHBUTTON = By.xpath("//a[@class='navItem ft-icon icon bt-bottomsearch']");
	
}
