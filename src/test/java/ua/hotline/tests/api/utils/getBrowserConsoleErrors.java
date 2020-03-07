package ua.hotline.tests.api.utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import ua.hotline.tests.seleniumTests.BaseTest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class getBrowserConsoleErrors {

    public static boolean isThereJSErrorOnThePage() {
        Set<String> errorStrings = new HashSet<>();
        errorStrings.add("Error");
        errorStrings.add("Unchecked runtime");
        errorStrings.add("Could not");
        errorStrings.add("associated");
        LogEntries logEntries = BaseTest.getDriver().manage().logs().get(LogType.BROWSER);
        for (LogEntry logEntry : logEntries) {
            for (String errorString : errorStrings) {
                if (logEntry.getMessage().contains(errorString)) {
                    log.error("Java Script error has been detected:");
                    log.error(new Date(logEntry.getTimestamp()) + " " + logEntry.getLevel() + " " + logEntry.getMessage());
                    return true;
                }
            }
        }
        return false;
    }
}
