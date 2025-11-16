package commonMethods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import configurations.common.CommonMethods;
import configurations.common.IframesOfApplication;
import configurations.common.WaitUtils;
import web.locators.BranchPageLocator;
import web.locators.CompanyPageLocators;


public class BranchPageCommonMethod {

	private static final Logger logger = LogManager.getLogger(BranchPageCommonMethod.class);
	private final WebDriver driver;
	private final CommonMethods commonMethods;
	private final IframesOfApplication iframe;
	private final WaitUtils waitUtils;
	private final String password = "Test@123";
    private  String branchName;
	
	
	public BranchPageCommonMethod(WebDriver driver)
	{
		logger.info("Initializing BranchPageMethods");
		this.driver = driver;
		this.commonMethods = new CommonMethods(driver);
		this.iframe = new IframesOfApplication(driver);
		this.waitUtils = new WaitUtils(driver);
		logger.info("BranchPageMethods initialized");
	}
	
	public void addBranch() throws InterruptedException
	{
		logger.info("entering addBranch method");
		iframe.switchToBottomFrame();
		WebElement addbuttonElement = waitUtils.waitForElementToBeClickable(BranchPageLocator.ADD_BUTTON);
		addbuttonElement.click();
		Thread.sleep(2000);
		logger.info("exiting addBranch method");
	}
	
	
	public void EnterBranchName()
	{
		logger.info("Entering the EnterBranchName method");
		iframe.switchToContentFrame();
		WebElement branchnamElement = waitUtils.waitForElementToBeClickable(BranchPageLocator.BRANCH_NAME);
		this.branchName = commonMethods.getBranchName();
		branchnamElement.sendKeys(branchName);
		logger.info("Exiting the EnterBranchName method");
		
	}
	
	 public void selectCountry(String countryName) {
	        logger.info("Selecting country for branch: {}", countryName);
	        iframe.switchToContentFrame();
	        By countryDropdownLocator = BranchPageLocator.Branch_DETAILS_COUNTRY_DROPDOWN;
	        By countryOptionLocator = By.xpath(String.format(BranchPageLocator.branch_DETAILS_COUNTRY_DROPDOWN_OPTION, countryName));
	        commonMethods.selectFromDropdown(countryDropdownLocator, countryOptionLocator,true);
	        logger.info("Country selected for branch: {}", countryName);
	    }

	    public void selectState(String stateName) {
	        logger.info("Selecting state for branch: {}", stateName);
	        waitUtils.waitForMilliseconds(500);
	        iframe.switchToContentFrame();
	        By stateDropdownLocator = BranchPageLocator.branch_DETAILS_STATE_DROPDOWN;
	        By stateOptionLocator = By.xpath(String.format(BranchPageLocator.branch_DETAILS_STATE_DROPDOWN_OPTION, stateName));
	        commonMethods.selectFromDropdown(stateDropdownLocator, stateOptionLocator,true);
	        logger.info("State selected for branch: {}", stateName);
	    }
	    
	    public void EnterCityName()
	    {
	    	logger.info("Entering the EnterCityName method");
	    	WebElement citynameElement = waitUtils.waitForElementToBeClickable(BranchPageLocator.CITY);
	    	citynameElement.sendKeys(commonMethods.RandomCityName());
	    	logger.info("Exiting the EnterCityName method");
	    }
	    
	    public void EnterZipCode()
	    {
	    	logger.info("Entering the EnterZipCode method");
	    	WebElement zipcodElement = waitUtils.waitForElementToBeClickable(BranchPageLocator.ZIPCODE);
	    	zipcodElement.sendKeys(commonMethods.getRandomZipCode());
	    	logger.info("Exiting the EnterZipCode method");
	    }
	    
	    public void EnterStreet1()
	    {
	    	logger.info("Entering the EnterStreet1 method");
	    	WebElement street1 = waitUtils.waitForElementToBeClickable(BranchPageLocator.STREET1);
	    	street1.sendKeys(commonMethods.getRandomAddress());
	    	logger.info("Exiting the EnterStreet1 method");
	    }
	    
	    public void EnterStreet2()
	    {
	    	logger.info("Entering the EnterStreet2 method");
	    	WebElement street2 = waitUtils.waitForElementToBeClickable(BranchPageLocator.STREET2);
	    	street2.sendKeys(commonMethods.getRandomAddress());
	    	logger.info("Exiting the EnterStreet2 method");
	    }
	    
