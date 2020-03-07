package ua.hotline.tests.api.utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.hotline.tests.seleniumTests.BaseTest;

@UtilityClass
public class CustomSeleniumActions {

    private WebDriver driver = BaseTest.getDriver();

    public static WebElement doFindElement(By selector) {
        return driver.findElement(selector);
    }

    public static void doSendKeys(By selector, String text) {
        driver.findElement(selector).clear();
        driver.findElement(selector).sendKeys(text);
    }

    public static boolean getBrowserConsoleErrors(){
        boolean errorBrowserConsole = getBrowserConsoleErrors.isThereJSErrorOnThePage();
        return errorBrowserConsole;
    }
}
