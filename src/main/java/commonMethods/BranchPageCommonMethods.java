package commonMethods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v137.tethering.Tethering;

import configurations.common.CommonMethods;
import configurations.common.IframesOfApplication;
import configurations.common.WaitUtils;
import web.locators.BranchPageLocators;
import web.locators.CompanyPageLocators;

public class BranchPageCommonMethods {
	
	public static final Logger logger = LogManager.getLogger(CompanyPageCommonMethods.class);
    private final WebDriver driver;
    private final CommonMethods commonMethods;
    private final IframesOfApplication iframe;
    private final WaitUtils waitUtils;
    private String branchname;
    
    
    
    public BranchPageCommonMethods(WebDriver driver) {
        logger.info("Initializing CompanyPageCommonMethods");
        this.driver = driver;
        this.commonMethods = new CommonMethods(driver);
        this.iframe = new IframesOfApplication(driver);
        this.waitUtils = new WaitUtils(driver);
        branchname = commonMethods.generateRandomFirstName();
        logger.info("CompanyPageCommonMethods initialized");
    }
    
	
	public void AddButton() {	
	logger.info("clicking on Add Button");
	iframe.switchToBottomFrame();
	WebElement addbutton = waitUtils.waitForElementToBeClickable(BranchPageLocators.ADD_NEW);
	addbutton.click();
	
	}
	
	public void SelectCompany(String CompanyName)
	{   logger.info("selecting the company");
		iframe.switchToContentFrame();
		By CompanyDropDownLocator = BranchPageLocators.COMPANY_DROPDOWN;
		By CompanyDropDownOptionLocator = By.xpath(String.format(BranchPageLocators.COMPANY_DROPDOWN_OPTION,CompanyName));
		commonMethods.selectFromDropdown(CompanyDropDownLocator, CompanyDropDownOptionLocator, true);
		
	}
	
	public void EnterBranchName()
	{   
		logger.info("Entering the Branch Name");
		iframe.switchToContentFrame();
		WebElement BranchName = waitUtils.waitForElementToBeClickable(BranchPageLocators.BranchName);
		BranchName.sendKeys(branchname);		
		
	}
	
	public void SelectCountry(String CountryName)
	{
		logger.info("Selecting the Company: ",CountryName);
		iframe.switchToContentFrame();
		By CountryDropDownLocator = BranchPageLocators.BRANCH_DETAILS_COUNTRY_DROPDOWN;
		By CountryDropDownOptionLocator = By.xpath(String.format(BranchPageLocators.BRANCH_DETAILS_COUNTRY_DROPDOWN_OPTION,CountryName));
		commonMethods.selectFromDropdown(CountryDropDownLocator,CountryDropDownOptionLocator,true);
			
	}
	
	public void selectState(String stateName) {
        logger.info("Selecting state for branch: {}", stateName);
        waitUtils.waitForMilliseconds(500);
        iframe.switchToContentFrame();
        By stateDropdownLocator = BranchPageLocators.BRANCH_DETAILS_STATE_DROPDOWN;
        By stateOptionLocator = By.xpath(String.format(BranchPageLocators.BRANCH_DETAILS_STATE_DROPDOWN_OPTION, stateName));
        commonMethods.selectFromDropdown(stateDropdownLocator, stateOptionLocator,true);
        logger.info("State selected for branch: {}", stateName);
    }
	
	
	public void EnterCityName(String CityName)
	{   
		logger.info("Entering city name: ",CityName);
		iframe.switchToContentFrame();
		WebElement CITYLOCATOR = waitUtils.waitForElementToBeClickable(BranchPageLocators.CITY);
		CITYLOCATOR.sendKeys(CityName);
	}

	public void EnterZipCode(String Zipcode)
	{
		logger.info("Entering the Zipcode: ",Zipcode);
		iframe.switchToContentFrame();
		WebElement ZIPCODELOCATOR = waitUtils.waitForElementToBeClickable(BranchPageLocators.ZIPCODE);
		ZIPCODELOCATOR.sendKeys(Zipcode);
	}
	

	public void EnterStreetAddress1(String address)
	{
		logger.info("Entering the street one address: ",address);
		iframe.switchToContentFrame();
		WebElement ADDRESSONE = waitUtils.waitForElementToBeClickable(BranchPageLocators.STREETONE);
		ADDRESSONE.sendKeys(address);
	}
	
	
	public void EnterStreetAddress2(String address)
	{
		logger.info("Entering the street one address: ",address);
		iframe.switchToContentFrame();
		WebElement ADDRESSTWO = waitUtils.waitForElementToBeClickable(BranchPageLocators.STREETTWO);
		ADDRESSTWO.sendKeys(address);
	}
	
