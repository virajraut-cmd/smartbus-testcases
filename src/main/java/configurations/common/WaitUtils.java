package configurations.common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WaitUtils {
   
	 private static final long DEFAULT_TIMEOUT = 60;  // Timeout in seconds
	    private final WebDriver driver;

	    public WaitUtils(WebDriver driver) {
	        this.driver = driver;
	    }

	    // --- Clickable ---
	    public WebElement waitForElementToBeClickable(By searchbuttononoverviewscreen) {
	        return waitForElementToBeClickable(searchbuttononoverviewscreen, DEFAULT_TIMEOUT);
	    }
	    public WebElement waitForElementToBeClickable(By locator, long timeoutSeconds) {
	        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
	                .until(ExpectedConditions.elementToBeClickable(locator));
	    }
	    public WebElement waitForElementToBeClickable(WebElement element) {
	        return waitForElementToBeClickable(element, DEFAULT_TIMEOUT);
	    }
	    public WebElement waitForElementToBeClickable(WebElement element, long timeoutSeconds) {
	        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
	                .until(ExpectedConditions.elementToBeClickable(element));
	    }

	    // --- Visible ---
	    public WebElement waitForElementToBeVisible(By locator) {
	        return waitForElementToBeVisible(locator, DEFAULT_TIMEOUT);
	    }
	    public WebElement waitForElementToBeVisible(By locator, long timeoutSeconds) {
	        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
	                .until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }
	    public WebElement waitForElementToBeVisible(WebElement element) {
	        return waitForElementToBeVisible(element, DEFAULT_TIMEOUT);
	    }
	    public WebElement waitForElementToBeVisible(WebElement element, long timeoutSeconds) {
	        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
	                .until(ExpectedConditions.visibilityOf(element));
	    }

	    // --- Present ---
	    public void waitForElementToBePresent(By locator) {
	        waitForElementToBePresent(locator, DEFAULT_TIMEOUT);
	    }
	    public void waitForElementToBePresent(By locator, long timeoutSeconds) {
	        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
	                .until(ExpectedConditions.presenceOfElementLocated(locator));
	    }

	    // --- Disappear ---
	    public void waitForElementToDisappear(By locator) {
	        waitForElementToDisappear(locator, DEFAULT_TIMEOUT);
	    }
	    public void waitForElementToDisappear(By locator, long timeoutSeconds) {
	        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
	                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
	    }
	    public void waitForElementToDisappear(WebElement element) {
	        waitForElementToDisappear(element, DEFAULT_TIMEOUT);
	    }
	    public void waitForElementToDisappear(WebElement element, long timeoutSeconds) {
	        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
	                .until(ExpectedConditions.invisibilityOf(element));
	    }

	    // --- Text ---
	    public void waitForTextToBePresentInElement(By locator, String text) {
	        waitForTextToBePresentInElement(locator, text, DEFAULT_TIMEOUT);
	    }
	    public void waitForTextToBePresentInElement(By locator, String text, long timeoutSeconds) {
	        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
	                .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	    }
	    public void waitForTextToBePresentInElement(WebElement element, String text) {
	        waitForTextToBePresentInElement(element, text, DEFAULT_TIMEOUT);
	    }
	    public void waitForTextToBePresentInElement(WebElement element, String text, long timeoutSeconds) {
	        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
	                .until(ExpectedConditions.textToBePresentInElement(element, text));
	    }

	    // --- Attribute ---
	    public void waitForAttributeToBe(By locator, String attribute, String value) {
	        waitForAttributeToBe(locator, attribute, value, DEFAULT_TIMEOUT);
	    }
	    public void waitForAttributeToBe(By locator, String attribute, String value, long timeoutSeconds) {
	        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
	                .until(ExpectedConditions.attributeToBe(locator, attribute, value));
	    }
	    public void waitForAttributeToBe(WebElement element, String attribute, String value) {
	        waitForAttributeToBe(element, attribute, value, DEFAULT_TIMEOUT);
	    }
	    public void waitForAttributeToBe(WebElement element, String attribute, String value, long timeoutSeconds) {
	        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
	                .until(ExpectedConditions.attributeToBe(element, attribute, value));
	    }

	    // --- Number of elements ---
	    public void waitForNumberOfElementsToBeMoreThan(By locator, int number) {
	        waitForNumberOfElementsToBeMoreThan(locator, number, DEFAULT_TIMEOUT);
	    }
	    public void waitForNumberOfElementsToBeMoreThan(By locator, int number, long timeoutSeconds) {
	        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
	                .until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, number));
	    }

	    // --- URL ---
	    public void waitForUrlToContain(String fraction) {
	        waitForUrlToContain(fraction, DEFAULT_TIMEOUT);
	    }
	    public void waitForUrlToContain(String fraction, long timeoutSeconds) {
	        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
	                .until(ExpectedConditions.urlContains(fraction));
	    }

	    // --- Page load ---
	    public void waitForPageToLoad() {
	        waitForPageToLoad(DEFAULT_TIMEOUT);
	    }
	    public void waitForPageToLoad(long timeoutSeconds) {
	        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds)).until(
	                webDriver -> "complete".equals(((org.openqa.selenium.JavascriptExecutor) webDriver)
	                        .executeScript("return document.readyState"))
	        );
	    }

	    // --- Alert ---
	    public void waitForAlertToBePresent() {
	        waitForAlertToBePresent(DEFAULT_TIMEOUT);
	    }
	    public void waitForAlertToBePresent(long timeoutSeconds) {
	        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
	                .until(ExpectedConditions.alertIsPresent());
	    }

	    public void waitForAlertToDisappear() {
	        waitForAlertToDisappear(DEFAULT_TIMEOUT);
	    }

	    public void waitForAlertToDisappear(long timeoutSeconds) {
	        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
	                .until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
	    }

	    // --- Custom condition ---
	    public <T> T waitForCondition(Function<WebDriver, T> condition) {
	        return waitForCondition(condition, DEFAULT_TIMEOUT);
	    }
	    public <T> T waitForCondition(Function<WebDriver, T> condition, long timeoutSeconds) {
	        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds)).until(condition);
	    }
	    public <T> T waitForCustomCondition(ExpectedCondition<T> condition) {
	        return waitForCustomCondition(condition, DEFAULT_TIMEOUT);
	    }
	    public <T> T waitForCustomCondition(ExpectedCondition<T> condition, long timeoutSeconds) {
	        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds)).until(condition);
	    }

	    // --- Sleep ---
	    public void waitForMilliseconds(long millis) {
	        try {
	            Thread.sleep(millis);
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }
	
}
