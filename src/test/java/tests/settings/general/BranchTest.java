package tests.settings.general;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonMethods.LoginPageCommonMethods;
import configurations.base.TestBase;
import configurations.config.ConfigLoader;
import listeners.CustomTestListener;
import web.pages.BranchPage;
import web.pages.CompanyPage;
import web.pages.HomePage;




@Listeners({CustomTestListener.class})
public class BranchTest extends TestBase{
    
	 private static final Logger logger = LoggerFactory.getLogger(CompanyTest.class);
	 private static final String MENU_SETTINGS = "Settings";
	 private static final String MENU_GENERAL = "General";
	 private static final String MENU_BRANCH = "Branch";
	 private final ConfigLoader configLoader = ConfigLoader.getInstance();
	 private LoginPageCommonMethods loginPageCommonMethods;
	 private HomePage homepage;
	 private BranchPage branchPage;
	 
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		setUpWeb();
		driver.get(getWebsiteUrl());
		initializePages();
		loginToApplication();
		navigateToBranchSettings();
	
		
	}
	
	public void initializePages()
	{
		loginPageCommonMethods = new LoginPageCommonMethods(driver);
		homepage = new HomePage(driver);
		branchPage = new BranchPage(driver);
		
	}
	
	public void loginToApplication()
	{
		String userType = System.getProperty("userType", "admin");
        String credentials = configLoader.getUserCredentials(userType);
        String[] credentialParts = credentials.split(":");
        String username = credentialParts[0];
        String password = credentialParts[1];
        logger.info("Logging in as user: {}", username);
        loginPageCommonMethods.enterUsername(username);
        loginPageCommonMethods.enterPassword(password);
        loginPageCommonMethods.clickLoginButton();
	}
	
	private void navigateToBranchSettings() throws InterruptedException
	{
		logger.info("Navigating to branch settings");
		homepage.selectProject(configLoader.getProperty("project.name"));
		homepage.navigateToMenu(MENU_SETTINGS, MENU_GENERAL, MENU_BRANCH);
		
	}
	
	@Test
	public void shouldCreateAndDeleteBranchWithAllDetails() throws InterruptedException
	{
		branchPage.addBranch()
		          .addBranchDetail()
		          .SaveButton()
		          .searchBranch();
		Thread.sleep(3000);
		
	}
	
	
//	
//	@AfterMethod
//	public void tearDown()
//	{
//		driver.close();
//	}
	
	
	
	
	
	
	
}
