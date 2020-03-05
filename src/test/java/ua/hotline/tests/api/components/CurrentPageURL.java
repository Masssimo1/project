package ua.hotline.tests.api.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import ua.hotline.tests.seleniumTests.BaseTest;

import java.time.Duration;

public class CurrentPageURL {

    public static String getCurrentUrl() {
        String currentUrl;
        Duration timeout = Duration.ofSeconds(10);
        Duration pollingTime = Duration.ofMillis(250);
        Wait<WebDriver> wait = new FluentWait<>(BaseTest.getDriver()).withTimeout(timeout).pollingEvery(pollingTime);
        try {
            wait.until(ExpectedConditions.urlContains("login"));
            currentUrl = BaseTest.getDriver().getCurrentUrl();
        } catch (Exception e) {
            currentUrl = BaseTest.getDriver().getCurrentUrl();
        }
        return currentUrl;

    }
}
