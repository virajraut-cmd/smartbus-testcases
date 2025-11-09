package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonMethods.BranchPageCommonMethods;
import configurations.common.CommonMethods;
import configurations.common.IframesOfApplication;
import configurations.common.WaitUtils;
import web.locators.BranchPageLocators;

public class BranchPage {
	
	private static final Logger logger = LogManager.getLogger(CompanyPage.class);
    private final BranchPageCommonMethods branchPageCommonMethods;
    private final PermissionPage permissionPage;
    private final WaitUtils waitUtils;
    private final IframesOfApplication iframe;
    private final CommonMethods commonMethods;

    public BranchPage(WebDriver driver) {
        this.branchPageCommonMethods = new BranchPageCommonMethods(driver);
        this.permissionPage = new PermissionPage(driver);
        this.waitUtils = new WaitUtils(driver);
        this.iframe = new IframesOfApplication(driver);
        this.commonMethods = new CommonMethods(driver);

    }
     
	public BranchPage addBranch() {
        logger.info("Entering addBranch Method");
        iframe.switchToBottomFrame();
        WebElement addButton = waitUtils.waitForElementToBeClickable(BranchPageLocators.ADD_NEW);
        addButton.click();
        return this;
        
        
    }
	
	public BranchPage addBranchDetail()
	{  
		logger.info("Entering addBranchDetail");
		branchPageCommonMethods.SelectCompany("Annelle");
		branchPageCommonMethods.EnterBranchName();
		branchPageCommonMethods.SelectCountry("India");
		branchPageCommonMethods.selectState("Maharashtra");
		branchPageCommonMethods.EnterCityName(commonMethods.RandomCityName());
		branchPageCommonMethods.EnterZipCode(commonMethods.getRandomZipCode());
		branchPageCommonMethods.EnterStreetAddress1(commonMethods.getRandomAddress());
		branchPageCommonMethods.EnterStreetAddress2(commonMethods.getRandomAddress());
		branchPageCommonMethods.EnterContactPerson(commonMethods.generateRandomFirstName()+" "+commonMethods.generateRandomLastName());
		branchPageCommonMethods.EnterMobileNumber(commonMethods.generateRandomMobileNumber());
		branchPageCommonMethods.EnterEmail(commonMethods.generateRandomEmail());
		branchPageCommonMethods.EnterFaxNumber(commonMethods.getRandomFaxNumber());
		branchPageCommonMethods.EnterBranchCode(commonMethods.getRandomBranchCode(8));
		branchPageCommonMethods.clickOnAddLocationButton();
		branchPageCommonMethods.EnterLatLongCoordinates();
		branchPageCommonMethods.EnterSchoolRegistrationNumber(commonMethods.getRandomBranchCode(12));	
		return this;
	}
	
	public BranchPage SaveButton()
	{   logger.info("Branch saved");
		branchPageCommonMethods.clickonSaveButton();
		logger.info("Branch has been created");
		return this;
	}
	
	public BranchPage searchBranch()
	{
		logger.info("Branch Search");
		branchPageCommonMethods.SearchCreatedBranchOnOverview();;
		branchPageCommonMethods.ClickingonSearchButton();
		logger.info("Branched searched");
		return this;
	}
	
	
	
	
}
