package configurations.base;

import java.io.File;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.net.ServerSocket;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

import configurations.config.ConfigLoader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;

public class TestBase {
   
	private static final Logger LOGGER = LogManager.getLogger(TestBase.class);
    private static AppiumDriverLocalService service;

    @Getter
    protected WebDriver driver;

    protected AppiumDriver mobileDriver;

    public TestBase() {
        // No longer instantiate ConfigLoader here
    }

    public void setUpMobile() throws Exception {
        try {
            setUpMobileDriver();
        } catch (Exception e) {
            LOGGER.error("Failed to set up mobile driver: {}", e.getMessage());
            throw e;
        }
    }

    public void setUpWeb() {
        setUpWebDriver();
    }

    private boolean isHeadlessMode() {
        return Boolean.parseBoolean(System.getProperty("headless", "false"));
    }

    private void setUpWebDriver() {
        LOGGER.info("Setting up WebDriver...");

        // Only attempt to kill Chrome processes on Unix-based OS
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            try {
                Runtime.getRuntime().exec("pkill -f chrome || true");
                Thread.sleep(1000);
            } catch (IOException | InterruptedException e) {
                LOGGER.warn("Error while terminating Chrome processes: {}", e.getMessage());
            }
        }
        WebDriverManager.chromedriver().clearDriverCache();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        if (System.getenv("JENKINS_HOME") != null || isHeadlessMode()) {
            options.addArguments("--headless=new");
//            options.addArguments("--start-maximized");

            LOGGER.info("Running in Headless mode");
        } else {
//            options.addArguments("--start-maximized");
            LOGGER.info("Running in normal mode");
        }

        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--window-size=1920x1080");
        if (new File("/usr/bin/google-chrome").exists()) {
            options.setBinary("/usr/bin/google-chrome");
        }

        Map<String, Object> loggingPrefs = new HashMap<>();
        loggingPrefs.put("driver", Level.ALL);
        loggingPrefs.put("browser", Level.ALL);
        options.setCapability("goog:loggingPrefs", loggingPrefs);

        this.driver = new ChromeDriver(options);
        // Ensure window size is set explicitly for consistent screenshots
        org.openqa.selenium.Dimension screenSize = new org.openqa.selenium.Dimension(1920, 1080);
        try {
            this.driver.manage().window().setSize(screenSize);
            this.driver.manage().window().maximize();
        } catch (Exception e) {
            LOGGER.warn("Could not set window size: {}", e.getMessage());
        }
        this.driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        this.driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(60));
        LOGGER.info("WebDriver setup complete.");
    }

    private void setUpMobileDriver() throws Exception {
        String platformName = System.getProperty("platform", "android");
        String platformVersion = ConfigLoader.getInstance().getProperty("platformVersion");
        String deviceName = ConfigLoader.getInstance().getProperty("deviceName");

        if (platformVersion == null || deviceName == null) {
            throw new IllegalStateException("Mobile platform configuration is incomplete.");
        }

        URL url = new URL("http://127.0.0.1:4723/");
        DesiredCapabilities caps = new DesiredCapabilities();

        switch (platformName.toLowerCase()) {
            case "android":
                caps.setCapability("platformName", "Android");
                caps.setCapability("platformVersion", platformVersion);
                caps.setCapability("deviceName", deviceName);
                caps.setCapability("automationName", "uiautomator2");
                caps.setCapability("appPackage", "com.uffizio.taskeye");
                caps.setCapability("appActivity", "ui.activity.startup.SplashScreenActivity");
                caps.setCapability("app", ConfigLoader.getInstance().getProperty("appApkFilePath"));
                break;
            default:
                throw new IllegalArgumentException("Unsupported platform: " + platformName);
        }

        startAppiumServer();
        try {
            this.mobileDriver = new AppiumDriver(url, caps);
            this.mobileDriver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(60));
            LOGGER.info("Mobile driver initialized successfully.");
        } catch (Exception e) {
            LOGGER.error("Error initializing Appium driver: {}", e.getMessage());
            throw e;
        }
    }

    private void startAppiumServer() {
        if (!isServerRunning(4723)) {
            try {
                service = AppiumDriverLocalService.buildDefaultService();
                service.start();
                LOGGER.info("Appium server started.");
            } catch (Exception e) {
                LOGGER.error("Failed to start Appium service: {}", e.getMessage());
            }
        } else {
            LOGGER.info("Appium server already running.");
        }
    }

    private boolean isServerRunning(int port) {
        try (ServerSocket socket = new ServerSocket(port)) {
            return false;
        } catch (IOException e) {
            return true;
        }
    }

    public WebDriver getWebDriver() {
        return this.driver;
    }

    public AppiumDriver getMobileDriver() {
        return this.mobileDriver;
    }

    public String getWebsiteUrl() {
        return ConfigLoader.getInstance().getProperty("website.url");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
            LOGGER.info("WebDriver terminated.");
        }
        if (mobileDriver != null) {
            mobileDriver.quit();
            mobileDriver = null;
            LOGGER.info("Mobile driver terminated.");
        }
        if (service != null) {
            try {
                service.stop();
                LOGGER.info("Appium service stopped.");
            } catch (Exception e) {
                LOGGER.warn("Appium service stop failed: {}", e.getMessage());
            }
            service = null;
        }
    }
	
}
