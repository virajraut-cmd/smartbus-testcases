package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.locators.PermissionLocators;
import configurations.common.WaitUtils;
import configurations.common.IframesOfApplication;

/**
 * Handles permission-related actions for the TaskEye project.
 */
public class PermissionPage {
    private final WebDriver driver;
    private final WaitUtils waitUtils;
    private final IframesOfApplication iframe;

    /**
     * Represents a permission action for a module or submodule.
     */
    private static class PermissionAction {
        String dataPid;
        String dataMid;
        String subModuleId; // nullable
        String screenId;
        String value;
        PermissionAction(String dataPid, String dataMid, String screenId, String value) {
            this.dataPid = dataPid;
            this.dataMid = dataMid;
            this.screenId = screenId;
            this.value = value;
        }
        PermissionAction(String dataPid, String dataMid, String subModuleId, String screenId, String value) {
            this.dataPid = dataPid;
            this.dataMid = dataMid;
            this.subModuleId = subModuleId;
            this.screenId = screenId;
            this.value = value;
        }
    }

    public PermissionPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        this.iframe = new IframesOfApplication(driver);
    }

    private void clickProject(String dataPid) {
        WebElement project = waitUtils.waitForElementToBeClickable(PermissionLocators.project(dataPid));
        project.click();
    }

    private void clickModule(String dataPid, String dataMid) {
        WebElement module = waitUtils.waitForElementToBeClickable(PermissionLocators.module(dataPid, dataMid));
        module.click();
    }

    private void clickSubModule(String parentDataMid, String childDataMid) {
        WebElement subModule = waitUtils.waitForElementToBeClickable(PermissionLocators.subModule(parentDataMid, childDataMid));
        subModule.click();
    }

    private void clickPermission(String dataMid, String screenId, String value) {
        WebElement permission = waitUtils.waitForElementToBeClickable(PermissionLocators.permissionCell(dataMid, screenId, value));
        permission.click();
    }

    /**
     * Helper to process a list of PermissionAction for modules (no submodule).
     */
    private void processModulePermissions(PermissionAction[] actions) {
        if (actions.length == 0) return;
        clickModule(actions[0].dataPid, actions[0].dataMid);
        for (PermissionAction action : actions) {
            clickPermission(action.dataMid, action.screenId, action.value);
        }
    }

    /**
     * Helper to process a list of PermissionAction for submodules.
     */
    private void processSubModulePermissions(PermissionAction[] actions) {
        if (actions.length == 0) return;
        clickSubModule(actions[0].dataMid, actions[0].subModuleId);
        for (PermissionAction action : actions) {
            clickPermission(action.subModuleId, action.screenId, action.value);
        }
    }

    /**
     * Clicks the TaskEye project for screen access.
     */
    public void clickOnTaskEyeProjectOfScreenAccess() {
        iframe.switchToContentFrame();
        clickProject("41");
    }

    /**
     * Clicks Dashboard permissions for TaskEye project.
     */
    public void clickOnDashboardOfTaskEyeProjectOfScreenAccessOfCompany() {
        iframe.switchToContentFrame();
        PermissionAction[] actions = {
                new PermissionAction("41", "41_0", "2390", "1_V"),
                new PermissionAction("41", "41_0", "3772", "3_A")
        };
        processModulePermissions(actions);
    }

    public void editOnDashboardOfTaskEyeProjectOfScreenAccessOfCompany() {
        iframe.switchToContentFrame();
        PermissionAction[] actions = {
                new PermissionAction("41", "41_0", "2390", "0_N"),
                new PermissionAction("41", "41_0", "3772", "2_M")
        };
        processModulePermissions(actions);
    }

    /**
     * Clicks Tracking permissions for TaskEye project.
     */
    public void clickOnTrackingOfTaskEyeProjectOfScreenAccessOfCompany() {
        iframe.switchToContentFrame();
        PermissionAction[] actions = {
                new PermissionAction("41", "41_1", "2176", "3_A"),
                new PermissionAction("41", "41_1", "3666", "1_V")
        };
        processModulePermissions(actions);
    }

    /**
     * Clicks Activity Reports permissions for TaskEye project.
     */
    public void clickOnReportsOfActivityOfTaskEyeProjectOfScreenAccessOfCompany() {
        iframe.switchToContentFrame();
        PermissionAction[] actions = {
                new PermissionAction("41", "41_2", "41_s_2_0", "2146", "1_V"),
                new PermissionAction("41", "41_2", "41_s_2_0", "4574", "1_V"),
                new PermissionAction("41", "41_2", "41_s_2_0", "2135", "1_V"),
                new PermissionAction("41", "41_2", "41_s_2_0", "2378", "1_V"),
                new PermissionAction("41", "41_2", "41_s_2_0", "3737", "1_V"),
                new PermissionAction("41", "41_2", "41_s_2_0", "3800", "1_V"),
                new PermissionAction("41", "41_2", "41_s_2_0", "2346", "1_V"),
                new PermissionAction("41", "41_2", "41_s_2_0", "2890", "1_V"),
                new PermissionAction("41", "41_2", "41_s_2_0", "4062", "1_V"),
                new PermissionAction("41", "41_2", "41_s_2_0", "4292", "1_V"),
                new PermissionAction("41", "41_2", "41_s_2_0", "4730", "1_V"),
                new PermissionAction("41", "41_2", "41_s_2_0", "2136", "1_V")
        };
        clickModule(actions[0].dataPid, actions[0].dataMid);
        processSubModulePermissions(actions);
    }

    /**
     * Clicks Approvals Reports permissions for TaskEye project.
     */
    public void clickOnReportsOfApprovalsOfTaskEyeProjectOfScreenAccessOfCompany() {
        iframe.switchToContentFrame();
        PermissionAction[] actions = {
                new PermissionAction("41", "41_2", "41_s_2_1", "4024", "1_V"),
                new PermissionAction("41", "41_2", "41_s_2_1", "4489", "1_V")
        };
        processSubModulePermissions(actions);
    }

    /**
     * Clicks Geofence/Poi Reports permissions for TaskEye project.
     */
    public void clickOnReportsOfGeofencePoiOfTaskEyeProjectOfScreenAccessOfCompany() {
        iframe.switchToContentFrame();
        PermissionAction[] actions = {
                new PermissionAction("41", "41_2", "41_s_2_2", "2317", "1_V"),
                new PermissionAction("41", "41_2", "41_s_2_2", "2316", "1_V")
        };
        processSubModulePermissions(actions);
    }

    /**
     * Clicks Alerts Reports permissions for TaskEye project.
     */
    public void clickOnReportsOfAlertsOfTaskEyeProjectOfScreenAccessOfCompany() {
        iframe.switchToContentFrame();
        PermissionAction[] actions = {
                new PermissionAction("41", "41_2", "41_s_2_3", "2326", "1_V"),
                new PermissionAction("41", "41_2", "41_s_2_3", "4756", "1_V"),
                new PermissionAction("41", "41_2", "41_s_2_3", "1244", "1_V")
        };
        processSubModulePermissions(actions);
    }

    /**
     * Clicks Logs Reports permissions for TaskEye project.
     */
    public void clickOnReportsOfLogsOfTaskEyeProjectOfScreenAccessOfCompany() {
        iframe.switchToContentFrame();
        PermissionAction[] actions = {
                new PermissionAction("41", "41_2", "41_s_2_4", "1324", "1_V"),
                new PermissionAction("41", "41_2", "41_s_2_4", "1288", "1_V"),
                new PermissionAction("41", "41_2", "41_s_2_4", "1228", "1_V"),
                new PermissionAction("41", "41_2", "41_s_2_4", "1217", "1_V"),
                new PermissionAction("41", "41_2", "41_s_2_4", "1328", "1_V")
        };
        processSubModulePermissions(actions);
    }

    /**
     * Clicks Chart permissions for TaskEye project.
     */
    public void clickOnChartOfTaskEyeProjectOfScreenAccessOfCompany() {
        iframe.switchToContentFrame();
        PermissionAction[] actions = {
                new PermissionAction("41", "41_3", "2330", "1_V"),
                new PermissionAction("41", "41_3", "2332", "1_V")
        };
        processModulePermissions(actions);
    }

    /**
     * Clicks General Settings permissions for TaskEye project.
     */
    public void clickOnSettingsOfGeneralOfTaskEyeProjectOfScreenAccessOfCompany() {
        iframe.switchToContentFrame();
        PermissionAction[] actions = {
                new PermissionAction("41", "41_4", "41_s_4_0", "2351", "3_A"),
                new PermissionAction("41", "41_4", "41_s_4_0", "2351", "2_M"),
                new PermissionAction("41", "41_4", "41_s_4_0", "3356", "3_A"),
                new PermissionAction("41", "41_4", "41_s_4_0", "4707", "3_A"),
                new PermissionAction("41", "41_4", "41_s_4_0", "2130", "3_A"),
                new PermissionAction("41", "41_4", "41_s_4_0", "4731", "3_A"),
                new PermissionAction("41", "41_4", "41_s_4_0", "2258", "3_A")
        };
        clickModule(actions[0].dataPid, actions[0].dataMid);
        processSubModulePermissions(actions);
    }

    /**
     * Clicks Master Settings permissions for TaskEye project.
     */
    public void clickOnSettingsOfMasterOfTaskEyeProjectOfScreenAccessOfCompany() {
        iframe.switchToContentFrame();
        PermissionAction[] actions = {
                new PermissionAction("41", "41_4", "41_s_4_1", "2133", "3_A"),
                new PermissionAction("41", "41_4", "41_s_4_1", "2985", "3_A"),
                new PermissionAction("41", "41_4", "41_s_4_1", "4722", "1_V"),
                new PermissionAction("41", "41_4", "41_s_4_1", "2910", "3_A"),
                new PermissionAction("41", "41_4", "41_s_4_1", "2082", "3_A"),
                new PermissionAction("41", "41_4", "41_s_4_1", "2083", "3_A"),
                new PermissionAction("41", "41_4", "41_s_4_1", "3322", "3_A"),
                new PermissionAction("41", "41_4", "41_s_4_1", "3659", "3_A"),
                new PermissionAction("41", "41_4", "41_s_4_1", "4713", "3_A")
        };
        processSubModulePermissions(actions);
    }

    /**
     * Clicks Order Management Settings permissions for TaskEye project.
     */
    public void clickOnSettingsOfOrderManagementOfTaskEyeProjectOfScreenAccessOfCompany() {
        iframe.switchToContentFrame();
        PermissionAction[] actions = {
                new PermissionAction("41", "41_4", "41_s_4_2", "4629", "3_A"),
                new PermissionAction("41", "41_4", "41_s_4_2", "4631", "3_A"),
                new PermissionAction("41", "41_4", "41_s_4_2", "4654", "3_A"),
                new PermissionAction("41", "41_4", "41_s_4_2", "4748", "3_A"),
                new PermissionAction("41", "41_4", "41_s_4_2", "4736", "3_A")
        };
        processSubModulePermissions(actions);
    }
}