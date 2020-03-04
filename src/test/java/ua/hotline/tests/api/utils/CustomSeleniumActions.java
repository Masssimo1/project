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

    private static WebDriver driver() {
        return driver;
    }
}
