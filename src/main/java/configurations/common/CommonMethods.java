package configurations.common;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

public class CommonMethods {
   
	private static final Logger logger = LogManager.getLogger(CommonMethods.class);
    private static final Faker FAKER = new Faker();
    private static final Random RANDOM = new Random();

    private final WebDriver driver;
    private final IframesOfApplication iframe;
    private final WaitUtils waitUtils;

    public CommonMethods(WebDriver driver) {
        this.driver = driver;
        this.iframe = new IframesOfApplication(driver);
        this.waitUtils = new WaitUtils(driver);
    }

    /**
     * Generates a random 10-digit mobile number.
     *
     * @return Random 10-digit mobile number as a String.
     */
    public static String generateRandomMobileNumber() {
        StringBuilder mobileNumber = new StringBuilder("9");
        for (int i = 0; i < 9; i++) {
            mobileNumber.append(RANDOM.nextInt(10));
        }
        return mobileNumber.toString();
    }

    /**
     * Generates a random 4-digit number.
     *
     * @return Random 4-digit number as a String.
     */
    public static String generateRandomNumber() {
        StringBuilder mobileNumber = new StringBuilder("3");
        for (int i = 0; i < 3; i++) {
            mobileNumber.append(RANDOM.nextInt(9));
        }
        return mobileNumber.toString();
    }

    /**
     * Generates a random email ID using @gmail.com domain.
     *
     * @return Random email ID as a String.
     */
    public static String generateRandomEmail() {
        String emailPrefix = FAKER.name().firstName().toLowerCase() +
                FAKER.name().lastName().toLowerCase() +
                RANDOM.nextInt(1000);
        return emailPrefix + "@Iotech.com";
    }

    /**
     * Generates a random first name using Java Faker.
     *
     * @return A random first name as a String.
     */
    public static String generateRandomFirstName() {
        return FAKER.name().firstName();
    }

    /**
     * Generates a random last name using Java Faker.
     *
     * @return A random last name as a String.
     */
    public static String generateRandomLastName() {
        return FAKER.name().lastName();
    }

    /**
     * Generates a random first name that is not in the provided list of already used names, using Java Faker.
     *
     * @param usedNames List of names that should not be returned.
     * @return A unique random first name as a String.
     */
    public static String generateRandomFirstName(List<String> usedNames) {
        String name;
        int attempts = 0;
        do {
            name = FAKER.name().firstName();
            attempts++;
        } while (usedNames != null && usedNames.contains(name) && attempts < 100);
        return name;
    }

    /**
     * Generates a random last name that is not in the provided list of already used names, using Java Faker.
     *
     * @param usedNames List of names that should not be returned.
     * @return A unique random last name as a String.
     */
    public static String generateRandomLastName(List<String> usedNames) {
        String name;
        int attempts = 0;
        do {
            name = FAKER.name().lastName();
            attempts++;
        } while (usedNames != null && usedNames.contains(name) && attempts < 100);
        return name;
    }

    public static void checkCheckbox(WebElement checkboxElement) {
        if (!checkboxElement.isSelected()) {
            checkboxElement.click();
        }
    }

    public static void uncheckCheckbox(WebElement checkboxElement) {
        if (checkboxElement.isSelected()) {
            checkboxElement.click();
        }
    }

    public void clickOnAnyButtonWithNameAndXpath(String buttonName, String xpath) {
        try {
            waitUtils.waitForElementToBeVisible(By.xpath(xpath));
            waitUtils.waitForElementToBeClickable(By.xpath(xpath));
            WebElement element = driver.findElement(By.xpath(xpath));
            element.click();
            logger.info("Clicked on button: {}", buttonName);
        } catch (TimeoutException e) {
            logger.error("Button not clickable: {}", buttonName, e);
        } catch (NoSuchElementException e) {
            logger.error("Element not found for button: {}", buttonName, e);
        } catch (Exception e) {
            logger.error("Error clicking button: {}", buttonName, e);
        }
    }

    public void verifyElementText(String xpath, String expectedText, String description) {
        try {
            iframe.switchToTitleFrame();
            waitUtils.waitForElementToBeVisible(By.xpath(xpath));
            WebElement element = driver.findElement(By.xpath(xpath));
            waitUtils.waitForElementToBeVisible(By.xpath(xpath));
            String actualText = element.getText().trim();
            if (actualText.equals(expectedText)) {
                logger.info("Verification successful for: {}", description);
            } else {
                logger.warn("Verification failed for: {}. Expected: {}, but found: {}", description, expectedText, actualText);
            }
            SoftAssert soft = new SoftAssert();
            soft.assertEquals(actualText, expectedText, "Header text mismatch for: " + description);
            soft.assertAll(); // Assert all soft assertions
        } catch (Exception e) {
            logger.error("Error verifying element text for: {}", description, e);
        }
    }

