package configurations.common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.LocalDate;
import java.util.List;

public class DatePickerUtils {
    private final WebDriver driver;
    private final WaitUtils waitUtils;

    // Allow passing locators for year, month, and day
    private final By yearDropdownLocator;
    private final By yearOptionsLocator;
    private final By monthDropdownLocator;
    private final By monthOptionsLocator;
    private final String dayXPathTemplate;
    private final String[] monthNames;

    public DatePickerUtils(WebDriver driver) {
        this(driver,
            By.xpath("//select[contains(@class,'ui-datepicker-year')]") ,
            By.xpath("//select[contains(@class,'ui-datepicker-year')]/option"),
            By.xpath("//select[contains(@class,'ui-datepicker-month')]") ,
            By.xpath("//select[contains(@class,'ui-datepicker-month')]/option"),
            "//td[not(contains(@class, 'ui-datepicker-unselectable'))]//a[normalize-space()='%d']",
            new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}
        );
    }

    public DatePickerUtils(WebDriver driver, By yearDropdownLocator, By yearOptionsLocator, By monthDropdownLocator, By monthOptionsLocator, String dayXPathTemplate, String[] monthNames) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        this.yearDropdownLocator = yearDropdownLocator;
        this.yearOptionsLocator = yearOptionsLocator;
        this.monthDropdownLocator = monthDropdownLocator;
        this.monthOptionsLocator = monthOptionsLocator;
        this.dayXPathTemplate = dayXPathTemplate;
        this.monthNames = monthNames;
    }

    public void selectDate(By dateField, int daysOffset) {
        LocalDate targetDate = LocalDate.now().plusDays(daysOffset);
        selectDate(dateField, targetDate);
    }

    public void selectDateOfBirth18YearsAgo(By dateField) {
        LocalDate targetDate = LocalDate.now().minusYears(18);
        selectDate(dateField, targetDate);
    }

    public void selectFromAndToDate(By dateField, int daysOffset) {
        LocalDate targetDate = LocalDate.now().plusDays(daysOffset);
        selectDate(dateField, targetDate);
    }

    // Generic date selection
    public void selectDate(By dateField, LocalDate targetDate) {
        int year = targetDate.getYear();
        int month = targetDate.getMonthValue();
        int day = targetDate.getDayOfMonth();
        WebElement dateInputField = waitUtils.waitForElementToBeClickable(dateField);
        dateInputField.click();
        WebElement yearDropdown = waitUtils.waitForElementToBeClickable(yearDropdownLocator);
        List<WebElement> years = driver.findElements(yearOptionsLocator);
        for (WebElement yearOption : years) {
            if (yearOption.getText().equals(String.valueOf(year))) {
                yearOption.click();
                break;
            }
        }
        WebElement monthDropdown = waitUtils.waitForElementToBeClickable(monthDropdownLocator);
        List<WebElement> months = driver.findElements(monthOptionsLocator);
        for (WebElement monthOption : months) {
            if (monthOption.getText().equals(getMonthName(month))) {
                monthOption.click();
                break;
            }
        }
        String dayXPath = String.format(dayXPathTemplate, day);
        List<WebElement> dayElements = driver.findElements(By.xpath(dayXPath));
        if (dayElements.isEmpty()) {
            throw new NoSuchElementException("The specified day is not selectable in the calendar.");
        }
        dayElements.get(0).click();
    }

    private String getMonthName(int month) {
        return monthNames[month - 1];
    }
}