	    public void EnterContactPerson()
	    {
	    	logger.info("Entering the EnterContactperson method");
	    	WebElement contactpersonElement = waitUtils.waitForElementToBeClickable(BranchPageLocator.CONTACT_PERSON);
	    	contactpersonElement.sendKeys(commonMethods.generateRandomFirstName());
	    	logger.info("Exiting the Entercontactperson method");
	    }
	    
	    public void EnterMobileNumber()
	    {
	    	logger.info("Entering the EnterMobileNumber method");
	    	WebElement mobilenumberElement = waitUtils.waitForElementToBeClickable(BranchPageLocator.MOBILE_NUMBER);
	    	mobilenumberElement.sendKeys(commonMethods.generateRandomMobileNumber());
	    	logger.info("Exiting the EnterMobile method");
	    }
	    
	    public void EnterEmail()
	    {
	    	logger.info("Entering the EnterEmail method");
	    	WebElement emailElement = waitUtils.waitForElementToBeClickable(BranchPageLocator.EMAIL);
	    	emailElement.sendKeys(commonMethods.generateRandomEmail());
	    	logger.info("Exiting the EnterEmail method");
	    }
	    
	    public void EnterFaxNumber()
	    {
	    	logger.info("Entering the EnterFaxNumber method");
	    	WebElement faxnumberElement = waitUtils.waitForElementToBeClickable(BranchPageLocator.FAX_NUMBER);
	    	faxnumberElement.sendKeys(commonMethods.getRandomFaxNumber());
	    	logger.info("Exiting the EnterFaxNumber method");
	    }
	    
	    public void EnterBranchCode()
	    {
	    	logger.info("Entering the EnterBranchCode method");
	    	WebElement branchcodElement = waitUtils.waitForElementToBeClickable(BranchPageLocator.BRANCH_CODE);
	    	branchcodElement.sendKeys(commonMethods.getRandomBranchCode(4));
	    	logger.info("Exiting the EnterBranchCode method");
	    }
	    
	    public void ClickOnAddGeolocation() throws InterruptedException
	    {
	    	logger.info("clicking on geolocation button");
	    	WebElement geolocationbuttonElement = waitUtils.waitForElementToBeClickable(BranchPageLocator.GEOLOCATION_BUTTON);
	    	geolocationbuttonElement.click();
	    	WebElement geolocationinputElement = waitUtils.waitForElementToBeClickable(BranchPageLocator.GeoLocationInput);
	    	geolocationinputElement.sendKeys("21.138161203518976, 72.75092349347928");
	        WebElement savebuton = waitUtils.waitForElementToBeClickable(BranchPageLocator.geolocation_save_button);
	        savebuton.click();
	    	
	    	logger.info("clicked on geolocation button");
	    }
	    
	  public void EnterSchoolRegistrationNumber() throws InterruptedException
	  {
		  logger.info("enter ScholRegistration number method");
		  WebElement schoolregistrationElement = waitUtils.waitForElementToBeClickable(BranchPageLocator.SCHOOL_REGISTRION_NUMBER);
          schoolregistrationElement.sendKeys(commonMethods.generateSchoolRegNumber());		  
		  logger.info("exit SchoolRegistration number method");
		  Thread.sleep(1000);
	  }
	  
	  public void clickOnSaveButton()
	  {
		  logger.info("clicking on save button");
		  iframe.switchToBottomFrame();
		  WebElement savebutton = waitUtils.waitForElementToBeClickable(BranchPageLocator.SaveButton);
		  savebutton.click();
		  logger.info("clicked on save button");
	  }
	  
	  public void searchBranch()
	  {
		  logger.info("searching the branch");
		  iframe.switchToBottomFrame();
		  WebElement searchbox = waitUtils.waitForElementToBeClickable(BranchPageLocator.searchboxOnOverviewScreen);
		  searchbox.sendKeys(branchName);
		  WebElement searchbuttonElement = waitUtils.waitForElementToBeClickable(BranchPageLocator.searchbuttonOnOverviewScreen);
		  searchbuttonElement.click();
		  logger.info("branch search");
	  }
	  
	  public void clickOnCreatedBranch()
	  {
		  logger.info("Entering clickOnCreatedBranch");
		  waitUtils.waitForMilliseconds(3000);
		  iframe.switchToContentFrame();
		  String formattedXpath = String.format(BranchPageLocator.TABLE_OF_SHORT_NAME, branchName);
		  commonMethods.doubleClick(By.xpath(formattedXpath));
		  logger.info("exiting clickoncreated method");
		  
	  }
	  
	  
	
	
}
