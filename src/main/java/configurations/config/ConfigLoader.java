package configurations.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigLoader {
     
	 private static volatile ConfigLoader instance;
	    private final Properties properties;
	    private final String environment;
	    private static final Logger LOGGER = LogManager.getLogger(ConfigLoader.class);

	    // Generic constructor allowing custom config file path and environment
	    public ConfigLoader(String configFilePath, String environment) {
	        properties = new Properties();
	        this.environment = environment;
	        try (FileInputStream fis = new FileInputStream(configFilePath)) {
	            properties.load(fis);
	            LOGGER.info("Properties loaded for environment: {} from {}", environment, configFilePath);
	        } catch (IOException e) {
	            LOGGER.error("Error loading properties file from path: {}", configFilePath, e);
	        }
	    }

	    // Default constructor for backward compatibility
	    private ConfigLoader() {
	        properties = new Properties();
	        environment = System.getProperty("env", "demo");
	        String configFilePath = System.getProperty("user.dir") + "/src/main/config.properties";
	        try (FileInputStream fis = new FileInputStream(configFilePath)) {
	            properties.load(fis);
	            LOGGER.info("Properties loaded for environment: {}", environment);
	        } catch (IOException e) {
	            LOGGER.error("Error loading properties file from path: {}", configFilePath, e);
	        }
	    }

	    // Singleton instance with default config
	    public static ConfigLoader getInstance() {
	        if (instance == null) {
	            synchronized (ConfigLoader.class) {
	                if (instance == null) {
	                    instance = new ConfigLoader();
	                }
	            }
	        }
	        return instance;
	    }

	    // Fetch property with environment prefix (default behavior)
	    public String getProperty(String key) {
	        String fullKey = environment + "." + key;
	        String value = properties.getProperty(fullKey);
	        if (value == null) {
	            LOGGER.warn("Property {} not found for environment: {}", fullKey, environment);
	            return null;
	        }
	        LOGGER.info("Fetched property: {} = {}", fullKey, value);
	        return value;
	    }

	    // Generic method to get user credentials based on environment and user type
	    public String getUserCredentials(String userType) {
	        String usernameKey = environment + "." + userType + ".username";
	        String passwordKey = environment + "." + userType + ".password";
	        String username = properties.getProperty(usernameKey);
	        String password = properties.getProperty(passwordKey);
	        if (username == null || password == null) {
	            throw new IllegalArgumentException("Credentials not found for userType: " + userType
	                    + " for environment: " + environment);
	        }
	        return username + ":" + password;
	    }
}