	public void EnterContactPerson(String PersonName)
	{
		logger.info("Entering the Contact person name: ",PersonName);
		iframe.switchToContentFrame();
		WebElement CONTACTPERSON = waitUtils.waitForElementToBeClickable(BranchPageLocators.CONTACT_PERSON);
		CONTACTPERSON.sendKeys(PersonName);	
	}
	
	public void EnterMobileNumber(String MobileNumber)
	{
		logger.info("Entering mobile number: ",MobileNumber);
		iframe.switchToContentFrame();
		WebElement MOBILENUMBER = waitUtils.waitForElementToBeClickable(BranchPageLocators.MOBILE_NUMBER);
		MOBILENUMBER.sendKeys(MobileNumber);
	}
	
	public void EnterEmail(String Email)
	{
		logger.info("Entering Email :",Email);
		iframe.switchToContentFrame();
		WebElement EMAIL = waitUtils.waitForElementToBeClickable(BranchPageLocators.EMAIL);
	    EMAIL.sendKeys(Email);
	}
	
	public void EnterFaxNumber(String FaxNumber)
	{
		logger.info("Entering Fax Number: ",FaxNumber);
		iframe.switchToContentFrame();
		WebElement FAXNUMBER = waitUtils.waitForElementToBeClickable(BranchPageLocators.FAX_NO);
		FAXNUMBER.sendKeys(FaxNumber);
	}
	
	public void EnterBranchCode(String Branchcode)
	{
		logger.info("Entering BranchCode: ",Branchcode);
		iframe.switchToContentFrame();
		WebElement BRANCHCODE = waitUtils.waitForElementToBeClickable(BranchPageLocators.BRANCH_CODE);
		BRANCHCODE.sendKeys(Branchcode);
	}
	
	public void EnterLatLongCoordinates()
	{
		logger.info("Entering Lat Long coordinates: ","21.084338191290417,72.71905663379358");
		iframe.switchToContentFrame();
		WebElement LatLongLocator = waitUtils.waitForElementToBeClickable(BranchPageLocators.LAT_LONG);
		LatLongLocator.sendKeys("21.084338191290417,72.71905663379358");
	}
	
	public void EnterSchoolRegistrationNumber(String SCHREGNO)
	{
		logger.info("Entering the school registration number: ",SCHREGNO);
		iframe.switchToContentFrame();
		WebElement SCHOOLREGNUMBER_Locator = waitUtils.waitForElementToBeClickable(BranchPageLocators.SCHOOL_REG_NO);
		SCHOOLREGNUMBER_Locator.sendKeys(SCHREGNO);
	}
	
	 public void clickOnAddLocationButton()
	    { 
	    	logger.info("click on add lcoation butotn");
	    	iframe.switchToContentFrame();
	    	WebElement AddLocationButton = driver.findElement(By.xpath(BranchPageLocators.ADD_GEOLOCATION));
	    	AddLocationButton.click();
	    	WebElement gEOLOCATION_INPUT_FIELDElement = driver.findElement(By.xpath(BranchPageLocators.GEOCODE_INPUT_FIELD)); 
	    	gEOLOCATION_INPUT_FIELDElement.sendKeys("21.08433304301649, 72.7190545319735");
	    	WebElement savebtton = driver.findElement(By.xpath(BranchPageLocators.GEOCODE_SAVE_BUTTON));
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        savebtton.click();
	    	
	    } 
	 
	 public void clickonSaveButton()
	 {
		 logger.info("clicking on save button on bottomframe");
		 iframe.switchToBottomFrame();
		 WebElement SAVEBUTTON = waitUtils.waitForElementToBeClickable(BranchPageLocators.SAVE_BUTTON);
		 SAVEBUTTON.click();
	 }
	 
	 
	 public void SearchCreatedBranchOnOverview()
	 {
		 logger.info("searching created branch on overview screen");
		 iframe.switchToBottomFrame();
		 WebElement searchBox = waitUtils.waitForElementToBeClickable(BranchPageLocators.OVERVIEW_SEARCHBOX);
		 searchBox.sendKeys(branchname);
	 }
	 
	 public void ClickingonSearchButton()
	 {
		 logger.info("clicking on search button on overview screen");
		 iframe.switchToBottomFrame();
		 WebElement searchbutton = waitUtils.waitForElementToBeClickable(BranchPageLocators.OVERVIEW_SEARCHBUTTON);
		 searchbutton.click();
	 }
	 
	 
	
	
	
	
	 
}
