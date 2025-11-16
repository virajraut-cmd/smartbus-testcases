package web.locators;

import org.openqa.selenium.By;

public class BranchPageLocator {
	
	 public static final By ADD_BUTTON = By.xpath("//a[@title='New']");
	 public static final By BRANCH_NAME = By.xpath("//input[@id='-short_name_i']");
	 public static final By CITY = By.xpath("//input[@id='-city_i']");
	 public static final By ZIPCODE = By.xpath("//input[@id='-zipcode']");
	 public static final By STREET1 = By.xpath("//input[@id='-streetone_i']");
	 public static final By STREET2 = By.xpath("//input[@id='-street_2']");
	 public static final By CONTACT_PERSON = By.xpath("//input[@id='-contact_person_i']");
	 public static final By EMAIL = By.xpath("//input[@id='-email']");
	 public static final By FAX_NUMBER = By.xpath("//input[@id='-fax_no']");
	 public static final By BRANCH_CODE = By.xpath("//input[@id='-branch_code']");
	 public static final By GEOLOCATION_BUTTON = By.xpath("//img[@id='add_geolocation']");
	 public static final By LAT_LONG = By.xpath("//input[@id='-lat_long_i']");
	 public static final By SCHOOL_REGISTRION_NUMBER = By.xpath("//input[@id='-registeration_number_i']");
	 public static final By Branch_DETAILS_COUNTRY_DROPDOWN = By.xpath("//div[@id='country_chosen']");
	    public static final String branch_DETAILS_COUNTRY_DROPDOWN_OPTION = "//div[@id='country_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
	    public static final By branch_DETAILS_STATE_DROPDOWN = By.xpath("//div[@id='state_chosen']");
	    public static final String branch_DETAILS_STATE_DROPDOWN_OPTION = "//div[@id='state_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";
	 
	public static final By MOBILE_NUMBER = By.xpath("//input[@id='-mob_no_i']");
	public static final  By GeoLocationInput = By.xpath("//input[@id='geocoder_input']");
	public static final By geolocation_save_button = By.xpath("//input[@id='btn_save']");
	public static final By SaveButton = By.xpath("//a[@title='Save']");
	public static final  By searchboxOnOverviewScreen = By.xpath("//input[@name='searchterm']");
	public static final By searchbuttonOnOverviewScreen = By.xpath("//a[@class='navItem ft-icon icon bt-bottomsearch']");
	public static final String TABLE_OF_SHORT_NAME = "//td[@name='short_name' and @title=\"%s\"]";
	
	
	 
}
