package web.locators;

import org.openqa.selenium.By;

public class CompanySubUserPageLocators {
	
	public static By ADD_BUTTON = By.xpath("//a[@title='New']");
	public static By USERNAME_FIELD = By.xpath("//input[@id=\"-username_i\"]");
	
	  public static final By COMPANY_DROPDOWN = By.xpath("//div[@id='company_id_i_chosen']");
	    public static final String COMPANY_DROPDOWN_OPTION = "//div[@id='company_id_i_chosen']//div[@class='chosen-drop']//ul//li[@title=\"%s\"]";

	
	
	
}
