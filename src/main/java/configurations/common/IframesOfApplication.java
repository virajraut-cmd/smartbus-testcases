package configurations.common;

import org.openqa.selenium.*;
import java.util.logging.Logger;

/**
 * Utility class for switching between various iframes in the application.
 * Provides generic and specific methods for frame navigation.
 */
public class IframesOfApplication {
    private final WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(IframesOfApplication.class.getName());

    // Frame name constants
    public static final String DIV_FRAME = "divframe";
    public static final String WINDOW_FRAME = "windowframe";
    public static final String BOTTOM_FRAME = "bottomframe";
    public static final String CONTENT_FRAME = "contentframe";
    public static final String TITLE_FRAME = "titleframe";
    public static final String IFRAME_SCHEDULE = "iframe_schedule";
    public static final String COMPANY_RULE_IFRAME = "company_rule_iframe";
    public static final String COMPANY_SUB_USER_SSO_IFRAME = "sso_iframe";
    public static final String RULE_IFRAME = "rule_iframe";
    public static final String ADMIN_RULE_IFRAME = "admin_rule_iframe";
    public static final String SUB_ACCOUNT = "sub_account";
    public static final String TEMPLATE_IFRAME = "template_iframe";
    public static final String PAYMENT_GATEWAY = "payment_gateway";
    public static final String RENAME_LABEL_IFRAME = "rename_label_iframe";
    public static final String SOCIAL_MEDIA_API = "social_media_api";
    public static final String MAP_IFRAME = "map_iframe";
    public static final String LEAVE_IFRAME = "leave_iframe";
    public static final String DOCUMENT_IFRAME = "document_iframe";
    public static final String BRANCH_IFRAME = "branch_iframe";
    public static final String DESIGNATION_IFRAME = "designation_iframe";
    public static final String SOS_CATEGORY_IFRAME = "sos_category_iframe";
    public static final String LEAVE_REASON_IFRAME = "leave_reason_iframe";
    public static final String DEPARTMENT_IFRAME = "department_iframe";
    public static final String TASK_CATEGORY_IFRAME = "task_category_iframe";
    public static final String EXPENSE_CATEGORY_IFRAME = "expense_category_iframe";
    public static final String SHIFT_IFRAME = "shift_iframe";
    public static final String POPUP_DIALOG_XPATH = "//div[@id='popup_dialog']//iframe";
    public static final String SETTING_POPUP_XPATH = "//iframe[@src='TrakzeeAdavncedSort.jsp']";

    public IframesOfApplication(WebDriver driver) {
        this.driver = driver;
    }
    
    public void switchToParentFrame()
    {
    	driver.switchTo().parentFrame();
    }
    
    public void switchToDefaultContent()
    {
    	driver.switchTo().defaultContent();
    }

    /**
     * Switches to the specified frame hierarchy by name.
     * @param frameNames Names of frames to switch through, in order.
     */
    public void switchToFrame(String... frameNames) {
        try {
            driver.switchTo().defaultContent();
            for (String frame : frameNames) {
                driver.switchTo().frame(frame);
            }
        } catch (Exception e) {
            LOGGER.warning("Failed to switch to frame(s): " + String.join(", ", frameNames) + ". Exception: " + e.getMessage());
        }
    }

    /**
     * Switches to a frame using a WebElement reference.
     * @param frameElement The WebElement representing the frame.
     */
    public void switchToFrame(WebElement frameElement) {
        try {
            driver.switchTo().defaultContent();
            driver.switchTo().frame(frameElement);
        } catch (Exception e) {
            LOGGER.warning("Failed to switch to frame by WebElement. Exception: " + e.getMessage());
        }
    }

    /**
     * Switches to the divframe.
     */
    public void switchToDivFrame() {
        switchToFrame(DIV_FRAME);
    }

