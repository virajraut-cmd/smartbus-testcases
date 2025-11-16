package commonMethods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import configurations.common.CommonMethods;
import configurations.common.IframesOfApplication;
import configurations.common.WaitUtils;

public class TransporterPageCommonMethods {
	private static final Logger logger = LogManager.getLogger(TransporterPageCommonMethods.class);   
	private final WebDriver driver;
	private final CommonMethods commonMethods;
	 private final IframesOfApplication iframe;
	    private final WaitUtils waitUtils;
	    private final String password = "Test@123";
	    private String userName;
	    private String shortName;
	    private String editShortName;
	    private String editMobileNumber;
	    private String editUserName;
	    
	    
	    public TransporterPageCommonMethods(WebDriver driver)
	    {
	    	logger.info("Initializing TransporterPageCommonMethods");
	    	this.driver = driver;
	    	this.commonMethods = new CommonMethods(driver);
	    	this.iframe = new IframesOfApplication(driver);
	    	this.waitUtils = new WaitUtils(driver);
	    	logger.info("TransporterCommonMethods initialized");
	    }
	
	  
}
