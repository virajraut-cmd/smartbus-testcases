package tests.settings.general;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonMethods.LoginPageCommonMethods;
import configurations.base.TestBase;
import configurations.config.ConfigLoader;
import web.pages.BranchPage;
import web.pages.HomePage;

public class BranchTest extends TestBase{
	
	private static final Logger logger = LoggerFactory.getLogger(BranchTest.class);
	private static final String MENU_SETTINGS = "Settings";
	private static final String MENU_GENERAL = "General";
	private static final String MENU_BRANCH = "Branch";
	private final ConfigLoader configLoader = ConfigLoader.getInstance();
	private LoginPageCommonMethods loginPageCommonMethods;
	private HomePage homePage;
	private BranchPage branchPage;
	
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		setUpWeb();
		driver.get(getWebsiteUrl());
		initializePages();
		loginToApplication();
		navigateToBranchSettings();
		
	}
	
	private void initializePages()
	{
		loginPageCommonMethods = new LoginPageCommonMethods(driver);
		homePage = new HomePage(driver);
		branchPage = new BranchPage(driver);
		
	}
	
	private void loginToApplication()
	{
		String userType = System.getProperty("userType","admin");
		String credentials = configLoader.getUserCredentials(userType);
		String[] credentialParts = credentials.split(":");
		String username = credentialParts[0];
		String password = credentialParts[1];
		logger.info("Logging in as user: {} ",username);
		loginPageCommonMethods.enterUsername(username);
		loginPageCommonMethods.enterPassword(password);
		loginPageCommonMethods.clickLoginButton();
		
	}
	
	private void navigateToBranchSettings() throws InterruptedException
	{
		  logger.info("Navigating to Branch settings");
		  homePage.selectProject(configLoader.getProperty("project.name"));
		  homePage.navigateToMenu(MENU_SETTINGS, MENU_GENERAL, MENU_BRANCH);
		  Thread.sleep(2000);
	}
	
	
	@Test
	public void shouldCreateAndDeleteBranchWithAllDetails() throws InterruptedException
	{
		branchPage.createBranch()
		          .addDetails()
		          .savingBranch()
		          .searchBranch();
		Thread.sleep(2000);
	}
	
    
	

}