    /**
     * Switches to the windowframe inside divframe.
     */
    public void switchToWindowFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME);
    }

    /**
     * Switches to the bottomframe inside windowframe and divframe.
     */
    public void switchToBottomFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, BOTTOM_FRAME);
    }

    /**
     * Switches to the contentframe inside windowframe and divframe.
     */
    public void switchToContentFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME);
    }

    /**
     * Switches to the titleframe inside windowframe and divframe.
     */
    public void switchToTitleFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, TITLE_FRAME);
    }

    /**
     * Switches to the schedule screen iframe.
     */
    public void switchToScheduleScreen() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, IFRAME_SCHEDULE);
    }

    /**
     * Switches to the setting popup iframe by locating it with XPath.
     */
    public void switchToSettingPopup() {
        try {
            driver.switchTo().defaultContent();
            driver.switchTo().frame(DIV_FRAME);
            WebElement frame = driver.findElement(By.xpath(SETTING_POPUP_XPATH));
            driver.switchTo().frame(frame);
        } catch (Exception e) {
            LOGGER.warning("Failed to switch to setting popup frame. Exception: " + e.getMessage());
        }
    }

    /**
     * Switches to the company rule content iframe.
     */
    public void switchToCompanyRuleContentFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, COMPANY_RULE_IFRAME);
    }

    public void switchToCompanySubUserSsoContentFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, COMPANY_SUB_USER_SSO_IFRAME);
    }

    /**
     * Switches to the rule content iframe.
     */
    public void switchToRuleContentFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, RULE_IFRAME);
    }

    /**
     * Switches to the admin rule iframe.
     */
    public void switchToAdminRuleFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, ADMIN_RULE_IFRAME);
    }

    /**
     * Switches to the sub admin user iframe.
     */
    public void switchToSubAdminUserFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, SUB_ACCOUNT);
    }

    /**
     * Switches to the template iframe.
     */
    public void switchToTemplateFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, TEMPLATE_IFRAME);
    }

    /**
     * Switches to the payment gateway iframe.
     */
    public void switchToPaymentGatewayFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, PAYMENT_GATEWAY);
    }

    /**
     * Switches to the rename label iframe.
     */
    public void switchToRenameLabelFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, RENAME_LABEL_IFRAME);
    }

    /**
     * Switches to the social media API iframe.
     */
    public void switchToSocialMediaApiFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, SOCIAL_MEDIA_API);
    }

    /**
     * Switches to the company map content iframe.
     */
    public void switchToCompanyMapContentFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, MAP_IFRAME);
    }

    /**
     * Switches to the employee leave iframe.
     */
    public void switchToEmployeeLeaveFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, LEAVE_IFRAME);
    }

    /**
     * Switches to the employee document iframe.
     */
    public void switchToEmployeeDocumentFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, DOCUMENT_IFRAME);
    }

    /**
     * Switches to the branch content iframe.
     */
    public void switchToBranchContentFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, BRANCH_IFRAME);
    }

    /**
     * Switches to the designation content iframe.
     */
    public void switchToDesignationContentFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, DESIGNATION_IFRAME);
    }

    /**
     * Switches to the sos category content iframe.
     */
    public void switchToSosCategoryContentFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, SOS_CATEGORY_IFRAME);
    }

    /**
     * Switches to the Leave Reason content iframe.
     */
    public void switchToLeaveReasonContentFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, LEAVE_REASON_IFRAME);
    }

    /**
     * Switches to the department content iframe.
     */
    public void switchToDepartmentContentFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, DEPARTMENT_IFRAME);
    }

    /**
     * Switches to the task category content iframe.
     */
    public void switchTaskCategoryContentFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, TASK_CATEGORY_IFRAME);
    }

    /**
     * Switches to the expense category content iframe.
     */
    public void switchExpenseCategoryContentFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, EXPENSE_CATEGORY_IFRAME);
    }

    /**
     * Switches to the shift content iframe.
     */
    public void switchShiftContentFrame() {
        switchToFrame(DIV_FRAME, WINDOW_FRAME, CONTENT_FRAME, SHIFT_IFRAME);
    }

    /**
     * Switches to the popup dialog iframe by locating it with XPath.
     */
    public void switchToPopUpDialogFrame() {
        try {
            driver.switchTo().defaultContent();
            driver.switchTo().frame(DIV_FRAME);
            driver.switchTo().frame(WINDOW_FRAME);
            driver.switchTo().frame(CONTENT_FRAME);
            driver.switchTo().frame(driver.findElement(By.xpath(POPUP_DIALOG_XPATH)));
        } catch (Exception e) {
            LOGGER.warning("Failed to switch to popup dialog frame. Exception: " + e.getMessage());
        }
    }
}
