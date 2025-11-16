package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import commonMethods.BranchPageCommonMethod;
import commonMethods.CompanyPageCommonMethods;
import commonMethods.EmployeePageCommonMethods;
import configurations.common.IframesOfApplication;
import configurations.common.WaitUtils;
import web.locators.BranchPageLocator;

public class BranchPage {
	
	private static final Logger logger = LogManager.getLogger(BranchPage.class);
	private final WebDriver driver;
	private BranchPageCommonMethod branchPageCommonMethod;
	private EmployeePageCommonMethods employeePageCommonMethods;
	private PermissionPage permissionPage;
	private final WaitUtils waitUtils;
	private final IframesOfApplication iframesOfApplication;
	
	public BranchPage(WebDriver driver)
	{
		this.driver = driver;
		this.branchPageCommonMethod = new BranchPageCommonMethod(driver);
		this.employeePageCommonMethods = new EmployeePageCommonMethods(driver);
		this.permissionPage = new PermissionPage(driver);
		this.waitUtils = new WaitUtils(driver);
		this.iframesOfApplication = new IframesOfApplication(driver);
	}
	
	public BranchPage createBranch() throws InterruptedException
	{
		logger.info("Creating branch");
		branchPageCommonMethod.addBranch();
		logger.info("branch creation initialized");
		return this;
	}
	
	public BranchPage addDetails() throws InterruptedException
	{
		logger.info("entering details");
		branchPageCommonMethod.EnterBranchName();
		branchPageCommonMethod.selectCountry("India");
		branchPageCommonMethod.selectState("Gujarat");
		branchPageCommonMethod.EnterCityName();
		branchPageCommonMethod.EnterZipCode();
		branchPageCommonMethod.EnterStreet1();
		branchPageCommonMethod.EnterStreet2();
		branchPageCommonMethod.EnterContactPerson();
		branchPageCommonMethod.EnterMobileNumber();
		branchPageCommonMethod.EnterEmail();
		branchPageCommonMethod.EnterFaxNumber();
		branchPageCommonMethod.EnterBranchCode();
		branchPageCommonMethod.ClickOnAddGeolocation();
		branchPageCommonMethod.EnterSchoolRegistrationNumber();
		logger.info("entered detials");
		return this;
	}
	
	public BranchPage savingBranch()
	{
		logger.info("saving the branch");
		branchPageCommonMethod.clickOnSaveButton();
		logger.info("branch record");
		
		return this;
	}
	
	public BranchPage searchBranch() throws InterruptedException
	{
		logger.info("searching the created branch");
		branchPageCommonMethod.searchBranch();
		branchPageCommonMethod.ClickOnAddGeolocation();
		logger.info("branch searched");
		return this;
	}
	
	
	
	
	
	

}
