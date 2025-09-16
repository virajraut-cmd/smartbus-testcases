package web.locators;

import org.openqa.selenium.By;

public class PermissionLocators {

    public static By project(String dataPid) {
        return By.xpath("//div[@id='project-list']//li[@data_pid='" + dataPid + "']//input");
    }

    public static By module(String dataPid, String dataMid) {
        return By.xpath("//div[@id='module-list']//ul[@data_pid='" + dataPid + "']//li[@data_mid='" + dataMid + "']//input");
    }

    public static By subModule(String parentDataMid, String childDataMid) {
        return By.xpath("//div[@id='sub-module-list']//ul[@data_mid='" + parentDataMid + "']//li[@data_mid='" + childDataMid + "']//input");
    }

    public static By permissionCell(String dataMid, String screenId, String value) {
        return By.xpath("//ul[@data_mid='" + dataMid + "']//tr[@screenid='" + screenId + "']//td[@value='" + value + "']");
    }
}