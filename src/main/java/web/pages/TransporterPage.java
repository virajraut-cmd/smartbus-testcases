package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import commonMethods.EmployeePageCommonMethods;
import commonMethods.TransporterPageCommonMethods;
import configurations.common.IframesOfApplication;
import configurations.common.WaitUtils;



public class TransporterPage {
      
	 private static final Logger logger = LogManager.getLogger(CompanyPage.class);
	    private final WebDriver driver;
	    private final TransporterPageCommonMethods transporterPageCommonMethods;
	    private final EmployeePageCommonMethods employeePageCommonMethods;
	    private final PermissionPage permissionPage;
	    private final WaitUtils waitUtils;
	    private final IframesOfApplication iframesOfApplication;
	    
	    
	    public TransporterPage(WebDriver driver)
	    {
	    	this.driver = driver;
	    	this.transporterPageCommonMethods = new TransporterPageCommonMethods(driver);
	    	this.employeePageCommonMethods = new EmployeePageCommonMethods(driver);
	    	this.permissionPage = new PermissionPage(driver);
	    	this.waitUtils = new WaitUtils(driver);
	    	this.iframesOfApplication = new IframesOfApplication(driver);
	    	
	    }
	
}