    public void selectFromDropdown(By dropdownLocator, By optionLocator, boolean isChosenDropdown) {
        try {
            waitUtils.waitForMilliseconds(1000);
            WebElement dropdown = waitUtils.waitForElementToBeClickable(dropdownLocator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
            dropdown.click();
            logger.info("Opened dropdown: {}", dropdownLocator);
            waitUtils.waitForElementToBeVisible(optionLocator);
            WebElement option = waitUtils.waitForElementToBeClickable(optionLocator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
            if (option.isDisplayed() && option.isEnabled()) {
                option.click();
                logger.info("Selected option: {} from dropdown: {}", optionLocator, dropdownLocator);
                if (isChosenDropdown) {
                    Actions actions = new Actions(driver);
                    actions.sendKeys(Keys.ESCAPE).perform();
                    logger.info("Closed chosen dropdown by sending ESCAPE key: {}", dropdownLocator);
                }
            } else {
                logger.error("Option '{}' is not clickable or not enabled: {}", optionLocator, dropdownLocator);
            }
        } catch (TimeoutException e) {
            logger.error("Timeout while selecting option: {} from {}", optionLocator, dropdownLocator, e);
        } catch (Exception e) {
            logger.error("Unexpected error occurred while selecting option.", e);
        }
    }

    public void selectFromSelectDropdown(By dropdownLocator, String optionText) {
        try {
            WebElement dropdown = waitUtils.waitForElementToBeVisible(dropdownLocator);
            Select select = new Select(dropdown);
            select.selectByVisibleText(optionText);
            logger.info("Selected option: {} from selected dropdown:{}", optionText, dropdownLocator);
        } catch (NoSuchElementException e) {
            logger.error("Option '{}' not found in dropdown: {}", optionText, dropdownLocator, e);
        } catch (Exception e) {
            logger.error("Unexpected error occurred while selecting option.", e);
        }
    }

    public void selectRadioButton(String radioButtonXPath) {
        try {
            WebElement radioButton = waitUtils.waitForElementToBeClickable(By.xpath(radioButtonXPath));
            radioButton.click();
            logger.info("Selected radio button: {}", radioButtonXPath);
        } catch (TimeoutException e) {
            logger.error("Error selecting radio button: {}", radioButtonXPath, e);
            System.out.println(driver.getPageSource());
        } catch (Exception e) {
            logger.error("Unexpected error selecting radio button.", e);
        }
    }

    public void assertText(String xpathTemplate, String expectedText, String message) {
        String xpath = String.format(xpathTemplate, expectedText);
        waitUtils.waitForElementToBeVisible(By.xpath(xpath));
        WebElement element = driver.findElement(By.xpath(xpath));
        String actualText = element.getText();
        String normalizedActualText = actualText.replaceAll("\s+", "").toLowerCase();
        String normalizedExpectedText = expectedText.replaceAll("\s+", "").toLowerCase();
        Assert.assertEquals(normalizedActualText, normalizedExpectedText, message);
    }

    public void doubleClick(By locator) {
        WebElement element = waitUtils.waitForElementToBeVisible(locator);
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public void doubleClick(WebElement element) {
        waitUtils.waitForElementToBeVisible(element);
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public void acceptAlert() {
        waitUtils.waitForAlertToBePresent();
        Alert alert = driver.switchTo().alert();
        alert.accept(); // Clicks OK
    }

    public void dismissAlert() {
        waitUtils.waitForAlertToBePresent();
        Alert alert = driver.switchTo().alert();
        alert.dismiss(); // Clicks Cancel
    }

    public boolean isUserDeleted(String userName) {
        waitUtils.waitForPageToLoad();
        List<WebElement> elements = driver.findElements(By.xpath("//td[contains(text(), '" + userName + "')]"));
        return elements.isEmpty();
    }

    public boolean isTextPresentInTable(String text) {
        waitUtils.waitForPageToLoad();
        List<WebElement> elements = driver.findElements(By.xpath("//td[contains(text(), '" + text + "')]"));
        return !elements.isEmpty(); // Returns true if text is found, false otherwise
    }

    public boolean isTextPresentInTaskTable(String text) {
        waitUtils.waitForPageToLoad();
        List<WebElement> elements = driver.findElements(By.xpath(String.format("//td[@title='%s']", text)));
        return !elements.isEmpty(); // Returns true if text is found, false otherwise
    }

    public void selectTab(String tabName, String xpathTemplate) {
        try {
            iframe.switchToContentFrame();
            String dynamicTabLocator = String.format(xpathTemplate, tabName);
            waitUtils.waitForElementToBeVisible(By.xpath(dynamicTabLocator));
            waitUtils.waitForElementToBeClickable(By.xpath(dynamicTabLocator));
            WebElement tabElement = driver.findElement(By.xpath(dynamicTabLocator));
            tabElement.click();
            logger.info("Successfully selected tab: {}", tabName);
        } catch (TimeoutException e) {
            logger.error("Tab not clickable within timeout: {}", tabName, e);
        } catch (NoSuchElementException e) {
            logger.error("Tab not found: {}", tabName, e);
        } catch (Exception e) {
            logger.error("Error occurred while selecting tab: {}", tabName, e);
        }
    }

    public void selectWorkingDays(String... daysToSelect) {
        waitUtils.waitForPageToLoad();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[contains(@id,'working_day')]"));
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        if (checkboxes.size() > 7) {
            checkboxes = checkboxes.subList(0, 7);  // Take only the first 7 checkboxes
        }
        if (checkboxes.size() != daysOfWeek.length) {
            throw new IllegalStateException("Number of checkboxes does not match the number of days in the week.");
        }
        for (int i = 0; i < checkboxes.size(); i++) {
            for (String day : daysToSelect) {
                if (daysOfWeek[i].equalsIgnoreCase(day)) {
                    WebElement checkbox = checkboxes.get(i);
                    waitUtils.waitForElementToBeVisible(checkbox);
                    checkCheckbox(checkbox);
                    break;
                }
            }
        }
    }

    public void verifyAllWorkingDaysSelected() {
        waitUtils.waitForPageToLoad();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[contains(@id,'working_day')]"));
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        if (checkboxes.size() > 7) {
            checkboxes = checkboxes.subList(0, 7);  // Take only the first 7 checkboxes
        }
        if (checkboxes.size() != daysOfWeek.length) {
            throw new IllegalStateException("Number of checkboxes does not match the number of days in the week.");
        }
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < checkboxes.size(); i++) {
            WebElement checkbox = checkboxes.get(i);
            waitUtils.waitForElementToBeVisible(checkbox);
            softAssert.assertTrue(checkbox.isSelected(), "Checkbox for " + daysOfWeek[i] + " is not selected.");
        }
        softAssert.assertAll();
    }

    public void selectCheckboxByLabel(String labelText) {
        try {
            WebElement label = waitUtils.waitForElementToBeVisible(By.xpath("//label[contains(text(), '" + labelText + "')]"));
            String forAttr = label.getAttribute("for");
            WebElement checkbox = waitUtils.waitForElementToBeVisible(By.id(forAttr));
            checkCheckbox(checkbox);
            logger.info("Selected checkbox with label: {}", labelText);
        } catch (Exception e) {
            logger.error("Error selecting checkbox by label: {}", labelText, e);
        }
    }

    public void selectRadioButtonByValue(String name, String value) {
        try {
            List<WebElement> radios = driver.findElements(By.name(name));
            for (WebElement radio : radios) {
                waitUtils.waitForElementToBeVisible(radio);
                if (radio.getAttribute("value").equals(value)) {
                    if (!radio.isSelected()) {
                        waitUtils.waitForElementToBeClickable(radio);
                        radio.click();
                        logger.info("Selected radio button with value: {} in group: {}", value, name);
                    }
                    return;
                }
            }
            logger.warn("Radio button with value '{}' not found in group '{}'.", value, name);
        } catch (Exception e) {
            logger.error("Error selecting radio button by value: {} in group: {}", value, name, e);
        }
    }

    public void selectFromDropdownGeneric(By dropdownLocator, String selectBy, String value) {
        try {
            WebElement dropdown = waitUtils.waitForElementToBeVisible(dropdownLocator);
            Select select = new Select(dropdown);
            switch (selectBy.toLowerCase()) {
                case "text":
                    select.selectByVisibleText(value);
                    break;
                case "value":
                    select.selectByValue(value);
                    break;
                case "index":
                    select.selectByIndex(Integer.parseInt(value));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid selectBy: " + selectBy);
            }
            logger.info("Selected '{}' from dropdown {} by {}.", value, dropdownLocator, selectBy);
        } catch (Exception e) {
            logger.error("Error selecting from dropdown {} by {}: {}", dropdownLocator, selectBy, value, e);
        }
    }

    public void clearAndType(By locator, String text) {
        try {
            WebElement element = waitUtils.waitForElementToBeVisible(locator);
            element.clear();
            element.sendKeys(text);
            logger.info("Typed '{}' into element {}.", text, locator);
        } catch (Exception e) {
            logger.error("Error typing into element {}: {}", locator, text, e);
        }
    }

    public void waitAndClick(By locator) {
        try {
            WebElement element = waitUtils.waitForElementToBeClickable(locator);
            element.click();
            logger.info("Clicked element {}.", locator);
        } catch (Exception e) {
            logger.error("Error clicking element {}", locator, e);
        }
    }

    public void verifyLabelDisplayedWithText(By locator, String expectedText) {
        WebElement label = waitUtils.waitForElementToBeVisible(locator);
        Assert.assertTrue(label.isDisplayed(), "Label was not displayed.");
        Assert.assertEquals(label.getText().trim(), expectedText, "Label text does not match.");
    }
	
}
